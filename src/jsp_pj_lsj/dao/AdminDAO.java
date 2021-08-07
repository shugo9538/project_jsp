package jsp_pj_lsj.dao;

import java.util.List;

import jsp_pj_lsj.vo.CategoryVO;
import jsp_pj_lsj.vo.ProductVO;

public interface AdminDAO {
    /************************ 관리자 DA 요청 및 페이지 생성 ***********************/
    // 관리자 로그인 처리
    public int adminCheck(String id, String pw);
    
    // 회원탈퇴 설문 결과 누적하기
    public void surveyResult(String reason);
    
    // 카테고리 리스트 읽어오기
    public List<CategoryVO> categoryList();
    
    // 카테고리 하나 가져오기
    public String getCategory(int id);
    
    // 카테고리 리스트 추가
    public int categoryAdd(String name);
    
    // 카테고리 리스트 삭제
    public int categoryDelete(String id);

    // 상품 리스트 읽어오기
    public List<ProductVO> productList();
    
    // 상품 추가
    public int productAdd(ProductVO vo);
    
    // 상품 정보 수정
    public ProductVO getProductDetail(int id);
    
    // 상품 정보 수정
    public int productUpdate(ProductVO vo);
    
    // 상품 삭제
    public int productDelete(int id);
    
    // 환불요청 목록
    public int refundList(int id);
    
    // 환불허가
    public int refundOk(int id);
    
    // 리뷰목록
    public int reviewList();    
    
    // 리뷰삭제
    public int reviewDelete();
    
    // 결산 데이터 읽어오기
    public int settelmentData();
    
    // 별점 계산하기
    public int starPoint();
}
