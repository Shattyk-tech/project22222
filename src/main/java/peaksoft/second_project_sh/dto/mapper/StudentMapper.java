package peaksoft.second_project_sh.dto.mapper;

import org.springframework.stereotype.Component;
import peaksoft.second_project_sh.dto.StudentDto;
import peaksoft.second_project_sh.model.Role;
import peaksoft.second_project_sh.model.Student;
import peaksoft.second_project_sh.model.User;


@Component
public class StudentMapper {

    public Student create(StudentDto studentDto){
        if (studentDto == null){
            return  null;

        }
        Student student = new Student();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setEmail(studentDto.getEmail());
        student.setStudyFormat(studentDto.getStudyFormat());
        User user = new User();
        user.setEmail(studentDto.getEmail());
        user.setPassword(studentDto.getPassword());
        Role role = new Role();
        role.setRole("STUDENT");
        user.setRole(role);
        student.setUsers(user);
        return student;
    }
}
