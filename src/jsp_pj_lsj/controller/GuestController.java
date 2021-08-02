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
            
            viewPage = "/guest/account/page/signIn.jsp";
            
        // 회원가입 처리
        } else if (url.equals("/signInAction.gu")) {
            System.out.println("[url ==> ]" + url);
            service.signInAction(req, res);
            
            viewPage = "/guest/account/action/signInAction.jsp";
        
        // 회원가입 완료 후 이동
        } else if (url.equals("/signInComplete.gu")) {
            System.out.println("[url ==> ]" + url);
            
            viewPage = INDEX_PAGE_URL;
            
        // 이메일 인증
        } else if (url.equals("/emailChk.gu")) {
            System.out.println("[url ==> ]" + url);
            service.emailChkAction(req, res);
            
            viewPage = INDEX_PAGE_URL;
            
        // 로그인 페이지로 이동
        } else if (url.equals("/login.gu")) {
            System.out.println("[url ==> ]" + url);
            
            viewPage = "/guest/account/page/login.jsp";
            
        // 로그인 처리
        } else if (url.equals("/loginAction.gu")) {
            System.out.println("[url ==> ]" + url);
            service.loginAction(req, res);
            
            viewPage = "/guest/account/action/loginAction.jsp";
            
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
            
            viewPage = "/guest/account/page/editInfo.jsp";
            
        // 회원정보 수정 처리
        } else if (url.equals("/editInfoAction.gu")) {
            System.out.println("[url ==> ]" + url);
            service.editAction(req, res);
            
            viewPage = "/guest/account/action/editInfoAction.jsp";
            
        // 회원정보 완료 후 수정화면으로 다시 이동
        } else if (url.equals("/editInfoComplete.gu")) {
            System.out.println("[url ==> ]" + url);
            service.editComplete(req, res);
            
            viewPage = "/guest/account/page/editInfo.jsp";
            
        // 이름수정화면
        } else if (url.equals("/editName.gu")) {
            System.out.println("[url ==> ]" + url);
            
            viewPage = "/guest/account/page/editName.jsp";
            
        // 회원 탈퇴 화면
        } else if (url.equals("/withdrawal.gu")) {
            System.out.println("[url ==> ]" + url);
            
            viewPage = "/guest/account/page/withdrawal.jsp";
            
        // 회원탈퇴 전 마지막 비밀번호 확인
        } else if (url.equals("/withdrawalAction.gu")) {
            System.out.println("[url ==> ]" + url);
            service.confirmPw(req, res);
            
            viewPage = "/guest/account/action/withdrawalAction.jsp";
            
        // 회원탈퇴 전 설문조사
        } else if (url.equals("/withdrawalSurvey.gu")) {
            System.out.println("[url ==> ]" + url);
            
            viewPage = "/guest/account/page/withdrawalSurvey.jsp";
            
        // 탈퇴 후 메인 화면으로 이동
        } else if (url.equals("/withdrawalComplete.gu")) {
            System.out.println("[url ==> ]" + url);
            service.deleteAction(req, res);
            
            viewPage = INDEX_PAGE_URL;
            
        } 
        
        // url에 따라 설정된(viewPage)로 이동
        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
        dispatcher.forward(req, res);
    }
}
