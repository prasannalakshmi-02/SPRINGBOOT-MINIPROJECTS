package com.prasanna.StudentCoursePlatform.service;

import com.prasanna.StudentCoursePlatform.dto.CourseDto;

import java.util.List;

public interface CourseService {


    CourseDto createCourse(CourseDto courseDto);
    List<CourseDto> getAllCourses();


    List<CourseDto> getCoursesByStudentId(Long studentId); // "My Courses"
    CourseDto getMostPopularCourse();

}
