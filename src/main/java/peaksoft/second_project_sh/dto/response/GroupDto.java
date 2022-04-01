package peaksoft.second_project_sh.dto.response;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class GroupDto {
    @NotBlank
    private String groupName;
    @NotBlank
    private String dateOfStart;
    @NotBlank
    private String dateOfFinish;

}
