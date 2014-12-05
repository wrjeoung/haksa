package registerclass.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.RegisterForCoursesDao;
import dao.RegisterclassDao;

@Controller
public class SubmitController {

	private RegisterForCoursesDao registerForCoursesDao;
	private RegisterclassDao registerclassDao;
	
	@RequestMapping("registerSubmit.do")
	public String form(
			HttpServletRequest request){
		String subjectnum;
		String stnumber;
		
		subjectnum = request.getParameter("subjectnum");
		stnumber = request.getParameter("stnumber");
		System.out.println("subjectnum : " + subjectnum + "stnumber : " + stnumber);
		/*
		request.setAttribute("subjectnum", request.getParameter("subjectnum"));
		request.setAttribute("studentNumber", request.getParameter("studentNumber"));
		*/
		//registerclassDao.insertRegisterclass(request.getParameter("subjectnum"), request.getParameter("studentNumber"));
		registerForCoursesDao.insertRegisterclass(subjectnum, stnumber);
		registerclassDao.updateExtraNum(subjectnum);
		return "registerclass/submit.jsp";
	}

	public RegisterForCoursesDao getRegisterForCoursesDao() {
		return registerForCoursesDao;
	}

	public void setRegisterForCoursesDao(RegisterForCoursesDao registerForCoursesDao) {
		this.registerForCoursesDao = registerForCoursesDao;
	}

	public RegisterclassDao getRegisterclassDao() {
		return registerclassDao;
	}

	public void setRegisterclassDao(RegisterclassDao registerclassDao) {
		this.registerclassDao = registerclassDao;
	}
	
}
