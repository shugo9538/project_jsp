package jsp_pj_lsj.vo;

public class UserVO {
    private String email;
    private String pw;
    private String name;
    private String tel;
    private boolean alertChk;
    private boolean adminChk;
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPw() {
        return pw;
    }
    public void setPw(String pw) {
        this.pw = pw;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public boolean isAlertChk() {
        return alertChk;
    }
    public void setAlertChk(boolean alertChk) {
        this.alertChk = alertChk;
    }
    public boolean isAdminChk() {
        return adminChk;
    }
    public void setAdminChk(boolean adminChk) {
        this.adminChk = adminChk;
    }
    @Override
    public String toString() {
        return getEmail() + "\n" + getPw() + "\n" + getName() + "\n" + getTel() + "\n" + isAdminChk() + "\n" + isAlertChk();
    }
}
