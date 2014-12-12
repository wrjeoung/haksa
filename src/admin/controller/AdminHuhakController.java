package admin.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Huhak;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.AdminHuhakDao;

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
	
	public AdminHuhakDao getAdminHuhakDao() {
		return adminHuhakDao;
	}
	public void setAdminHuhakDao(AdminHuhakDao adminHuhakDao) {
		this.adminHuhakDao = adminHuhakDao;
	}
	
	
}
