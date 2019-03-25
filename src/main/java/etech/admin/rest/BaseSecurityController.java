package etech.admin.rest;

import etech.admin.domain.User;
import org.springframework.security.core.context.SecurityContextHolder;

public abstract class BaseSecurityController {

    public User getCurrentUser(){
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
