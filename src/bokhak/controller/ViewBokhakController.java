package bokhak.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Bokhak;
import model.Member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.BokhakDao;
import dao.MemberDao;

@Controller
public class ViewBokhakController {
	private BokhakDao bokhakDao;
	private MemberDao memberDao;
	
	@RequestMapping("bokhakView.do")
	public String View(HttpServletRequest request,HttpSession session){
		int num=Integer.parseInt(request.getParameter("num"));
		Member member;
		member=memberDao.selectMember((String)session.getAttribute("memId"));
		Bokhak bokhak=bokhakDao.getBokhak(num);
		request.setAttribute("bokhak", bokhak);
		request.setAttribute("member", member);
		
		return "/bokhak/viewBokhakForm.jsp";
	}
	
	public BokhakDao getBokhakDao() {
		return bokhakDao;
	}
	public void setBokhakDao(BokhakDao bokhakDao) {
		this.bokhakDao = bokhakDao;
	}
	public MemberDao getMemberDao() {
		return memberDao;
	}
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
}
