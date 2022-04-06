package peaksoft.second_project_sh.apis;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.second_project_sh.dto.StudentDto;
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

    @Operation(method = "postMethod", description = "create student")
    @PostMapping("/save/{groupId}")
    public Student createStudent(@PathVariable Long groupId, @RequestBody StudentDto student) {

        return studentService.saveStudent(student, groupId);
    }

    @Operation(method = "patchMethod", description = "update with id")
    @PatchMapping("/update/{id}")
    public StudentDto update(@RequestBody StudentDto student, @PathVariable Long id) {
        return studentService.update(id, student);
    }

    @Operation(method = "getMethod", description = "get all group")
    @GetMapping("/get")
    public List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    @Operation(method = "deleteMethod", description = "delete by id")
    @DeleteMapping("/delete/{id}")
    public void delateByIdStudent(@PathVariable("id") Long id) {
        studentService.removeStudentById(id);
    }

    @Operation(method = "getMethod", description = "get by id")
    @GetMapping("{id}")
    public Student getById(@PathVariable Long id) {
        return studentService.getById(id);
    }
}
