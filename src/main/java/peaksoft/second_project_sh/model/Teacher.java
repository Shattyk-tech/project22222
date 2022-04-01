package peaksoft.second_project_sh.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import peaksoft.second_project_sh.model.enums.StudyFormat;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teachers")
@Getter @Setter
@RequiredArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH, CascadeType.PERSIST})
    @JsonIgnore
    private Course course;
}
