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
import jsp_pj_lsj.service.ProductService;
import jsp_pj_lsj.service.ProductServiceImpl;
import jsp_pj_lsj.util.Log;

@WebServlet("*.adm")
public class AdminController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AdminService adminService = new AdminServiceImpl();
    private ProductService pdService = new ProductServiceImpl();

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        action(req, res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res);
    }

    private void action(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String viewPage = "";

        String uri = req.getRequestURI(); // 컨텍스트명 + 나머지 주소
        String contextPath = req.getContextPath();
        String url = uri.substring(contextPath.length());

        // 관리자 페이지 시작지점
        if (url.equals("/admin.adm")) {
            Log.i("url", url);

            viewPage = "/admin.jsp";

        // 로그인 처리 
        } else if (url.equals("/loginAction.adm")) {
            Log.i("url", url);
            adminService.loginAction(req, res);

            viewPage = "/action/loginAction.jsp";

        // 사용자 확인 이후 성공적인 경우 사용자 세션을 유지
        } else if (url.equals("/makeSession.adm")) {
            Log.i("url", url);
            adminService.makeSession(req, res);
            pdService.categoryList(req, res);

            req.setAttribute("isOk", 1);

            viewPage = "/admin/category/categoryList.jsp";

        // 로그아웃
        } else if (url.equals("/logout.adm")) {
            Log.i("url", url);
            req.getSession().invalidate();

            viewPage = "/admin.jsp";

        } 

        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
        dispatcher.forward(req, res);
    }
}
