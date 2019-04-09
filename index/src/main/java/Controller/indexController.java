package Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class indexController {
	
	@GetMapping("/")
	public String index(Model model) {
		
		
		return "index";
	}

}
