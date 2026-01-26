package com.prasanna.StudentCoursePlatform.dto;

import com.prasanna.StudentCoursePlatform.entity.Course;
import lombok.Data;
import java.util.List;

@Data
public class StudentDto {

    private String name;
    private String email;
    private List<CourseDto> courses;
}
