package multijungong.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Multijungong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.MultijungongDao;

@Controller
public class InsertMultijungongController {
	private MultijungongDao multijungongDao;
	Calendar today=Calendar.getInstance();
	@RequestMapping("/insertmultijungongForm.do")
	public String form(HttpServletRequest request){
		List<Multijungong> list=null;
		list=multijungongDao.getMultijungongList();
		request.setAttribute("list", list);
		
		return "/multijungong/insertmultijungongForm.jsp";
	}
	
	@RequestMapping("/insertmultijungongPro.do")
	public ModelAndView formPro(@ModelAttribute Multijungong multijungong){
		multijungong.setMulti_reg_date(today.getTime());
		multijungongDao.insertMultijungong(multijungong);
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("multijungong", multijungong);
		mv.setViewName("redirect:/multijungongList.do");
		return mv;
	}
	@RequestMapping("/multijungongList.do")
	public String form1(HttpServletRequest request){
		List<Multijungong> list=null;
		list=multijungongDao.getMultijungongList();
		
		request.setAttribute("list", list);
		return "/multijungong/insertmultijungongForm.jsp";
	}
	
	public MultijungongDao getMultijungongDao() {
		return multijungongDao;
	}

	public void setMultijungongDao(MultijungongDao multijungongDao) {
		this.multijungongDao = multijungongDao;
	}
}
