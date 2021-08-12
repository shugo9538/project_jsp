package jsp_pj_lsj.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp_pj_lsj.dao.UserDAO;
import jsp_pj_lsj.dao.UserDAOImpl;
import jsp_pj_lsj.util.EmailChkHandler;
import jsp_pj_lsj.vo.ArrivalVO;
import jsp_pj_lsj.vo.UserVO;
import jsp_pj_lsj.util.*;


public class GuestServiceImpl implements GuestService {
    private UserDAO userDAO = UserDAOImpl.INSTANCE;
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
        int isInsert = userDAO.insertUser(vo);
        
        // 실패 시 중복정보인지 확인
        boolean isExists = true;
        if (isInsert == 0) {
            isExists = userDAO.checkID(vo.getEmail());
        }
        if (!isExists) isInsert = 2;
        else EmailChkHandler.sendmail(email, key);
        
        // 회원가입 결과
        req.setAttribute("isInsert", isInsert);
    }

    // 이메일 인증
    @Override
    public void checkIDAction(HttpServletRequest req, HttpServletResponse res) {
        Log.i("SERVICE", this.toString());
        
        // 사용자 입력정보 획득
        String key = req.getParameter("key");
        
        // 이메일 인증 확인
        int isAuth = userDAO.emailCheck(key);
        
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
        int isUser = userDAO.userCheck(id, pw, 0);
        
        // 사용자 정보 설정
        req.setAttribute("isUser", isUser);
        req.getSession().setAttribute("id", id);
    }
    
    // 로그인 처리 완료
    @Override
    public void makeSession(HttpServletRequest req, HttpServletResponse res) {
        Log.i("SERVICE", this.toString());
        
        // 로그인한 회원 정보 가져오기
        String id = req.getSession().getAttribute("id").toString();
        req.getSession().setAttribute("id", "");
        
        vo = new UserVO();
        vo = userDAO.getUserData(id);
        
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
        int isDeleted = userDAO.deleteUser(vo.getEmail());
        if (isDeleted == 1) {
            req.getSession().invalidate();
            userDAO.survey(req.getParameter("reason").toString());
        }
        
        // 삭제 결과
        req.setAttribute("isDeleted", isDeleted);
    }

    // 회원정보 수정
    @Override
    public void modifyAction(HttpServletRequest req, HttpServletResponse res) {
        Log.i("SERVICE", this.toString());
        
        // 수정 항목 받아와서 적용
        UserVO updateVO = (UserVO) req.getSession().getAttribute("vo");
        String email = vo.getEmail();
        
        updateVO.setName(req.getParameter("name"));
        if (!req.getParameter("rePw1").isEmpty()) {
            updateVO.setPw(req.getParameter("rePw1")); 
        }
        boolean b = ((String) req.getParameter("checkAlert") == null) ? false : true;
        updateVO.setAlertChk(b); 
        updateVO.setTel(req.getParameter("reTel")); 
        
        // 업데이트 요청
        int isUpdated = userDAO.modifyUser(updateVO);
        
        // 업데이트 결과
        req.setAttribute("isUpdated", isUpdated);
        if (isUpdated == 1) {
            vo = userDAO.getUserData(email);
            req.getSession().setAttribute("vo", vo);
        }
    }

    // 비밀번호 확인
    @Override
    public void checkPW(HttpServletRequest req, HttpServletResponse res) {
        Log.i("SERVICE", this.toString());
        
        // 비밀번호 확인
        int isPass = 0;
        vo = (UserVO) req.getSession().getAttribute("vo");
        String pw = vo.getPw();
        String inputPw = req.getParameter("pw");
        
        // 업데이트 요청
        if (pw.equals(inputPw)) isPass = 1;
        
        // 업데이트 결과
        req.setAttribute("isPass", isPass);
    }

    // 
    @Override
    public void addArrivalAddr(HttpServletRequest req, HttpServletResponse res) {
        Log.i(this.getClass().getName(), "addArrivalAddr");
        ArrivalVO vo = new ArrivalVO();
        vo.setArrivalAddr(req.getParameter("arrival_address"));
        UserVO user = (UserVO) req.getSession().getAttribute("vo");
        vo.setReceiverTel(req.getParameter("arrival_phone"));
        vo.setReceiverComment(req.getParameter("arrival_comment"));
        vo.setUserID(user.getEmail());
        vo.setReceiverName(req.getParameter("userName"));
        
        int isInsert = userDAO.addArrivalAddr(vo);
        
        req.setAttribute("isInsert", isInsert);
        req.setAttribute("nextPage", "arrivalAddr.gu");
    }
}
