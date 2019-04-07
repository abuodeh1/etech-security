package etech.security;

import etech.admin.domain.Group;
import etech.admin.domain.Role;
import etech.admin.domain.User;
import etech.admin.services.GroupService;
import etech.admin.services.LookupService;
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
    @Autowired
    private LookupService lookupService;

    @Autowired
    private GroupService groupService;



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

            Group group =  new Group("1", "FirstGroub");
            Group group1 = new Group("2", "SecondGroub");
            Group group2 = new Group("3", "thirdGroub");

            groupService.save(group);
            groupService.save(group1);
            groupService.save(group2);



            User user = new User();
            user.setCode("admin");
            user.setPassword("123");
            user.setEmail("admin@etech-systems.com");
            user.setName("Admin");
//
//            User user1 = new User("admin1", "123", AuthorityUtils.NO_AUTHORITIES);
//            user1.setEmail("admin1@etech-systems.com");
//            user1.setName("Admin 1");
//
//            User user2 = new User("admin2", "123", AuthorityUtils.NO_AUTHORITIES);
//            user2.setEmail("admin2@etech-systems.com");
//            user2.setName("Admin 2");
//
//            User user4 = new User("admin4", "123", AuthorityUtils.NO_AUTHORITIES);
//            user4.setEmail("admin1@etech-systems.com");
//            user4.setName("Admin 4");
//
//            User user3 = new User("admin3", "123", AuthorityUtils.NO_AUTHORITIES);
//            user3.setEmail("admin3@etech-systems.com");
//            user3.setName("Admin 3");

            userService.save(user);
//            userService.save(user1);
//            userService.save(user2);
//            userService.save(user3);
//            userService.save(user4);

            /*Lookup lookup = new Lookup();
            lookup.setCode("0");
            lookup.setName("Cities");

            Lookup lookup1 = new Lookup();
            lookup1.setCode("100");
            lookup1.setName("Amman");
            //lookup1.setParent(lookup);

            Lookup lookup2 = new Lookup();
            lookup2.setCode("101");
            lookup2.setName("Aqaba");
            //lookup2.setParent(lookup);

            Lookup lookup3 = new Lookup();
            lookup3.setCode("102");
            lookup3.setName("Zarqa");
            //lookup3.setParent(lookup);

            Lookup lookup4 = new Lookup();
            lookup4.setCode("103");
            lookup4.setName("Irbid");
            //lookup4.setParent(lookup);

            lookupService.save(lookup);
            lookupService.save(lookup1);
            lookupService.save(lookup2);
            lookupService.save(lookup3);
            lookupService.save(lookup4);*/

            logger.info("NO USERS AVAILABLE / DEFAULT USER CREATED : ( " + user.getUsername() + " : " + user.getPassword() + " )");
        }
    }
}
