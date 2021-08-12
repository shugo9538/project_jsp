package jsp_pj_lsj.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp_pj_lsj.dao.ProductDAO;
import jsp_pj_lsj.dao.ProductDAOImpl;
import jsp_pj_lsj.util.Log;
import jsp_pj_lsj.util.Pager;
import jsp_pj_lsj.vo.CategoryVO;
import jsp_pj_lsj.vo.ProductVO;

public class ProductServiceImpl implements ProductService {
    private ProductDAO prDAO = ProductDAOImpl.INSTANCE;
    private Pager pager = Pager.INSTANCE;
    
    @Override
    public void categoryList(HttpServletRequest req, HttpServletResponse res) {
        Log.i(this.getClass().getName(), "categoryList");
        
        int cnt = prDAO.categoryCnt();
        pager.setCnt(cnt);
        
        String pageNum = "";
        pageNum = req.getParameter("pageNum");
        if (pageNum == null) pageNum =  "1";
        
        pager.setPageNum(Integer.parseInt(pageNum));
        
        // 모든 카테고리 정보 가져오기
        ArrayList<CategoryVO> list = (ArrayList<CategoryVO>) prDAO.categoryList(pager.getStart(), pager.getEnd());
        
        // 결과 반환
        req.getSession().setAttribute("categoryList", list);
        req.setAttribute("cnt", cnt);
        req.setAttribute("pageNum", pageNum);
        req.setAttribute("number", pager.getNumber());
        
        if (cnt > 0) {
            req.setAttribute("startPage", pager.getStartPage());
            req.setAttribute("endPage", pager.getEndPage());
            req.setAttribute("pageBlock", pager.getBlock());
            req.setAttribute("pageCnt", pager.getPageCnt());
            req.setAttribute("currentPage", pager.getCurrentPage());
        }
    }
    
    @Override
    public void categoryListAll(HttpServletRequest req, HttpServletResponse res) {
        Log.i(this.getClass().getName(), "categoryListAll");

        // 모든 카테고리 정보 가져오기
        ArrayList<CategoryVO> list = (ArrayList<CategoryVO>) prDAO.categoryListAll();

        // 결과 반환
        req.getSession().setAttribute("categoryList", list);
    }

    @Override
    public void categoryName(HttpServletRequest req, HttpServletResponse res) {
        Log.i(this.getClass().getName(), "categoryName");
        int id = Integer.parseInt(req.getParameter("id"));
        String name = prDAO.categoryName(id);
        
        req.setAttribute("categoryName", name);
    }

    @Override
    public void insertCategory(HttpServletRequest req, HttpServletResponse res) {
        Log.i(this.getClass().getName(), "categoryAdd");

        // 카테고리 데이터 추가
        String id = req.getParameter("category_name");
        int isInsert = prDAO.insertCategory(id);

        // 결과 반환
        req.setAttribute("isError", isInsert);
    }

    @Override
    public void deleteCategory(HttpServletRequest req, HttpServletResponse res) {
        Log.i(this.getClass().getName(), "categoryDelete");

        // 카테고리 데이터 삭제
        String id = req.getParameter("categoryId");
        int isDelete = (prDAO.deleteCategory(id) == 1) ? 1 : -1;

        // 결과 반환
        req.setAttribute("isError", isDelete);
    }

    @Override
    public void productList(HttpServletRequest req, HttpServletResponse res) {
        Log.i(this.getClass().getName(), "productList");
        int categoryId = Integer.parseInt(req.getParameter("categoryId"));
        
        int cnt = prDAO.productCnt(categoryId);
        pager.setCnt(cnt);
        
        String pageNum = "";
        pageNum = req.getParameter("pageNum");
        if (pageNum == null) pageNum =  "1";
        
        pager.setPageNum(Integer.parseInt(pageNum));
        
        List<ProductVO> list = (ArrayList<ProductVO>) prDAO.productList(categoryId, pager.getStart(), pager.getEnd());
        
        // 결과 반환
        req.setAttribute("list", list);
        req.setAttribute("cnt", cnt);
        req.setAttribute("pageNum", pageNum);
        req.setAttribute("number", pager.getNumber());
        
        if (cnt > 0) {
            req.setAttribute("startPage", pager.getStartPage());
            req.setAttribute("endPage", pager.getEndPage());
            req.setAttribute("pageBlock", pager.getBlock());
            req.setAttribute("pageCnt", pager.getPageCnt());
            req.setAttribute("currentPage", pager.getCurrentPage());
        }
    }

    @Override
    public void productListAll(HttpServletRequest req, HttpServletResponse res) {
        Log.i(this.getClass().getName(), "stockList");
        
        int cnt = prDAO.productCntAll();
        pager.setCnt(cnt);
        
        String pageNum = "";
        pageNum = req.getParameter("pageNum");
        if (pageNum == null) pageNum =  "1";
        
        pager.setPageNum(Integer.parseInt(pageNum));
        
        // 재고 목록 데이터
        ArrayList<ProductVO> list = (ArrayList<ProductVO>) prDAO.productListAll(pager.getStart(), pager.getEnd());
        ArrayList<CategoryVO> category = (ArrayList<CategoryVO>) prDAO.categoryList(1, pager.getCnt());

        for (ProductVO vo : list) {
            for (CategoryVO name : category) {
                if (vo.getCategoryId() == name.getCategoryId()) {
                    vo.setCategoryName(name.getCategoryName());
                    break;
                }
            }
        }

        // 결과 반환
        req.setAttribute("productVO", list);
        req.setAttribute("categoryVO", category);
        req.setAttribute("cnt", cnt);
        req.setAttribute("pageNum", pageNum);
        req.setAttribute("number", pager.getNumber());
        
        if (cnt > 0) {
            req.setAttribute("startPage", pager.getStartPage());
            req.setAttribute("endPage", pager.getEndPage());
            req.setAttribute("pageBlock", pager.getBlock());
            req.setAttribute("pageCnt", pager.getPageCnt());
            req.setAttribute("currentPage", pager.getCurrentPage());
        }
    }

    @Override
    public void productDetail(HttpServletRequest req, HttpServletResponse res) {
        Log.i(this.getClass().getName(), "productDetail");
        int productId = Integer.parseInt(req.getParameter("id"));
        ProductVO vo = prDAO.productDetail(productId);
        Log.i("vo", vo.getProductName());
        req.setAttribute("ProductVO", vo);
    }

    @Override
    public void insertProduct(HttpServletRequest req, HttpServletResponse res) {
        Log.i(this.getClass().getName(), "stockAdd");
        ProductVO vo = new ProductVO();
        res.setContentType("image/jpeg");

        vo.setProductName(req.getParameter("productName"));
        vo.setProductPrice(Integer.parseInt(req.getParameter("productPrice")));
        vo.setProductStock(Integer.parseInt(req.getParameter("productStock")));
        vo.setProductImg((String) req.getAttribute("fileName"));
        vo.setProductEa(req.getParameter("productEA"));
        vo.setProductProducer(req.getParameter("productProducer"));
        vo.setProductOrigin(req.getParameter("productOrigin"));
        vo.setCategoryId(Integer.parseInt(req.getParameter("categoryId")));
        vo.setProductContent(req.getParameter("productContent"));
        vo.setCategoryName(prDAO.categoryName(vo.getCategoryId()));

        int isInsert = prDAO.insertProduct(vo);

        req.setAttribute("isError", isInsert);
    }

    @Override
    public void modifyProduct(HttpServletRequest req, HttpServletResponse res) {
        Log.i(this.getClass().getName(), "stockModify");

        int id = Integer.parseInt(req.getParameter("id"));
        ProductVO vo = prDAO.productDetail(id);
        ArrayList<CategoryVO> category = (ArrayList<CategoryVO>) prDAO.categoryListAll();

        req.setAttribute("vo", vo);
        req.setAttribute("categoryVO", category);
    }
    
    @Override
    public void modifyProductAction(HttpServletRequest req, HttpServletResponse res) {
        Log.i(this.getClass().getName(), "stockModifyAction");
        ProductVO vo = new ProductVO();

        vo.setProductId(Integer.parseInt(req.getParameter("productId")));
        vo.setProductName(req.getParameter("productName"));
        vo.setProductPrice(Integer.parseInt(req.getParameter("productPrice")));
        vo.setProductStock(Integer.parseInt(req.getParameter("productStock")));
        vo.setProductImg((String) req.getAttribute("fileName"));
        vo.setProductEa(req.getParameter("productEA"));
        vo.setProductProducer(req.getParameter("productProducer"));
        vo.setProductOrigin(req.getParameter("productOrigin"));
        vo.setCategoryId(Integer.parseInt(req.getParameter("categoryId")));
        vo.setProductContent(req.getParameter("productContent"));
        vo.setCategoryName(prDAO.categoryName(vo.getCategoryId()));

        int isModify = prDAO.modifyProduct(vo);

        req.setAttribute("isError", isModify);
    }

    @Override
    public void deleteProduct(HttpServletRequest req, HttpServletResponse res) {
        Log.i(this.getClass().getName(), "stockDelete");

        int id = Integer.parseInt(req.getParameter("id"));
        int isDelete = prDAO.deleteProduct(id);

        req.setAttribute("isError", isDelete);
    }

    @Override
    public void starPoint(HttpServletRequest req, HttpServletResponse res) {
        
    }

}
