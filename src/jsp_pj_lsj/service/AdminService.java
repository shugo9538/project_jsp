package jsp_pj_lsj.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AdminService {
    // 로그인 처리
    public void loginAction(HttpServletRequest req, HttpServletResponse res);
    
    // 로그인 성공
    public void loginComplete(HttpServletRequest req, HttpServletResponse res);
    
    // 카테고리 가져오기
    public void categoryList(HttpServletRequest req, HttpServletResponse res);

    // 카테고리 추가
    public void categoryAdd(HttpServletRequest req, HttpServletResponse res);
    
}
