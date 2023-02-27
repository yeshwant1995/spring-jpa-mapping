package com.yeshwant.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yeshwant.jpa.entity.Course;


public interface CourseRepository extends JpaRepository<Course, Long> {
	
	@Query("select c from Course c left join fetch c.reviews ")
	List<Course> findAllCourseWithReviews();

}
