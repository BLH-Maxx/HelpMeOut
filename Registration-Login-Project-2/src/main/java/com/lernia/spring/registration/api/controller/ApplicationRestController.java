package com.lernia.spring.registration.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lernia.spring.registration.api.model.User;
import com.lernia.spring.registration.api.service.UserService;

@RestController
public class ApplicationRestController {
	

	@Autowired
	private UserService userService;

	@GetMapping("/saveuser")
	public String saveUser(@RequestParam int personalNumber, @RequestParam String userName,
			@RequestParam String firstName, @RequestParam String lastName, @RequestParam String address,
			@RequestParam String email, @RequestParam Long phone, @RequestParam String password) {
		User newUser = new User(personalNumber, userName, firstName, lastName, address, email, phone, password);
		userService.saveMyUser(newUser);
		System.out.println("Samer     " + newUser.getUserName());

		return "User has been saved";

	}
	
	@GetMapping("/getoneuser/{id}")
	public User findOneUser(@PathVariable int id) {
		//ModelAndView mav = new ModelAndView("userCenter/loginPage");
		//mav.addObject("id", id);
		//mav.setViewName("login");		
		return userService.getByID(id);

	}
	
	@GetMapping("/getoneuserbypersonalnumber/{id}")
	public User findOneUserByPersonalNumber(@PathVariable long id) {
		
		return userService.findBypersonalNumber(id);

	}
	
	
	@GetMapping("/getsaldo")
	public String getSaldo() {		
		return "{\"Version\": 1.0}";

	}
	
	@GetMapping("/getAuthName")
	public String getAuthName() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth.getName();

	}
	
	@GetMapping("/getAuthId")
	public int getAuthId() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByUserName(auth.getName());
		return user.getUser_id();

	}
	
	public class obteinUserSession {
		@RequestMapping(value = "/loginds", method = RequestMethod.GET)
		public String UserSession(ModelMap modelMap) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			System.out.println(auth.toString());
			String name = auth.getName();
			modelMap.addAttribute("username", name);
			return "hellos " + name;
		}
	}
	

}
