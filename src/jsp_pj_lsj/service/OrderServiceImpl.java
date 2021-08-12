package jsp_pj_lsj.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp_pj_lsj.dao.OrderDAO;
import jsp_pj_lsj.dao.OrderDAOImpl;
import jsp_pj_lsj.dao.ProductDAO;
import jsp_pj_lsj.dao.ProductDAOImpl;
import jsp_pj_lsj.dao.UserDAO;
import jsp_pj_lsj.dao.UserDAOImpl;
import jsp_pj_lsj.util.Log;
import jsp_pj_lsj.vo.ArrivalVO;
import jsp_pj_lsj.vo.ProductVO;

public class OrderServiceImpl implements OrderService {
    private OrderDAO orderDAO = OrderDAOImpl.INSTANCE;
    private UserDAO userDAO = UserDAOImpl.INSTANCE;
    private ProductDAO prDAO = ProductDAOImpl.INSTANCE;

    @Override
    public void order(HttpServletRequest req, HttpServletResponse res) {
        int productId = Integer.parseInt(req.getParameter("productId"));
        int cnt = Integer.parseInt(req.getParameter("cnt"));
        
        ProductVO productVO = prDAO.productDetail(productId);
        ArrivalVO arrivalVO = userDAO.defaultArrivalAddr();
        Log.i("arrivalVO", arrivalVO.getArrivalAddr());
        
        req.setAttribute("ProductVO", productVO);
        req.setAttribute("ArrivalVO", arrivalVO);
        req.setAttribute("OrderCnt", cnt);
    }
}
