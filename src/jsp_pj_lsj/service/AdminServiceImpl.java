package jsp_pj_lsj.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp_pj_lsj.dao.AdminDAO;
import jsp_pj_lsj.dao.AdminDAOImpl;
import jsp_pj_lsj.dao.GuestDAO;
import jsp_pj_lsj.dao.GuestDAOImpl;
import jsp_pj_lsj.util.Log;
import jsp_pj_lsj.vo.CategoryVO;
import jsp_pj_lsj.vo.ProductVO;
import jsp_pj_lsj.vo.UserVO;

public class AdminServiceImpl implements AdminService {
    private AdminDAO adminDAO = AdminDAOImpl.INSTANCE;
    private GuestDAO guestDAO = GuestDAOImpl.INSTANCE;
    private UserVO vo = null;

    // 로그인시 사용자 정보 확인
    @Override
    public void loginAction(HttpServletRequest req, HttpServletResponse res) {
        Log.i(this.getClass().getName(), "loginAction");

        // 로그인 아이디, 비밀번호 획득
        String id = req.getParameter("email");
        String pw = req.getParameter("pw");

        // 사용자 정보 확인
        int isUser = adminDAO.adminCheck(id, pw);

        // 사용자 정보 설정
        req.setAttribute("isUser", isUser);
        req.setAttribute("id", id);
    }

    // 로그인 처리 완료
    @Override
    public void loginComplete(HttpServletRequest req, HttpServletResponse res) {
        Log.i(this.getClass().getName(), "loginComplete");

        // 로그인한 회원 정보 가져오기
        String id = req.getParameter("id").toString();
        vo = new UserVO();
        vo = guestDAO.getGuestInfo(id);

        // 로그인 결과 세션에 적용
        req.getSession().setAttribute("vo", vo);
    }

    // 카테고리 리스트 호출
    @Override
    public void categoryList(HttpServletRequest req, HttpServletResponse res) {
        Log.i(this.getClass().getName(), "categoryList");

        // 모든 카테고리 정보 가져오기
        ArrayList<CategoryVO> list = (ArrayList<CategoryVO>) adminDAO.categoryList();

        // 결과 반환
        req.setAttribute("categoryVO", list);
    }

    // 카테고리 추가
    @Override
    public void categoryAdd(HttpServletRequest req, HttpServletResponse res) {
        Log.i(this.getClass().getName(), "categoryAdd");

        // 카테고리 데이터 추가
        String id = req.getParameter("category_name");
        int isInsert = adminDAO.categoryAdd(id);

        // 결과 반환
        req.setAttribute("isError", isInsert);
    }

    // 카테고리 삭제
    @Override
    public void categoryDelete(HttpServletRequest req, HttpServletResponse res) {
        Log.i(this.getClass().getName(), "categoryDelete");

        // 카테고리 데이터 삭제
        String id = req.getParameter("categoryId");
        int isDelete = (adminDAO.categoryDelete(id) == 1) ? 1 : -1;

        // 결과 반환
        req.setAttribute("isError", isDelete);
    }

    // 재고목록
    @Override
    public void stockList(HttpServletRequest req, HttpServletResponse res) {
        Log.i(this.getClass().getName(), "stockList");

        // 재고 목록 데이터
        ArrayList<ProductVO> list = (ArrayList<ProductVO>) adminDAO.productList();
        ArrayList<CategoryVO> category = (ArrayList<CategoryVO>) adminDAO.categoryList();

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
    }

    // 재고 추가
    @Override
    public void stockAdd(HttpServletRequest req, HttpServletResponse res) {
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
        vo.setCategoryName(adminDAO.getCategory(vo.getCategoryId()));

        int isInsert = adminDAO.productAdd(vo);

        req.setAttribute("isError", isInsert);
    }

    // 재고삭제
    @Override
    public void stockDelete(HttpServletRequest req, HttpServletResponse res) {
        Log.i(this.getClass().getName(), "stockDelete");

        int id = Integer.parseInt(req.getParameter("id"));
        int isDelete = adminDAO.productDelete(id);

        req.setAttribute("isError", isDelete);
    }

    // 상품정보 수정
    @Override
    public void stockModify(HttpServletRequest req, HttpServletResponse res) {
        Log.i(this.getClass().getName(), "stockModify");

        int id = Integer.parseInt(req.getParameter("id"));
        ProductVO vo = adminDAO.getProductDetail(id);
        ArrayList<CategoryVO> category = (ArrayList<CategoryVO>) adminDAO.categoryList();

        req.setAttribute("vo", vo);
        req.setAttribute("categoryVO", category);
    }

    // 상품정보 수정
    @Override
    public void stockModifyAction(HttpServletRequest req, HttpServletResponse res) {
        Log.i(this.getClass().getName(), "stockModifyAction");
        ProductVO vo = new ProductVO();

        vo.setProductId(Integer.parseInt(req.getParameter("productId")));
        vo.setProductName(req.getParameter("productName"));
        vo.setProductPrice(Integer.parseInt(req.getParameter("productPrice")));
        vo.setProductStock(Integer.parseInt(req.getParameter("productStock")));
        vo.setProductImg(req.getParameter("productImg"));
        vo.setProductEa(req.getParameter("productEA"));
        vo.setProductProducer(req.getParameter("productProducer"));
        vo.setProductOrigin(req.getParameter("productOrigin"));
        vo.setCategoryId(Integer.parseInt(req.getParameter("categoryId")));
        vo.setProductContent(req.getParameter("productContent"));
        vo.setCategoryName(adminDAO.getCategory(vo.getCategoryId()));

        int isModify = adminDAO.productUpdate(vo);

        req.setAttribute("isError", isModify);
    }

    // 환불목록
    @Override
    public void refundList(HttpServletRequest req, HttpServletResponse res) {
        Log.i(this.getClass().getName(), "refundList");
    }

    // 환불요청
    @Override
    public void refundAction(HttpServletRequest req, HttpServletResponse res) {
        Log.i(this.getClass().getName(), "refundAction");

    }

}
