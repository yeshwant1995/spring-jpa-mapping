package com.yeshwant.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yeshwant.jpa.dao.CourseDao;
import com.yeshwant.jpa.dao.ReviewDao;
import com.yeshwant.jpa.entity.Course;
import com.yeshwant.jpa.entity.Review;

@SpringBootTest
public class ReviewTests {
	
	@Autowired
	ReviewDao reviewDao;
	
	
	@Test
	void testSaveReview() {
		
		Review review1 = new Review("1", "Good");
		Review review2 = new Review("2", "Bad");
		Review review3 = new Review("3", "Great");
		Review review4 = new Review("2", null);
		Review review5 = new Review("5", "Excellent");
		
		Review savedReview1 = reviewDao.saveReview(review1);
		Review savedReview2 = reviewDao.saveReview(review2);
		Review savedReview3 = reviewDao.saveReview(review3);
		Review savedReview4 = reviewDao.saveReview(review4);
		Review savedReview5 = reviewDao.saveReview(review5);
		
		System.out.println(savedReview1);
		System.out.println(savedReview2);
		System.out.println(savedReview3);
		System.out.println(savedReview4);
		System.out.println(savedReview5);
		
		assertThat(savedReview1.getId()).isGreaterThan(0);
		assertThat(savedReview2.getId()).isGreaterThan(0);
		assertThat(savedReview3.getId()).isGreaterThan(0);
		assertThat(savedReview4.getId()).isGreaterThan(0);
		assertThat(savedReview5.getId()).isGreaterThan(0);
	}
	


}
