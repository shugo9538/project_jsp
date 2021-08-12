package jsp_pj_lsj.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AdminService {
    // 로그인 처리
    public void loginAction(HttpServletRequest req, HttpServletResponse res);
    
    // 로그인 성공
    public void makeSession(HttpServletRequest req, HttpServletResponse res);
    
    
    // 환불목록
    public void refundList(HttpServletRequest req, HttpServletResponse res);
    
    // 환불처리 (처리 1, 반려 0)
    public void refundAction(HttpServletRequest req, HttpServletResponse res);
    
}
