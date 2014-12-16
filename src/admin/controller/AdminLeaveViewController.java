package admin.controller;

import javax.servlet.http.HttpServletRequest;

import model.Leave;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.AdminLeaveDao;

@Controller
public class AdminLeaveViewController {
	private AdminLeaveDao adminLeaveDao;
	
	@RequestMapping("adminleaveView.do")
	public String View(HttpServletRequest request){
		int num=Integer.parseInt(request.getParameter("num"));
		Leave leave=adminLeaveDao.getAdminLeave(num);
		request.setAttribute("leave", leave);
		return "/adminleave/adminLeaveViewForm.jsp";
	}
	
	public AdminLeaveDao getAdminLeaveDao() {
		return adminLeaveDao;
	}

	public void setAdminLeaveDao(AdminLeaveDao adminLeaveDao) {
		this.adminLeaveDao = adminLeaveDao;
	}
}
