package jsp_pj_lsj.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp_pj_lsj.dao.UserDAO;
import jsp_pj_lsj.dao.UserDAOImpl;
import jsp_pj_lsj.util.Log;
import jsp_pj_lsj.vo.UserVO;

public class AdminServiceImpl implements AdminService {
    private UserDAO userDAO = UserDAOImpl.INSTANCE;
    private UserVO vo = null;

    // 로그인시 사용자 정보 확인
    @Override
    public void loginAction(HttpServletRequest req, HttpServletResponse res) {
        Log.i(this.getClass().getName(), "loginAction");

        // 로그인 아이디, 비밀번호 획득
        String id = req.getParameter("email");
        String pw = req.getParameter("pw");

        // 사용자 정보 확인
        int isUser = userDAO.userCheck(id, pw, 1);
        String redirectURL = "makeSession.adm?id=" + id;
        
        // 사용자 정보 설정
        req.setAttribute("isUser", isUser);
        req.setAttribute("redirectURL", redirectURL);
    }

    // 로그인 처리 완료
    @Override
    public void makeSession(HttpServletRequest req, HttpServletResponse res) {
        Log.i(this.getClass().getName(), "loginComplete");

        // 로그인한 회원 정보 가져오기
        String id = req.getParameter("id").toString();
        vo = new UserVO();
        vo = userDAO.getUserData(id);

        // 로그인 결과 세션에 적용
        req.getSession().setAttribute("vo", vo);
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
