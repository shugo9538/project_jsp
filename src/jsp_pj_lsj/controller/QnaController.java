package jsp_pj_lsj.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp_pj_lsj.service.QnaService;
import jsp_pj_lsj.service.QnaServiceImpl;
import jsp_pj_lsj.util.ImageUploaderHandler;
import jsp_pj_lsj.util.Log;

@WebServlet("*.qa")
@MultipartConfig(location = "D:\\Dev88\\workspace\\jsp_pj_lsj\\WebContent\\upload\\qna", fileSizeThreshold = 1024
        * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class QnaController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String IMG_UPLOAD_DIR = "D:\\\\Dev88\\\\workspace\\\\jsp_pj_lsj\\\\WebContent\\\\upload\\\\qna";
    private ImageUploaderHandler uploader;
    private QnaService qnaService = new QnaServiceImpl();

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
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

        // 문의하기 페이지
        if (url.equals("/inquire.qa")) {
            Log.i("url", url);

            viewPage = "/guest/activity/inquire.jsp";

            // 문의 내역(목록 확인)
        } else if (url.equals("/inquireList.qa")) {
            Log.i("url", url);
            qnaService.qnaList(req, res);
            
            req.setAttribute("isOk", 1);
            viewPage = "/guest/activity/inquireList.jsp";

            // 문의 내용 수정/삭제 페이지
        } else if (url.equals("/inquireModify.qa")) {
            Log.i("url", url);
            qnaService.modifyQna(req, res);

            viewPage = "/guest/activity/inquireModify.jsp";

            // QNA 추가
        } else if (url.equals("/inquireAction.qa")) {
            Log.i("url", url);
            String contentType = req.getContentType();
            if (contentType != null && contentType.toLowerCase().startsWith("multipart/")) {
                uploader = new ImageUploaderHandler();
                uploader.setUploadPath(IMG_UPLOAD_DIR);
                uploader.setCachePath(req.getServletContext().getRealPath("/qna"));
                Log.i("url", IMG_UPLOAD_DIR);
                uploader.imageUpload(req, res);
            }

            qnaService.insertQna(req, res);
            viewPage = "/guest/activity/inquireList.jsp";
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
        dispatcher.forward(req, res);
    }
}