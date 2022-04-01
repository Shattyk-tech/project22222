package peaksoft.second_project_sh.apis;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.second_project_sh.dto.response.CourseDto;
import peaksoft.second_project_sh.model.Course;
import peaksoft.second_project_sh.services.CompanyService;
import peaksoft.second_project_sh.services.CourseService;

import java.util.List;


@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseApi {

    private  final CourseService courseService;
    private final CompanyService companyService;

    @PostMapping("/save/{companyId}")
    public Course createCourse(@RequestBody CourseDto course, @PathVariable("companyId") Long companyId){
        return  courseService.saveCourse(course,companyId);
    }
    @PutMapping("/update/{id}")
    public Course update(@RequestBody Course course,@PathVariable Long id){
        return courseService.update(id,course);
    }
    @GetMapping("/get")
    public List<Course> getAllCourse(){
        return courseService.getAllCourse();
    }
    @DeleteMapping("{id}")
    public void delateCourseById(@PathVariable Long id){
        courseService.removeCourseById(id);
    }

    @GetMapping("/{id}")
    public Course getById(@PathVariable ("id")Long id){
        return  courseService.getById(id);
    }

}
