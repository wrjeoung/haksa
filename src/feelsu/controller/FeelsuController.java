package feelsu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class  FeelsuController{
	
	@RequestMapping("feelsu.do")
	public String form() {
		
		return "/feelsu/feelsu.jsp";
		
	}
}
