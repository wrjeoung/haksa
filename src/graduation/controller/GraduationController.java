package graduation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import dao.GraduationDao;

@Controller
public class  GraduationController{
	private GraduationDao graduationDao;
	
	
	@RequestMapping("graduation.do")
	public String form() {
		
		return "/graduation/graduation.jsp";
		
	}


	public GraduationDao getGraduationDao() {
		return graduationDao;
	}


	public void setGraduationDao(GraduationDao graduationDao) {
		this.graduationDao = graduationDao;
	}
	
	
	
}
