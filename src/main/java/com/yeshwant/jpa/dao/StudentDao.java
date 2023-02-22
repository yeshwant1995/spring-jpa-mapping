package com.yeshwant.jpa.dao;

import com.yeshwant.jpa.entity.Student;

public interface StudentDao {
	
	Student saveStudent(Student student);
	
	Student getStudentById(Long id);

}
