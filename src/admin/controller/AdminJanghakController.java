package admin.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Janghak;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.AdminJanghakDao;

@Controller
public class AdminJanghakController {
	private AdminJanghakDao adminJanghakDao;
	Calendar today=Calendar.getInstance();
	
	@RequestMapping("/adminjanghakList.do")
	public String form1(HttpServletRequest request){
		List<Janghak> list=null;
		list=adminJanghakDao.getAdminJanghakList();
		request.setAttribute("list", list);
		
		return "/adminjanghak/adminJanghakForm.jsp";
	}
	@RequestMapping("adminjanghakUpdateCom.do")
	public String UpdateCom(HttpServletRequest request){
		String[] rnum=request.getParameterValues("rnum");
		for(int i=0;i<rnum.length;i++){
			String value=rnum[i];
			adminJanghakDao.updatecomAdminJanghak(value);
		}
		return "redirect:/adminjanghakList.do";
	}
	@RequestMapping("adminjanghakUpdateCan.do")
	public String UpdateCan(HttpServletRequest request){
		String[] rnum=request.getParameterValues("rnum");
		for(int i=0;i<rnum.length;i++){
			String value=rnum[i];
			adminJanghakDao.updatecanAdminJanghak(value);
		}
		return "redirect:/adminjanghakList.do";
	}
	//삭제
	@RequestMapping("adminjanghakDelete.do")
	public String Delete(HttpServletRequest request){
		String[] rnum=request.getParameterValues("rnum");
		for(int i=0;i<rnum.length;i++){
			String value=rnum[i];
			adminJanghakDao.deleteAdminJanghak(value);
		}
		return "redirect:/adminjanghakList.do";
	}
	
	public AdminJanghakDao getAdminJanghakDao() {
		return adminJanghakDao;
	}
	public void setAdminJanghakDao(AdminJanghakDao adminJanghakDao) {
		this.adminJanghakDao = adminJanghakDao;
	}
}
