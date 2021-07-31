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
        vo = new UserVO();
        vo.setEmail(req.getParameter("email"));
        vo.setPw(req.getParameter("pw"));
        vo.setName(req.getParameter("name"));
        vo.setTel(req.getParameter("tel"));
        
        int isInsert = dao.insertGuest(vo);
        
        boolean isExists = true;
        if (isInsert == 0) isExists = dao.idCheck(vo.getEmail());
        if (!isExists) isInsert = 2;
        
        req.setAttribute("isInsert", isInsert);
    }

    // 로그인 처리
    @Override
    public void loginAction(HttpServletRequest req, HttpServletResponse res) {
        System.out.println("SERVICE : loginAction");
        
        String id = req.getParameter("email");
        String pw = req.getParameter("pw");
        
        int isUser = dao.userCheck(id, pw);
        req.setAttribute("isUser", isUser);
        req.setAttribute("id", id);
    }
    
    // 로그인 처리 완료
    @Override
    public void loginComplete(HttpServletRequest req, HttpServletResponse res) {
        System.out.println("SERVICE : loginComplete");
        
        String id = req.getParameter("id").toString();
        
        vo = new UserVO();
        vo = dao.getGuestInfo(id);
        req.getSession().setAttribute("vo", vo);
    }

    // 회원 삭제
    @Override
    public void deleteAction(HttpServletRequest req, HttpServletResponse res) {
        System.out.println("SERVICE : deleteAction");
        
        vo = new UserVO();
        vo = (UserVO) req.getSession().getAttribute("vo");
        int isDeleted = dao.deleteGuest(vo.getEmail());
        
        req.setAttribute("isDeleted", isDeleted);
    }

    // 회원정보 수정
    @Override
    public void editAction(HttpServletRequest req, HttpServletResponse res) {
        System.out.println("SERVICE : deleteAction");
        
        vo = new UserVO();
        vo.setPw(req.getParameter("rePw1")); 
        vo.setAlertChk((req.getParameter("alert") == "true") ? true : false); 
        vo.setTel(req.getParameter("reTel")); 
        vo.setPw(req.getParameter("rePw1")); 
        int isUpdated = dao.updateGuest(vo);
        
        req.setAttribute("isUpdated", isUpdated);
    }
    
}
