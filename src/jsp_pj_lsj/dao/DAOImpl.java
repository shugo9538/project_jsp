package jsp_pj_lsj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jsp_pj_lsj.vo.CategoryVO;
import jsp_pj_lsj.vo.UserVO;

public enum DAOImpl implements DAO {
    INSTANCE;
    
    private DataSource dataSource;
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    private DAOImpl() {
        try {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/jsp_pj_lsj");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    /* 아이디 중복확인을 위한 데이터 접근
     * @param : 입력ID
     * 
     * @return
     * 성공 : true
     * 실패 : false
     * */
    @Override
    public boolean idCheck(String id) {
        System.out.println("DAO : IDCHECK");
        boolean isExists = false;

        try {
            conn = dataSource.getConnection();
            String query = "SELECT * FROM USERVO WHERE id = ?";
            pstmt = conn.prepareStatement(query);
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
                if (pstmt != null)
                    pstmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isExists;
    }

    /* 회원가입 데이터 접근
     * @param : UserVO(유저정보)
     * 
     * @return
     * 성공 : 1
     * 실패 : 2
     * */
    @Override
    public int insertGuest(UserVO vo) {
        System.out.println("DAO : INSERT");
        int isInsert = 0;

        try {
            conn = dataSource.getConnection();
            String query = "INSERT INTO USERVO(id, pw, name, tel) VALUES(?, ?, ?, ?)";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, vo.getEmail());
            pstmt.setString(2, vo.getPw());
            pstmt.setString(3, vo.getName());
            pstmt.setString(4, vo.getTel());

            isInsert = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (pstmt != null)
                    pstmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isInsert;
    }

    /* 사용자확인 위한 데이터 접근
     * @param : 아이디, 패스워드
     * 
     * @return
     * 성공 : 1
     * 실패 : -1(비밀번호 오류), 0(쿼리오류:사용자 없음)
     * */
    @Override
    public int userCheck(String id, String pw) {
        System.out.println("DAO : SELECT USER");
        int isUser = 0;

        try {
            conn = dataSource.getConnection();
            String query = "SELECT * FROM USERVO WHERE id = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, id);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                if (pw.equals(rs.getString("pw"))) {
                    isUser = 1;
                } else {
                    isUser = -1;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (rs != null)
                    pstmt.close();
                if (pstmt != null)
                    pstmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isUser;
    }
    
    /* 사용자 정보 획득 : userCheck()후에만 동작할 것
     * @param : 입력ID
     * 
     * @return
     * 성공 : UserVO
     * */
    @Override
    public UserVO getGuestInfo(String id) {
        System.out.println("DAO : SELECT USER");
        UserVO vo = new UserVO();

        try {
            conn = dataSource.getConnection();
            String query = "SELECT * FROM USERVO WHERE id = ?";
            pstmt = conn.prepareStatement(query);
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
                    pstmt.close();
                if (pstmt != null)
                    pstmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return vo;
    }

    /* 사용자 정보 삭제
     * @param : 입력ID
     * 
     * @return
     * 성공 : 1
     * 실패 : 0
     * */
    @Override
    public int deleteGuest(String id) {
        System.out.println("DAO : UPDATE USER");
        int isDeleted = 0;

        try {
            conn = dataSource.getConnection();
            String query = "DELETE USERVO WHERE id=?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, id);

            isDeleted = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (pstmt != null)
                    pstmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isDeleted;
    }

    /* 사용자 정보 수정
     * @param : UserVO
     * 
     * @return
     * 성공 : 1
     * 실패 : 0
     * */
    @Override
    public int updateGuest(UserVO vo) {
        System.out.println("DAO : UPDATE USER");
        int isUpdated = 0;

        try {
            conn = dataSource.getConnection();
            String query = "UPDATE USERVO SET pw=?, name=?, tel=?, alert=? WHERE id=?";
            pstmt = conn.prepareStatement(query);
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

        } finally {
            try {
                if (pstmt != null)
                    pstmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isUpdated;
    }

    /* 관리자 로그인
     * @param : 아이디, 패스워드
     * 
     * @return
     * 성공 : 1
     * 실패 : -1(비밀번호 오류), 0(쿼리오류:사용자 없음)
     * */
    @Override
    public int adminCheck(String id, String pw) {
        System.out.println("DAO : SELECT USER");
        int isUser = 0;

        try {
            conn = dataSource.getConnection();
            String query = "SELECT * FROM USERVO WHERE id = ? AND isAdmin = 1";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, id);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                if (pw.equals(rs.getString("pw"))) {
                    isUser = 1;
                } else {
                    isUser = -1;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (rs != null)
                    pstmt.close();
                if (pstmt != null)
                    pstmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isUser;
    }

    /* 카테고리 리스트 읽어오기
     * 
     * @return 모든 카테고리 리스트
     * */
    @Override
    public List<CategoryVO> categoryList() {
        System.out.println("DAO : SELECT CATEGORY");
        List<CategoryVO> list = new ArrayList<>();
        CategoryVO vo = new CategoryVO();

        try {
            conn = dataSource.getConnection();
            String query = "SELECT * FROM CATEGORY ORDER BY category_id";
            pstmt = conn.prepareStatement(query);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                vo.setCategoryId(rs.getInt("category_id")); 
                vo.setCategoryName(rs.getString("category_name")); 
                list.add(vo);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (rs != null)
                    pstmt.close();
                if (pstmt != null)
                    pstmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }
}
