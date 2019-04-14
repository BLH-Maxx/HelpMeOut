package com.lernia.spring.registration.api.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lernia.spring.registration.api.model.User;
import com.lernia.spring.registration.api.service.UserService;

@Controller
public class ApplicationController {

	@Bean
	public BCryptPasswordEncoder encoderPWD() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	UserService userService;

	@RequestMapping("/welcome")
	public String welcom(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
	}

	@RequestMapping("/register")
	public String registration(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_REGISTER");
		return "/register";
	}

	@PostMapping("/save-user")
	public String registerUser(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Samer " + user.toString());

		Map<String, String> messages = new HashMap<String, String>();
		request.setAttribute("messages", messages);
		User userExist = userService.findBypersonalNumber(user.getPersonalNumber());
		Boolean isExist = (userExist != null);
		if (isExist) {
			messages.put("AlreadyExist", "This user is already exist, try again with new input data.");
			System.out.println(messages);
			request.setAttribute("samer", messages);
			request.setAttribute("isExist", isExist);
			request.getRequestDispatcher("/register").forward(request, response);

			return "/register";
		}
		userService.saveMyUser(user);
		request.setAttribute("mode", "MODE_HOME");
		return "login";
	}

	@RequestMapping("/edit-user")
	public String editUser(@RequestParam int id, HttpServletRequest request) {
		request.setAttribute("user", userService.editUser(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "welcomepage";
	}

	@PostMapping("/update-user")
	public String updateUser(@ModelAttribute User user, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Samer " + user.toString());
		Map<String, String> messages = new HashMap<String, String>();
		messages.put("Updated", "This user has been uodated.");
		request.setAttribute("messages", messages);
		User userFromDatabase = userService.findByUserName(user.getUserName());

		if (user.getPersonalNumber() == userFromDatabase.getPersonalNumber()) {
			user.setActive(userFromDatabase.getActive());
			user.setRating(userFromDatabase.getRating());
			user.setRoles(userFromDatabase.getRoles());
			userService.updateMyUser(user);
			return "login";

		} else {
			messages.put("NotFound", "This user can't be updated.");
			request.setAttribute("mode", "MODE_UPDATE");
			return "welcomepage";

		}

	}

	@GetMapping("/show-users")
	public String showAllUsers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("users", userService.showAllUsers());
		System.out.println(userService.showAllUsers());
		// request.getRequestDispatcher("/allusers").forward(request, response);
		return "allusers";
	}

	@GetMapping("/delete-user")
	public String deleteUser(@RequestParam int id, HttpServletRequest request) {
		userService.deleteTheUser(id);
		request.setAttribute("users", userService.showAllUsers());
		return "allusers";
	}

	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_LOGIN");
		return "/login";
	}

	@RequestMapping("/login-user")
	public String loginUser(@ModelAttribute User user, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, String> messages = new HashMap<String, String>();
		request.setAttribute("messages", messages);
		User userFromDatabase = userService.findByUserName(user.getUserName());

		if (userFromDatabase == null) {
			Boolean isExist = false;
			request.setAttribute("isExist", isExist);
			request.setAttribute("messages", messages);
			messages.put("UserNotFound", "There is no account with these information");
			request.setAttribute("messages", messages);
			System.out.println(messages);
			request.getRequestDispatcher("/login").forward(request, response);
			return "login";

		}

		if (encoderPWD().matches(user.getPassword(), userFromDatabase.getPassword())) {
			Boolean isExist = true;
			messages.put("Approved", "Welcome - You will be forwarded to your dashboard");
			request.setAttribute("isExist", isExist);
			request.setAttribute("messages", messages);
			System.out.println("samer" + request.getContextPath());
			System.out.println(messages);
			// request.getRequestDispatcher("/webapp/WEB-INF/view/dashboard").forward(request,
			// response);
			return "dashboard";
		} else {
			Boolean BadCredentials = true;
			messages.put("BadCredentials", "Invalid Username or Password");
			request.setAttribute("messages", messages);
			request.setAttribute("BadCredentials", BadCredentials);
			System.out.println(messages);
			request.getRequestDispatcher("/login").forward(request, response);
			return "login";
		}
	}
}
