package registerclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterclassMainController {

	@RequestMapping("registerclass.do")
	public String form(){
		return "registerclass/main.jsp";
	}
}
