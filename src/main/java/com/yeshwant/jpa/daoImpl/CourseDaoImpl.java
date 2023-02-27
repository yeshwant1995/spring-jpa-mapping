package com.yeshwant.jpa.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yeshwant.jpa.dao.CourseDao;
import com.yeshwant.jpa.entity.Course;
import com.yeshwant.jpa.repository.CourseRepository;

@Repository
public class CourseDaoImpl implements CourseDao {

	@Autowired
	CourseRepository courseRepository;

	@Override
	public Course saveCourse(Course course) {

		Course savedCourse = courseRepository.save(course);

		return savedCourse;
	}

	@Override
	public Course getCourseById(Long id) {
		
		Course getFetchedCourse = courseRepository.getReferenceById(id);
		
		return getFetchedCourse;
	}

	@Override
	public List<Course> findAllCourse() {
		
		return courseRepository.findAll();
	}

}
