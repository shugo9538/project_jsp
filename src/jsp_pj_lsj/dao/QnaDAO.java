package jsp_pj_lsj.dao;

import java.util.List;

import jsp_pj_lsj.vo.QnaVO;
import jsp_pj_lsj.vo.QuestionVO;

public interface QnaDAO {
    // 문의 내용 추가
    public int insertQna(QuestionVO vo);
    
    // 문의 내용 추가
    public List<QnaVO> qnaList(int start, int end);
    
    // 문의 목록 갯수
    public int qnaCnt();
    
}
