package peaksoft.second_project_sh.dto.mapper;

import org.springframework.stereotype.Component;
import peaksoft.second_project_sh.dto.TeacherDto;
import peaksoft.second_project_sh.model.Role;
import peaksoft.second_project_sh.model.Teacher;
import peaksoft.second_project_sh.model.User;


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

        User user = new User();
        user.setEmail(teacherDto.getEmail());
        user.setPassword(teacherDto.getPassword());
        Role role = new Role();
        role.setRole("TEACHER");
        user.setRole(role);
        teacher.setUsers(user);
    return teacher;

    }
}
