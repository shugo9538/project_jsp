package jsp_pj_lsj.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp_pj_lsj.dao.DAOImpl;
import jsp_pj_lsj.vo.CategoryVO;
import jsp_pj_lsj.vo.UserVO;

public class AdminServiceImpl implements AdminService {
    private DAOImpl dao = DAOImpl.INSTANCE;
    private UserVO vo = null;
    
    // 로그인시 사용자 정보 확인
    @Override
    public void loginAction(HttpServletRequest req, HttpServletResponse res) {
        System.out.println("SERVICE : loginAction");
        
        // 로그인 아이디, 비밀번호 획득
        String id = req.getParameter("email");
        String pw = req.getParameter("pw");

        // 사용자 정보 확인
        int isUser = dao.adminCheck(id, pw);
        
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

    @Override
    public void categoryList(HttpServletRequest req, HttpServletResponse res) {
        System.out.println("SERVICE : categoryList");
        
        // 모든 카테고리 정보 가져오기
        ArrayList<CategoryVO> list = (ArrayList<CategoryVO>) dao.categoryList();
        
        // 결과 반환
        req.setAttribute("categoryVO", list);
    }
    
}
