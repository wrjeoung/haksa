package leave.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Leave;
import model.Member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.LeaveDao;
import dao.MemberDao;

@Controller
public class InsertLeaveController {
	private LeaveDao leaveDao;
	Calendar today=Calendar.getInstance();
	MemberDao memberDao;
	@RequestMapping("/insertLeaveForm.do")
	public String form(HttpServletRequest request,HttpSession session){
		List<Leave> list=null;
		//세션1
		Member member;
		member=memberDao.selectMember((String)session.getAttribute("memId"));
		list=leaveDao.getLeaveList(member.getStudentNumber());
		
		request.setAttribute("list", list);
		request.setAttribute("member", member);
		return "/leave/insertLeaveForm.jsp";
	}
	@RequestMapping("/insertLeavePro.do")
	public ModelAndView formPro(@ModelAttribute Leave leave,HttpServletRequest request,HttpSession session){
		leave.setLeave_reg_date(today.getTime());
		leaveDao.insertLeave(leave);
		//세션
		Member member;
		member=memberDao.selectMember((String)session.getAttribute("memId"));
		
		request.setAttribute("member", member);
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("leave", leave);
		mv.setViewName("redirect:/leaveList.do");
		return mv;
	}
	@RequestMapping("/leaveList.do")
	public String form1(HttpServletRequest request,HttpSession session){
		List<Leave> list=null;
		//세션
		Member member;
		member=memberDao.selectMember((String)session.getAttribute("memId"));
		list=leaveDao.getLeaveList(member.getStudentNumber());
		
		
		request.setAttribute("list", list);
		request.setAttribute("member", member);
		return "/leave/insertLeaveForm.jsp";
	}
	
	public LeaveDao getLeaveDao() {
		return leaveDao;
	}

	public void setLeaveDao(LeaveDao leaveDao) {
		this.leaveDao = leaveDao;
	}
	public MemberDao getMemberDao() {
		return memberDao;
	}
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
}
