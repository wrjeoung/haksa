package registerclass.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.RegisterForCoursesDao;

@Controller
public class RegisterCancleProController {

	private RegisterForCoursesDao registerForCoursesDao;
	
	@RequestMapping("registerCanclePro.do")
	public String form(
			HttpServletRequest request){
		String subjectnum;
		String stnumber;
		
		subjectnum = request.getParameter("subjectnum");
		stnumber = request.getParameter("stnumber");
		System.out.println("subjectnum : " + subjectnum + "stnumber : " + stnumber);
		
		registerForCoursesDao.deleteRegisterclass(subjectnum, stnumber);
		
		return "registerclass/registerCanclePro.jsp";
	}

	public RegisterForCoursesDao getRegisterForCoursesDao() {
		return registerForCoursesDao;
	}

	public void setRegisterForCoursesDao(RegisterForCoursesDao registerForCoursesDao) {
		this.registerForCoursesDao = registerForCoursesDao;
	}
	
	
}
