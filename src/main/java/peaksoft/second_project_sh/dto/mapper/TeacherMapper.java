package peaksoft.second_project_sh.dto.mapper;

import org.springframework.stereotype.Component;
import peaksoft.second_project_sh.dto.response.TeacherDto;
import peaksoft.second_project_sh.model.Teacher;

@Component
public class TeacherMapper {

    public Teacher create(TeacherDto teacherDto){
        if (teacherDto == null){
            return  null;
    }
    Teacher teacher = new Teacher();
    teacher.setFirstName(teacherDto.getFirstName());
    teacher.setLastName(teacherDto.getLastName());
    teacher.setEmail(teacherDto.getEmail());
    return teacher;

    }
}
