package peaksoft.second_project_sh.apis;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.second_project_sh.dto.TeacherDto;
import peaksoft.second_project_sh.model.Teacher;
import peaksoft.second_project_sh.services.CourseService;
import peaksoft.second_project_sh.services.TeacherService;

import java.util.List;

@RestController
@RequestMapping("api/teachers")
@AllArgsConstructor
public class TeacherApi {

    private TeacherService teacherService;
    private CourseService courseService;

    @Operation(method = "postMethod", description = "create teacher")
    @PostMapping("/save/{courseId}")
    public Teacher createTeacher(@PathVariable Long courseId, @RequestBody TeacherDto teacherDto) {
        return teacherService.saveTeacher(teacherDto, courseId);
    }

    @Operation(method = "patchMethod", description = "update with id")
    @PatchMapping("/update/{id}")
    public TeacherDto update(@RequestBody TeacherDto teacher, @PathVariable("id") Long id) {
        return teacherService.update(id, teacher);
    }

    @Operation(method = "getMethod", description = "get all teacher")
    @GetMapping("/get")
    public List<Teacher> getAllTeacher() {
        return teacherService.getAllTeacher();
    }

    @Operation(method = "deleteMethod", description = "delete by id")
    @DeleteMapping("/delete/{id}")
    public void deleteByIdTeacher(@PathVariable Long id) {
        teacherService.deleteTeacherById(id);
    }

    @Operation(method = "getMethod", description = "get by id")
    @GetMapping("{id}")
    public Teacher getById(@PathVariable Long id) {
        return teacherService.getById(id);
    }

}



