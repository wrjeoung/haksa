package janghak.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Janghak;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.JanghakDao;

@Controller
public class InsertJanghakController {
	private JanghakDao janghakDao;
	Calendar today=Calendar.getInstance();
	
	@RequestMapping("/insertJanghakForm.do")
	public String form(HttpServletRequest request){
		List<Janghak> list=null;
		list=janghakDao.getJanghakList();
		request.setAttribute("list", list);
		
		return "/janghak/insertJanghakForm.jsp";
		
	}

	@RequestMapping("/insertJanghakPro.do")
	public ModelAndView formPro(@ModelAttribute Janghak janghak){
		janghak.setJanghak_reg_date(today.getTime());
		janghakDao.insertJanghak(janghak);
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("janghak", janghak);
		mv.setViewName("redirect:/janghakList.do");
		return mv;
	}
	@RequestMapping("/janghakList.do")
	public String form1(HttpServletRequest request){
		List<Janghak> list=null;
		list=janghakDao.getJanghakList();
		request.setAttribute("list", list);
		return "/janghak/insertJanghakForm.jsp";
	}
	public JanghakDao getJanghakDao() {
		return janghakDao;
	}

	public void setJanghakDao(JanghakDao janghakDao) {
		this.janghakDao = janghakDao;
	}
}
