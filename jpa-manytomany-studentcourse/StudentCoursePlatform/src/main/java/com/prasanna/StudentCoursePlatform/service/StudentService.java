package com.prasanna.StudentCoursePlatform.service;


import com.prasanna.StudentCoursePlatform.dto.StudentDto;

import java.util.List;

public interface StudentService {

    StudentDto createStudent(StudentDto studentDto);
    List<StudentDto> getAllStudents();

    // 🔥 Difficult Methods
    StudentDto assignCourseToStudent(Long studentId, Long courseId);
    List<StudentDto> getStudentsByCourseTitle(String courseTitle);

}
