package etech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EtechSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(EtechSecurityApplication.class, args);
    }

}
