package huhak.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Huhak;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.HuhakDao;

@Controller
public class InsertHuhakController {
	private HuhakDao huhakDao;
	Calendar today = Calendar.getInstance();
	@RequestMapping("/insertHuhakForm.do")
	public String form(HttpServletRequest request){
		List<Huhak> list=null;
		list=huhakDao.getHuhakList();
		
		request.setAttribute("list", list);
		System.out.println("1");
		return "/huhak/insertHuhakForm.jsp";
	}
	
	@RequestMapping("/insertHuhakPro.do")
	public ModelAndView formPro(@ModelAttribute Huhak huhak){
		System.out.println("2");
		huhak.setHuhak_reg_date(today.getTime());
		huhakDao.insertHuhak(huhak);
		
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("huhak",huhak);
		mv.setViewName("huhakList.do");
		return mv;
		
	}
	@RequestMapping("/huhakList.do")
	public String form1(HttpServletRequest request){
		System.out.println("3");
		List<Huhak> list=null;
		list=huhakDao.getHuhakList();
		
		request.setAttribute("list", list);
		return "/huhak/insertHuhakForm.jsp";
	}
	
	public HuhakDao getHuhakDao() {
		return huhakDao;
	}

	public void setHuhakDao(HuhakDao huhakDao) {
		this.huhakDao = huhakDao;
	}
	
	
}
