package janghak.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InsertJanghakController {
	
	@RequestMapping("/insertJanghakForm.do")
	public String form(){
		return "/janghak/insertJanghakForm.jsp";
		
	}
}
