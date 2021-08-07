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
    private String categoryName;
    private String productProducer;
    private String productOrigin;
    private String productEa;
    private String productContent;
    private int starPoint;

    public int getStarPoint() {
        return starPoint;
    }

    public void setStarPoint(int starPoint) {
        this.starPoint = starPoint;
    }

    public String getProductContent() {
        return productContent;
    }

    public void setProductContent(String productContent) {
        this.productContent = productContent;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getProductProducer() {
        return productProducer;
    }

    public void setProductProducer(String productProducer) {
        this.productProducer = productProducer;
    }

    public String getProductOrigin() {
        return productOrigin;
    }

    public void setProductOrigin(String productOrigin) {
        this.productOrigin = productOrigin;
    }

    public String getProductEa() {
        return productEa;
    }

    public void setProductEa(String productEa) {
        this.productEa = productEa;
    }

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
}
