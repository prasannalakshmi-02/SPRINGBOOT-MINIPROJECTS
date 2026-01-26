package com.prasanna.StudentCoursePlatform.service;

import com.prasanna.StudentCoursePlatform.dto.StudentDto;
import com.prasanna.StudentCoursePlatform.entity.Course;
import com.prasanna.StudentCoursePlatform.entity.Student;
import com.prasanna.StudentCoursePlatform.repository.CourseRepository;
import com.prasanna.StudentCoursePlatform.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public StudentDto createStudent(StudentDto studentDto){
        Student std = modelMapper.map(studentDto, Student.class);
        Student savedStd = studentRepository.save(std);
        return modelMapper.map(savedStd, StudentDto.class);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> list = studentRepository.findAll();

        return list.stream()
                .map(student->modelMapper.map(student, StudentDto.class))
                .toList();
    }

    @Override
    public StudentDto assignCourseToStudent(Long studentId, Long courseId) {
        Student std = studentRepository.findById(studentId)
                .orElseThrow(()->new RuntimeException("student not found with id" + studentId));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(()->new RuntimeException("course not found with id" + courseId));
        List<Course> courses = std.getCourses();
        courses.add(course);
        std.setCourses(courses);
        Student savedStd = studentRepository.save(std);
        return modelMapper.map(savedStd, StudentDto.class);
    }

    @Override
    public List<StudentDto> getStudentsByCourseTitle(String courseTitle) {
        List<Student> students = studentRepository.findByCourses_Title(courseTitle);
        return students.stream()
                .map(student->modelMapper.map(student, StudentDto.class))
                .toList();
   }
}
