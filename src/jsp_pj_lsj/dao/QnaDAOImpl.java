package jsp_pj_lsj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jsp_pj_lsj.util.Log;
import jsp_pj_lsj.vo.QnaVO;
import jsp_pj_lsj.vo.QuestionVO;

public enum QnaDAOImpl implements QnaDAO {
    INSTANCE;
    
    private DataSource dataSource;
    private ResultSet rs = null;

    private QnaDAOImpl() {
        try {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/jsp_pj_lsj");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
    
    /** qna 추가
     * @param : QnaVO
     * 
     * @return
     * 성공 : 1
     * 실패 : 0
     * */
    @Override
    public int insertQna(QuestionVO vo) {
        Log.i(this.getClass().getName(), "insertQna");
        int isInsert = 0;

        String query = "INSERT INTO QNA_TBL(qna_comment, user_id, qna_title, qna_img, qna_id, answer_id) "
                    + "VALUES(?, ?, ?, ?, qna_seq.nextval, qna_seq.currval)";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);) {
            pstmt.setString(1, vo.getQnaComment());
            pstmt.setString(2,  vo.getUserId());
            pstmt.setString(3, vo.getQnaTitle());
            pstmt.setString(4, vo.getQnaImg());
//            pstmt.setInt(5, vo.getProductId());
            
            isInsert = pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return isInsert;
    }

    @Override
    public List<QnaVO> qnaList(int start, int end) {
        Log.i(this.getClass().getName(), "qnaList");
        List<QnaVO> list = new ArrayList<>();
        QnaVO vo = new QnaVO();

        String query = "SELECT * " 
                +   "      FROM "
                +   "        (SELECT qna_id, qna_title, answer_id, answer_layer, answer_order, "
                +   "         qna_comment, qna_img, user_id, product_id, faq_state, qna_enrollment, rowNum rNum " 
                +   "          FROM ( SELECT * FROM qna_tbl " 
                +   "                    ORDER BY answer_id asc, answer_order desc"
                +   "               ) " 
                +   "         ) "
                +   "      WHERE rNum >= ? AND rNum <= ? ";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);) {
            pstmt.setInt(1, start);
            pstmt.setInt(2, end);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                vo = new QnaVO();
                vo.setQnaId(rs.getInt("qna_id")); 
                vo.setQnaTitle(rs.getString("qna_title")); 
                vo.setAnswer_id(rs.getInt("answer_id"));
                vo.setAnswer_level(rs.getInt("answer_layer"));
                vo.setAnswer_cnt(rs.getInt("answer_order"));
                vo.setQnaComment(rs.getString("qna_comment"));
                vo.setQnaImg(rs.getString("qna_img"));
                vo.setUserId(rs.getString("user_id"));
                vo.setProductId(rs.getInt("product_id"));
                vo.setFaqState(rs.getInt("faq_state") == 1 ? true : false);
                vo.setQnaDate(rs.getDate("qna_enrollment"));
                list.add(vo);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    /** 카테고리 갯수 가져오기
     * @return
     * 성공 : count
     * */
    @Override
    public int qnaCnt() {
        Log.i(this.getClass().getName(), "categoryList");
        int cnt = 0;

        String query = "SELECT COUNT(qna_id) as cnt FROM qna_tbl";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);) {
            
            rs = pstmt.executeQuery();
            
            if (rs.next()) cnt = rs.getInt("cnt");
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return cnt;
    }
}
