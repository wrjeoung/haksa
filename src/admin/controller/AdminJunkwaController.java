package admin.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Junkwa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.AdminJunkwaDao;

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
		for(int i=0;i<rnum.length;i++){
			String value=rnum[i];
			adminJunkwaDao.updatecomAdminJunkwa(value);
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
	public AdminJunkwaDao getAdminJunkwaDao() {
		return adminJunkwaDao;
	}
	public void setAdminJunkwaDao(AdminJunkwaDao adminJunkwaDao) {
		this.adminJunkwaDao = adminJunkwaDao;
	}
}
