package com.yeshwant.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.yeshwant.jpa.dao.CourseDao;
import com.yeshwant.jpa.entity.Course;
import com.yeshwant.jpa.entity.Passport;
import com.yeshwant.jpa.entity.Review;
import com.yeshwant.jpa.entity.Student;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class CourseTests {
	
	@Autowired
	CourseDao courseDao;
	
	@Test
	void testSaveCourse() {
		
		Course course1 = new Course("Course 1");
		Course course2 = new Course("Course 2");
		Course course3 = new Course("Course 3");
		
		Course savedCourse1 = courseDao.saveCourse(course1);
		Course savedCourse2 = courseDao.saveCourse(course2);
		Course savedCourse3 = courseDao.saveCourse(course3);
		
		System.out.println(savedCourse1);
		System.out.println(savedCourse2);
		System.out.println(savedCourse3);
		
		assertThat(savedCourse1.getId()).isGreaterThan(0);
		assertThat(savedCourse2.getId()).isGreaterThan(0);
		assertThat(savedCourse3.getId()).isGreaterThan(0);
	}
	
	@Test
	void testSaveCourseWithReview() {
		
		Course course = new Course("course with review");
		
		Review review1 = new Review("1", "good course");
		review1.setCourse(course);
		
		Review review2 = new Review("1","excellent course");
		review2.setCourse(course);
		
		course.addReviews(review1);
		course.addReviews(review2);
		
		Course savedCourse = courseDao.saveCourse(course);
		
		System.out.println("Course " + savedCourse);
		System.out.println("Reviews " + savedCourse.getReviews());
		
		assertThat(savedCourse.getId()).isGreaterThan(0);
		
	}
	
	@Test
	void testGetCourseById() {
		
		Course fetchedCourse = courseDao.getCourseById(42L);
		
		System.out.println("testGetCourseById fetchedCourse "+ fetchedCourse);
		
		List<Review> fetchedReviews = fetchedCourse.getReviews();
		
		System.out.println("testGetCourseById fetchedReviews " + fetchedReviews);
		
		assertThat(fetchedCourse).isNotNull();
		
	}
	
	@Test
	void testSaveCourseWithStudent() {
		
		Course course = new Course("Student course");
		
		Student student1 = new Student("c-student-1", new Passport("safdsfsdf"));
		Student student2 = new Student("c-student-2", new Passport("gdgrtdfs"));
		
		course.setStudents(student1);
		course.setStudents(student2);
		
		student1.setCourses(course);
		student2.setCourses(course);
		
		courseDao.saveCourse(course);	
	}
	
//	@Test
//	void testSave_10_000_CourseWithReview() {
//		
//		for(int i=0 ; i<=10000 ; i++) {
//
//			Course course = new Course("course " + UUID.randomUUID());
//			
//			Review review1 = new Review("1", "Course blagasdsdsa");
//			review1.setCourse(course);
//			
//			Review review2 = new Review("2","excellent course");
//			review2.setCourse(course);
//
//			Review review3 = new Review("3","exc sadasdellent course");
//			review3.setCourse(course);
//			
//			Review review4 = new Review("4","e dasdd4rxcellent course");
//			review4.setCourse(course);
//			
//			Review review5 = new Review("5","excellent dassdasd course");
//			review5.setCourse(course);
//			
//			
//			course.addReviews(review1);
//			course.addReviews(review2);
//			course.addReviews(review3);
//			course.addReviews(review4);
//			course.addReviews(review5);
//			
//			courseDao.saveCourse(course);
//
//		}
//					
//	}
	
	@Test
	void getAllCourse() {
		
		List<Course> courses = courseDao.findAllCourse();
		
		courses.stream().forEach(c -> {
			System.out.println( c.getReviews());
			//c.getReviews();
		});
		
	}

}
