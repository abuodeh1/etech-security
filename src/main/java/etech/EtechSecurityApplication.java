package etech;

import etech.admin.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@SpringBootApplication
public class EtechSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(EtechSecurityApplication.class, args);
    }

}
