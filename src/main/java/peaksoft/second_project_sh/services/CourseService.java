package peaksoft.second_project_sh.services;
import peaksoft.second_project_sh.dto.CourseDto;
import peaksoft.second_project_sh.model.Course;
import java.util.List;


public interface CourseService {


    Course saveCourse(CourseDto course,Long companyId );

    Course getById(Long id);

    List<Course> getAllCourse();


    CourseDto update(Long id, CourseDto course);

    void removeCourseById(Long id);
}
