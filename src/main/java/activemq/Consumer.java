package activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
class ConsumerA {

    @JmsListener(destination = "sample.queue")
    public void receiveQueue(String text) {
        System.out.println("ConsumerA: " + text);
    }
}

@Component
class ConsumerB {

    @JmsListener(destination = "sample.queue")
    public void receiveQueue(String text) {
        System.out.println("ConsumerB: " + text);
    }
}
