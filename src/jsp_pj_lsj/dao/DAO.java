package jsp_pj_lsj.dao;

import java.util.List;

import jsp_pj_lsj.vo.CategoryVO;
import jsp_pj_lsj.vo.UserVO;

public interface DAO {
    // 중복확인 처리
    public boolean idCheck(String id);
    
    // 회원가입 처리
    public int insertGuest(UserVO vo);
    
    // 로그인 처리
    public int userCheck(String id, String pw);
    
    // 회원정보 상세 페이지
    public UserVO getGuestInfo(String id);
    
    // 회원정보 탈퇴 처리
    public int deleteGuest(String id);
    
    // 회원정보 수정 처리
    public int updateGuest(UserVO vo);
    
    // 관리자 로그인 처리
    public int adminCheck(String id, String pw);
    
    // 카테고리 리스트 읽어오기
    public List<CategoryVO> categoryList();
}
