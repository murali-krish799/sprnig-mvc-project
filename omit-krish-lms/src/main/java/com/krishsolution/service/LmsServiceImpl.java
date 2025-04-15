package com.krishsolution.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.krishsolution.DTO.RegistrationDTO;
import com.krishsolution.entity.Course;
import com.krishsolution.entity.Instructor;
import com.krishsolution.entity.Lesson;
import com.krishsolution.repository.LmsDAO;

@Service
public class LmsServiceImpl implements LmsService {

	@Autowired
	private LmsDAO lmsDAO;

	@Override
	public List<Instructor> fetchInstructors() {

		return lmsDAO.fetchInstructors();
	}

	@Override
	@Transactional
	public void saveInstructor(Instructor instructor) {

		lmsDAO.saveInstructor(instructor);

	}

	@Override
	@Transactional
	public List<Instructor> findInstructorByName(String name) {
		return lmsDAO.findInstructorByName(name);
	}

	@Override
	@Transactional
	public void deleteInstructorById(int id) {
		lmsDAO.deleteInstructorById(id);
	}

	@Override
	public List<Course> findCourses() {
		
		
		return lmsDAO.findCourses();
	}

	@Override
	@Transactional
	public List<Course> findLessonsBycourseId(int courseId) {
		return lmsDAO.findLessonsBycourseId(courseId);
	}

	@Override
	@Transactional
	public Lesson findLessonsById(int lessonId) {
		
		
		return lmsDAO.findLessonsById(lessonId);
	}

	@Override
	@Transactional
	public int saveCourse(Course course) {

		return lmsDAO.saveCourse(course);
		
	}

	@Override
	@Transactional
	public void saveLesson(Lesson lesson) {
		
		lmsDAO.saveLesson(lesson);
	}

	@Override
	@Transactional
	public void deleteLesson(Lesson lesson) {

		lmsDAO.deleteLesson(lesson);
	}

	@Override
	@Transactional
	public void saveRegistration(RegistrationDTO registrationDTO) {
		
		lmsDAO.saveRegistration(registrationDTO);
	}

}
