package com.krishsolution.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.krishsolution.DTO.LessonNextPreviousDTO;
import com.krishsolution.entity.Course;
import com.krishsolution.entity.Instructor;
import com.krishsolution.entity.Lesson;
import com.krishsolution.service.LmsService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@SessionAttributes({ "lesNextPreviousDTO" })
public class MyCourseController {
	@Autowired
	private LmsService lmsService;
//	viewLessons?courseId=4

	@GetMapping("viewLessons")
	public String findlessonsByCourseId(@RequestParam(name = "courseId", required = false) Integer courseId,
			@RequestParam(name = "pageNo", required = false) String pageNo, Model model, HttpServletRequest request) {
		LessonNextPreviousDTO lesNextPreviousDTO = new LessonNextPreviousDTO();
		// here implementing pagination
		PagedListHolder<Lesson> pagedListHolder = new PagedListHolder<>();
		List<Course> course = null;

		if (pageNo == null) {
			course = lmsService.findLessonsBycourseId(courseId);
			pagedListHolder.setSource(course.get(0).getLessons());
			pagedListHolder.setPageSize(2);
			pagedListHolder.setPage(0);
			System.out.println(pagedListHolder.getPageCount());
			request.getSession().setAttribute("pagedListHolder", pagedListHolder);
			request.getSession().setAttribute("course", course);

		} else if (pageNo.equals("prev")) {
			pagedListHolder = (PagedListHolder<Lesson>) request.getSession().getAttribute("pagedListHolder");
			pagedListHolder.previousPage();
			course = (List<Course>) request.getSession().getAttribute("course");

		} else if (pageNo.equals("next")) {
			pagedListHolder = (PagedListHolder<Lesson>) request.getSession().getAttribute("pagedListHolder");
			pagedListHolder.nextPage();
			course = (List<Course>) request.getSession().getAttribute("course");

		} else {

			pagedListHolder = (PagedListHolder<Lesson>) request.getSession().getAttribute("pagedListHolder");
			pagedListHolder.setPage(Integer.valueOf(pageNo));
			course = (List<Course>) request.getSession().getAttribute("course");

		}

		if (!course.get(0).getLessons().isEmpty()) {
			int firstLessonId = course.get(0).getLessons().get(0).getId();

			int totalLessonsSize = course.get(0).getLessons().size();

//		formula for find's how many lessons from starting to ending

			int endLessonSize = (firstLessonId + totalLessonsSize) - 1;
			lesNextPreviousDTO.setFirstLesson(firstLessonId);
			lesNextPreviousDTO.setSecondLesson(endLessonSize);
		}
		model.addAttribute("course", course.get(0));
		model.addAttribute("lesNextPreviousDTO", lesNextPreviousDTO);
		model.addAttribute("pagedListHolder", pagedListHolder);
		return "lessons-list";

	}

//	http://localhost:8080/omit-krish-lms/showAddLessonPage?courseId=8

	@GetMapping("showAddLessonPage")
	public String showAddLessonPage(@RequestParam(name = "courseId", required = false) Integer courseId,
			@RequestParam(name = "lessonId", required = false) Integer lessonId, Model model) {

		List<Course> courses = lmsService.findLessonsBycourseId(courseId);
		Lesson lesson = null;
		// always fetching single course data through find by id
		Course course = courses.get(0);
		if (lessonId != null) {
			Lesson returnLesson = lmsService.findLessonsById(lessonId);
			lesson = returnLesson;
		} else {

			lesson = new Lesson();
		}

		lesson.setCourse(course);
		model.addAttribute("lesson", lesson);
		return "showLessonAddPage";

	}

	@PostMapping("saveLesson")
	public String saveLesson(Lesson lesson, Model model) {

		System.out.println("lesson date cooming from front end(UI) : " + lesson);

		lmsService.saveLesson(lesson);
		return "redirect:/viewLessons?courseId=" + lesson.getCourse().getId();

	}

//	deleteLesson?lessonId=${lesson.id}
	@GetMapping("deleteLesson")
	public String deleteLesson(@RequestParam("lessonId") int lessonId) {
		Lesson lesson = lmsService.findLessonsById(lessonId);
		int courseId = lesson.getCourse().getId();
		lesson.setCourse(null);
		lmsService.deleteLesson(lesson);

		return "redirect:/viewLessons?courseId=" + courseId;

	}

	@GetMapping("openLesson")
	public String openLessonByLessonId(@RequestParam("lessonId") int lessonId, Model model) {

		System.out.println("lesson id is :" + lessonId);

		Lesson lesson = lmsService.findLessonsById(lessonId);
		model.addAttribute("lesson", lesson);
		return "streaming-lesson";

	}

	@GetMapping("showAddCoursePage")
	public String showAddCoursePage(Course course, Model model) {

		List<Instructor> instructors = lmsService.fetchInstructors();
		model.addAttribute("course", course);
		model.addAttribute("instructors", instructors);

		return "showCoursePage";

	}

	@PostMapping("addCourse")
	public String addCourse(Course course) {

		System.out.println("course details :" + course.getInstructor());
		int courseId = lmsService.saveCourse(course);

		return "redirect:/viewLessons?courseId=" + courseId;

	}
}
