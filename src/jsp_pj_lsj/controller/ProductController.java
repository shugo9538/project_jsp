package jsp_pj_lsj.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.pr")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductController() {
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
        
        if (url.equals("/productList.pr")) {
            System.out.println("[url ==> ]" + url);
            
            viewPage = "/guest/product/productList.jsp";
            
        } else if (url.equals("/productDetail.pr")) {
            System.out.println("[url ==> ]" + url);
            
            viewPage = "/guest/product/productList.jsp";
            
        } else if (url.equals("/prouctInsert.pr")) {
            System.out.println("[url ==> ]" + url);
            
            viewPage = "/guest/product/productList.jsp";
            
        } else if (url.equals("/productUpdate.pr")) {
            System.out.println("[url ==> ]" + url);
            
            viewPage = "/guest/product/productList.jsp";
            
        } else if (url.equals("/productDelete.pr")) {
            System.out.println("[url ==> ]" + url);
            
            viewPage = "/guest/product/productList.jsp";
            
        }
        
        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
        dispatcher.forward(req, res);
    }
}
