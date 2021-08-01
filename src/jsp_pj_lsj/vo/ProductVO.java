package jsp_pj_lsj.vo;

import java.util.Date;

public class ProductVO {
    private int productId;
    private String productName;
    private int productPrice;
    private int productArrival;
    private int productStock;
    private String productImg;
    private Date productEnrollment;
    private int categoryId;
    private int detailId;
    
    public int getProductId() {
        return productId;
    }
    
    public void setProductId(int productId) {
        this.productId = productId;
    }
    
    public String getProductName() {
        return productName;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    public int getProductPrice() {
        return productPrice;
    }
    
    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }
    
    public int getProductArrival() {
        return productArrival;
    }
    
    public void setProductArrival(int productArrival) {
        this.productArrival = productArrival;
    }
    
    public int getProductStock() {
        return productStock;
    }
    
    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }
    
    public String getProductImg() {
        return productImg;
    }
    
    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }
    
    public Date getProductEnrollment() {
        return productEnrollment;
    }
    
    public void setProductEnrollment(Date productEnrollment) {
        this.productEnrollment = productEnrollment;
    }
    
    public int getCategoryId() {
        return categoryId;
    }
    
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    
    public int getDetailId() {
        return detailId;
    }
    
    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }
}
