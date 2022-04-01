package peaksoft.second_project_sh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.second_project_sh.model.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
