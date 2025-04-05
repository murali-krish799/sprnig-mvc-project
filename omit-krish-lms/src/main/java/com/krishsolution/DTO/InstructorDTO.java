package com.krishsolution.DTO;

public class InstructorDTO {

	private int id;

	private String name;

	private double experience;

	private String gMail;

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

	public double getExperience() {
		return experience;
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
