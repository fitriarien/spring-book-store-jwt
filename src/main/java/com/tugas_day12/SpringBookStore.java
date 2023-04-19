package com.tugas_day12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.tugas_day12"})
public class SpringBookStore {

    public static void main(String[] args) {
        SpringApplication.run(SpringBookStore.class, args);
    }
}