package etech.security;

import etech.admin.domain.Role;
import etech.admin.domain.User;
import etech.admin.services.RoleService;
import etech.admin.services.UserService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

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

        List<User> userList = userService.getAll();

        if (userList.isEmpty()) {

            Role role = new Role();
            role.setCode("role1");
            role.setEnabled(true);
            role.setName("Role 1");

            Role role1 = new Role();
            role1.setCode("role2");
            role1.setEnabled(true);
            role1.setName("Role 2");

            roleService.save(role);
            roleService.save(role1);

            User user = new User("admin", "123", AuthorityUtils.NO_AUTHORITIES);
            user.setEmail("admin@etech-systems.com");
            user.setName("Admin");

            User user1 = new User("admin1", "123", AuthorityUtils.NO_AUTHORITIES);
            user1.setEmail("admin1@etech-systems.com");
            user1.setName("Admin 1");

            User user2 = new User("admin2", "123", AuthorityUtils.NO_AUTHORITIES);
            user2.setEmail("admin2@etech-systems.com");
            user2.setName("Admin 2");

            User user4 = new User("admin4", "123", AuthorityUtils.NO_AUTHORITIES);
            user4.setEmail("admin1@etech-systems.com");
            user4.setName("Admin 4");

            User user3 = new User("admin3", "123", AuthorityUtils.NO_AUTHORITIES);
            user3.setEmail("admin3@etech-systems.com");
            user3.setName("Admin 3");

            userService.save(user);
            userService.save(user1);
            userService.save(user2);
            userService.save(user3);
            userService.save(user4);

            logger.info("NO USERS AVAILABLE / DEFAULT USER CREATED : ( " + user.getUsername() + " : " + user.getPassword() + " )");
        }
    }
}
