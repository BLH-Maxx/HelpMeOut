package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class indexController {
	
	@Autowired
	private Environment environment;
	
	
	@GetMapping("/")
	public String index(Model model) {
		
		
		model.addAttribute("port", environment.getProperty("local.server.port"));
		
		System.out.println(environment.getProperty("local.server.port"));
		return "index";
	}


}
