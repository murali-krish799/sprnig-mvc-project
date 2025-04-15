package com.krishsolution.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MySecurityController {

	@GetMapping("/myLoginPage")
	public String loginPage() {
		System.out.println("Login page hit!");

		return "loginPage";
	}
	@GetMapping("/mylogout")
	public String logoutPage() {
		System.out.println("logot constructor!");

		return "logoutpage";
	}

}
