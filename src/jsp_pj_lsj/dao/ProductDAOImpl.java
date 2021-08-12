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

public enum ProductDAOImpl implements ProductDAO {
    INSTANCE;
    
    private DataSource dataSource;
    private ResultSet rs = null;

    private ProductDAOImpl() {
        try {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/jsp_pj_lsj");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
    
    /** 카테고리 갯수 가져오기
     * @return
     * 성공 : count
     * */
    @Override
    public int categoryCnt() {
        Log.i(this.getClass().getName(), "categoryList");
        int cnt = 0;

        String query = "SELECT COUNT(category_id) as cnt FROM CATEGORY_TBL";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);) {
            
            rs = pstmt.executeQuery();
            
            if (rs.next()) cnt = rs.getInt("cnt");
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return cnt;
    }

    /** 카테고리 목록 가져오기
     * @return
     * 성공 : List<CategoryVO>
     * 실패 : null
     * */
    @Override
    public List<CategoryVO> categoryListAll() {
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
    /** 카테고리 목록 가져오기
     * @param start, end(시작부터 종료 10개씩)
     * @return
     * 성공 : List<CategoryVO>
     * 실패 : null
     * */
    @Override
    public List<CategoryVO> categoryList(int start, int end) {
        Log.i(this.getClass().getName(), "categoryList");
        List<CategoryVO> list = new ArrayList<>();
        CategoryVO vo = new CategoryVO();

        String query = "SELECT * " 
                +   "      FROM "
                +   "        (SELECT category_id, category_name, rowNum rNum " 
                +   "          FROM ( SELECT * FROM CATEGORY_TBL " 
                +   "                    ORDER BY category_id "
                +   "               ) " 
                +   "         ) "
                +   "      WHERE rNum >= ? AND rNum <= ? ";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);) {
            pstmt.setInt(1,  start);
            pstmt.setInt(2, end);
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
    public String categoryName(int id) {
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
    public int insertCategory(String name) {
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
    public int deleteCategory(String id) {
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
    
    @Override
    public int productCnt(int categoryId) {
        Log.i(this.getClass().getName(), "productCnt");
        int cnt = 0;

        String query = "SELECT COUNT(product_id) as cnt FROM product_tbl WHERE product_category=?";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);) {
            pstmt.setInt(1, categoryId);
            rs = pstmt.executeQuery();
            
            if (rs.next()) cnt = rs.getInt("cnt");
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return cnt;
    }

    @Override
    public int productCntAll() {
        Log.i(this.getClass().getName(), "productCntAll");
        int cnt = 0;

        String query = "SELECT COUNT(product_id) as cnt FROM product_tbl";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);) {
            
            rs = pstmt.executeQuery();
            
            if (rs.next()) cnt = rs.getInt("cnt");
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return cnt;
    }

    /** 카테고리별로 필터링 되는 상품 목록 가져오기
     * @param : 카테고리 id
     * 
     * @return
     * 성공 : List<ProductVO>
     * 실패 : null
     * */
    @Override
    public List<ProductVO> productList(int categoryId, int start, int end) {
        Log.i(this.getClass().getName(), "productList");
        List<ProductVO> list = new ArrayList<>();
        ProductVO vo;

        String query = "SELECT * " 
                +   "      FROM "
                +   "        (SELECT product_id, product_name, product_price, product_stock, product_img, "
                +   "                product_ea, product_producer, product_origin, product_category, product_content, category_name, rowNum rNum " 
                +   "          FROM ( SELECT * FROM product_tbl p, category_tbl c "
                +   "                  WHERE product_category=? "
                +   "                    AND p.product_category=c.category_id "
                +   "                  ORDER BY product_id "
                +   "               ) " 
                +   "         ) "
                +   "      WHERE rNum >= ? AND rNum <= ? ";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);) {
            pstmt.setInt(1, categoryId);
            pstmt.setInt(2, start);
            pstmt.setInt(3, end);
            
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
                vo.setCategoryName(rs.getString("category_name"));
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
    
    /** 상품 리스트 읽어오기
     * @return 모든 상품 리스트
     * */
    @Override
    public List<ProductVO> productListAll(int start, int end) {
        Log.i(this.getClass().getName(), "productList");
        List<ProductVO> list = new ArrayList<>();
        ProductVO vo;

        String query = "SELECT * " 
                +   "      FROM "
                +   "        (SELECT product_id, product_name, product_price, product_stock, product_img, "
                +   "                product_ea, product_producer, product_origin, product_category, product_content, category_name, rowNum rNum " 
                +   "          FROM ( SELECT * FROM product_tbl p, category_tbl c "
                +   "                  WHERE p.product_category=c.category_id "
                +   "                  ORDER BY product_id "
                +   "               ) " 
                +   "         ) "
                +   "      WHERE rNum >= ? AND rNum <= ? ";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);) {
            pstmt.setInt(1, start);
            pstmt.setInt(2, end);
            
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
    public int insertProduct(ProductVO vo) {
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
    public ProductVO productDetail(int id) {
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

    /** 상품 수정
     * @param : ProductVO
     * 
     * @return
     * 성공 : 1
     * 실패 : -2
     * */
    @Override
    public int modifyProduct(ProductVO vo) {
        Log.i(this.getClass().getName(), "productUpdate");
        int isUpdate = -2;

        String query = "UPDATE product_tbl SET product_name=?, product_price=?, product_stock=?, product_img=?, "
                + "product_ea=?, product_producer=?, product_origin=?, product_category=?, product_content=? "
                + "WHERE product_id=?";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, vo.getProductName());
            pstmt.setInt(2, vo.getProductPrice());
            pstmt.setInt(3, vo.getProductStock());
            pstmt.setString(4, vo.getProductImg());
            pstmt.setString(5, vo.getProductEa());
            pstmt.setString(6, vo.getProductProducer());
            pstmt.setString(7, vo.getProductOrigin());
            pstmt.setInt(8, vo.getCategoryId());
            pstmt.setString(9, vo.getProductContent());
            pstmt.setInt(10, vo.getProductId());
            
            isUpdate = pstmt.executeUpdate();
            if (isUpdate == 0) isUpdate = -2;        
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return isUpdate;
    }

    /** 상품 삭제
     * @param : Product id
     * 
     * @return
     * 성공 : 1
     * 실패 : -1
     * */
    @Override
    public int deleteProduct(int id) {
        Log.i(this.getClass().getName(), "insertGuest");
        int isDelete = -1;

        String query = "DELETE FROM product_tbl WHERE product_id=?";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            
            isDelete = pstmt.executeUpdate();
            if (isDelete == 0) isDelete = -1;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return isDelete;
    }
    
    // 별점 가져오기
    @Override
    public int starPoint() {
        // TODO Auto-generated method stub
        return 0;
    }
}
