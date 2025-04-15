package com.krishsolution.repository;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.krishsolution.DTO.RegistrationDTO;
import com.krishsolution.entity.Course;
import com.krishsolution.entity.Instructor;
import com.krishsolution.entity.Lesson;
import com.krishsolution.entity.Registration;

@Repository
public class LmsDAOImpl implements LmsDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<Instructor> fetchInstructors() {

		Session session = sessionFactory.openSession();

		session.getTransaction().begin();
		// HQL query fire here for fetching instructor details...
		Query<Instructor> query = session.createQuery("from Instructor", Instructor.class);
		List<Instructor> listOfInstructors = query.list();
		// course make it lazy to eager
		listOfInstructors.forEach(instructor -> Hibernate.initialize(instructor.getCourses()));
		session.getTransaction().commit();
		session.close();
		return listOfInstructors;
	}

	@Override
	public void saveInstructor(Instructor instructor) {

		Session session = sessionFactory.openSession();

		session.getTransaction().begin();

		session.persist(instructor);
		System.out.println("new instructor into data base  with name of " + instructor.getName());
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<Instructor> findInstructorByName(String name) {
		Session session = sessionFactory.getCurrentSession();

		Query<Instructor> namedQuery = session.createNamedQuery("findInstructorByName", Instructor.class);

		List<Instructor> instructorsList = namedQuery.setParameter("instructorName", name + "%").list();

		// making from lazy to eager of fetch type...

		for (Instructor instructor : instructorsList) {

			Hibernate.initialize(instructor.getCourses());
		}

		return instructorsList;
	}

	@Override
	public void deleteInstructorById(int id) {

		Session session = sessionFactory.getCurrentSession();

		Instructor instructor = session.get(Instructor.class, id);

		session.remove(instructor);
	}

	@Override
	public List<Course> findCourses() {

		Session session = sessionFactory.getCurrentSession();
		List<Course> courses = session.createNamedQuery("findCourses", Course.class).list();
		return courses;
	}

	@Override
	public List<Course> findLessonsBycourseId(int courseId) {

		Session session = sessionFactory.getCurrentSession();

		List<Course> courses = session.createNamedQuery("findLessonByCourseId", Course.class)
				.setParameter("courseId", courseId).list();
		// making from lazy to eager fetch type
		courses.forEach(course -> Hibernate.initialize(course.getLessons()));

		return courses;
	}

	@Override
	public Lesson findLessonsById(int lessonId) {

		Session session = sessionFactory.getCurrentSession();

		List<Lesson> lesson = session.createNamedQuery("findLessonById", Lesson.class)
				.setParameter("LESSONID", lessonId).list();
		return lesson.get(0);
	}

	@Override
	public int saveCourse(Course course) {

		Session session = sessionFactory.getCurrentSession();
		int id = (int) session.save(course);

		return id;
	}

	@Override
	public void saveLesson(Lesson lesson) {

		Session session = sessionFactory.getCurrentSession();
		session.merge(lesson);
	}

	@Override
	public void deleteLesson(Lesson lesson) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.remove(lesson);
		
	}

	@Override
	public void saveRegistration(RegistrationDTO registrationDTO) {

		registrationDTO.setActive(true);
		registrationDTO.setRoles("user");
		Registration registration = modelMapper.map(registrationDTO, Registration.class);
		
		Session session = sessionFactory.getCurrentSession();
		
		session.persist(registration);
	}

}
