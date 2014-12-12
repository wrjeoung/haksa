package admin.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Jujungong2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.AdminJujungongDao;

@Controller
public class AdminJujungongController {
	private AdminJujungongDao adminJujungongDao;
	Calendar today=Calendar.getInstance();
	
	@RequestMapping("/adminjujungongList.do")
	public String form1(HttpServletRequest request){
		List<Jujungong2> list2=null;
		list2=adminJujungongDao.getAdminJujungongList();
		request.setAttribute("list2", list2);
		return "/adminjujungong/adminJujungongForm.jsp";
		
	}
	@RequestMapping("adminjujungongUpdateCom.do")
	public String UpdateCom(HttpServletRequest request){
		String[] rnum=request.getParameterValues("rnum");
		for(int i=0;i<rnum.length;i++){
			String value=rnum[i];
			adminJujungongDao.updatecomAdminJujungong(value);
		}
		return "redirect:/adminjujungongList.do";
	}
	@RequestMapping("adminjujungongUpdateCan.do")
	public String UpdateCan(HttpServletRequest request){
		String[] rnum=request.getParameterValues("rnum");
		for(int i=0;i<rnum.length;i++){
			String value=rnum[i];
			adminJujungongDao.updatecanAdminJujungong(value);
		}
		return "redirect:/adminjujungongList.do";
	}
	//삭제
	@RequestMapping("adminjujungongDelete.do")
	public String Delete(HttpServletRequest request){
		String[] rnum=request.getParameterValues("rnum");
		for(int i=0;i<rnum.length;i++){
			String value=rnum[i];
			adminJujungongDao.deleteAdminJujungong(value);
		}
		return "redirect:/adminjujungongList.do";
	}
	public AdminJujungongDao getAdminJujungongDao() {
		return adminJujungongDao;
	}
	public void setAdminJujungongDao(AdminJujungongDao adminJujungongDao) {
		this.adminJujungongDao = adminJujungongDao;
	}
}
