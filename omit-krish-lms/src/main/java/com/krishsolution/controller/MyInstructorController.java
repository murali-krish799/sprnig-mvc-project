package com.krishsolution.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.krishsolution.entity.Instructor;
import com.krishsolution.service.LmsService;

@Controller
public class MyInstructorController {
//new changes has been done here
	@Autowired
	private LmsService lmsService;

	@GetMapping("/instructors")
	public String myInstructors(Model model) {

		List<Instructor> fetchInstructors = lmsService.fetchInstructors();

//		List<Course> courses = lmsService.findCourses();
		model.addAttribute("listOfInstructors", fetchInstructors);
		model.addAttribute("instructorDTO", new Instructor());
//		model.addAttribute("courses", courses);

		return "instructor";
	}

	@GetMapping("/show-instructor-page")
	public String showInstructorPage(@ModelAttribute("instructor") Instructor instructor) {

		return "instructor_page";

	}

	@PostMapping("/save-instructor")
	public String saveInstructor(Instructor instructor) {
		System.out.println("instructor details from UI :" + instructor);

		lmsService.saveInstructor(instructor);

		return "redirect:/instructors";

	}

	@PostMapping("/findName")
	public String findStructorByName(@RequestParam("name") String name, Model model) {

		List<Instructor> instructorByName = lmsService.findInstructorByName(name);

		model.addAttribute("listOfInstructors", instructorByName);
		model.addAttribute("instructorDTO", new Instructor());
		return "instructor";
	}

	@GetMapping("/deleteinstructorById")
	public String deleteInstructorById(@RequestParam("id") int id) {

		lmsService.deleteInstructorById(id);

		return "redirect:/instructors";
	}
}
