package com.yeshwant.jpa.dao;

import com.yeshwant.jpa.entity.Passport;

public interface PassportDao {
	
	Passport savePassport(Passport passport);
	
	Passport getPassportById(Long id);

}
