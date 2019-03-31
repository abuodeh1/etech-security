package etech.security;

import etech.admin.domain.Role;
import etech.admin.domain.User;
import etech.admin.domain.UserRole;
import etech.admin.services.RoleService;
import etech.admin.services.UserService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@EnableJpaAuditing
@Component
public class ApplicationInitializer implements CommandLineRunner {

    Log logger = LogFactory.getLog(ApplicationInitializer.class);

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @Override
    public void run(String... args) throws Exception {

        List<User> userList = userService.findAll();

        if (userList.isEmpty()) {

            Role role = new Role();
            role.setCode("role1");
            role.setEnabled(true);
            role.setName("Role 1");

            Role role1 = new Role();
            role1.setCode("role2");
            role1.setEnabled(true);
            role1.setName("Role 2");

            roleService.create(role);
            roleService.create(role1);

            User user = new User("admin", "123", AuthorityUtils.NO_AUTHORITIES);
            user.setEmail("admin@etech-systems.com");
            user.setName("Mohammad");

            List<UserRole> userRoles = new ArrayList<>();
            userRoles.add(new UserRole(role, 1554025466465L));
            userRoles.add(new UserRole(role1, 1554025466465L));

            user.setUserRoles(userRoles);

            userService.save(user);

            logger.info("NO USERS AVAILABLE / DEFAULT USER CREATED : ( " + user.getUsername() + " : " + user.getPassword() + " )");
        }
    }
}
