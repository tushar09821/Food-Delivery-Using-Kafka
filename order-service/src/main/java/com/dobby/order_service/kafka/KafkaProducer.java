package com.dobby.order_service.kafka;

import com.dobby.order_service.dto.OrderResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {
    @Autowired
    private KafkaTemplate<String,Object> template;

    public void sendOrderEvent(OrderResponseDto data){
        template.send("order-event",data);
    }
}
