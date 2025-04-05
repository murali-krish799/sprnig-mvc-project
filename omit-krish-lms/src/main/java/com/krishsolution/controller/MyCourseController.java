package com.krishsolution.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.krishsolution.DTO.LessonNextPreviousDTO;
import com.krishsolution.entity.Course;
import com.krishsolution.entity.Lesson;
import com.krishsolution.service.LmsService;

@Controller
@SessionAttributes("lesNextPreviousDTO")
public class MyCourseController {

	@Autowired
	private LmsService lmsService;
//	viewLessons?courseId=4

	@GetMapping("viewLessons")
	public String findlessonsByCourseId(@RequestParam("courseId") int courseId, Model model) {

		List<Course> course = lmsService.findLessonsBycourseId(courseId);

		model.addAttribute("course", course.get(0));

		int firstLessonId = course.get(0).getLessons().get(0).getId();

		int totalLessonsSize = course.get(0).getLessons().size();

//		formula for find's how many lessons from starting to ending

		int endLessonSize = (firstLessonId + totalLessonsSize) - 1;

		LessonNextPreviousDTO lesNextPreviousDTO = new LessonNextPreviousDTO();
		lesNextPreviousDTO.setFirstLesson(firstLessonId);
		lesNextPreviousDTO.setSecondLesson(endLessonSize);
		model.addAttribute("lesNextPreviousDTO", lesNextPreviousDTO);

		return "lessons-list";

	}

	@GetMapping("openLesson")
	public String openLessonByLessonId(@RequestParam("lessonId") int lessonId, Model model) {

		System.out.println("lesson id is :" + lessonId);

		Lesson lesson = lmsService.findLessonsById(lessonId);
		model.addAttribute("lesson", lesson);
		return "streaming-lesson";

	}
}
