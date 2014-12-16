package admin.controller;

import javax.servlet.http.HttpServletRequest;

import model.Bokhak;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.AdminBokhakDao;

@Controller
public class AdminBokhakViewController {
	private AdminBokhakDao adminBokhakDao;
	
	@RequestMapping("adminbokhakView.do")
	public String View(HttpServletRequest request){
		int num=Integer.parseInt(request.getParameter("num"));
		Bokhak bokhak=adminBokhakDao.getAdminBokhak(num);
		request.setAttribute("bokhak", bokhak);
		return "/adminbokhak/adminBokhakViewForm.jsp";
	}
	
	public AdminBokhakDao getAdminBokhakDao() {
		return adminBokhakDao;
	}

	public void setAdminBokhakDao(AdminBokhakDao adminBokhakDao) {
		this.adminBokhakDao = adminBokhakDao;
	}
}
