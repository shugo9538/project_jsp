package jsp_pj_lsj.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp_pj_lsj.service.ProductService;
import jsp_pj_lsj.service.ProductServiceImpl;
import jsp_pj_lsj.util.ImageUploaderHandler;
import jsp_pj_lsj.util.Log;

@WebServlet("*.pr")
@MultipartConfig(location = "D:\\Dev88\\workspace\\jsp_pj_lsj\\WebContent\\upload\\product", fileSizeThreshold = 1024
        * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class ProductController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String IMG_UPLOAD_DIR = "D:\\\\Dev88\\\\workspace\\\\jsp_pj_lsj\\\\WebContent\\\\upload\\\\product";
    private ImageUploaderHandler uploader;
    private ProductService prService = new ProductServiceImpl();

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

        /***********************************
         * ********* 고객 상품 요청 ************
         ********************************/
        if (url.equals("/productList.pr")) {
            Log.i("url", url);
            prService.productList(req, res);

            viewPage = "/guest/product/productList.jsp";

        } else if (url.equals("/productDetail.pr")) {
            Log.i("url", url);
            prService.productDetail(req, res);

            viewPage = "/guest/product/productInfo.jsp";

            /***********************************
             ********** 관리자 상품 요청  ************
             ********************************/
            // 카테고리 목록
        } else if (url.equals("/categoryList.pr")) {
            Log.i("url", url);
            prService.categoryList(req, res);
            
            viewPage = "/admin/category/categoryList.jsp";

            // 카테고리 추가
        } else if (url.equals("/categoryAddAction.pr")) {
            Log.i("url", url);
            prService.insertCategory(req, res);
            prService.categoryList(req, res);

            viewPage = "/admin/category/categoryList.jsp";

            // 카테고리 삭제
        } else if (url.equals("/categoryDeleteAction.pr")) {
            Log.i("url", url);
            prService.deleteCategory(req, res);
            prService.categoryList(req, res);

            viewPage = "/admin/category/categoryList.jsp";

            // 재고관리 페이지
        } else if (url.equals("/stockList.pr")) {
            Log.i("url", url);
            prService.productListAll(req, res);
            req.setAttribute("isOk", 1);

            viewPage = "/admin/stock/stockList.jsp";

            // 재고 추가 페이지
        } else if (url.equals("/stockAddAction.pr")) {
            Log.i("url", url);
            String contentType = req.getContentType();
            if (contentType != null && contentType.toLowerCase().startsWith("multipart/")) {
                uploader = new ImageUploaderHandler();
                uploader.setUploadPath(IMG_UPLOAD_DIR);
                uploader.setCachePath(req.getServletContext().getRealPath("/upload"));
                Log.i("url", IMG_UPLOAD_DIR);
                uploader.imageUpload(req, res);
            }

            prService.insertProduct(req, res);

            viewPage = "/admin/stock/stockList.jsp";

            // 상품 삭제
        } else if (url.equals("/stockDeleteAction.pr")) {
            Log.i("url", url);
            prService.deleteProduct(req, res);

            viewPage = "/admin/stock/stockList.jsp";

            // 상품 수정
        } else if (url.equals("/stockModify.pr")) {
            Log.i("url", url);
            prService.modifyProduct(req, res);

            viewPage = "/admin/stock/stockModify.jsp";

            // 상품 수정 처리
        } else if (url.equals("/stockModifyAction.pr")) {
            Log.i("url", url);
            String contentType = req.getContentType();
            if (contentType != null && contentType.toLowerCase().startsWith("multipart/")) {
                uploader = new ImageUploaderHandler();
                uploader.setUploadPath(IMG_UPLOAD_DIR);
                uploader.setCachePath(req.getServletContext().getRealPath("/upload"));
                Log.i("url", IMG_UPLOAD_DIR);
                uploader.imageUpload(req, res);
            }
            prService.modifyProductAction(req, res);

            viewPage = "/admin/stock/stockList.jsp";
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
        dispatcher.forward(req, res);
    }
}
