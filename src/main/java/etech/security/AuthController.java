package etech.security;

import etech.admin.domain.User;
import etech.admin.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private TokenUtil tokenUtil;

    @PostMapping(value = {"", "/"})
    private JwtResponse auth(@RequestBody AuthObject authObject){

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authObject.getUsername(), authObject.getPassword(), null)
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userDetails = userService.loadUserByUsername(authObject.getUsername());

        String token = tokenUtil.generateToken(userDetails);

        return new JwtResponse(token);

    }

    @PostMapping(value = "/verify")
    private boolean verify(@RequestBody VerifyAuthObject verifyAuthObject){
        return tokenUtil.isTokenValid(verifyAuthObject.getToken(), verifyAuthObject.getUsername());
    }

    class JwtResponse{

        private String token;

        public JwtResponse(String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
