package peaksoft.second_project_sh.apis;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.second_project_sh.dto.CourseDto;
import peaksoft.second_project_sh.model.Course;
import peaksoft.second_project_sh.services.CourseService;

import java.util.List;


@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseApi {

    private final CourseService courseService;

    @Operation(method = "postmethod", description = "create course")
    @PostMapping("/save/{companyId}")
    public Course createCourse(@RequestBody CourseDto course, @PathVariable("companyId") Long companyId) {
        return courseService.saveCourse(course, companyId);
    }

    @Operation(method = "putMethod", description = "update from id")
    @PutMapping("/update/{id}")
    public CourseDto update(@RequestBody CourseDto course, @PathVariable Long id) {
        return courseService.update(id, course);
    }

    @Operation(method = "getMethod", description = "get all courses")
    @GetMapping("/get")
    public List<Course> getAllCourse() {
        return courseService.getAllCourse();
    }

    @Operation(method = "deleteMethod", description = "delete from id")
    @DeleteMapping("{id}")
    public void delateCourseById(@PathVariable Long id) {
        courseService.removeCourseById(id);
    }

    @Operation(method = "getMethod", description = "get from id")
    @GetMapping("/{id}")
    public Course getById(@PathVariable("id") Long id) {
        return courseService.getById(id);
    }

}
