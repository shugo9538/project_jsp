package jsp_pj_lsj.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp_pj_lsj.dao.DAOImpl;
import jsp_pj_lsj.vo.UserVO;


public class GuestServiceImpl implements GuestService {
    private DAOImpl dao = DAOImpl.INSTANCE;
    private UserVO vo = null;
    
    // 회원가입 처리
    @Override
    public void signInAction(HttpServletRequest req, HttpServletResponse res) {
        System.out.println("SERVICE : signInAction");
        
        // 사용자 입력정보 획득
        vo = new UserVO();
        vo.setEmail(req.getParameter("email"));
        vo.setPw(req.getParameter("pw"));
        vo.setName(req.getParameter("name"));
        vo.setTel(req.getParameter("tel"));
        
        // 회원가입 요청
        int isInsert = dao.insertGuest(vo);
        
        // 실패 시 중복정보인지 확인
        boolean isExists = true;
        if (isInsert == 0) isExists = dao.idCheck(vo.getEmail());
        if (!isExists) isInsert = 2;
        
        // 회원가입 결과
        req.setAttribute("isInsert", isInsert);
    }

    // 로그인 처리
    @Override
    public void loginAction(HttpServletRequest req, HttpServletResponse res) {
        System.out.println("SERVICE : loginAction");
        
        // 로그인 아이디, 비밀번호 획득
        String id = req.getParameter("email");
        String pw = req.getParameter("pw");

        // 사용자 정보 확인
        int isUser = dao.userCheck(id, pw);
        
        // 사용자 정보 설정
        req.setAttribute("isUser", isUser);
        req.setAttribute("id", id);
    }
    
    // 로그인 처리 완료
    @Override
    public void loginComplete(HttpServletRequest req, HttpServletResponse res) {
        System.out.println("SERVICE : loginComplete");
        
        // 로그인한 회원 정보 가져오기
        String id = req.getParameter("id").toString();
        vo = new UserVO();
        vo = dao.getGuestInfo(id);
        
        // 로그인 결과 세션에 적용
        req.getSession().setAttribute("vo", vo);
    }

    // 회원 삭제
    @Override
    public void deleteAction(HttpServletRequest req, HttpServletResponse res) {
        System.out.println("SERVICE : deleteAction");
        
        // 세션에서 회원아이디 가지고오기
        vo = new UserVO();
        vo = (UserVO) req.getSession().getAttribute("vo");
        
        // 삭제요청
        int isDeleted = dao.deleteGuest(vo.getEmail());
        
        // 삭제 결과
        req.setAttribute("isDeleted", isDeleted);
    }

    // 회원정보 수정
    @Override
    public void editAction(HttpServletRequest req, HttpServletResponse res) {
        System.out.println("SERVICE : editAction");
        
        // 수정 항목 받아와서 적용
        vo = new UserVO();
        vo.setPw(req.getParameter("rePw1")); 
        vo.setAlertChk((req.getParameter("alert") == "true") ? true : false); 
        vo.setTel(req.getParameter("reTel")); 
        vo.setPw(req.getParameter("rePw1")); 
        
        // 업데이트 요청
        int isUpdated = dao.updateGuest(vo);
        
        // 업데이트 결과
        req.setAttribute("isUpdated", isUpdated);
    }
    
}
