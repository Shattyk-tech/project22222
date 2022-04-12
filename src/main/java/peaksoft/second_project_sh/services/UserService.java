package peaksoft.second_project_sh.services;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import peaksoft.second_project_sh.config.jwt.JwtUtils;
import peaksoft.second_project_sh.dto.auth.UserRequest;
import peaksoft.second_project_sh.dto.auth.UserResponse;

@Service
@AllArgsConstructor
public class UserService {

    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    public UserResponse authenticate(UserRequest authRequest) {
        Authentication authentication;

        authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authRequest.getEmail(),
                authRequest.getPassword()
        ));

        String generatedToken = jwtUtils.generateToken(authentication);

        return UserResponse.builder()
                .email(authRequest.getEmail())
                .token(generatedToken)
                .build();
    }
}
