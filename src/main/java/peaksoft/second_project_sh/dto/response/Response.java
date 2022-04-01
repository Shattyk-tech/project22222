package peaksoft.second_project_sh.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Builder
@Getter
@Setter
public class Response {
    private HttpStatus status;
    private String message;
}
