package etech.admin.services;

import etech.admin.domain.User;
import etech.admin.repositories.UserRepository;
import etech.admin.rest.find.QuerySpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> myUser = userRepository.findUserByUsername(username);
        if (myUser.get() == null)
            throw new UsernameNotFoundException("Unknown User");

        return myUser.get();
    }

    public User save(User user) throws Exception{
        Optional<User> checkUser = userRepository.findUserByUsername(user.getUsername());
        if (checkUser.isPresent()) {
            throw new Exception("User already exists");
        }
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<User> findAll(QuerySpecification<User> userSpecification) {
        return userRepository.findAll(userSpecification);
    }

    public User create(User user) {

        return userRepository.save(user);
    }

    public User get(String username) {

        Optional<User> user = userRepository.findUserByUsername(username);

        return user.isPresent() ? user.get() : null;
    }

    public void delete(String username) {

        if (get(username) != null)

            userRepository.deleteById(username);
    }

    public User update(User user) {

        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        List userList = new ArrayList();
        userList = userRepository.findAll();
        return userList;
    }

    public User disableUser(String username) {

        User updatedUser = null;

        Optional<User> user = userRepository.findUserByUsername(username);
        if (user.isPresent()) {
            user.get().setEnabled(false);
            updatedUser = userRepository.save(user.get());
        }

        return updatedUser;
    }

}
