package com.yeshwant.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yeshwant.jpa.entity.Course;


public interface CourseRepository extends JpaRepository<Course, Long> {

}
