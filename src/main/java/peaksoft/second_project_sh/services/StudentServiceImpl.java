package peaksoft.second_project_sh.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import peaksoft.second_project_sh.dto.mapper.StudentMapper;
import peaksoft.second_project_sh.dto.StudentDto;
import peaksoft.second_project_sh.model.Student;
import peaksoft.second_project_sh.model.enums.StudyFormat;
import peaksoft.second_project_sh.repositories.StudentRepository;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private  final GroupService groupService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Student saveStudent(StudentDto studentDto,Long ig) {
        studentDto.setPassword(passwordEncoder.encode(studentDto.getPassword()));

        Student student = studentMapper.create(studentDto);
        student.setGroup(groupService.getById(ig));

        return studentRepository.save(student);
    }

    @Override
    public void removeStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student getById(long id) {
        return studentRepository.findById(id)
                .orElseThrow(()->{
                    throw new NotFoundException(
                            String.format("student with id = %s  does not exist",id)
                    );
                });
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Transactional
    @Override
    public StudentDto update(Long id, StudentDto studentDto) {
        Student student =studentRepository.findById(id)
                .orElseThrow(()->{
                    throw new NotFoundException(
                            String.format("student with id = %s  does not exist",id)
                    );
                });

        String studentName = student.getFirstName();
        String newName = studentDto.getFirstName();

        if (!Objects.equals(studentName, newName)) {
            student.setFirstName(newName);
        }

        String lastName = student.getLastName();
        String newLastName = studentDto.getLastName();

        if (!Objects.equals(lastName,newLastName)){
            student.setLastName(newLastName);
        }
        String email = student.getEmail();
        String newEmail = studentDto.getEmail();

        if (!Objects.equals(email,newEmail)){
            student.setEmail(newEmail);
        }
        StudyFormat studyFormat = student.getStudyFormat();
        StudyFormat newStudyFormat = studentDto.getStudyFormat();

        if (!Objects.equals(studyFormat,newStudyFormat)){
            student.setStudyFormat(newStudyFormat);
        }

        return studentDto;

    }
}
