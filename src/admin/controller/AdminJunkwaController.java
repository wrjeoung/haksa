package admin.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Junkwa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.AdminJunkwaDao;
import dao.JunkwaDao;

@Controller
public class AdminJunkwaController {
	private AdminJunkwaDao adminJunkwaDao;
	Calendar today=Calendar.getInstance();
	
	@RequestMapping("/adminjunkwaList.do")
	public String form1(HttpServletRequest request){
		List<Junkwa> list=null;
		list=adminJunkwaDao.getAdminJunkwaList();
		request.setAttribute("list", list);
		
		return "/adminjunkwa/adminJunkwaForm.jsp";
	}
	@RequestMapping("adminjunkwaUpdateCom.do")
	public String UpdateCom(HttpServletRequest request){
		String[] rnum=request.getParameterValues("rnum");
		
		String junkwahakkwa=request.getParameter("junkwahakkwa");
		String name=request.getParameter("name");
		
		for(int i=0;i<rnum.length;i++){
			String value=rnum[i];
			
			adminJunkwaDao.updatecomAdminJunkwa(value);
			adminJunkwaDao.updateAdminJunkwaMember(junkwahakkwa, name);
		}
		return "redirect:/adminjunkwaList.do"; 
	}
	@RequestMapping("adminjunkwaUpdateCan.do")
	public String UpdateCan(HttpServletRequest request){
		String[] rnum=request.getParameterValues("rnum");
		for(int i=0;i<rnum.length;i++){
			String value=rnum[i];
			adminJunkwaDao.updatecanAdminJunkwa(value);
		}
		return "redirect:/adminjunkwaList.do";
	}
	//삭제
	@RequestMapping("adminjunkwaDelete.do")
	public String Delete(HttpServletRequest request){
		String[] rnum=request.getParameterValues("rnum");
		for(int i=0;i<rnum.length;i++){
			String value=rnum[i];
			adminJunkwaDao.deleteAdminJunkwa(value);
		}
		return "redirect:/adminjunkwaList.do";
	}
	//상세보기
	@RequestMapping("adminjunkwaView.do")
	public String View(HttpServletRequest request){
		int num=Integer.parseInt(request.getParameter("num"));
		Junkwa junkwa=adminJunkwaDao.getAdminJunkwa(num);
		request.setAttribute("junkwa", junkwa);
		
		return "/adminjunkwa/adminJunkwaViewForm.jsp";
	}
	@RequestMapping("adminjunkwainfomodify.do")
	public String infoModify(HttpServletRequest request){
		int num=Integer.parseInt(request.getParameter("num"));
		Junkwa junkwa;
		junkwa=adminJunkwaDao.getAdminJunkwa(num);
		request.setAttribute("junkwa", junkwa);
		return "/adminjunkwa/adminJunkwaModifyForm.jsp";
	}
	@RequestMapping("adminjunkwainfoPro.do")
	public ModelAndView Modify(@ModelAttribute Junkwa junkwa,HttpServletRequest request){
		junkwa.setJunkwa_reg_date(today.getTime());
		adminJunkwaDao.changeAdminJunkwa(junkwa);
		ModelAndView mv=new ModelAndView();
		mv.addObject("junkwa",junkwa);
		mv.setViewName("redirect:/adminjunkwaList.do");
		return mv;
	}
	
	public AdminJunkwaDao getAdminJunkwaDao() {
		return adminJunkwaDao;
	}
	public void setAdminJunkwaDao(AdminJunkwaDao adminJunkwaDao) {
		this.adminJunkwaDao = adminJunkwaDao;
	}
}
