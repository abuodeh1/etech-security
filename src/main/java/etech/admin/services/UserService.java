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

import static java.util.Optional.empty;

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

        Optional<User> myUser = userRepository.findById(username);
        if (myUser.get() == null)
            throw new UsernameNotFoundException("Unknown User");

        return myUser.get();
    }

    public User save(User user) throws Exception {
        Optional<User> checkUser = userRepository.findById(user.getUsername());

        if (checkUser.isPresent() && (checkUser.get().getUsername().equals(user.getUsername()))) {

            throw new Exception("User already exists");

        } else {

            user.setPassword(passwordEncoder().encode(user.getPassword()));
            return userRepository.save(user);
        }
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

    public User get(String id) {

        Optional<User> user = userRepository.findById(id);

        return user.isPresent() ? user.get() : null;
    }

    public void delete(String id) {

        if (get(id) != null)

            userRepository.deleteById(id);
    }

    public User update(User user) throws Exception {
        Optional<User> checkUser = userRepository.findById(user.getUsername());

        if (checkUser.isPresent()) {
            return userRepository.save(user);
        } else {
            throw new Exception("User not exist");
        }
    }


    public List<User> getAllUsers() {
        List userList = new ArrayList();
        userList = userRepository.findAll();
        return userList;
    }

    public User disableUser(String userID) {

        Optional<User> user = userRepository.findById(userID);
        user.get().setEnabled(false);

        return userRepository.save(user.get());
    }

}
