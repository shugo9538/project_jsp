package jsp_pj_lsj.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface GuestService {
    // 회원가입 처리
    public void signInAction(HttpServletRequest req, HttpServletResponse res);

    // 회원가입 처리
    public void checkIDAction(HttpServletRequest req, HttpServletResponse res);

    // 로그인 처리
    public void loginAction(HttpServletRequest req, HttpServletResponse res);

    // 로그인 성공
    public void makeSession(HttpServletRequest req, HttpServletResponse res);

    // 회원정보 인증 및 탈퇴처리
    public void deleteAction(HttpServletRequest req, HttpServletResponse res);

    // 회원정보 인증 및 상세페이지
    public void modifyAction(HttpServletRequest req, HttpServletResponse res);

    // 비밀번호 확인
    public void checkPW(HttpServletRequest req, HttpServletResponse res);

    
    // 배송지 추가하기
    public void addArrivalAddr(HttpServletRequest req, HttpServletResponse res);
}
