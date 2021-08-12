package jsp_pj_lsj.dao;

import jsp_pj_lsj.vo.ArrivalVO;
import jsp_pj_lsj.vo.UserVO;

public interface UserDAO {
    // 사용자 아이디 확인
    public boolean checkID(String id);

    // 사용자 회원가입
    public int insertUser(UserVO vo);
    
    // 이메일 확인
    public int emailCheck(String key);
    
    // 사용자 확인
    public int userCheck(String id, String pw, int isAdmin);
    
    // 세션 적용을 위한 사용자 정보 획득
    public UserVO getUserData(String id);
    
    // 사용자 회원탈퇴
    public int deleteUser(String id);
    
    // 사용자 정보 수정
    public int modifyUser(UserVO vo);
    
    // 회원탈퇴 시 설문조사 저장
    public void survey(String reason);
    
    // 사용자 배송지 정보 설정
    public int addArrivalAddr(ArrivalVO vo);
    
    // 기본 배송지 가져오기
    public ArrivalVO defaultArrivalAddr();
    
    // 사용자 이름 획득
    public String getUserName(String id);
}
