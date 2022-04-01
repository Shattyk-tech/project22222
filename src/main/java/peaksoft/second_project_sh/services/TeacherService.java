package peaksoft.second_project_sh.services;

import peaksoft.second_project_sh.dto.response.TeacherDto;
import peaksoft.second_project_sh.model.Teacher;


import java.util.List;

public interface TeacherService {

    Teacher saveTeacher(TeacherDto teacherDto,Long teacherId);

    void deleteTeacherById(Long id) ;

    Teacher getById(long id);

    List<Teacher> getAllTeacher();

    Teacher update(long id, Teacher teacher);
}
