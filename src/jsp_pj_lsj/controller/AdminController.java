package jsp_pj_lsj.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.adm")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminController() {
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
        if (url.equals("/admin.adm")) {
            System.out.println("[url ==> ]" + url);
            
            viewPage = "/admin.jsp";
            
        }
        
        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
        dispatcher.forward(req, res);
    }
}
