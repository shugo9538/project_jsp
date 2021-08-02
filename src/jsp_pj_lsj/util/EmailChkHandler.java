package jsp_pj_lsj.util;

import java.util.Random;

public class EmailChkHandler {
    public static String getKey() {
        StringBuffer temp = new StringBuffer();
        Random rand = new Random();
        
        for (int i = 0 ; i < 6 ; i++) {
            int rIndex = rand.nextInt(2);
            switch (rIndex) {
            case 0:
                // A-Z
                temp.append((char) ((int) (rand.nextInt(26)+65)));
                break;

            case 1:
                // 0-9
                temp.append((rand.nextInt(10)));
                break;
            }
        }
        
        return temp.toString();
    }
}
