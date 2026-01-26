package com.prasanna.StudentCoursePlatform.repository;

import com.prasanna.StudentCoursePlatform.dto.StudentDto;
import com.prasanna.StudentCoursePlatform.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByCourses_Title(String title);
}
