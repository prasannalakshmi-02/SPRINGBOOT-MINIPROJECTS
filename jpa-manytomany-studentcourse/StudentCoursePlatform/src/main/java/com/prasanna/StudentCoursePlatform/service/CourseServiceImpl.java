package com.prasanna.StudentCoursePlatform.service;

import com.prasanna.StudentCoursePlatform.dto.CourseDto;
import com.prasanna.StudentCoursePlatform.entity.Course;
import com.prasanna.StudentCoursePlatform.repository.CourseRepository;
import com.prasanna.StudentCoursePlatform.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CourseDto createCourse(CourseDto courseDto) {
        Course course = modelMapper.map(courseDto, Course.class);
        Course savedCourse = courseRepository.save(course);
        return modelMapper.map(savedCourse, CourseDto.class);
    }

    @Override
    public List<CourseDto> getAllCourses() {
        List<Course> list = courseRepository.findAll();

        return list.stream()
                .map(course->modelMapper.map(course, CourseDto.class))
                .toList();

    }

    @Override
    public List<CourseDto> getCoursesByStudentId(Long studentId) {
        List<Course> courses = courseRepository.findByStudents_Id(studentId);
        return courses.stream()
                .map(course->modelMapper.map(course, CourseDto.class))
                .toList();
    }

    @Override
    public CourseDto getMostPopularCourse() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream()
                .max((c1, c2)->Integer.compare(c1.getStudents().size(), c2.getStudents().size()))
                .map(course->modelMapper.map(course, CourseDto.class))
                .orElseThrow(() -> new RuntimeException("No courses found in database!"));
    }
}
