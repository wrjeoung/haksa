package admin.controller;

import javax.servlet.http.HttpServletRequest;

import model.Multijungong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.AdminMultijungongDao;

@Controller
public class AdminMultijungongViewController {
	private AdminMultijungongDao adminMultijungongDao;
	
	@RequestMapping("adminmultijungongView.do")
	public String View(HttpServletRequest request){
		int num=Integer.parseInt(request.getParameter("num"));
		Multijungong multijungong=adminMultijungongDao.getAdminMultijungong(num);
		request.setAttribute("multijungong", multijungong);
		return "/adminmultijungong/adminMultijungongViewForm.jsp";
	}
	
	public AdminMultijungongDao getAdminMultijungongDao() {
		return adminMultijungongDao;
	}

	public void setAdminMultijungongDao(AdminMultijungongDao adminMultijungongDao) {
		this.adminMultijungongDao = adminMultijungongDao;
	}
}
