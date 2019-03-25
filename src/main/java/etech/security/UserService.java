package etech.security;

import etech.admin.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public MyUser loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<MyUser> myUser = userRepository.findById(username);
        if (myUser.get() == null)
            throw new UsernameNotFoundException("Unknown User");

        return myUser.get();
    }

    public void save(MyUser myUser){
        myUser.setPassword(passwordEncoder().encode(myUser.getPassword()));
        userRepository.save(myUser);
    }

    public List<MyUser> findAll(){
        return userRepository.findAll();
    }
}
