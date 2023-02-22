package com.yeshwant.jpa.dao;

import com.yeshwant.jpa.entity.Course;

public interface CourseDao {

	Course saveCourse(Course course);
	
	Course getCourseById(Long id);
	
}
