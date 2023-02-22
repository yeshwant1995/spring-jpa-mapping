package com.yeshwant.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.yeshwant.jpa.dao.StudentDao;
import com.yeshwant.jpa.entity.Passport;
import com.yeshwant.jpa.entity.Student;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class StudentTests {
	

	
	@Autowired
	StudentDao studentDao;
	
	@Test
	void testSaveStudent() {
		
		Student student1 = new Student("Student 1", new Passport(RandomStringUtils.random(10, true, true)));
		Student student2 = new Student("Student 2", new Passport(RandomStringUtils.random(10, true, true)));
		Student student3 = new Student("Student 3", new Passport(RandomStringUtils.random(10, true, true)));
		
		Student savedStudent1 = studentDao.saveStudent(student1);
		Student savedStudent2 = studentDao.saveStudent(student2);
		Student savedStudent3 = studentDao.saveStudent(student3);
		
		System.out.println(savedStudent1);
		System.out.println(savedStudent2);
		System.out.println(savedStudent3);
		
		assertThat(savedStudent1.getId()).isGreaterThan(0);
		assertThat(savedStudent2.getId()).isGreaterThan(0);
		assertThat(savedStudent3.getId()).isGreaterThan(0);
		
	}
	
	@Test
	void testGetStudentById() {
		
		Student student = new Student("Student 1", new Passport(RandomStringUtils.random(10, true, true)));
		
		Student savedStudent = studentDao.saveStudent(student);
		
		Student fetchedStudent = studentDao.getStudentById(savedStudent.getId());
		
		System.out.println(fetchedStudent);

		assertThat(fetchedStudent.getId()).isEqualByComparingTo(savedStudent.getId());
	}



}
