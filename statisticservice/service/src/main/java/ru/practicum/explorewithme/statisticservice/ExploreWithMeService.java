package ru.practicum.explorewithme.statisticservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class ExploreWithMeService {
    @Value("${server.port}")
    private static int port;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ExploreWithMeService.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", port));
        app.run(args);
    }
}
