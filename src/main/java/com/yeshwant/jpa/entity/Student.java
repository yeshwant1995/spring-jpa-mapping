package com.yeshwant.jpa.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(columnDefinition = "passport_id")
	private Passport passport;
	
	@ManyToMany(mappedBy = "students")
	private List<Course> courses = new ArrayList<Course>();
	

	@CreationTimestamp
	private LocalDateTime createdDateTime;

	@UpdateTimestamp
	private LocalDateTime lastUpdatedDateTime;

	public Student() {
	}

	public Student(String name, Passport passport) {
		this.name = name;
		this.passport = passport;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	
	

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(Course course) {
		this.courses.add(course);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", createdDateTime=" + createdDateTime
				+ ", lastUpdatedDateTime=" + lastUpdatedDateTime + "]";
	}

	

	

}
