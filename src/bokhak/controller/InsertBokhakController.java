package bokhak.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Bokhak;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.BokhakDao;

@Controller
public class InsertBokhakController {
	private BokhakDao bokhakDao;
	Calendar today=Calendar.getInstance();
	
	@RequestMapping("/insertBokhakForm.do")
	public String form(HttpServletRequest request){
		List<Bokhak> list=null;
		list=bokhakDao.getBokhakList();
		
		request.setAttribute("list", list);
		return "/bokhak/insertBokhakForm.jsp";
	}
	
	@RequestMapping("/insertBokhakPro.do")
	public ModelAndView formPro(@ModelAttribute Bokhak bokhak){
		bokhak.setBokhak_reg_date(today.getTime());
		bokhakDao.insertBokhak(bokhak);
		ModelAndView mv=new ModelAndView();
		mv.addObject("bokhak", bokhak);
		mv.setViewName("redirect:/bokhakList.do");
		return mv;
	}
	@RequestMapping("/bokhakList.do")
	public String form1(HttpServletRequest request){
		List<Bokhak> list=null;
		list=bokhakDao.getBokhakList();
		request.setAttribute("list", list);
		
		return "/bokhak/insertBokhakForm.jsp";
	}
	
	public BokhakDao getBokhakDao() {
		return bokhakDao;
	}
	public void setBokhakDao(BokhakDao bokhakDao) {
		this.bokhakDao = bokhakDao;
	}
}
