package etech.admin.services;

import etech.admin.domain.User;
import etech.admin.repositories.UserRepository;
import etech.admin.rest.find.QuerySpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService, EntityService<User> {

    @Autowired
    UserRepository userRepository;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public User loadUserByUsername(String username)  {

        Optional<User> user = userRepository.findById(username);

        return user.isPresent()? user.get() : null;
    }

    public User save(User user) {

        user.setPassword(passwordEncoder().encode(user.getPassword()));

        return userRepository.save(user);
    }

    @Override
    public List<User> find(QuerySpecification<User> querySpecification) {

        return userRepository.findAll(querySpecification);
    }

    @Override
    public Optional<User> get(String username) {

        return userRepository.findUserByUsername(username);
    }

    public boolean delete(String username) {

        Optional<User> user = get(username);

        if (user.isPresent()) {

            userRepository.delete(user.get());

            return true;
        }

        return false;
    }

    public List<User> getAll() {

        return userRepository.findAll();
    }

}
