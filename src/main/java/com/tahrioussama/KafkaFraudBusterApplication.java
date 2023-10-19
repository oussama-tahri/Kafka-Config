package com.tahrioussama;

import com.tahrioussama.records.Message;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import java.time.LocalDateTime;

@SpringBootApplication
public class KafkaFraudBusterApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaFraudBusterApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(KafkaTemplate<String, Message> kafkaTemplate) {
        return args -> {
          kafkaTemplate.send("tahrioussama", new Message("samaykom hh", LocalDateTime.now()));
        };
    }

}
