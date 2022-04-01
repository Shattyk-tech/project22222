package peaksoft.second_project_sh.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "groups")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String groupName;
    private String dateOfStart;
    private String dateOfFinish;

    @ManyToMany(cascade = MERGE)
    @JoinTable(name = "course_group", joinColumns = @JoinColumn(name = "course_id"),
                inverseJoinColumns = @JoinColumn(name = "group_id"))
    @JsonIgnore
    private List<Course> courses;

    @OneToMany(mappedBy = "group",fetch = FetchType.EAGER ,cascade = REMOVE)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Student> student;


    @JsonIgnore
    public void setCourse(Course courseId) {
        if (courses == null){
            courses = new ArrayList<>();
        }
        courses.add(courseId);
        courseId.setGroup(this);
    }
}
