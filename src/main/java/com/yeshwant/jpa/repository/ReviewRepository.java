package com.yeshwant.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yeshwant.jpa.entity.Review;


public interface ReviewRepository extends JpaRepository<Review, Long> {

}
