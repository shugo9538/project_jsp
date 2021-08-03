package jsp_pj_lsj.util;

public class Log {
    public static void i(String tag, String msg) {
        System.out.println(tag + " : " + msg);
    }
    
    public static void i(String tag, int msg) {
        System.out.println(tag + " : " + msg);
    }
    
    public static void i(String tag, Object msg) {
        System.out.println(tag + " : " + msg.getClass().getName());
    }
}
