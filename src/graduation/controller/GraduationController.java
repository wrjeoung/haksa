package graduation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class  GraduationController{
	
	@RequestMapping("graduation.do")
	public String form() {
		
		return "/graduation/graduation.jsp";
		
	}
}
