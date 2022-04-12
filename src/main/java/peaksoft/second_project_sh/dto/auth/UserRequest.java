package peaksoft.second_project_sh.dto.auth;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Beksultan
 */
@Getter @Setter
public class UserRequest {
    private String email;
    private String password;
}
