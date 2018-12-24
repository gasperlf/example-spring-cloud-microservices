package lf.com.rabbitbusservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RabbitBusServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitBusServiceApplication.class, args);
    }

}

