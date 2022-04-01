package peaksoft.second_project_sh.services;

import peaksoft.second_project_sh.dto.response.StudentDto;
import peaksoft.second_project_sh.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentService {

    Student saveStudent(StudentDto studentDto,Long studentId);

    void removeStudentById(long nid) ;

    Student getById(long id);

    List<Student> getAllStudent();

    Student update(long id, Student student);

}
