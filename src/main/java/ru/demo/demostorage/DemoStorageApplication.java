package ru.demo.demostorage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication(scanBasePackages = {"ru.demo.demostorage"})
@EnableKafka
public class DemoStorageApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoStorageApplication.class, args);
    }

}
