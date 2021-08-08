package jsp_pj_lsj.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface GuestService {

    // 회원가입 처리
    public void signInAction(HttpServletRequest req, HttpServletResponse res);
    
    // 회원가입 처리
    public void emailChkAction(HttpServletRequest req, HttpServletResponse res);
    
    // 로그인 처리
    public void loginAction(HttpServletRequest req, HttpServletResponse res);
    
    // 로그인 성공
    public void loginComplete(HttpServletRequest req, HttpServletResponse res);
    
    // 회원정보 인증 및 탈퇴처리
    public void deleteAction(HttpServletRequest req, HttpServletResponse res);
    
    // 회원정보 인증 및 상세페이지
    public void editAction(HttpServletRequest req, HttpServletResponse res);
    
    // 회원정보 수정 완료
    public void editComplete(HttpServletRequest req, HttpServletResponse res);
    
    // 비밀번호 확인
    public void confirmPw(HttpServletRequest req, HttpServletResponse res);
    
    // 문의하기
    public void inquireAction(HttpServletRequest req, HttpServletResponse res);
    
    // 문의하기
    public void inquireModify(HttpServletRequest req, HttpServletResponse res);
    
    // 상품 목록 가져오기
    public void productList(HttpServletRequest req, HttpServletResponse res);
    
    // 상품 자세히 보기
    public void productDetail(HttpServletRequest req, HttpServletResponse res);
   
    // 카테고리 목록 가져오기
    public void categoryList(HttpServletRequest req, HttpServletResponse res);
    
    // 배송지 추가하기
    public void addArrivalAddr(HttpServletRequest req, HttpServletResponse res);
}
