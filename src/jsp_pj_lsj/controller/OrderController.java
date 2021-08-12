package jsp_pj_lsj.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp_pj_lsj.service.OrderService;
import jsp_pj_lsj.service.OrderServiceImpl;
import jsp_pj_lsj.util.Log;

@WebServlet("*.od")
public class OrderController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private OrderService orderService = new OrderServiceImpl();
    
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // TODO Auto-generated method stub
        action(req, res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}

    private void action(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	        req.setCharacterEncoding("utf-8");

	        String viewPage = "";

	        String uri = req.getRequestURI(); // 컨텍스트명 + 나머지 주소
	        String contextPath = req.getContextPath();
	        String url = uri.substring(contextPath.length());

	        /***********************************
	         * ********* 고객 주문 관리 ************
	         ********************************/
	        if (url.equals("/order.od")) {
	            Log.i("url", url);
	            orderService.order(req, res);

	            viewPage = "/guest/order/order.jsp";
	        }
	        
	        
	           /***********************************
             * ********* 관리자 주문 관리 ************
             ********************************/
	        
	        // 환불관리 페이지
	      //} else if (url.equals("/refundList.adm")) {
//	          System.out.println("[url ==> ]" + url);
	      //
//	          viewPage = "/admin/refund/refund.jsp";
	      //

	          // 결산 확인 페이지
	      //} else if (url.equals("/settlement.adm")) {
//	          System.out.println("[url ==> ]" + url);
	      //
//	          viewPage = "/admin/settlement/settlement.jsp";
	      //}
	        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
	        dispatcher.forward(req, res);
    }
}
