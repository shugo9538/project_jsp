package jsp_pj_lsj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jsp_pj_lsj.util.Log;
import jsp_pj_lsj.util.SettingsValue;
import jsp_pj_lsj.vo.CategoryVO;
import jsp_pj_lsj.vo.ProductVO;
import jsp_pj_lsj.vo.UserVO;

public enum DAOImpl implements DAO {
    INSTANCE;
    
    private DataSource dataSource;
    private ResultSet rs = null;

    private DAOImpl() {
        try {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/jsp_pj_lsj");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    /* 사용자 데이터 접근 */
    /** 아이디 중복확인을 위한 데이터 접근
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

        String query = "SELECT * FROM USER_TBL WHERE id = ?";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);) {
            pstmt.setString(1, id);

            rs = pstmt.executeQuery();

            if (!rs.next()) isExists = true;

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

    /** 회원가입 데이터 접근
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

        String query = "INSERT INTO USER_TBL(id, pw, name, tel, key) VALUES(?, ?, ?, ?, ?)";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);) {
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
    
    /** 메일 확인을 위한 메일 전송
     * @param : email과 key값
     * */
    @Override
    public void sendmail(String email, String key) {
        final String username = SettingsValue.HOST; // 본인 이메일
        final String password = SettingsValue.PW;   // 본인 비밀번호
        final String host = "smtp.gmail.com";
        
        // SMTP(메일 서버) 설정
        Properties props = new Properties();
        props.put("mail.smtp.user", username);                  // SMTP에서 사용할 사용자 메일주소
        props.put("mail.smtp.password", password);              // 비밀번호
        props.put("mail.smtp.host", host);                      // host 서버 : gmail로 설정
        props.put("mail.smtp.port", "25");                      // 25번 포트 사용
        props.put("mail.debug", "true");                        // 디버그 설정
        props.put("mail.smtp.auth", "true");                    // 인증 : true        
        props.put("mail.smtp.starttls.enable", "true");         // tls 사용 허용
//        props.put("mail.smtp.EnableSSL.enable", "true");      // SSL 사용 허용값인거 같은데 설정이 안먹는다.
        props.put("mail.smtp.ssl.enable", "true");              // ssl 허용  
        props.put("mail.smtp.ssl.trust", host);                 // ssl 신뢰 가능으로 설정(보안레벨)
        
        // propert값 설정
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");   // socketFactory 설정을 ssl사용하기 때문에 SSLSocketFactory
        props.setProperty("mail.smtp.socketFactory.fallback", "false");                         // fallback 설정 : false
        props.setProperty("mail.smtp.port", "465");                                             // 465번 포트 사용(gmail 설정)
        props.setProperty("mail.smtp.socketFactory.port", "465");                               // 마찬가지로 포트 설정
        
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("admin@CosmoJspPJ.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            
            String content = "회원가입을 축하드립니다. 링크를 눌러 회원가입을 완료하세요."
                            + "<a href='http://localhost/jsp_pj_lsj/emailChk.gu?key=" + key + "'>링크</a>";
            message.setSubject("회원가입 인증 메일");
            message.setContent(content, "text/html; charset=utf-8");
            
            System.out.println("send");
            Transport.send(message);
            System.out.println("SEND");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /** 사용자 이메일 인증을 통한 확인
     * @param : 인증키 값이 일치하면 회원 인증 허용
     * */
    @Override
    public int emailChk(String key) {
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
    public int userCheck(String id, String pw) {
        System.out.println("DAO : SELECT USER");
        int isUser = 0;

        String query = "SELECT * FROM USER_TBL WHERE id = ?";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);) {
            pstmt.setString(1, id);

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
    public UserVO getGuestInfo(String id) {
        System.out.println("DAO : SELECT USER");
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
    public int deleteGuest(String id) {
        System.out.println("DAO : UPDATE USER");
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
    public int updateGuest(UserVO vo) {
        System.out.println("DAO : UPDATE USER");
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
    public void surveyResult(String reason) {
        System.out.println("DAO : UPDATE SURVEY");

        String query = "UPDATE WITHDRAWAL_SURVEY SET survey_cnt=survey_cnt+1 WHERE reason LIKE ?";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);) {
            pstmt.setString(1, reason);
            
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
    
    /* 관리자 데이터 접근 */
    /** 관리자 로그인
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

        String query = "SELECT * FROM USER_TBL WHERE id = ? AND isAdmin = 1";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);) {
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
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isUser;
    }

    /** 카테고리 리스트 읽어오기
     * @return 모든 카테고리 리스트
     * */
    @Override
    public List<CategoryVO> categoryList() {
        System.out.println("DAO : SELECT CATEGORY");
        List<CategoryVO> list = new ArrayList<>();
        CategoryVO vo = new CategoryVO();

        String query = "SELECT * FROM CATEGORY_TBL ORDER BY category_id";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);) {

            rs = pstmt.executeQuery();

            while (rs.next()) {
                vo = new CategoryVO();
                vo.setCategoryId(rs.getInt("category_id")); 
                vo.setCategoryName(rs.getString("category_name")); 
                list.add(vo);
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

        return list;
    }

    /** 카테고리 추가
     * @param : 카테고리 이름추가
     * 
     * @return
     * 성공 : 1
     * 실패 : 0
     * */
    @Override
    public int categoryAdd(String name) {
        System.out.println("DAO : INSERT CATEGORY");
        int isInsert = 0;

        String query = "INSERT INTO CATEGORY_TBL(category_id, category_name) VALUES(category_seq.nextval, ?)";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);) {
            pstmt.setString(1, name);

            isInsert = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return isInsert;
    }

    /** 카테고리 삭제
     * @param : 카테고리 아이디
     * 
     * @return
     * 성공 : 1
     * 실패 : 0
     * */
    @Override
    public int categoryDelete(String id) {
        System.out.println("DAO : DELETE CATEGORY");
        int isDelete = 0;

        String query = "DELETE FROM CATEGORY_TBL WHERE category_id = ?";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);) {
            pstmt.setString(1, id);

            isDelete = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return isDelete;
    }

    /** 상품 리스트 읽어오기
     * @return 모든 상품 리스트
     * */
    @Override
    public List<ProductVO> productList() {
        System.out.println("DAO : SELECT PRODCUT");
        List<ProductVO> list = new ArrayList<>();
        ProductVO vo = new ProductVO();

        String query = "SELECT * FROM CATEGORY_TBL ORDER BY category_id";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);) {

            rs = pstmt.executeQuery();

            while (rs.next()) {
                vo = new ProductVO();
                list.add(vo);
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

        return list;
    }
    
    
    
}
