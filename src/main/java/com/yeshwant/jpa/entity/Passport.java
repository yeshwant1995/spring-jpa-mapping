package com.yeshwant.jpa.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Passport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String number;

	@OneToOne(mappedBy = "passport")
	private Student student;

	@CreationTimestamp
	private LocalDateTime createdDateTime;

	@UpdateTimestamp
	private LocalDateTime lastUpdatedDateTime;

	public Passport() {
	}

	public Passport(String number) {
		this.number = number;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public LocalDateTime getLastUpdatedDateTime() {
		return lastUpdatedDateTime;
	}

	public void setLastUpdatedDateTime(LocalDateTime lastUpdatedDateTime) {
		this.lastUpdatedDateTime = lastUpdatedDateTime;
	}

	@Override
	public String toString() {
		return "Passport [id=" + id + ", number=" + number + ", student=" + student + ", createdDateTime="
				+ createdDateTime + ", lastUpdatedDateTime=" + lastUpdatedDateTime + "]";
	}

}
