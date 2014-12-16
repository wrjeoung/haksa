package admin.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Huhak;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.AdminHuhakDao;
import dao.HuhakDao;

@Controller
public class AdminHuhakController {
	private AdminHuhakDao adminHuhakDao;
	Calendar today=Calendar.getInstance();
	
	@RequestMapping("/adminhuhakList.do")
	public String form1(HttpServletRequest request){
		List<Huhak> list=null;
		list=adminHuhakDao.getAdminHuhakList();
		
		request.setAttribute("list", list);
		
		return "/adminhuhak/adminHuhakForm.jsp";
	}
	@RequestMapping("updateCom.do")
	public String UpdateCom(HttpServletRequest request){
		String[] rnum=request.getParameterValues("rnum");
		for(int i=0;i<rnum.length;i++){
			String value=rnum[i];
			adminHuhakDao.updatecomAdminHuhak(value);
		}
		return "redirect:/adminhuhakList.do";
	}
	@RequestMapping("updateCan.do")
	public String UpdateCan(HttpServletRequest request){
		String[] rnum=request.getParameterValues("rnum");
		for(int i=0;i<rnum.length;i++){
			String value=rnum[i];
			adminHuhakDao.updatecanAdminHuhak(value);
		}
		return "redirect:/adminhuhakList.do";
	}
	//삭제
	@RequestMapping("adminhuhakDelete.do")
	public String Delete(HttpServletRequest request){
		String[] rnum=request.getParameterValues("rnum");
		for(int i=0;i<rnum.length;i++){
			String value=rnum[i];
			adminHuhakDao.deleteAdminHuhak(value);
		}
		return "redirect:/adminhuhakList.do";
	}
	//수정폼
	@RequestMapping("adminhuhakinfomodify.do")
	public String infoModify(HttpServletRequest request){
		int num=Integer.parseInt(request.getParameter("num"));
		Huhak huhak;
		huhak=adminHuhakDao.getAdminHuhak(num);
		request.setAttribute("huhak", huhak);
		return "/adminhuhak/adminHuhakModifyForm.jsp";
	}
	@RequestMapping("adminhuhakeinfoPro.do")
	public ModelAndView Modify(@ModelAttribute Huhak huhak,HttpServletRequest request){
		huhak.setHuhak_reg_date(today.getTime());
		adminHuhakDao.changeAdminHuhak(huhak);
		ModelAndView mv=new ModelAndView();
		mv.addObject("huhak", huhak);
		mv.setViewName("redirect:/adminhuhakList.do");
		return mv;
	}
	
	
	public AdminHuhakDao getAdminHuhakDao() {
		return adminHuhakDao;
	}
	public void setAdminHuhakDao(AdminHuhakDao adminHuhakDao) {
		this.adminHuhakDao = adminHuhakDao;
	}
	
	
}
