package jsp_pj_lsj.vo;

import oracle.sql.DATE;

public class ReviewVO {
    private int revieId;
    private String reviewComment;
    private int starPoint;
    private DATE reviewDate;
    private String userId;
    private int productId;
    
    public int getRevieId() {
        return revieId;
    }
    public void setRevieId(int revieId) {
        this.revieId = revieId;
    }
    public String getReviewComment() {
        return reviewComment;
    }
    public void setReviewComment(String reviewComment) {
        this.reviewComment = reviewComment;
    }
    public int getStarPoint() {
        return starPoint;
    }
    public void setStarPoint(int starPoint) {
        this.starPoint = starPoint;
    }
    public DATE getReviewDate() {
        return reviewDate;
    }
    public void setReviewDate(DATE reviewDate) {
        this.reviewDate = reviewDate;
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
}
