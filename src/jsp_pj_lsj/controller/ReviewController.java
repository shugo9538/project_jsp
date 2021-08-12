package jsp_pj_lsj.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp_pj_lsj.service.ReviewService;
import jsp_pj_lsj.service.ReviewServiceImpl;
import jsp_pj_lsj.util.ImageUploaderHandler;
import jsp_pj_lsj.util.Log;

@WebServlet("*.rv")
@MultipartConfig(location = "D:\\Dev88\\workspace\\jsp_pj_lsj\\WebContent\\upload\\review", fileSizeThreshold = 1024
        * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class ReviewController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String IMG_UPLOAD_DIR = "D:\\\\Dev88\\\\workspace\\\\jsp_pj_lsj\\\\WebContent\\\\upload\\\\review";

    private ReviewService rvService = new ReviewServiceImpl();
    private ImageUploaderHandler uploader;

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

        // 리뷰 목록
        if (url.equals("/reviewList.rv")) {
            Log.i("url", url);
            rvService.reviewList(req, res);
            
            viewPage = "/admin/review/reviewList.jsp";

            // 리뷰 추가
        } else if (url.equals("/insertReview.rv")) {
            Log.i("url", url);

            viewPage = "/index.jsp";

            // 리뷰 삭제
        } else if (url.equals("/deleteReview.rv")) {
            Log.i("url", url);

            viewPage = "/index.jsp";

            // 리뷰 수정
        } else if (url.equals("/modifyReview.rv")) {
            Log.i("url", url);

            viewPage = "/index.jsp";
        }

        // url에 따라 설정된(viewPage)로 이동
        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
        dispatcher.forward(req, res);
    }

    // 리뷰관리 페이지
//} else if (url.equals("/reviewList.adm")) {
//    System.out.println("[url ==> ]" + url);//
//    viewPage = "/admin/review/reviewList.jsp";
//

}
