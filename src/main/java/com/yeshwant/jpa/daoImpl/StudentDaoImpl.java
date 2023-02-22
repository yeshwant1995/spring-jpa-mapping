package com.yeshwant.jpa.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yeshwant.jpa.dao.StudentDao;
import com.yeshwant.jpa.entity.Student;
import com.yeshwant.jpa.repository.StudentRepository;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public Student saveStudent(Student student) {

		Student savedStudent = studentRepository.save(student);

		return savedStudent;
	}

	@Override
	public Student getStudentById(Long id) {

		Student fetchedStudent = studentRepository.getReferenceById(id);

		return fetchedStudent;

	}

}
