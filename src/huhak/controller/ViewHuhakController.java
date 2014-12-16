package huhak.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Huhak;
import model.Janghak;
import model.Member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.HuhakDao;
import dao.MemberDao;

@Controller
public class ViewHuhakController {
	private HuhakDao huhakDao;
	private MemberDao memberDao;
	
	@RequestMapping("huhakView.do")
	public String View(HttpServletRequest request,HttpSession session){
		int num=Integer.parseInt(request.getParameter("num"));
		Member member;
		member=memberDao.selectMember((String)session.getAttribute("memId"));
		Huhak huhak=huhakDao.getHuhak(num);
		request.setAttribute("huhak", huhak);
		request.setAttribute("member", member);
		
		return "/huhak/viewHuhakForm.jsp";
	}
	
	
	public HuhakDao getHuhakDao() {
		return huhakDao;
	}
	public void setHuhakDao(HuhakDao huhakDao) {
		this.huhakDao = huhakDao;
	}
	public MemberDao getMemberDao() {
		return memberDao;
	}
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
}
