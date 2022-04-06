package peaksoft.second_project_sh.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter@Setter
public class CourseDto {
    @NotBlank
    private String name;
    @NotBlank
    private String durationMonth;
}
