package jsp_pj_lsj.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp_pj_lsj.dao.DAOImpl;
import jsp_pj_lsj.vo.UserVO;


public class GuestServiceImpl implements GuestService {
    private DAOImpl dao = DAOImpl.INSTANCE;
    private UserVO vo = null;
    
    @Override
    public void confirmId(HttpServletRequest req, HttpServletResponse res) {
        // TODO Auto-generated method stub
        
    }

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

    @Override
    public void loginAction(HttpServletRequest req, HttpServletResponse res) {
        System.out.println("SERVICE : loginAction");
        
        String id = req.getParameter("email");
        String pw = req.getParameter("pw");
        
        int isUser = dao.userCheck(id, pw);
        req.setAttribute("isUser", isUser);
        req.setAttribute("id", id);
    }
    
    @Override
    public void loginComplete(HttpServletRequest req, HttpServletResponse res) {
        System.out.println("SERVICE : loginComplete");
        
        String id = req.getParameter("id").toString();
        
        vo = new UserVO();
        vo = dao.getGuestInfo(id);
        req.getSession().setAttribute("vo", vo);
    }

    @Override
    public void deleteAction(HttpServletRequest req, HttpServletResponse res) {
        System.out.println("SERVICE : deleteAction");
        
        vo = new UserVO();
        vo = (UserVO) req.getSession().getAttribute("vo");
        int isDeleted = dao.deleteGuest(vo.getEmail());
        
        req.setAttribute("isDeleted", isDeleted);
    }

    @Override
    public void modifyDetailAction(HttpServletRequest req, HttpServletResponse res) {
        
    }

    @Override
    public void modifyAction(HttpServletRequest req, HttpServletResponse res) {
        
    }
    
}
