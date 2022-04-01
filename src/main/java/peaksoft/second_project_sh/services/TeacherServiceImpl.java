package peaksoft.second_project_sh.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.second_project_sh.dto.mapper.TeacherMapper;
import peaksoft.second_project_sh.dto.response.TeacherDto;
import peaksoft.second_project_sh.model.Teacher;
import peaksoft.second_project_sh.repositories.TeacherRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService{

    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;
    private final  CourseService courseService;

    @Override
    public Teacher saveTeacher(TeacherDto teacherDto,Long teacherId) {
        Teacher teacher = teacherMapper.create(teacherDto);
        teacher.setCourse(courseService.getById(teacherId));
        return teacherRepository.save(teacher);
    }

    @Override
    public void deleteTeacherById(Long id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public Teacher getById(long id) {
        return teacherRepository.getById(id);
    }

    @Override
    public List<Teacher> getAllTeacher() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher update(long id, Teacher teacher) {
        teacherRepository.findById(id).get();

        return teacher;
    }
}
