package jsp_pj_lsj.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp_pj_lsj.service.GuestServiceImpl;

@WebServlet("*.gu")
public class GuestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static String INDEX_PAGE_URL = "/index.jsp";
	private GuestServiceImpl service = new GuestServiceImpl();
	
    public GuestController() {
        super();
    }

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
        
        // 2단계. 요청 분석
        if (url.equals("/index.gu")) {
            System.out.println("[url ==> ]" + url);
            
            viewPage = INDEX_PAGE_URL;
            
        } else if (url.equals("/signIn.gu")) {
            System.out.println("[url ==> ]" + url);
            
            viewPage = "/guest/account/signIn.jsp";
            
        } else if (url.equals("/signInAction.gu")) {
            System.out.println("[url ==> ]" + url);
            service.signInAction(req, res);
            
            viewPage = "/guest/account/signInAction.jsp";
        
        } else if (url.equals("/signInComplete.gu")) {
            System.out.println("[url ==> ]" + url);
            
            viewPage = INDEX_PAGE_URL;
            
        } else if (url.equals("/login.gu")) {
            System.out.println("[url ==> ]" + url);
            
            viewPage = "/guest/account/login.jsp";
            
        } else if (url.equals("/loginAction.gu")) {
            System.out.println("[url ==> ]" + url);
            service.loginAction(req, res);
            
            viewPage = "/guest/account/loginAction.jsp";
            
        } else if (url.equals("/loginComplete.gu")) {
            System.out.println("[url ==> ]" + url);
            service.loginComplete(req, res);
            
            viewPage = INDEX_PAGE_URL;
            
        } else if (url.equals("/logout.gu")) {
            System.out.println("[url ==> ]" + url);
            req.getSession().invalidate();
            
            viewPage = INDEX_PAGE_URL;
            
        } else if (url.equals("/editInfo.gu")) {
            System.out.println("[url ==> ]" + url);
            
            viewPage = "/guest/account/editInfo.jsp";
            
        } 
        
        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
        dispatcher.forward(req, res);
    }
}
