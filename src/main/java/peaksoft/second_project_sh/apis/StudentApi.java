package peaksoft.second_project_sh.apis;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @Operation(method = "postMethod", description = "create student")
    @PreAuthorize("hasAnyAuthority('TEACHER','ADMIN')")
    @PostMapping("/save/{groupId}")
    public Student createStudent(@PathVariable Long groupId, @RequestBody StudentDto student) {

        return studentService.saveStudent(student, groupId);
    }

    @Operation(method = "patchMethod", description = "update with id")
    @PreAuthorize("hasAnyAuthority('ADMIN','TEACHAR')")
    @PatchMapping("/update/{id}")
    public StudentDto update(@RequestBody StudentDto student, @PathVariable Long id) {
        return studentService.update(id, student);
    }

    @Operation(method = "getMethod", description = "get all group")
    @PreAuthorize("hasAnyAuthority('ADMIN','TEACHER')")
    @GetMapping("/get")
    public List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    @Operation(method = "deleteMethod", description = "delete by id")
    @PreAuthorize("hasAnyAuthority('ADMIN','TEACHER')")
    @DeleteMapping("/delete/{id}")
    public void delateByIdStudent(@PathVariable("id") Long id) {
        studentService.removeStudentById(id);
    }

    @Operation(method = "getMethod", description = "get by id")
    @PreAuthorize("hasAnyAuthority('ADMIN','TEACHER')")
    @GetMapping("{id}")
    public Student getById(@PathVariable Long id) {
        return studentService.getById(id);
    }
}
