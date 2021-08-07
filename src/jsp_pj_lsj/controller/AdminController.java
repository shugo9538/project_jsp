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

            req.setAttribute("isInsert", 1);

            viewPage = "/admin/category/categoryList.jsp";

        // 로그아웃
        } else if (url.equals("/logout.adm")) {
            System.out.println("[url ==> ]" + url);
            req.getSession().invalidate();

            viewPage = "/admin.jsp";

        // 카테고리 목록
        } else if (url.equals("/categoryList.adm")) {
            System.out.println("[url ==> ]" + url);
            service.categoryList(req, res);

            req.setAttribute("isOk", 1);

            viewPage = "/admin/category/categoryList.jsp";

        // 카테고리 추가
        } else if (url.equals("/categoryAddAction.adm")) {
            System.out.println("[url ==> ]" + url);
            service.categoryAdd(req, res);
            service.categoryList(req, res);

            viewPage = "/admin/category/categoryList.jsp";

        // 카테고리 삭제
        } else if (url.equals("/categoryDeleteAction.adm")) {
            System.out.println("[url ==> ]" + url);
            service.categoryDelete(req, res);
            service.categoryList(req, res);

            viewPage = "/admin/category/categoryList.jsp";

        // 재고관리 페이지
        } else if (url.equals("/stockList.adm")) {
            System.out.println("[url ==> ]" + url);
            service.stockList(req, res);
            req.setAttribute("isOk", 1);

            viewPage = "/admin/stock/stockList.jsp";

        // 재고 추가 페이지
        } else if (url.equals("/stockAddAction.adm")) {
            System.out.println("[url ==> ]" + url);
            service.stockAdd(req, res);

            viewPage = "/admin/stock/stockList.jsp";

        // 상품 삭제
        } else if (url.equals("/stockDeleteAction.adm")) {
            System.out.println("[url ==> ]" + url);
            service.stockDelete(req, res);

            viewPage = "/admin/stock/stockList.jsp";

        // 상품 수정
        } else if (url.equals("/stockModify.adm")) {
            System.out.println("[url ==> ]" + url);
            service.stockModify(req, res);

            viewPage = "/admin/stock/stockModify.jsp";

        // 상품 수정 처리
        } else if (url.equals("/stockModifyAction.adm")) {
            System.out.println("[url ==> ]" + url);
            service.stockModifyAction(req, res);

            viewPage = "/admin/stock/stockList.jsp";

        // 환불관리 페이지
        } else if (url.equals("/refundList.adm")) {
            System.out.println("[url ==> ]" + url);

            viewPage = "/admin/refund/refund.jsp";

        // 리뷰관리 페이지
        } else if (url.equals("/reviewList.adm")) {
            System.out.println("[url ==> ]" + url);

            viewPage = "/admin/review/reviewList.jsp";

        // 결산 확인 페이지
        } else if (url.equals("/settlement.adm")) {
            System.out.println("[url ==> ]" + url);

            viewPage = "/admin/settlement/settlement.jsp";
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
        dispatcher.forward(req, res);
    }
}
