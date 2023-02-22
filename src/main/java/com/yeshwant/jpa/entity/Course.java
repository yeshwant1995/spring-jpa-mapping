package com.yeshwant.jpa.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Review> reviews = new ArrayList<Review>();

	private String name;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "course_student",
			   joinColumns = {@JoinColumn(name = "course_id")},
			   inverseJoinColumns = {@JoinColumn(name = "student_id")})
	private List<Student> students = new ArrayList<Student>();

	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private LocalDateTime createdDateTime;

	@UpdateTimestamp
	private LocalDateTime lastUpdatedDateTime;

	protected Course() {
	}

	public Course(String name) {
		this.name = name;
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

	public List<Review> getReviews() {
		return reviews;
	}

	public void addReviews(Review review) {
		this.reviews.add(review);
	}

	public void removeReviews(Review review) {
		this.reviews.remove(review);
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(Student student) {
		this.students.add(student);
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", createdDateTime=" + createdDateTime + ", lastUpdatedDateTime="
				+ lastUpdatedDateTime + "]";
	}

}
