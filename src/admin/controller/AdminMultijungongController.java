package admin.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Multijungong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.AdminMultijungongDao;

@Controller
public class AdminMultijungongController {
	private AdminMultijungongDao adminMultijungongDao;
	Calendar today=Calendar.getInstance();

	@RequestMapping("/adminmultijungongList.do")
	public String form1(HttpServletRequest request){
		List<Multijungong> list=null;
		list=adminMultijungongDao.getAdminMultijungongList();
		request.setAttribute("list", list);
		return "/adminmultijungong/adminMultijungongForm.jsp";
	}
	@RequestMapping("adminmultijungongUpdateCom.do")
	public String UpdateCom(HttpServletRequest request){
		String[] rnum=request.getParameterValues("rnum");
		for(int i=0;i<rnum.length;i++){
			String value=rnum[i];
			adminMultijungongDao.updatecomAdminMultijungong(value);
		}
		return "redirect:/adminmultijungongList.do";
	}
	@RequestMapping("adminmultijungongUpdateCan.do")
	public String UpdateCan(HttpServletRequest request){
		String[] rnum=request.getParameterValues("rnum");
		for(int i=0;i<rnum.length;i++){
			String value=rnum[i];
			adminMultijungongDao.updatecanAdminMultijungong(value);
		}
		return "redirect:/adminmultijungongList.do";
	}
	@RequestMapping("adminmultijungongDelete.do")
	public String Delete(HttpServletRequest request){
		String[] rnum=request.getParameterValues("rnum");
		for(int i=0;i<rnum.length;i++){
			String value=rnum[i];
			adminMultijungongDao.deleteAdminMultijungong(value);
		}
		return "redirect:/adminmultijungongList.do";
	}
	public AdminMultijungongDao getAdminMultijungongDao() {
		return adminMultijungongDao;
	}
	public void setAdminMultijungongDao(AdminMultijungongDao adminMultijungongDao) {
		this.adminMultijungongDao = adminMultijungongDao;
	}
}
