package com.krishsolution.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "instructors")
@NamedQueries({

		@NamedQuery(name = "findInstructorByName", query = "from Instructor where name like :instructorName")

})
public class Instructor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "instructor_id")
	private int id;

	@Column(name = "instructor_name")
	private String name;

	@Column(name = "instructor_teaching_exp")
	private Double experience = 1.0;

	@Column(name = "instructor_gMail")
	private String gMail;

	@OneToMany(mappedBy = "instructor", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.REMOVE })
	private List<Course> courses;

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
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

	public Double getExperience() {
		return experience;
	}

	public void setExperience(Double experience) {
		this.experience = experience;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setExperience(double experience) {
		this.experience = experience;
	}

	public String getgMail() {
		return gMail;
	}

	public void setgMail(String gMail) {
		this.gMail = gMail;
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", name=" + name + ", experience=" + experience + ", gMail=" + gMail + "]";
	}

}
