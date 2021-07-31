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

    // action 실행
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
	        throws ServletException, IOException {
	    action(req, res);
	}

	// 시작
    protected void doPost(HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException {
		doGet(req, res);
	}

    // url 파싱 및 페이지 이동
    private void action(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        
        String viewPage = "";
        
        String uri = req.getRequestURI(); // 컨텍스트명 + 나머지 주소
        String contextPath = req.getContextPath();
        String url = uri.substring(contextPath.length());
        
        // 인덱스 페이지로 이동
        if (url.equals("/index.gu")) {
            System.out.println("[url ==> ]" + url);
            
            viewPage = INDEX_PAGE_URL;
            
        // 회원가입 페이지 이동
        } else if (url.equals("/signIn.gu")) {
            System.out.println("[url ==> ]" + url);
            
            viewPage = "/guest/account/signIn.jsp";
            
        // 회원가입 처리
        } else if (url.equals("/signInAction.gu")) {
            System.out.println("[url ==> ]" + url);
            service.signInAction(req, res);
            
            viewPage = "/guest/account/signInAction.jsp";
        
        // 회원가입 완료 후 이동
        } else if (url.equals("/signInComplete.gu")) {
            System.out.println("[url ==> ]" + url);
            
            viewPage = INDEX_PAGE_URL;
            
        // 로그인 페이지로 이동
        } else if (url.equals("/login.gu")) {
            System.out.println("[url ==> ]" + url);
            
            viewPage = "/guest/account/login.jsp";
            
        // 로그인 처리
        } else if (url.equals("/loginAction.gu")) {
            System.out.println("[url ==> ]" + url);
            service.loginAction(req, res);
            
            viewPage = "/guest/account/loginAction.jsp";
            
        // 로그인 완료 후 세션 적용과 이동
        } else if (url.equals("/loginComplete.gu")) {
            System.out.println("[url ==> ]" + url);
            service.loginComplete(req, res);
            
            viewPage = INDEX_PAGE_URL;
            
        // 로그아웃
        } else if (url.equals("/logout.gu")) {
            System.out.println("[url ==> ]" + url);
            req.getSession().invalidate();
            
            viewPage = INDEX_PAGE_URL;
            
        // 회원정보 수정
        } else if (url.equals("/editInfo.gu")) {
            System.out.println("[url ==> ]" + url);
            
            viewPage = "/guest/account/editInfo.jsp";
            
        // 회원정보 수정 처리
        } else if (url.equals("/editInfoAction.gu")) {
            System.out.println("[url ==> ]" + url);
            service.editAction(req, res);
            
            viewPage = "/guest/account/editInfoAction.jsp";
            
        } else if (url.equals("/editInfoComplete.gu")) {
            System.out.println("[url ==> ]" + url);
            service.editComplete(req, res);
            
            viewPage = "/guest/account/editInfo.jsp";
            
        } else if (url.equals("/editInfoComplete.gu")) {
            System.out.println("[url ==> ]" + url);
            service.editComplete(req, res);
            
            viewPage = "/guest/account/editInfo.jsp";
            
        } else if (url.equals("/editName.gu")) {
            System.out.println("[url ==> ]" + url);
            
            viewPage = "/guest/account/editName.jsp";
            
        } else if (url.equals("/withdrawal.gu")) {
            System.out.println("[url ==> ]" + url);
            
            viewPage = "/guest/account/withdrawal.jsp";
            
        } else if (url.equals("/withdrawalSurvey.gu")) {
            System.out.println("[url ==> ]" + url);
            
            viewPage = "/guest/account/withdrawalSurvey.jsp";
            
        } else if (url.equals("/withdrawalAction.gu")) {
            System.out.println("[url ==> ]" + url);
            service.deleteAction(req, res);
            
            viewPage = INDEX_PAGE_URL;
            
        } 
        
        // url에 따라 설정된(viewPage)로 이동
        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
        dispatcher.forward(req, res);
    }
}
