package com.yeshwant.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yeshwant.jpa.dao.PassportDao;
import com.yeshwant.jpa.entity.Passport;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
public class PassportTests {
	
	@Autowired
	PassportDao passportDao;
	
	@Test
	void testSavePassport() {
	
		Passport passport1 = new Passport(RandomStringUtils.random(10, true, true));
		Passport passport2 = new Passport(RandomStringUtils.random(10, true, true));
		Passport passport3 = new Passport(RandomStringUtils.random(10, true, true));
		
		Passport savedPassport1 = passportDao.savePassport(passport1);
		Passport savedPassport2 = passportDao.savePassport(passport2);
		Passport savedPassport3 = passportDao.savePassport(passport3);
		
		System.out.println(savedPassport1);
		System.out.println(savedPassport2);
		System.out.println(savedPassport3);
	
		assertThat(savedPassport1.getId()).isGreaterThan(0);
		assertThat(savedPassport2.getId()).isGreaterThan(0);
		assertThat(savedPassport3.getId()).isGreaterThan(0);
	
	}
	
	@Test
	void testGetPassport() {
		
		Passport fetchedPassport = passportDao.getPassportById(7L);
		
		System.out.println(fetchedPassport.getStudent().getId());
		
		assertThat(fetchedPassport.getId()).isGreaterThan(0);
	}

}
