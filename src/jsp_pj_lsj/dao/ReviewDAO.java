package jsp_pj_lsj.dao;

import java.util.List;

import jsp_pj_lsj.vo.ReviewVO;

public interface ReviewDAO {
    // 리뷰 숫자 가져오기
    public int reviewCnt();
    
    // 리뷰목록
    public List<ReviewVO> reviewList(int start, int end);
    
    // 리뷰추가
    // 리뷰삭제
    // 리뷰수정
    
}
