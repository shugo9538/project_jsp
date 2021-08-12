package jsp_pj_lsj.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ProductService {
    // 카테고리 목록 가져오기
    public void categoryList(HttpServletRequest req, HttpServletResponse res);
    
    // 카테고리 목록 가져오기
    public void categoryListAll(HttpServletRequest req, HttpServletResponse res);

    // 카테고리명
    public void categoryName(HttpServletRequest req, HttpServletResponse res);

    // 카테고리 추가
    public void insertCategory(HttpServletRequest req, HttpServletResponse res);

    // 카테고리 삭제
    public void deleteCategory(HttpServletRequest req, HttpServletResponse res);

    // 상품 목록 가져오기
    public void productList(HttpServletRequest req, HttpServletResponse res);

    // 상품 전체 목록 가져오기
    public void productListAll(HttpServletRequest req, HttpServletResponse res);

    // 상품 상세 정보
    public void productDetail(HttpServletRequest req, HttpServletResponse res);

    // 상품 추가
    public void insertProduct(HttpServletRequest req, HttpServletResponse res);

    // 상품 정보 수정
    public void modifyProduct(HttpServletRequest req, HttpServletResponse res);
    
    // 상품 정보 수정 처리
    public void modifyProductAction(HttpServletRequest req, HttpServletResponse res);

    // 상품 삭제
    public void deleteProduct(HttpServletRequest req, HttpServletResponse res);
    
    // 별점가져오기
    public void starPoint(HttpServletRequest req, HttpServletResponse res);
}
