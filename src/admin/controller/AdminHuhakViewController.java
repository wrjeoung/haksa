package admin.controller;

import javax.servlet.http.HttpServletRequest;

import model.Huhak;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.AdminHuhakDao;

@Controller
public class AdminHuhakViewController {
	private AdminHuhakDao adminHuhakDao;
	
	@RequestMapping("adminhuhakView.do")
	public String View(HttpServletRequest request){
		int num=Integer.parseInt(request.getParameter("num"));
		
		Huhak huhak=adminHuhakDao.getAdminHuhak(num);
		request.setAttribute("huhak", huhak);
		return "/adminhuhak/adminHuhakViewForm.jsp";
	}
	public AdminHuhakDao getAdminHuhakDao() {
		return adminHuhakDao;
	}

	public void setAdminHuhakDao(AdminHuhakDao adminHuhakDao) {
		this.adminHuhakDao = adminHuhakDao;
	}
}
