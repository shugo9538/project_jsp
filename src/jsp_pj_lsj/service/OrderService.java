package jsp_pj_lsj.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface OrderService {
    // 주문페이지
    public void order(HttpServletRequest req, HttpServletResponse res);
}
