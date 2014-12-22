package registerclass.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
			HttpServletRequest request,
			HttpSession session){
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
		List<String> list;
		list = registerclassDao.getSubjectNum((String)session.getAttribute("memId"));
		boolean chkDupli = false;
		
		for(String str : list) {
			if(str.equals(subjectnum)) {
				chkDupli = true;
			}
		}
		//System.out.println("SubmitController chkDupli : "+chkDupli);
		if(chkDupli == false)
		{	
			registerForCoursesDao.insertRegisterclass(subjectnum, stnumber);
			registerclassDao.updateExtraNum(subjectnum);
		}
		request.setAttribute("chkDupli", chkDupli);
		
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
