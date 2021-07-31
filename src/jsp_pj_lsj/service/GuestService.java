package jsp_pj_lsj.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface GuestService {
    // 중복확인 처리
    public void confirmId(HttpServletRequest req, HttpServletResponse res);

    // 회원가입 처리
    public void signInAction(HttpServletRequest req, HttpServletResponse res);
    
    // 로그인 처리
    public void loginAction(HttpServletRequest req, HttpServletResponse res);
    
    // 로그인 성공
    public void loginComplete(HttpServletRequest req, HttpServletResponse res);
    
    // 회원정보 인증 및 탈퇴처리
    public void deleteGuestAction(HttpServletRequest req, HttpServletResponse res);
    
    // 회원정보 인증 및 상세페이지
    public void modifyDetailAction(HttpServletRequest req, HttpServletResponse res);
    
    // 회원정보 수정 처리
    public void modifyGuestAction(HttpServletRequest req, HttpServletResponse res);
}
