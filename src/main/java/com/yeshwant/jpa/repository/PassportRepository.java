package com.yeshwant.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yeshwant.jpa.entity.Course;
import com.yeshwant.jpa.entity.Passport;


public interface PassportRepository extends JpaRepository<Passport, Long> {

}
