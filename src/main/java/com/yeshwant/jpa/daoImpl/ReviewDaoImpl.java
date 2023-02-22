package com.yeshwant.jpa.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yeshwant.jpa.dao.ReviewDao;
import com.yeshwant.jpa.entity.Passport;
import com.yeshwant.jpa.entity.Review;
import com.yeshwant.jpa.repository.PassportRepository;
import com.yeshwant.jpa.repository.ReviewRepository;

@Repository
public class ReviewDaoImpl implements ReviewDao {

	@Autowired
	ReviewRepository reviewRepository;

	@Override
	public Review saveReview(Review review) {

		Review savedReview = reviewRepository.save(review);

		return savedReview;

	}

}
