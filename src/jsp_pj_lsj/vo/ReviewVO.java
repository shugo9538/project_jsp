package jsp_pj_lsj.vo;

import java.util.Date;

public class ReviewVO {
    private int review_id;
    private String user_id;
    private String user_name;
    private String review_comment;
    private int product_id;
    private String product_name;
    private int star_point;
    private Date review_enrollment;
    private int ref;
    private int ref_step;
    private int ref_level;
    private String review_img;
    private int r_num;
    
    public int getR_num() {
        return r_num;
    }

    public void setR_num(int r_num) {
        this.r_num = r_num;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getReview_id() {
        return review_id;
    }

    public void setReview_id(int review_id) {
        this.review_id = review_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getReview_comment() {
        return review_comment;
    }

    public void setReview_comment(String review_comment) {
        this.review_comment = review_comment;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getStar_point() {
        return star_point;
    }

    public void setStar_point(int star_point) {
        this.star_point = star_point;
    }

    public Date getReview_enrollment() {
        return review_enrollment;
    }

    public void setReview_enrollment(Date review_enrollment) {
        this.review_enrollment = review_enrollment;
    }

    public int getRef() {
        return ref;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public int getRef_step() {
        return ref_step;
    }

    public void setRef_step(int ref_step) {
        this.ref_step = ref_step;
    }

    public int getRef_level() {
        return ref_level;
    }

    public void setRef_level(int ref_level) {
        this.ref_level = ref_level;
    }

    public String getReview_img() {
        return review_img;
    }

    public void setReview_img(String review_img) {
        this.review_img = review_img;
    }

}
