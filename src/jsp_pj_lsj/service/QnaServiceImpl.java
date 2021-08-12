package jsp_pj_lsj.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp_pj_lsj.dao.QnaDAO;
import jsp_pj_lsj.dao.QnaDAOImpl;
import jsp_pj_lsj.dao.UserDAO;
import jsp_pj_lsj.dao.UserDAOImpl;
import jsp_pj_lsj.util.Log;
import jsp_pj_lsj.util.Pager;
import jsp_pj_lsj.vo.ProductVO;
import jsp_pj_lsj.vo.QnaVO;
import jsp_pj_lsj.vo.QuestionVO;
import jsp_pj_lsj.vo.UserVO;

public class QnaServiceImpl implements QnaService {
    private QnaDAO qnaDAO = QnaDAOImpl.INSTANCE;
    private UserDAO userDAO = UserDAOImpl.INSTANCE;

    private Pager pager = Pager.INSTANCE;

    // 문의하기
    @Override
    public void insertQna(HttpServletRequest req, HttpServletResponse res) {
        Log.i(this.getClass().getName(), "insertQna");

        QuestionVO vo = new QuestionVO();
        UserVO user = (UserVO) req.getSession().getAttribute("vo");
        String email = user.getEmail();
//        if (!req.getParameter("productId").equals("")) {
//            vo.setProductId(Integer.parseInt(req.getParameter("productId")));
//        }

        vo.setQnaComment(req.getParameter("qnaComment"));
        vo.setUserId(email);
        vo.setQnaTitle(req.getParameter("qnaTitle"));
        vo.setQnaImg((String) req.getAttribute("fileName"));

        int isInsert = qnaDAO.insertQna(vo);

        req.setAttribute("isError", isInsert);
    }

    // 문의 목록 불러오기
    @Override
    public void qnaList(HttpServletRequest req, HttpServletResponse res) {
        Log.i(this.getClass().getName(), "qnaList");
        int cnt = qnaDAO.qnaCnt();
        pager.setCnt(cnt);

        String pageNum = "";
        pageNum = req.getParameter("pageNum");
        if (pageNum == null)
            pageNum = "1";

        pager.setPageNum(Integer.parseInt(pageNum));
        ArrayList<QnaVO> list = (ArrayList<QnaVO>) qnaDAO.qnaList(pager.getStart(), pager.getEnd());

        for (int i = 0 ; i < list.size() ; i++) {
            String email = list.get(i).getUserId();
            list.get(i).setUserName(userDAO.getUserName(email));
        }

        // 결과 반환
        req.setAttribute("qnaList", list);
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

    // 문의 수정/삭제 페이지
    @Override
    public void modifyQna(HttpServletRequest req, HttpServletResponse res) {
        Log.i(this.getClass().getName(), "modifyQna");
    }
}
