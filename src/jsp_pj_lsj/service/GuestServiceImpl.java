package jsp_pj_lsj.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp_pj_lsj.dao.AdminDAO;
import jsp_pj_lsj.dao.AdminDAOImpl;
import jsp_pj_lsj.dao.GuestDAO;
import jsp_pj_lsj.dao.GuestDAOImpl;
import jsp_pj_lsj.util.EmailChkHandler;
import jsp_pj_lsj.vo.UserVO;
import jsp_pj_lsj.util.*;


public class GuestServiceImpl implements GuestService {
    private GuestDAO guestDAO = GuestDAOImpl.INSTANCE;
    private AdminDAO adminDAO = AdminDAOImpl.INSTANCE;
    private UserVO vo = null;
    
    // 회원가입 처리
    @Override
    public void signInAction(HttpServletRequest req, HttpServletResponse res) {
        Log.i("SERVICE", this.toString());
        
        // 사용자 입력정보 획득
        String email = req.getParameter("email");
        String key = EmailChkHandler.getKey();
        vo = new UserVO();
        vo.setEmail(email);
        vo.setPw(req.getParameter("pw"));
        vo.setName(req.getParameter("name"));
        vo.setTel(req.getParameter("tel"));
        vo.setEmailChk(key);
        
        // 회원가입 요청
        int isInsert = guestDAO.insertGuest(vo);
        
        // 실패 시 중복정보인지 확인
        boolean isExists = true;
        if (isInsert == 0) {
            isExists = guestDAO.idCheck(vo.getEmail());
        }
        if (!isExists) isInsert = 2;
        else guestDAO.sendmail(email, key);
        
        // 회원가입 결과
        req.setAttribute("isInsert", isInsert);
    }

    // 이메일 인증
    @Override
    public void emailChkAction(HttpServletRequest req, HttpServletResponse res) {
        Log.i("SERVICE", this.toString());
        
        // 사용자 입력정보 획득
        String key = req.getParameter("key");
        
        // 이메일 인증 확인
        int isAuth = guestDAO.emailChk(key);
        
        // 회원가입 결과
        req.setAttribute("isAuth", isAuth);
    }
    
    // 로그인 처리
    @Override
    public void loginAction(HttpServletRequest req, HttpServletResponse res) {
        Log.i("SERVICE", this.toString());
        
        // 로그인 아이디, 비밀번호 획득
        String id = req.getParameter("email");
        String pw = req.getParameter("pw");

        // 사용자 정보 확인
        int isUser = guestDAO.userCheck(id, pw);
        
        // 사용자 정보 설정
        req.setAttribute("isUser", isUser);
        req.setAttribute("id", id);
    }
    
    // 로그인 처리 완료
    @Override
    public void loginComplete(HttpServletRequest req, HttpServletResponse res) {
        Log.i("SERVICE", this.toString());
        
        // 로그인한 회원 정보 가져오기
        String id = req.getParameter("id").toString();
        vo = new UserVO();
        vo = guestDAO.getGuestInfo(id);
        
        // 로그인 결과 세션에 적용
        req.getSession().setAttribute("vo", vo);
    }

    // 회원 삭제
    @Override
    public void deleteAction(HttpServletRequest req, HttpServletResponse res) {
        Log.i("SERVICE", this.toString());
        
        // 세션에서 회원아이디 가지고오기
        vo = new UserVO();
        vo = (UserVO) req.getSession().getAttribute("vo");
        
        // 삭제요청
        int isDeleted = guestDAO.deleteGuest(vo.getEmail());
        if (isDeleted == 1) {
            req.getSession().invalidate();
            adminDAO.surveyResult(req.getParameter("reason").toString());
        }
        
        // 삭제 결과
        req.setAttribute("isDeleted", isDeleted);
    }

    // 회원정보 수정
    @Override
    public void editAction(HttpServletRequest req, HttpServletResponse res) {
        Log.i("SERVICE", this.toString());
        
        // 수정 항목 받아와서 적용
        UserVO updateVO = (UserVO) req.getSession().getAttribute("vo");
        updateVO.setName(req.getParameter("name"));
        if (!req.getParameter("rePw1").isEmpty()) {
            updateVO.setPw(req.getParameter("rePw1")); 
        }
        boolean b = ((String) req.getParameter("checkAlert") == null) ? false : true;
        updateVO.setAlertChk(b); 
        updateVO.setTel(req.getParameter("reTel")); 
        
        // 업데이트 요청
        int isUpdated = guestDAO.updateGuest(updateVO);
        
        // 업데이트 결과
        req.setAttribute("isUpdated", isUpdated);
    }

    // 회원 정보 완료 후 세션 재정렬
    @Override
    public void editComplete(HttpServletRequest req, HttpServletResponse res) {
        Log.i("SERVICE", this.toString());
        
        // 수정된 사용자 정보 획득
        vo = (UserVO) req.getSession().getAttribute("vo");
        String email = vo.getEmail();
        
        // 업데이트 요청
        vo = guestDAO.getGuestInfo(email);
        
        // 업데이트 결과
        req.getSession().setAttribute("vo", vo);
    }

    // 비밀번호 확인
    @Override
    public void confirmPw(HttpServletRequest req, HttpServletResponse res) {
        Log.i("SERVICE", this.toString());
        
        // 비밀번호 확인
        int chkPW = 0;
        vo = (UserVO) req.getSession().getAttribute("vo");
        String pw = vo.getPw();
        String inputPw = req.getParameter("pw");
        
        // 업데이트 요청
        if (pw.equals(inputPw)) chkPW = 1;
        
        // 업데이트 결과
        req.setAttribute("chkPW", chkPW);
    }
}
