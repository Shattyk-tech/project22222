package peaksoft.second_project_sh.dto.mapper;

import org.springframework.stereotype.Component;
import peaksoft.second_project_sh.dto.response.StudentDto;
import peaksoft.second_project_sh.model.Student;

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
        return student;
    }
}
