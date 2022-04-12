package peaksoft.second_project_sh.dto;

import lombok.Getter;
import lombok.Setter;
import peaksoft.second_project_sh.model.enums.StudyFormat;

import javax.validation.constraints.NotBlank;

@Getter@Setter
public class StudentDto {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String email;
    @NotBlank
    private StudyFormat studyFormat;

    private String password;
}
