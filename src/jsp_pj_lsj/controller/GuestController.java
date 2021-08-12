package jsp_pj_lsj.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp_pj_lsj.service.GuestServiceImpl;
import jsp_pj_lsj.service.ProductService;
import jsp_pj_lsj.service.ProductServiceImpl;
import jsp_pj_lsj.util.Log;

@WebServlet("*.gu")
public class GuestController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final static String INDEX_PAGE_URL = "index.gu";
    private GuestServiceImpl service = new GuestServiceImpl();
    private ProductService prService = new ProductServiceImpl();

    // action 실행
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        action(req, res);
    }

    // 시작
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res);
    }

    // url 파싱 및 페이지 이동
    private void action(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String viewPage = "";

        String uri = req.getRequestURI(); // 컨텍스트명 + 나머지 주소
        String contextPath = req.getContextPath();
        String url = uri.substring(contextPath.length());

        /*******************************************
         *************** 사용자 정보 처리****************
         ******************************************/
        // 인덱스 페이지로 이동
        if (url.equals("/index.gu")) {
            Log.i("url", url);
            prService.categoryListAll(req, res);

            viewPage = "/index.jsp";

            // 회원가입 페이지 이동
        } else if (url.equals("/signIn.gu")) {
            Log.i("url", url);

            viewPage = "/guest/account/signIn.jsp";

            // 회원가입 처리
        } else if (url.equals("/signInAction.gu")) {
            Log.i("url", url);
            service.signInAction(req, res);
            String redirectURL = "login.gu";

            req.setAttribute("redirectURL", redirectURL);
            viewPage = "/action/insertAction.jsp";

            // 이메일 인증
        } else if (url.equals("/emailChk.gu")) {
            Log.i("url", url);
            service.checkIDAction(req, res);

            viewPage = INDEX_PAGE_URL;

            // 로그인 페이지로 이동
        } else if (url.equals("/login.gu")) {
            Log.i("url", url);
            viewPage = "/guest/account/login.jsp";

            // 로그인 처리
        } else if (url.equals("/loginAction.gu")) {
            Log.i("url", url);
            service.loginAction(req, res);
            String redirectURL = "makeSession.gu";
            
            req.setAttribute("redirectURL", redirectURL);

            viewPage = "/action/loginAction.jsp";

            // 로그인 완료 후 세션 적용과 이동
        } else if (url.equals("/makeSession.gu")) {
            Log.i("url", url);
            service.makeSession(req, res);

            viewPage = INDEX_PAGE_URL;

            // 로그아웃
        } else if (url.equals("/logout.gu")) {
            Log.i("url", url);
            req.getSession().invalidate();

            viewPage = INDEX_PAGE_URL;

            // 회원정보 수정
        } else if (url.equals("/editInfo.gu")) {
            Log.i("url", url);

            viewPage = "/guest/account/editInfo.jsp";

            // 회원정보 수정 처리
        } else if (url.equals("/editInfoAction.gu")) {
            Log.i("url", url);
            service.modifyAction(req, res);
            String redirectURL = "editInfo.gu";

            req.setAttribute("redirectURL", redirectURL);
            viewPage = "/action/updateAction.jsp";

            // 이름수정화면
        } else if (url.equals("/editName.gu")) {
            Log.i("url", url);

            viewPage = "/guest/account/page/editName.jsp";

            // 회원 탈퇴 화면
        } else if (url.equals("/withdrawal.gu")) {
            Log.i("url", url);

            viewPage = "/guest/account/withdrawal.jsp";

            // 회원탈퇴 전 마지막 비밀번호 확인
        } else if (url.equals("/withdrawalAction.gu")) {
            Log.i("url", url);
            service.checkPW(req, res);
            String redirectURL = "withdrawalSurvey.gu";

            req.setAttribute("redirectURL", redirectURL);
            viewPage = "/action/checkAction.jsp";

            // 회원탈퇴 전 설문조사
        } else if (url.equals("/withdrawalSurvey.gu")) {
            Log.i("url", url);

            viewPage = "/guest/account/withdrawalSurvey.jsp";

            // 탈퇴 후 메인 화면으로 이동
        } else if (url.equals("/deleteUserAction.gu")) {
            Log.i("url", url);
            service.deleteAction(req, res);
            String redirectURL = INDEX_PAGE_URL;

            req.setAttribute("redirectURL", redirectURL);

            viewPage = "/action/deleteAction.jsp";

            /*******************************************
             ***************사용자 정보 처리****************
             ******************************************/
            // 내 주문목록
        } else if (url.equals("/myOrder.gu")) {
            Log.i("url", url);

            viewPage = "/guest/myShopping/myOrder.jsp";

            // 환불 요청 목록
        } else if (url.equals("/myRefund.gu")) {
            Log.i("url", url);

            viewPage = "/guest/myShopping/myRefund.jsp";

            // 리뷰관리 페이지
        } else if (url.equals("/review.gu")) {
            Log.i("url", url);

            viewPage = "/guest/activity/review.jsp";

            // 찜 목록
        } else if (url.equals("/wishList.gu")) {
            Log.i("url", url);

            viewPage = "/guest/activity/wishList.jsp";

            // 배송지 관리
        } else if (url.equals("/arrivalAddr.gu")) {
            Log.i("url", url);

            viewPage = "/guest/account/page/arrivalAddr.jsp";

            // 배송지 추가
        } else if (url.equals("/arrivalAddrAddAction.gu")) {
            Log.i("url", url);
            service.addArrivalAddr(req, res);

            viewPage = "/guest/action/insertAction.jsp";

            // 장바구니 목록
        } else if (url.equals("/myCart.gu")) {
            Log.i("url", url);

            viewPage = "/guest/myShopping/myCart.jsp";

            // 주문 요청
        } else if (url.equals("/order.gu")) {
            Log.i("url", url);

            viewPage = "/guest/order/order.jsp";

            // 환불 요청 목록
        } else if (url.equals("/orderConfirm.gu")) {
            Log.i("url", url);

            viewPage = "/guest/order/orderConfirm.jsp";

            // 환불 요청 목록
        } else if (url.equals("/myCart.gu")) {
            Log.i("url", url);

            viewPage = "/guest/myShopping/myCart.jsp";

            // 상품목록화면
        } else if (url.equals("/productList.gu")) {
            Log.i("url", url);
            prService.productList(req, res);

            viewPage = "/guest/product/productList.jsp";

            // 상품 상세 정보
        } else if (url.equals("/productDetail.gu")) {
            Log.i("url", url);
            prService.productDetail(req, res);

            viewPage = "/guest/product/productInfo.jsp";

        }

        // url에 따라 설정된(viewPage)로 이동
        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
        dispatcher.forward(req, res);
    }
}
