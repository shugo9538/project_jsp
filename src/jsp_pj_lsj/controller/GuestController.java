package jsp_pj_lsj.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp_pj_lsj.service.GuestServiceImpl;
import jsp_pj_lsj.vo.CategoryVO;

@WebServlet("*.gu")
public class GuestController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final static String INDEX_PAGE_URL = "index.gu";
    private GuestServiceImpl service = new GuestServiceImpl();

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

        // 인덱스 페이지로 이동
        if (url.equals("/index.gu")) {
            System.out.println("[url ==> ]" + url);
            service.categoryList(req, res);

            viewPage = "/index.jsp";

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

            // 내 주문목록
        } else if (url.equals("/myOrder.gu")) {
            System.out.println("[url ==> ]" + url);

            viewPage = "/guest/myShopping/myOrder.jsp";

            // 환불 요청 목록
        } else if (url.equals("/myRefund.gu")) {
            System.out.println("[url ==> ]" + url);

            viewPage = "/guest/myShopping/myRefund.jsp";

            // 문의하기 페이지
        } else if (url.equals("/inquire.gu")) {
            System.out.println("[url ==> ]" + url);

            viewPage = "/guest/activity/inquire.jsp";

            // 문의 내역(목록 확인)
        } else if (url.equals("/inquireList.gu")) {
            System.out.println("[url ==> ]" + url);

            viewPage = "/guest/activity/inquireList.jsp";

            // QNA 추가
        } else if (url.equals("/inquireAction.gu")) {
            System.out.println("[url ==> ]" + url);
            service.inquireAction(req, res);

            viewPage = "/guest/activity/inquireList.jsp";

            // 리뷰관리 페이지
        } else if (url.equals("/review.gu")) {
            System.out.println("[url ==> ]" + url);

            viewPage = "/guest/activity/review.jsp";

            // 찜 목록
        } else if (url.equals("/wishList.gu")) {
            System.out.println("[url ==> ]" + url);

            viewPage = "/guest/activity/wishList.jsp";

            // 배송지 관리
        } else if (url.equals("/shippingAddress.gu")) {
            System.out.println("[url ==> ]" + url);

            viewPage = "/guest/account/page/shippingAddress.jsp";

            // 장바구니 목록
        } else if (url.equals("/myCart.gu")) {
            System.out.println("[url ==> ]" + url);

            viewPage = "/guest/myShopping/myCart.jsp";

            // 주문 요청
        } else if (url.equals("/order.gu")) {
            System.out.println("[url ==> ]" + url);

            viewPage = "/guest/order/order.jsp";

            // 환불 요청 목록
        } else if (url.equals("/orderConfirm.gu")) {
            System.out.println("[url ==> ]" + url);

            viewPage = "/guest/order/orderConfirm.jsp";

            // 환불 요청 목록
        } else if (url.equals("/myCart.gu")) {
            System.out.println("[url ==> ]" + url);

            viewPage = "/guest/myShopping/myCart.jsp";

            // 상품목록화면
        } else if (url.equals("/productList.gu")) {
            System.out.println("[url ==> ]" + url);
            service.productList(req, res);

            viewPage = "/guest/product/productList.jsp";

            // 상품 상세 정보
        }  else if (url.equals("/productDetail.gu")) {
            System.out.println("[url ==> ]" + url);
            service.productDetail(req, res);

            viewPage = "/guest/product/productInfo.jsp";

        }

        // url에 따라 설정된(viewPage)로 이동
        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
        dispatcher.forward(req, res);
    }
}
