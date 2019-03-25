package etech.security;

import etech.admin.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component	
public class ApplicationInitializer implements CommandLineRunner {
	
	Log logger = LogFactory.getLog(ApplicationInitializer.class);

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {

        List<MyUser> myUserList = userService.findAll();

        if(myUserList.isEmpty()){

            MyUser user = new MyUser("admin", "123", AuthorityUtils.NO_AUTHORITIES);
            user.setCreated(new Date());
            user.setEmail("admin@etech-systems.com");
            user.setName("Mohammad");

            userService.save(user);
            
            logger.info("NO USERS AVAILABLE / DEFAULT USER CREATED : ( " + user.getUsername() + " : " + user.getPassword() + " )");
        }
    }
}
