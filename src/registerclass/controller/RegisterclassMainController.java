package registerclass.controller;

import model.Registerclass;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.RegisterclassDao;

@Controller
public class RegisterclassMainController {

	private RegisterclassDao registerclassDao;
	
	@RequestMapping("registerclass.do")
	public String form(@ModelAttribute Registerclass registerclassDto){
		
		
		System.out.println("name : " + registerclassDto.getSubjectname());
		System.out.println("num : " + registerclassDto.getSubjectnum());
		
		
		return "registerclass/main.jsp";
	}

	public RegisterclassDao getRegisterclassDao() {
		return registerclassDao;
	}

	public void setRegisterclassDao(RegisterclassDao registerclassDao) {
		this.registerclassDao = registerclassDao;
	}
	
	
}
