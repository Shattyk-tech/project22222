package peaksoft.second_project_sh.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String groupName;
    private String dateOfStart;
    private String dateOfFinish;

    @ManyToMany(cascade = {PERSIST,DETACH,MERGE,REFRESH})
    @JoinTable(name = "course_group",
            joinColumns = @JoinColumn(name = "course_id"),
                inverseJoinColumns = @JoinColumn(name = "group_id"))
    @JsonIgnore
    private List<Course> courses;

    @OneToMany(
            cascade = {REMOVE},mappedBy = "group")
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
