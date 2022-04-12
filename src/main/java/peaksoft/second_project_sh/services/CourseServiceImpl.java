package peaksoft.second_project_sh.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import peaksoft.second_project_sh.dto.mapper.CourseMapper;
import peaksoft.second_project_sh.dto.CourseDto;
import peaksoft.second_project_sh.model.Course;
import peaksoft.second_project_sh.repositories.CourseRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService{

    private final CourseRepository courseRepository;
    private  final CourseMapper courseMapper;
    private  final  CompanyService companyService;

    @Override
    public Course saveCourse(CourseDto courseDto,Long companyId) {
        Course course = courseMapper.create(courseDto);
        course.setCompany(companyService.findById(companyId));
        return courseRepository.save(course);
    }

    @Override
    @Transactional
    public void removeCourseById(Long id)  {
        courseRepository.deleteById(id);

    }

    @Override
    public Course getById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(()->{
                    throw new NotFoundException(
                            String.format("student with id = %s  does not exist",id)
                    );
                });
    }

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    @Transactional
    public CourseDto update(Long id, CourseDto course) {

        Course course1 = courseRepository.getById(id);

        String currentName = course1.getName();
        String newName = course.getName();
        if (!Objects.equals(currentName, newName)) {
            course1.setName(newName);
        }


        String oldDurationMonth = course1.getDurationMonth();
        String durationMonth = course.getDurationMonth();
        if (!Objects.equals(oldDurationMonth,durationMonth)){
            course1.setDurationMonth(durationMonth);
        }

        return course;
    }


}
