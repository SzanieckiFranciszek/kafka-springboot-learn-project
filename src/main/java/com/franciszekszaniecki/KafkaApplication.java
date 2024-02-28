package com.franciszekszaniecki;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate) {
        System.out.printf("Sending messages to kafka topic caffeshop\n");
        return args -> {
            for (int i = 0; i < 100; i++) {
                System.out.printf("Sending message %d\n", i);
                kafkaTemplate.send("coffe", "Hello Kafka " + i);
            }
        };
    }

}
