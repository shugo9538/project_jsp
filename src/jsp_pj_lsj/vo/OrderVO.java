package jsp_pj_lsj.vo;

import java.util.Date;

public class OrderVO {
    private int orderId;
    private int orderState;
    private Date orderDate;
    private int userEmail;
    
    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public int getOrderState() {
        return orderState;
    }
    public void setOrderState(int orderState) {
        this.orderState = orderState;
    }
    public Date getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    public int getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(int userEmail) {
        this.userEmail = userEmail;
    }
}
