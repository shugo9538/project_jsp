package jsp_pj_lsj.dao;

import java.util.List;

import jsp_pj_lsj.vo.CategoryVO;
import jsp_pj_lsj.vo.ProductVO;

public interface ProductDAO {
    // 카테고리 수 가져오기 
    public int categoryCnt();
    
    // 카테고리 목록 가져오기
    public List<CategoryVO> categoryList(int start, int end);
    
    // 카테고리 목록 가져오기
    public List<CategoryVO> categoryListAll();
    
    // 카테고리명
    public String categoryName(int id);
    
    // 카테고리 추가
    public int insertCategory(String name);
    
    // 카테고리 삭제
    public int deleteCategory(String id);

    // 상품 수 가져오기 
    public int productCnt(int categoryId);
    
    // 상품 수 가져오기 
    public int productCntAll();
    
    // 상품 목록 가져오기
    public List<ProductVO> productList(int categoryId, int start, int end);
    
    // 상품 전체 목록 가져오기
    public List<ProductVO> productListAll(int start, int end);
    
    // 상품 상세 정보
    public ProductVO productDetail(int productId);
    
    // 상품 추가
    public int insertProduct(ProductVO vo);
    
    // 상품 정보 수정
    public int modifyProduct(ProductVO vo);
    
    // 상품 삭제
    public int deleteProduct(int id);
    
    // 별점가져오기
    public int starPoint();
}
