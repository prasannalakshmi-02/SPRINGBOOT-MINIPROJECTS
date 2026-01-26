package com.prasanna.StudentCoursePlatform.controller;

import com.prasanna.StudentCoursePlatform.dto.CourseDto;
import com.prasanna.StudentCoursePlatform.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<CourseDto> createCourse(@RequestBody CourseDto course){
        return new ResponseEntity<>(courseService.createCourse(course), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CourseDto>> getAllCourses(){
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<CourseDto>> getCoursesByStudentId(@PathVariable Long studentId){
        return ResponseEntity.ok(courseService.getCoursesByStudentId(studentId));
    }

    @GetMapping("/popular")
    public ResponseEntity<CourseDto> getMostPopularCourse(){
        return ResponseEntity.ok(courseService.getMostPopularCourse());
    }
}
