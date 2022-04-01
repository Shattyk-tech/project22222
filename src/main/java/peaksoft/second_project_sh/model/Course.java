package peaksoft.second_project_sh.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "coures")
@Getter @Setter
@RequiredArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String durationMonth;

    @JsonIgnore
    @ManyToOne
    private Company company;

    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "courses", cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REMOVE} )
    private List<Group> groups;

    @OneToOne(mappedBy = "course",cascade = ALL)
    private Teacher teacher;

    @JsonIgnore
    public void setGroup(Group group) {
        if (groups == null) {
            groups = new ArrayList<>();
        }
        groups.add(group);
    }
}
