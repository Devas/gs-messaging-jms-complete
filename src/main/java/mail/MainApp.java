package mail;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Send mail 1
        MailService mailService1 = context.getBean(MailService.class);
        mailService1.send("abcd@example.com");

        // Send mail 2
        MailService mailService2 = context.getBean(MailService.class);
        mailService2.send("boraji@example.com");

        context.close();
    }
}