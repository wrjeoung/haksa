package hakgi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HakgiController {
	
	@RequestMapping("hakgi.do")
	public String form() {
		
		return "/hakgisung/hakgi.jsp";
		
	}
}
