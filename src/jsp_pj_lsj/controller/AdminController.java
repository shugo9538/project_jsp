package jsp_pj_lsj.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp_pj_lsj.service.AdminService;
import jsp_pj_lsj.service.AdminServiceImpl;

@WebServlet("*.adm")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminService service = new AdminServiceImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
	        throws ServletException, IOException {
	    action(req, res);
	}

    protected void doPost(HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException {
		doGet(req, res);
	}

    private void action(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        
        String viewPage = "";
        
        String uri = req.getRequestURI(); // 컨텍스트명 + 나머지 주소
        String contextPath = req.getContextPath();
        String url = uri.substring(contextPath.length());
        
        // 관리자 페이지 시작지점
        if (url.equals("/admin.adm")) {
            System.out.println("[url ==> ]" + url);
            
            viewPage = "/admin.jsp";
            
        // 로그인 처리
        } else if (url.equals("/loginAction.adm")) {
            System.out.println("[url ==> ]" + url);
            service.loginAction(req, res);
            
            viewPage = "/admin/account/action/loginAction.jsp";
            
        // 로그인 완료 후 세션 적용과 이동
        } else if (url.equals("/loginComplete.adm")) {
            System.out.println("[url ==> ]" + url);
            service.loginComplete(req, res);
            service.categoryList(req, res);
            
            viewPage = "/admin/category/categoryList.jsp";
         
        // 로그아웃
        } else if (url.equals("/logout.adm")) {
            System.out.println("[url ==> ]" + url);
            req.getSession().invalidate();
            
            viewPage = "/admin.jsp";
            
        // 카테고리 추가
        } else if (url.equals("/categoryAdd.adm")) {
            System.out.println("[url ==> ]" + url);
            
            viewPage = "/admin/category/categoryList.jsp";
        } 
        
        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
        dispatcher.forward(req, res);
    }
}
