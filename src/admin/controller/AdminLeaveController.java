package admin.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Leave;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.AdminLeaveDao;

@Controller
public class AdminLeaveController {
	private AdminLeaveDao adminLeaveDao;
	Calendar today=Calendar.getInstance();
	
	@RequestMapping("/adminleaveList.do")
	public String form1(HttpServletRequest request){
		List<Leave> list=null;
		list=adminLeaveDao.getAdminLeaveList();
		request.setAttribute("list", list);
		return "/adminleave/adminLeaveForm.jsp";
	}
	@RequestMapping("adminleaveUpdateCom.do")
	public String UpdateCom(HttpServletRequest request){
		String[] rnum=request.getParameterValues("rnum");
		for(int i=0;i<rnum.length;i++){
			String value=rnum[i];
			adminLeaveDao.updatecomAdminLeave(value);
		}
		return "redirect:/adminleaveList.do";
	}
	@RequestMapping("adminleaveUpdateCan.do")
	public String UpdateCan(HttpServletRequest request){
		String[] rnum=request.getParameterValues("rnum");
		for(int i=0;i<rnum.length;i++){
			String value=rnum[i];
			adminLeaveDao.updatecanAdminLeave(value);
		}
		return "redirect:/adminleaveList.do";
	}
	//삭제
	@RequestMapping("adminleaveDelete.do")
	public String Delete(HttpServletRequest request){
		String[] rnum=request.getParameterValues("rnum");
		for(int i=0;i<rnum.length;i++){
			String value=rnum[i];
			adminLeaveDao.deleteAdminLeave(value);
		}
		return "redirect:/adminleaveList.do";
	}
	@RequestMapping("adminleaveinfomodify.do")
	public String infoModify(HttpServletRequest request){
		int num=Integer.parseInt(request.getParameter("num"));
		Leave leave;
		leave=adminLeaveDao.getAdminLeave(num);
		request.setAttribute("leave", leave);
		return "/adminleave/adminLeaveModifyForm.jsp";
	}
	@RequestMapping("adminleaveinfoPro.do")
	public ModelAndView Modify(@ModelAttribute Leave leave,HttpServletRequest request){
		leave.setLeave_reg_date(today.getTime());
		adminLeaveDao.changeAdminLeave(leave);
		ModelAndView mv=new ModelAndView();
		mv.addObject("leave",leave);
		mv.setViewName("redirect:/adminleaveList.do");
		return mv;
	}
	
	public AdminLeaveDao getAdminLeaveDao() {
		return adminLeaveDao;
	}
	public void setAdminLeaveDao(AdminLeaveDao adminLeaveDao) {
		this.adminLeaveDao = adminLeaveDao;
	}
}
