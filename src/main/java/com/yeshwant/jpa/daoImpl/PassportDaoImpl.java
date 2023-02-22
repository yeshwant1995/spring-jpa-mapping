package com.yeshwant.jpa.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yeshwant.jpa.dao.PassportDao;
import com.yeshwant.jpa.dao.StudentDao;
import com.yeshwant.jpa.entity.Passport;
import com.yeshwant.jpa.entity.Student;
import com.yeshwant.jpa.repository.PassportRepository;
import com.yeshwant.jpa.repository.StudentRepository;

@Repository
public class PassportDaoImpl implements PassportDao {

	@Autowired
	PassportRepository passportRepository;

	@Override
	public Passport savePassport(Passport passport) {

		Passport savedPassport = passportRepository.save(passport);
		return savedPassport;
	}

	@Override
	public Passport getPassportById(Long id) {

		Passport fetchedPassport = passportRepository.getReferenceById(id);

		return fetchedPassport;

	}

}
