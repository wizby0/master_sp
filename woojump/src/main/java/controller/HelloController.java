package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RestController
public class HelloController {

	@RequestMapping("/hello")
	@ResponseBody
	public String hello(Model model) {
		model.addAttribute("name","woozu hello");
		
		return "hello";
	}
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("name","woozu index");
		
		return "testView";
	}

}
