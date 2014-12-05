package registerclass.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.RegisterForCoursesDao;



@Controller
public class SubmitController {

	private RegisterForCoursesDao registerForCoursesDao;
	
	@RequestMapping("registerSubmit.do")
	public String form(
			HttpServletRequest request){
		String subjectnum;
		String stnumber;
		
		subjectnum = request.getParameter("subjectnum");
		stnumber = request.getParameter("stnumber");
		System.out.println("subjectnum : " + subjectnum);
		System.out.println("stnumber : " + stnumber);
		/*
		request.setAttribute("subjectnum", request.getParameter("subjectnum"));
		request.setAttribute("studentNumber", request.getParameter("studentNumber"));
		*/
		//registerclassDao.insertRegisterclass(request.getParameter("subjectnum"), request.getParameter("studentNumber"));
		registerForCoursesDao.insertRegisterclass(subjectnum, stnumber);
		return "registerclass/submit.jsp";
	}

	public RegisterForCoursesDao getRegisterForCoursesDao() {
		return registerForCoursesDao;
	}

	public void setRegisterForCoursesDao(RegisterForCoursesDao registerForCoursesDao) {
		this.registerForCoursesDao = registerForCoursesDao;
	}

	
}
