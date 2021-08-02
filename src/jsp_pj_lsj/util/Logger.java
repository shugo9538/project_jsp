package jsp_pj_lsj.util;

public class Logger {
    public static void log(String tag, String msg) {
        System.out.println(tag + " : " + msg);
    }
    
    public static void log(String tag, int msg) {
        System.out.println(tag + " : " + msg);
    }
    
    public static void log(String tag, Object msg) {
        System.out.println(tag + " : " + msg.getClass().getName());
    }
}
