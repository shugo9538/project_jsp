package jsp_pj_lsj.dao;

import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public enum OrderDAOImpl implements OrderDAO {
    INSTANCE;
    
    private DataSource dataSource;
    private ResultSet rs = null;

    private OrderDAOImpl() {
        try {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/jsp_pj_lsj");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
    
//    @Override
//    public int refundList(int id) {
//        // TODO Auto-generated method stub
//        return 0;
//    }
//
//    @Override
//    public int refundOk(int id) {
//        // TODO Auto-generated method stub
//        return 0;
//    }
//
//    @Override
//    public int reviewList() {
//        // TODO Auto-generated method stub
//        return 0;
//    }
//
//    @Override
//    public int reviewDelete() {
//        // TODO Auto-generated method stub
//        return 0;
//    }
//
//    @Override
//    public int settelmentData() {
//        // TODO Auto-generated method stub
//        return 0;
//    }
}
