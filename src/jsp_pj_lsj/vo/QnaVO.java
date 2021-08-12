package jsp_pj_lsj.vo;

import java.util.Date;

public class QnaVO {
    private int qnaId;
    private String qnaComment;
    private boolean faqState;
    private Date qnaDate;
    private String userId;
    private int productId;
    private int queryId;
    private String qnaTitle;
    private String userName;
    private String qnaImg;
    private int answer_id;
    private int answer_level;
    private int answer_cnt;

    public int getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(int answer_id) {
        this.answer_id = answer_id;
    }

    public int getAnswer_level() {
        return answer_level;
    }

    public void setAnswer_level(int answer_level) {
        this.answer_level = answer_level;
    }

    public int getAnswer_cnt() {
        return answer_cnt;
    }

    public void setAnswer_cnt(int answer_cnt) {
        this.answer_cnt = answer_cnt;
    }

    public String getQnaImg() {
        return qnaImg;
    }

    public void setQnaImg(String qnaImg1) {
        this.qnaImg = qnaImg1;
    }

    public String getQnaTitle() {
        return qnaTitle;
    }

    public void setQnaTitle(String qnaTitle) {
        this.qnaTitle = qnaTitle;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getQnaId() {
        return qnaId;
    }

    public void setQnaId(int qnaId) {
        this.qnaId = qnaId;
    }

    public String getQnaComment() {
        return qnaComment;
    }

    public void setQnaComment(String qnaComment) {
        this.qnaComment = qnaComment;
    }

    public boolean isFaqState() {
        return faqState;
    }

    public void setFaqState(boolean faqState) {
        this.faqState = faqState;
    }

    public Date getQnaDate() {
        return qnaDate;
    }

    public void setQnaDate(Date qnaDate) {
        this.qnaDate = qnaDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQueryId() {
        return queryId;
    }

    public void setQueryId(int queryId) {
        this.queryId = queryId;
    }
}
