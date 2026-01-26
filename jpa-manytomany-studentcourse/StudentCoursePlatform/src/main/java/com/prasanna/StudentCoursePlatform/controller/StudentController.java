package com.prasanna.StudentCoursePlatform.controller;

import com.prasanna.StudentCoursePlatform.dto.StudentDto;
import com.prasanna.StudentCoursePlatform.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto){
        return new ResponseEntity<>(studentService.createStudent(studentDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PostMapping("/{studentId}/courses/{courseId}")
    public ResponseEntity<StudentDto> assignCourseToStudent(@PathVariable Long studentId, @PathVariable Long courseId){
        return ResponseEntity.ok(studentService.assignCourseToStudent(studentId, courseId));
    }

    @GetMapping(params = "courseTitle")
    public ResponseEntity<List<StudentDto>> getStudentsByCourseTitle(@RequestParam String courseTitle){
        return ResponseEntity.ok(studentService.getStudentsByCourseTitle(courseTitle));
    }

}
