package com.yeshwant.jpa.dao;

import com.yeshwant.jpa.entity.Course;
import com.yeshwant.jpa.entity.Review;

public interface ReviewDao {

	Review saveReview(Review review);
	
}
