package jsp_pj_lsj.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface QnaService {
    // 문의하기
    public void insertQna(HttpServletRequest req, HttpServletResponse res);

    // 문의 목록
    public void qnaList(HttpServletRequest req, HttpServletResponse res);
    
    // 문의 내용 수정
    public void modifyQna(HttpServletRequest req, HttpServletResponse res);

}
