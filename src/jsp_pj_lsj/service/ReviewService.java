package jsp_pj_lsj.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ReviewService {
    // 리뷰 갯수 구하기
    public int reviewCnt(HttpServletRequest req, HttpServletResponse res);
    
    // 리뷰 갯수 구하기
    public void reviewList(HttpServletRequest req, HttpServletResponse res);
    
}
