package lf.com.secutityservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class SecutityServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecutityServiceApplication.class, args);
    }
}
