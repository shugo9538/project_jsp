package jsp_pj_lsj.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp_pj_lsj.dao.ReviewDAO;
import jsp_pj_lsj.dao.ReviewDAOImpl;
import jsp_pj_lsj.util.Log;
import jsp_pj_lsj.util.Pager;
import jsp_pj_lsj.vo.ReviewVO;

public class ReviewServiceImpl implements ReviewService {
    private ReviewDAO rvDAO = ReviewDAOImpl.INSTANCE;
    private Pager pager = Pager.INSTANCE;

    @Override
    public int reviewCnt(HttpServletRequest req, HttpServletResponse res) {
        Log.i(this.getClass().getName(), "reviewCnt");
        int cnt = rvDAO.reviewCnt();
        
        return cnt;
    }

    @Override
    public void reviewList(HttpServletRequest req, HttpServletResponse res) {
        Log.i(this.getClass().getName(), "reviewList");
        int cnt = reviewCnt(req, res);
        pager.setCnt(cnt);
        String pageNum = req.getParameter("pageNum");
        if (pageNum == null) pageNum ="1";
        
        pager.setPageNum(Integer.parseInt(pageNum));
        ArrayList<ReviewVO> list = (ArrayList<ReviewVO>) rvDAO.reviewList(pager.getStart(), pager.getEnd());
        
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
    
    
}
