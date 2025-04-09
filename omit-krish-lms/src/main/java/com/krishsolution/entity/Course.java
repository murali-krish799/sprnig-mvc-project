package com.krishsolution.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "courses")
@NamedQueries({ @NamedQuery(name = "findCourses", query = "from Course"),

		@NamedQuery(name = "findLessonByCourseId", query = "select c from Course c where c.id=:courseId")

})
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_id")
	private int id;

	@Column(name = "course_name")
	private String name;

	@Column(name = "course_duration")
	private String duration;

	@ManyToOne
	@JoinColumn(name = "instructor_id", referencedColumnName = "instructor_id")
	private Instructor instructor;

	@OneToMany(mappedBy = "course",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Lesson> lessons;

	public List<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", duration=" + duration + "]";
	}

}
