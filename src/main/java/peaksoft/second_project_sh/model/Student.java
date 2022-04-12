package peaksoft.second_project_sh.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.second_project_sh.model.enums.StudyFormat;
import javax.persistence.*;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private StudyFormat studyFormat;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
    @JsonIgnore
    private Group group;

    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
    private User users;

}
