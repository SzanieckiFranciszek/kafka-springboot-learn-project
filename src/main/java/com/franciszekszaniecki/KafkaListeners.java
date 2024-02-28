package com.franciszekszaniecki;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "coffe",
            groupId = "group_coffee_shop")
    void listen(String data) {
        System.out.printf("Received message: %s\n", data);
    }
}
