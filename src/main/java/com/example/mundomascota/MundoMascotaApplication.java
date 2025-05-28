package com.example.mundomascota;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.example.mundomascota")
@EnableJpaRepositories(basePackages = "com.example.mundomascota.repositories")
@EntityScan(basePackages = "com.example.mundomascota.entity")
public class MundoMascotaApplication {
    public static void main(String[] args) {
        SpringApplication.run(MundoMascotaApplication.class, args);
    }
}

