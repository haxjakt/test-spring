package net.haxjakt.springtest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringTestApplication {
    private final static Logger sLogger = LoggerFactory.getLogger(SpringTestApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringTestApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> { /* TODO */ };
    }

}

