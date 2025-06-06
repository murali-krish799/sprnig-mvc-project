package com.krishsolution.service;

import java.util.List;

import com.krishsolution.DTO.RegistrationDTO;
import com.krishsolution.entity.Course;
import com.krishsolution.entity.Instructor;
import com.krishsolution.entity.Lesson;

public interface LmsService {
	public List<Instructor> fetchInstructors();
	public void saveInstructor(Instructor instructor);
	public List<Instructor> findInstructorByName(String name);
	public void deleteInstructorById(int id);
	public List<Course> findCourses();
	public List<Course> findLessonsBycourseId(int courseId);
	public Lesson findLessonsById(int lessonId);
	public int saveCourse(Course course);
	public void saveLesson(Lesson lesson);
	public void deleteLesson(Lesson lesson);
	public void saveRegistration(RegistrationDTO registrationDTO);

}
