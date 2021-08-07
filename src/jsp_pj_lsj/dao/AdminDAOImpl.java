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

import jsp_pj_lsj.util.Log;
import jsp_pj_lsj.vo.CategoryVO;
import jsp_pj_lsj.vo.ProductVO;

public enum AdminDAOImpl implements AdminDAO {
    // AdminDAOImpl INSTNACE = new AdminDAOImpl(); 과 동일하며, getInstance()의 역할도 동시에 수행
    INSTANCE; 
    
    private DataSource dataSource;
    private ResultSet rs = null;

    private AdminDAOImpl() {
        try {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/jsp_pj_lsj");
        } catch (NamingException e) {
            e.printStackTrace();
        }
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
        Log.i(this.getClass().getName(), "adminCheck");
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
        Log.i(this.getClass().getName(), "categoryList");
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
     * @param : 카테고리 이름 가져오기
     * 
     * @return
     * 성공 : 1
     * 실패 : 0
     * */
    @Override
    public String getCategory(int id) {
        Log.i(this.getClass().getName(), "getCategory");
        String name = "";

        String query = "SELECT * FROM category_tbl WHERE category_id=?";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);) {
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            
            if (rs.next()) name = rs.getString("category_name");
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return name;
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
        Log.i(this.getClass().getName(), "categoryAdd");
        int isInsert = 0;

        String query = "INSERT INTO category_tbl(category_id, category_name) VALUES(category_seq.nextval, ?)";
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
        Log.i(this.getClass().getName(), "categoryDelete");
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
        Log.i(this.getClass().getName(), "productList");
        List<ProductVO> list = new ArrayList<>();
        ProductVO vo;

        String query = "SELECT * FROM product_tbl ORDER BY product_id";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);) {

            rs = pstmt.executeQuery();

            while (rs.next()) {
                vo = new ProductVO();
                vo.setProductId(rs.getInt("product_id"));
                vo.setProductName(rs.getString("product_name"));
                vo.setProductPrice(rs.getInt("product_price"));
                vo.setProductStock(rs.getInt("product_stock"));
                vo.setProductImg(rs.getString("product_img"));
                vo.setProductEa(rs.getString("product_ea"));
                vo.setProductProducer(rs.getString("product_producer"));
                vo.setProductOrigin(rs.getString("product_origin"));
                vo.setCategoryId(rs.getInt("product_category"));
                vo.setProductContent(rs.getString("product_content"));
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

    /** 상품 등록
     * @param : ProductVO
     * 
     * @return
     * 성공 : 1
     * 실패 : 0
     * */
    @Override
    public int productAdd(ProductVO vo) {
        Log.i(this.getClass().getName(), "insertGuest");
        int isInsert = 0;

        String query = "INSERT INTO product_tbl(product_id, product_name, product_price, product_stock, product_img, " 
                    + "product_ea, product_producer, product_origin, product_category, product_content) "
                    + "VALUES(product_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);) {
            pstmt.setString(1, vo.getProductName());
            pstmt.setInt(2, vo.getProductPrice());
            pstmt.setInt(3, vo.getProductStock());
            pstmt.setString(4, vo.getProductImg());
            pstmt.setString(5, vo.getProductEa());
            pstmt.setString(6, vo.getProductProducer());
            pstmt.setString(7, vo.getProductOrigin());
            pstmt.setInt(8, vo.getCategoryId());
            pstmt.setString(9, vo.getProductContent());

            isInsert = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isInsert;
    }

    /** 상품 등록
     * @param : ㅑㅇ
     * 
     * @return
     * 성공 : ProductVO = (product_tbl + category_tbl)
     * */
    @Override
    public ProductVO getProductDetail(int id) {
        Log.i(this.getClass().getName(), "productUpdate");
        ProductVO vo = new ProductVO();

        String query = "SELECT * FROM product_tbl p, category_tbl c WHERE product_id=? AND p.product_category = c.category_id";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                vo.setProductId(rs.getInt("product_id"));
                vo.setProductName(rs.getString("product_name"));
                vo.setProductPrice(rs.getInt("product_price"));
                vo.setProductArrival(rs.getInt("product_arrival"));
                vo.setProductStock(rs.getInt("product_stock"));
                vo.setProductEnrollment(rs.getDate("product_enrollment"));
                vo.setProductImg(rs.getString("product_img"));
                vo.setProductEa(rs.getString("product_ea"));
                vo.setProductProducer(rs.getString("product_producer"));
                vo.setProductOrigin(rs.getString("product_origin"));
                vo.setProductContent(rs.getString("product_content"));
                vo.setCategoryId(rs.getInt("category_id"));
                vo.setCategoryName(rs.getString("category_name"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return vo;
    }

    @Override
    public int productUpdate(ProductVO vo) {
        Log.i(this.getClass().getName(), "productUpdate");
        int isUpdate = 0;

        String query = "DELETE FROM product_tbl WHERE product_id=?";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)) {
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return isUpdate;
    }

    /** 상품 등록
     * @param : Product id
     * 
     * @return
     * 성공 : 1
     * 실패 : -1
     * */
    @Override
    public int productDelete(int id) {
        Log.i(this.getClass().getName(), "insertGuest");
        int isDelete = -1;

        String query = "DELETE FROM product_tbl WHERE product_id=?";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            
            isDelete = pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return isDelete;
    }

    @Override
    public int refundList(int id) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int refundOk(int id) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int reviewList() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int reviewDelete() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int settelmentData() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int starPoint() {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
