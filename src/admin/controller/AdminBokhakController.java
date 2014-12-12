package admin.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Bokhak;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
		for(int i=0;i<rnum.length;i++){
			String value=rnum[i];
			adminBokhakDao.updatecomAdminBokhak(value);
		}
		return "redirect:/adminbokhakList.do";
	}
	@RequestMapping("adminbokhakUpdateCan.do")
	public String UpdateCan(HttpServletRequest request){
		String[] rnum=request.getParameterValues("rnum");
		for(int i=0;i<rnum.length;i++){
			String value=rnum[i];
			adminBokhakDao.updatecanAdminBokhak(value);
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
