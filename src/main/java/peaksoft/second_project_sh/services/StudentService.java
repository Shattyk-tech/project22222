package peaksoft.second_project_sh.services;

import peaksoft.second_project_sh.dto.StudentDto;
import peaksoft.second_project_sh.model.Student;

import java.util.List;

public interface StudentService {

    Student saveStudent(StudentDto studentDto,Long studentId);

    void removeStudentById(Long nid) ;

    Student getById(long id);

    List<Student> getAllStudent();

    StudentDto update(Long id, StudentDto student);

}
