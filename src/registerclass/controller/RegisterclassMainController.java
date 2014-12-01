package registerclass.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Registerclass;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.RegisterclassDao;

@Controller
public class RegisterclassMainController {

	private RegisterclassDao registerclassDao;
	
	@RequestMapping("registerclass.do")
	public String form(HttpServletRequest request){
		List<Registerclass> list = null;
		HashMap params = new HashMap();
		int totalCount;
		
		params.put("major", "영어학과");
		params.put("grade", "1");
		
		list = registerclassDao.getRegisterclassList(params);
		totalCount = list.size();
		
		System.out.println("totalCount : " + totalCount);
		
		for(Object a : list)
		{
			System.out.println(((Registerclass)a).getSubjectnum());
		}
		
		request.setAttribute("list", list);
		return "registerclass/main.jsp";
		
	}

	public RegisterclassDao getRegisterclassDao() {
		return registerclassDao;
	}

	public void setRegisterclassDao(RegisterclassDao registerclassDao) {
		this.registerclassDao = registerclassDao;
	}
	
	
	/*
	@RequestMapping("registerclass.do")
	public String form(@ModelAttribute Registerclass registerclassDto){
		
		
		System.out.println("name : " + registerclassDto.getSubjectname());
		System.out.println("num : " + registerclassDto.getSubjectnum());
		
		
		return "registerclass/main.jsp";
	}
	*/

	
}
