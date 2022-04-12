package peaksoft.second_project_sh.dto.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter @Setter
public class UserResponse {
    private String email;
    private String token;
}
