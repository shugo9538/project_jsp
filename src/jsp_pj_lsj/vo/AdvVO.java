package jsp_pj_lsj.vo;

import java.util.Date;

public class AdvVO {
    private int advId;
    private String advImageUrl;
    private int advType;
    private Date advEnrollment;
    private int product_id;
    
    public int getAdvId() {
        return advId;
    }
    public void setAdvId(int advId) {
        this.advId = advId;
    }
    public String getAdvImageUrl() {
        return advImageUrl;
    }
    public void setAdvImageUrl(String advImageUrl) {
        this.advImageUrl = advImageUrl;
    }
    public int getAdvType() {
        return advType;
    }
    public void setAdvType(int advType) {
        this.advType = advType;
    }
    public Date getAdvEnrollment() {
        return advEnrollment;
    }
    public void setAdvEnrollment(Date advEnrollment) {
        this.advEnrollment = advEnrollment;
    }
    public int getProduct_id() {
        return product_id;
    }
    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
    
}
