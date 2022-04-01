package peaksoft.second_project_sh.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.second_project_sh.dto.mapper.StudentMapper;
import peaksoft.second_project_sh.dto.response.StudentDto;
import peaksoft.second_project_sh.model.Student;
import peaksoft.second_project_sh.repositories.StudentRepository;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{
    @Autowired
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private  final GroupService groupService;
    @Override
    public Student saveStudent(StudentDto studentDto,Long ig) {

        Student student = studentMapper.create(studentDto);

        student.setGroup(groupService.getById(ig));
        return studentRepository.save(student);
    }

    @Override
    public void removeStudentById(long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student getById(long id) {
        return studentRepository.getById(id);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student update(long id, Student student) {
       return  studentRepository.save(student);

    }
}
