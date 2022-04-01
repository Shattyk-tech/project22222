package peaksoft.second_project_sh.apis;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.second_project_sh.dto.response.TeacherDto;
import peaksoft.second_project_sh.model.Student;
import peaksoft.second_project_sh.model.Teacher;
import peaksoft.second_project_sh.repositories.CourseRepository;
import peaksoft.second_project_sh.services.CourseService;
import peaksoft.second_project_sh.services.StudentService;
import peaksoft.second_project_sh.services.TeacherService;

import java.util.List;

@RestController
@RequestMapping("api/teachers")
@AllArgsConstructor
public class TeacherApi {

    private TeacherService teacherService;
    private CourseService courseService;

    @PostMapping("/save/{courseId}")
    public Teacher createTeacher(@PathVariable Long courseId, @RequestBody TeacherDto teacherDto){

        return teacherService.saveTeacher(teacherDto,courseId);

    }
    @PatchMapping("/update/{id}")
    public Teacher update(@RequestBody Teacher teacher, @PathVariable Long id){
        return teacherService.update(id,teacher);
    }

    @GetMapping("/get")
    public List<Teacher>getAllTeacher(){
        return teacherService.getAllTeacher();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteByIdTeacher(@PathVariable Long id){
        teacherService.deleteTeacherById(id);
    }

    @GetMapping("{id}")
    public Teacher getById(@PathVariable Long id){
        return  teacherService.getById(id);
    }

}



