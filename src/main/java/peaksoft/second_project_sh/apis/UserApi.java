package peaksoft.second_project_sh.apis;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import peaksoft.second_project_sh.dto.auth.UserRequest;
import peaksoft.second_project_sh.dto.auth.UserResponse;
import peaksoft.second_project_sh.model.Role;
import peaksoft.second_project_sh.model.User;

import peaksoft.second_project_sh.repositories.UserRepository;
import peaksoft.second_project_sh.services.UserService;

import javax.annotation.PostConstruct;
import javax.annotation.security.PermitAll;


@RestController
@RequestMapping("/api/authentication")
@AllArgsConstructor
public class UserApi {

    private final UserService authService;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @PostMapping
    @PermitAll
    public UserResponse authenticate(@RequestBody UserRequest authRequest) {
        return authService.authenticate(authRequest);
    }
    @PostConstruct
    public  void  init(){
        User user = new User();
        user.setEmail("shattyk@gmail.com");
        user.setPassword(passwordEncoder.encode("shattyk"));
        Role role = new Role();
        role.setRole("ADMIN");
        user.setRole(role);
        userRepository.save(user);

    }
}
