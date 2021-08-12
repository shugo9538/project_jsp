package jsp_pj_lsj.util;

import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailChkHandler {
    /**
     * 메일 확인을 위한 메일 전송
     * 
     * @param : email과 key값
     */
    public static void sendmail(String email, String key) {
        final String username = SettingsValue.HOST; // 본인 이메일
        final String password = SettingsValue.PW; // 본인 비밀번호
        final String host = "smtp.gmail.com";

        // SMTP(메일 서버) 설정
        Properties props = new Properties();
        props.put("mail.smtp.user", username); // SMTP에서 사용할 사용자 메일주소
        props.put("mail.smtp.password", password); // 비밀번호
        props.put("mail.smtp.host", host); // host 서버 : gmail로 설정
        props.put("mail.smtp.port", "25"); // 25번 포트 사용
        props.put("mail.debug", "true"); // 디버그 설정
        props.put("mail.smtp.auth", "true"); // 인증 : true
        props.put("mail.smtp.starttls.enable", "true"); // tls 사용 허용
        props.put("mail.smtp.ssl.enable", "true"); // ssl 허용
        props.put("mail.smtp.ssl.trust", host); // ssl 신뢰 가능으로 설정(보안레벨)

        // propert값 설정
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); // socketFactory 설정을
        props.setProperty("mail.smtp.socketFactory.fallback", "false"); // fallback 설정 : false
        props.setProperty("mail.smtp.port", "465"); // 465번 포트 사용(gmail 설정)
        props.setProperty("mail.smtp.socketFactory.port", "465"); // 마찬가지로 포트 설정

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("admin@CosmoJspPJ.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));

            String content = "회원가입을 축하드립니다. 링크를 눌러 회원가입을 완료하세요."
                    + "<a href='http://localhost/jsp_pj_lsj/emailChk.gu?key=" + key + "'>링크</a>";
            message.setSubject("회원가입 인증 메일");
            message.setContent(content, "text/html; charset=utf-8");

            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
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
