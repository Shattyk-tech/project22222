package peaksoft.second_project_sh.apis;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.second_project_sh.dto.response.StudentDto;
import peaksoft.second_project_sh.model.Student;
import peaksoft.second_project_sh.services.GroupService;
import peaksoft.second_project_sh.services.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@AllArgsConstructor
public class StudentApi {

    private StudentService studentService;
    private GroupService groupService;

    @PostMapping("/save/{groupId}")
    public Student createStudent(@PathVariable Long groupId, @RequestBody StudentDto student){

        return studentService.saveStudent(student,groupId);
    }
    @PatchMapping("/update/{id}")
    public Student update(@RequestBody Student student,@PathVariable Long id){
        return studentService.update(id,student);
    }

    @GetMapping("/get")
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    @DeleteMapping("/delete/{id}")
    public void delateByIdStudent(@PathVariable Long id){
        studentService.getById(id);
    }

   @GetMapping("{id}")
    public Student getById(@PathVariable Long id){
        return  studentService.getById(id);
   }

}
