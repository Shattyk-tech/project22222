package peaksoft.second_project_sh.dto.mapper;

import org.springframework.stereotype.Component;
import peaksoft.second_project_sh.dto.CourseDto;
import peaksoft.second_project_sh.model.Course;

@Component
public class CourseMapper {
    public Course create(CourseDto courseDto){

        if (courseDto ==null) {
            return null;
        }

            Course course = new Course();

            course.setName(courseDto.getName());
            course.setDurationMonth(courseDto.getDurationMonth());

            return  course;


    }
}
