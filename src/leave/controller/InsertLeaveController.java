package leave.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Leave;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.LeaveDao;

@Controller
public class InsertLeaveController {
	private LeaveDao leaveDao;
	Calendar today=Calendar.getInstance();
	
	@RequestMapping("/insertLeaveForm.do")
	public String form(HttpServletRequest request){
		List<Leave> list=null;
		list=leaveDao.getLeaveList();
		
		request.setAttribute("list", list);
		
		return "/leave/insertLeaveForm.jsp";
	}
	@RequestMapping("/insertLeavePro.do")
	public ModelAndView formPro(@ModelAttribute Leave leave){
		leave.setLeave_reg_date(today.getTime());
		leaveDao.insertLeave(leave);
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("leave", leave);
		mv.setViewName("redirect:/leaveList.do");
		return mv;
	}
	@RequestMapping("/leaveList.do")
	public String form1(HttpServletRequest request){
		List<Leave> list=null;
		list=leaveDao.getLeaveList();
		
		request.setAttribute("list", list);
		return "/leave/insertLeaveForm.jsp";
	}
	
	public LeaveDao getLeaveDao() {
		return leaveDao;
	}

	public void setLeaveDao(LeaveDao leaveDao) {
		this.leaveDao = leaveDao;
	}
}
