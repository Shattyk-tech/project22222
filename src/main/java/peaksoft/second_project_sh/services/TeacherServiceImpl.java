package peaksoft.second_project_sh.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import peaksoft.second_project_sh.dto.mapper.TeacherMapper;
import peaksoft.second_project_sh.dto.TeacherDto;
import peaksoft.second_project_sh.model.Student;
import peaksoft.second_project_sh.model.Teacher;
import peaksoft.second_project_sh.repositories.TeacherRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService{

    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;
    private final  CourseService courseService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Teacher saveTeacher(TeacherDto teacherDto,Long teacherId) {
        teacherDto.setPassword(passwordEncoder.encode(teacherDto.getPassword()));
        Teacher teacher = teacherMapper.create(teacherDto);
        teacher.setCourse(courseService.getById(teacherId));
        return teacherRepository.save(teacher);
    }

    @Override
    public void deleteTeacherById(Long id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public Teacher getById(Long id) {
        return teacherRepository.findById(id)
                .orElseThrow(()->{
                    throw new NotFoundException(
                            String.format("student with id = %s  does not exist",id)
                    );
                });
    }

    @Override
    public List<Teacher> getAllTeacher() {
        return teacherRepository.findAll();
    }


    @Override
    @Transactional
    public TeacherDto update(Long id, TeacherDto teacher) {
        Teacher teacher1 = teacherRepository
                .findById(id).orElseThrow(()->{
            throw new NotFoundException(
                    String.format("teacher with id =%s does not exist",id)
            );
        });

        String nameT = teacher1.getFirstName();
        String newName = teacher.getFirstName();

        if (!Objects.equals(nameT, newName)) {
            teacher1.setFirstName(newName);
        }

        String lastName = teacher1.getLastName();
        String newLastName = teacher.getLastName();

        if (!Objects.equals(lastName,newLastName)){
            teacher1.setLastName(newLastName);
        }
        String email = teacher1.getEmail();
        String newEmail = teacher.getEmail();

        if (!Objects.equals(email,newEmail)){
            teacher1.setEmail(newEmail);
        }

        return teacher;
    }
}
