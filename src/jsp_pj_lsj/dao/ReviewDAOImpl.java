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
import jsp_pj_lsj.vo.ReviewVO;

public enum ReviewDAOImpl implements ReviewDAO {
    INSTANCE;

    private DataSource dataSource;
    private ResultSet rs = null;

    private ReviewDAOImpl() {
        try {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/jsp_88");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    // 모든 리뷰 갯수 획득
    @Override
    public int reviewCnt() {
        Log.i(this.getClass().getName(), "reviewCnt");
        int cnt = 0;

        String query = "SELECT COUNT(*) as cnt FROM mvc_board_tbl";
        try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {

            rs = pstmt.executeQuery();

            if (rs.next())
                cnt = rs.getInt("CNT");

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (rs != null)
                    rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return cnt;
    }

    @Override
    public List<ReviewVO> reviewList(int start, int end) {
        Log.i("DAO", "getBoardList");
        ArrayList<ReviewVO> list = new ArrayList<>();
        ReviewVO vo = new ReviewVO();

        // precedure로 변환할 예정
        String query = "SELECT * " + "      FROM "
                + "        (SELECT r.review_id, r.user_id, r.review_comment, r.product_id, r.star_point, r.review_enrollment, "
                + "               r.ref, r.ref_step, r.ref_level, r.review_img, p.product_name, u.name, rowNum r_num "
                + "          FROM ( SELECT r.*, p.product_name, u.name FROM review_tbl r, user_tbl u, product_tbl p "
                + "                  WHERE p.product_id = r.product_id"
                + "                    ANE u.id = r.user_id"
                + "                    ORDER BY REF DESC, REF_STEP ASC " 
                + "               ) " 
                + "         ) "
                + "      WHERE rNum >= ? AND rNum <= ? ";
        try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, start);
            pstmt.setInt(2, end);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                vo = new ReviewVO();
                vo.setReview_id(rs.getInt("r.review_id"));
                vo.setUser_id(rs.getString("r.user_id"));
                vo.setReview_comment(rs.getString("r.review_comment"));
                vo.setProduct_id(rs.getInt("r.product_id"));
                vo.setStar_point(rs.getInt("r.star_point"));
                vo.setReview_enrollment(rs.getDate("r.review_enrollment"));
                vo.setRef(rs.getInt("r.ref"));
                vo.setRef_step(rs.getInt("r.ref_step"));
                vo.setRef_level(rs.getInt("r.ref_level"));
                vo.setReview_img(rs.getString("r.review_img"));
                vo.setProduct_name(rs.getString("p.product_name"));
                vo.setUser_name(rs.getString("u.name"));
                vo.setR_num(rs.getInt("r_num"));
                list.add(vo);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (rs != null) rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return list;
    }

}
