package peaksoft.second_project_sh.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "companies")
@Getter
@Setter
@RequiredArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String locatedCountry;

    @OneToMany(fetch = FetchType.EAGER,
              mappedBy = "company",
            cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST})
    private List<Course> course;


}

