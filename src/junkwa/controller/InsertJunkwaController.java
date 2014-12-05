package junkwa.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Junkwa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.JunkwaDao;

@Controller
public class InsertJunkwaController {
	private JunkwaDao junkwaDao;
	Calendar today=Calendar.getInstance();
	
	@RequestMapping("/insertJunkwaForm.do")
	public String form(HttpServletRequest request){
		List<Junkwa> list=null;
		list=junkwaDao.getJunkwaList();
		request.setAttribute("list", list);
		
		return "/junkwa/insertJunkwaForm.jsp";
	}
	
	@RequestMapping("/insertJunkwaPro.do")
	public ModelAndView formPro(@ModelAttribute Junkwa junkwa){
		
		
		junkwa.setJunkwa_reg_date(today.getTime());
		junkwaDao.insertJunkwa(junkwa);
		
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("junkwa", junkwa);
		mv.setViewName("redirect:/junkwaList.do");
		return mv;
	}
	@RequestMapping("/junkwaList.do")
	public String form1(HttpServletRequest request){
		List<Junkwa> list=null;
		list=junkwaDao.getJunkwaList();
		request.setAttribute("list", list);
		return "/junkwa/insertJunkwaForm.jsp";
	}
	public JunkwaDao getJunkwaDao() {
		return junkwaDao;
	}

	public void setJunkwaDao(JunkwaDao junkwaDao) {
		this.junkwaDao = junkwaDao;
	}
	
	
}

