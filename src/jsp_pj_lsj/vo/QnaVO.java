package jsp_pj_lsj.vo;

import java.util.Date;

public class QnaVO {
    private int qnaId;
    private String qnaComment;
    private boolean faqState;
    private Date qnaDate;
    private String userId;
    private int arrivalId;
    private int productId;
    private int queryId;
    
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
    public int getArrivalId() {
        return arrivalId;
    }
    public void setArrivalId(int arrivalId) {
        this.arrivalId = arrivalId;
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
