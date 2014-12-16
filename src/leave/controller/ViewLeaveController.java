package leave.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Leave;
import model.Member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.MemberDao;
import dao.LeaveDao;

@Controller
public class ViewLeaveController {
	private LeaveDao leaveDao;
	private MemberDao memberDao;
	
	@RequestMapping("leaveView.do")
	public String View(HttpServletRequest request,HttpSession session){
		int num=Integer.parseInt(request.getParameter("num"));
		Member member;
		member=memberDao.selectMember((String)session.getAttribute("memId"));
		Leave leave=leaveDao.getLeave(num);
		request.setAttribute("leave", leave);
		request.setAttribute("member", member);
		
		return "/leave/viewLeaveForm.jsp";
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
