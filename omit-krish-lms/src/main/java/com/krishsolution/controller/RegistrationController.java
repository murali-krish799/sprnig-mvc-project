package com.krishsolution.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.krishsolution.DTO.RegistrationDTO;
import com.krishsolution.service.LmsService;

@Controller
public class RegistrationController {

	@Autowired
	private LmsService lmsService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/registration")
	public String registrationPage(@ModelAttribute("registrationDTO") RegistrationDTO registrationDTO) {

		return "registration-page";

	}

	@PostMapping("/registration-process")
	public String processRegistration(RegistrationDTO registrationDTO) {

		registrationDTO.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
		lmsService.saveRegistration(registrationDTO);

		return "redirect:/myLoginPage";

	}
}
