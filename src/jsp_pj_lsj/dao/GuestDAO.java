package jsp_pj_lsj.dao;

import java.util.List;

import jsp_pj_lsj.vo.CategoryVO;
import jsp_pj_lsj.vo.ProductVO;
import jsp_pj_lsj.vo.QnaVO;
import jsp_pj_lsj.vo.UserVO;

public interface GuestDAO {
    /********************* 고객화면 ****************************/
    // 중복확인 처리
    public boolean idCheck(String id);
    
    // 회원가입 처리
    public int insertGuest(UserVO vo);
    
    // 메일 송신
    public void sendmail(String email, String key);
    
    // 이메일 확인
    public int emailChk(String key);
    
    // 로그인 처리
    public int userCheck(String id, String pw);
    
    // 회원정보 상세 페이지
    public UserVO getGuestInfo(String id);
    
    // 회원정보 탈퇴 처리
    public int deleteGuest(String id);
    
    // 회원정보 수정 처리
    public int updateGuest(UserVO vo);
    
    // 문의하기
    public int addQna(QnaVO vo);
    
    // 상품 목록 페이지
    public List<ProductVO> productList(int categoryId);
    
    // 상품 정보 화면
    public ProductVO productDetail(int productId);
    
    // 상품 정보 화면
    public List<CategoryVO> categoryList();
}
