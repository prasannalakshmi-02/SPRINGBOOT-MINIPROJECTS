package com.prasanna.StudentCoursePlatform.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.Fetch;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "course_table")
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private double fee;

    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
    private List<Student> students;

}
