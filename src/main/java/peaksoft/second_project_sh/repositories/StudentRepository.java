package peaksoft.second_project_sh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.second_project_sh.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}
