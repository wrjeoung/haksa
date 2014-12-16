package admin.controller;

import javax.servlet.http.HttpServletRequest;

import model.Janghak;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.AdminJanghakDao;

@Controller
public class AdminJanghakViewController {
	private AdminJanghakDao adminJanghakDao;

	@RequestMapping("adminjanghakView.do")
	public String View(HttpServletRequest request){
		int num=Integer.parseInt(request.getParameter("num"));
		Janghak janghak=adminJanghakDao.getAdminJanghak(num);
		request.setAttribute("janghak", janghak);
		return "/adminjanghak/adminJanghakViewForm.jsp";
	}
	
	public AdminJanghakDao getAdminJanghakDao() {
		return adminJanghakDao;
	}

	public void setAdminJanghakDao(AdminJanghakDao adminJanghakDao) {
		this.adminJanghakDao = adminJanghakDao;
	}
}
