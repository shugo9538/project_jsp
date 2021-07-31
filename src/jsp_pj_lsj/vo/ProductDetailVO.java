package jsp_pj_lsj.vo;

public class ProductDetailVO {
    private int detailId;
    private String productKind;
    private String productEa;
    private String productProducer;
    private String productOrigin;
    
    public int getDetailId() {
        return detailId;
    }
    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }
    public String getProductKind() {
        return productKind;
    }
    public void setProductKind(String productKind) {
        this.productKind = productKind;
    }
    public String getProductEa() {
        return productEa;
    }
    public void setProductEa(String productEa) {
        this.productEa = productEa;
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
}
