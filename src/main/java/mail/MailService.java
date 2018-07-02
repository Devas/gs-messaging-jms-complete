package mail;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.HashMap;
import java.util.Map;

@Component
public class MailService {

    private Map<String, String> map;

    public MailService() {
        map=new HashMap<>();
    }

    public void send(String mailTo){
        //Code for sending mail
        System.out.println("Inside send method - "+mailTo);
    }

    @PostConstruct
    public void init() {
        map.put("host", "mail.example.com");
        map.put("port", "25");
        map.put("from", "example@boraji.com");
        System.out.println("Inside init method - "+map);
    }

    @PreDestroy
    public void destroy() {
        map.clear();
        System.out.println("Inside destroy method - "+map);
    }
}