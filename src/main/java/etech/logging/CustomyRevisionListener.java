package etech.logging;

import etech.admin.domain.User;
import org.hibernate.envers.RevisionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

public class CustomyRevisionListener implements RevisionListener {

    @Autowired
    private AuditEventHandler auditEventHandler;

    @Override
    public void newRevision(Object revisionEntity) {
        CustomRevision rev = (CustomRevision) revisionEntity;
        //rev.setUserName(auditorAware().getCurrentAuditor().get());
        rev.setModifiedDate(new Date().getTime());
        if(auditEventHandler != null) {
            rev.setHost(auditEventHandler.getWebAuthenticationDetails().getRemoteAddress());
        }
    }

    @Bean
    public AuditorAware<String> auditorAware() {
        /*Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            User user = (User) authentication.getPrincipal();
            return () -> Optional.of(user.getUsername());
        } else {
            return () -> Optional.of("");
        }*/
        return () -> Optional.of("");
    }

}