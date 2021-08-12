package jsp_pj_lsj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jsp_pj_lsj.util.Log;
import jsp_pj_lsj.vo.ArrivalVO;
import jsp_pj_lsj.vo.UserVO;

public enum UserDAOImpl implements UserDAO {
    INSTANCE;

    private DataSource dataSource;
    private ResultSet rs = null;

    private UserDAOImpl() {
        try {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/jsp_pj_lsj");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    /* 사용자 데이터 접근 */
    /**
     * 아이디 중복확인을 위한 데이터 접근
     * 
     * @param : 입력ID
     * 
     * @return 성공 : true 실패 : false
     */
    @Override
    public boolean checkID(String id) {
        Log.i(this.getClass().getName(), "checkID");
        boolean isExists = false;

        String query = "SELECT * FROM USER_TBL WHERE id = ?";
        try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query);) {
            pstmt.setString(1, id);

            rs = pstmt.executeQuery();

            if (!rs.next())
                isExists = true;

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isExists;
    }

    /**
     * 회원가입 데이터 접근
     * 
     * @param : UserVO(유저정보)
     * 
     * @return 성공 : 1 실패 : 2
     */
    @Override
    public int insertUser(UserVO vo) {
        Log.i(this.getClass().toString(), "insertGuest");
        int isInsert = 0;

        String query = "INSERT INTO USER_TBL(id, pw, name, tel, key) VALUES(?, ?, ?, ?, ?)";
        try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query);) {
            pstmt.setString(1, vo.getEmail());
            pstmt.setString(2, vo.getPw());
            pstmt.setString(3, vo.getName());
            pstmt.setString(4, vo.getTel());
            pstmt.setString(5, vo.getEmailChk());

            isInsert = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return isInsert;
    }

    /** 사용자 이메일 인증을 통한 확인
     * @param : 인증키 값이 일치하면 회원 인증 허용
     * */
    @Override
    public int emailCheck(String key) {
        Log.i(this.getClass().getName(), "emailCheck");
        int isAuth = 0;
        String sql = "UPDATE USER_TBL SET auth=1 WHERE key=?";
        
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, key);
            
            isAuth = pstmt.executeUpdate();
            
            if (isAuth == 1) Log.i("isAuth", isAuth);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return isAuth;
    }
    
    /** 사용자확인 위한 데이터 접근
     * @param : 아이디, 패스워드
     * 
     * @return
     * 성공 : 1
     * 실패 : -1(비밀번호 오류), 0(쿼리오류:사용자 없음), -2(이메일 인증 오류)
     * */
    @Override
    public int userCheck(String id, String pw, int isAdmin) {
        Log.i(this.getClass().getName(), "userCheck");
        int isUser = 0;

        String query = "SELECT * FROM USER_TBL WHERE id = ? AND isAdmin = ?";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);) {
            pstmt.setString(1, id);
            pstmt.setInt(2, isAdmin);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                if (pw.equals(rs.getString("pw"))) {
                    if (rs.getInt("auth") == 1) {
                        isUser = 1;
                    } else {
                        isUser = -2;
                    }
                } else {
                    isUser = -1;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isUser;
    }
    
    /** 사용자 정보 획득 : userCheck()후에만 동작할 것
     * @param : 입력ID
     * 
     * @return
     * 성공 : UserVO
     * */
    @Override
    public UserVO getUserData(String id) {
        Log.i(this.getClass().getName(), "getUserData");
        UserVO vo = new UserVO();

        String query = "SELECT * FROM USER_TBL WHERE id = ?";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);) {
            pstmt.setString(1, id);

            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                vo.setEmail(rs.getString("id"));
                vo.setPw(rs.getString("pw"));
                vo.setName(rs.getString("name"));
                vo.setTel(rs.getString("tel"));
                vo.setAlertChk((rs.getInt("alert") == 1) ? true : false);
                vo.setAdminChk((rs.getInt("isAdmin") == 1) ? true : false);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return vo;
    }
    
    /** 사용자 정보 삭제
     * @param : 입력ID
     * 
     * @return
     * 성공 : 1
     * 실패 : 0
     * */
    @Override
    public int deleteUser(String id) {
        Log.i(this.getClass().getName(), "deleteUser");
        int isDeleted = 0;

        String query = "DELETE USER_TBL WHERE id=?";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);) {
            pstmt.setString(1, id);

            isDeleted = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isDeleted;
    }
    
    /** 사용자 정보 수정
     * @param : UserVO
     * 
     * @return
     * 성공 : 1
     * 실패 : 0
     * */
    @Override
    public int modifyUser(UserVO vo) {
        Log.i(this.getClass().getName(), "updateGuest");
        int isUpdated = 0;

        String query = "UPDATE USER_TBL SET pw=?, name=?, tel=?, alert=? WHERE id=?";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);) {
            pstmt.setString(1, vo.getPw());
            pstmt.setString(2, vo.getName());
            pstmt.setString(3, vo.getTel());
            int i = (vo.isAlertChk()) ? 1 : 0;
            System.out.println("i : " + i);
            pstmt.setInt(4, i); // true : 1, false : 0
            pstmt.setString(5, vo.getEmail());

            isUpdated = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return isUpdated;
    }
    
    /** 설문결과 저장하기
     * @param : 이유
     * 
     * @return
     * 성공 : 1
     * 실패 : 0
     * */
    @Override
    public void survey(String reason) {
        Log.i(this.getClass().getName(), "surveyResult");

        String query = "UPDATE WITHDRAWAL_SURVEY SET survey_cnt=survey_cnt+1 WHERE reason LIKE ?";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);) {
            pstmt.setString(1, reason);
            
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
    
    /** 
     * @param : 배송지 정보 추가
     * 
     * @return
     * 성공 : 1
     * 실패 : 0
     * */
    @Override
    public int addArrivalAddr(ArrivalVO vo) {
        Log.i(this.getClass().toString(), "insertGuest");
        int isInsert = 0;

        String query = "INSERT INTO arrival_addr(arrival_id, receiver_id, receiver_name, receiver_phone, receiver_comment, arrival_address, isDefault)"
                + " VALUES(arrival_seq.nextval, ?, ?, ?, ?, ?, 0)";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);) {
            pstmt.setString(1, vo.getUserID());
            pstmt.setString(2, vo.getReceiverName());
            pstmt.setString(3, vo.getReceiverTel());
            pstmt.setString(4, vo.getReceiverComment());
            pstmt.setString(5, vo.getArrivalAddr());
            
            isInsert = pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return isInsert;
    }
    
    /** 기본 배송지 가져오기
     * 
     * @return
     * 성공 : ArrivalVO
     * 실패 : null
     * */
    @Override
    public ArrivalVO defaultArrivalAddr() {
        Log.i(this.getClass().toString(), "defaultArrivalAddr");
        ArrivalVO vo = new ArrivalVO();

        String query = "SELECT * FROM arrival_addr WHERE isDefault=1";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);) {
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
                vo.setArrivalAddr(rs.getString("arrival_address"));
                Log.i("arrivalVo", vo.getArrivalAddr());
                vo.setArrivalID(rs.getInt("arrival_id"));
                vo.setReceiverComment(rs.getString("receiver_comment"));
                vo.setReceiverName(rs.getString("receiver_name"));
                vo.setReceiverTel(rs.getString("receiver_phone"));
                vo.setUserID(rs.getString("receiver_id"));
                vo.setIsDefault(rs.getInt("isDefault"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return vo;
    }

    /** 이름 가져오기
     * @param : id
     * 
     * @return
     * 성공 : 이메일 반환
     * 실패 : 0
     * */
    @Override
    public String getUserName(String id) {
        Log.i(this.getClass().toString(), "getUserName");
        String name = "";

        String query = "SELECT name FROM user_tbl WHERE id=?";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);) {
            pstmt.setString(1, id);
            
            rs = pstmt.executeQuery();
            
            if (rs.next()) name = rs.getString("name");
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return name;
    }
}
