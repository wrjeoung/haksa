package admin.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Bokhak;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;



import org.springframework.web.servlet.ModelAndView;

import dao.AdminBokhakDao;

@Controller
public class AdminBokhakController {
	private AdminBokhakDao adminBokhakDao;
	Calendar today=Calendar.getInstance();
	
	@RequestMapping("/adminbokhakList.do")
	public String form1(HttpServletRequest request){
		List<Bokhak> list=null;
		list=adminBokhakDao.getAdminBokhakList();
		request.setAttribute("list", list);
		
		return "/adminbokhak/adminBokhakForm.jsp";
	}
	@RequestMapping("adminbokhakUpdateCom.do")
	public String UpdateCom(HttpServletRequest request){
		String[] rnum=request.getParameterValues("rnum");
		
		String stnumber=request.getParameter("stnumber");
		String name=request.getParameter("name");
		for(int i=0;i<rnum.length;i++){
			String value=rnum[i];
			adminBokhakDao.updatecomAdminBokhak(value);
			adminBokhakDao.updateBokhakMember(name);
		}
		return "redirect:/adminbokhakList.do";
	}
	@RequestMapping("adminbokhakUpdateCan.do")
	public String UpdateCan(HttpServletRequest request){
		String[] rnum=request.getParameterValues("rnum");
		
		String stnumber=request.getParameter("stnumber");
		String name=request.getParameter("name");
		for(int i=0;i<rnum.length;i++){
			String value=rnum[i];
			adminBokhakDao.updatecanAdminBokhak(value);
			adminBokhakDao.updateBokhakMember2(name);
		}
		return "redirect:/adminbokhakList.do";
	}
	//삭제
	@RequestMapping("adminbokhakDelete.do")
	public String Delete(HttpServletRequest request){
		String[] rnum=request.getParameterValues("rnum");
		for(int i=0;i<rnum.length;i++){
			String value=rnum[i];
			adminBokhakDao.deleteAdminBokhak(value);
		}
		return "redirect:/adminbokhakList.do";
	}
	//수정
	@RequestMapping("adminbokhakinfomodify.do")
	public String infoModify(HttpServletRequest request){
		int num=Integer.parseInt(request.getParameter("num"));
		Bokhak bokhak;
		bokhak=adminBokhakDao.getAdminBokhak(num);
		request.setAttribute("bokhak", bokhak);
		return "/adminbokhak/adminBokhakModify.jsp";
	}
	@RequestMapping("adminbokhakinfoPro.do")
	public ModelAndView Modify(@ModelAttribute Bokhak bokhak,HttpServletRequest request){
		bokhak.setBokhak_reg_date(today.getTime());
		adminBokhakDao.changeAdminBokhak(bokhak);
		ModelAndView mv=new ModelAndView();
		mv.addObject("bokhak",bokhak);
		mv.setViewName("redirect:/adminbokhakList.do");
		return mv;
	}
	
	public AdminBokhakDao getAdminBokhakDao() {
		return adminBokhakDao;
	}

	public void setAdminBokhakDao(AdminBokhakDao adminBokhakDao) {
		this.adminBokhakDao = adminBokhakDao;
	}

	public Calendar getToday() {
		return today;
	}

	public void setToday(Calendar today) {
		this.today = today;
	}
	
}
