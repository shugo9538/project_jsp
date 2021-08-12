package jsp_pj_lsj.vo;

public class QuestionVO {
    private String qnaComment;
    private String userId;
    private int productId;
    private String qnaTitle;
    private String qnaImg;
    
    public String getQnaComment() {
        return qnaComment;
    }
    
    public void setQnaComment(String qnaComment) {
        this.qnaComment = qnaComment;
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
    
    public String getQnaTitle() {
        return qnaTitle;
    }
    
    public void setQnaTitle(String qnaTitle) {
        this.qnaTitle = qnaTitle;
    }
    
    public String getQnaImg() {
        return qnaImg;
    }
    
    public void setQnaImg(String qnaImg) {
        this.qnaImg = qnaImg;
    }
}
