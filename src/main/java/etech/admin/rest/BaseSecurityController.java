package etech.admin.rest;

import etech.admin.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
public abstract class BaseSecurityController {

    public User getCurrentUser(){
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @Bean
    public AuditorAware<String> createAuditorProvider() {
        Optional username = Optional.ofNullable(getCurrentUser().getUsername()==null? "admin": getCurrentUser().getUsername());
        return () -> username;
    }

}
