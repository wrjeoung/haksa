package janghak.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Janghak;
import model.Member;

import org.apache.catalina.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.JanghakDao;
import dao.MemberDao;

@Controller
public class ViewJanghakController {
	private JanghakDao janghakDao;
	//세션
	private MemberDao memberDao;
	@RequestMapping("janghakView.do")
	public String View(HttpServletRequest request,HttpSession session){
		int num=Integer.parseInt(request.getParameter("num"));
		Member member;
		member=memberDao.selectMember((String)session.getAttribute("memId"));
		
		Janghak janghak=janghakDao.getJanghak(num);
		request.setAttribute("janghak", janghak);
		request.setAttribute("member", member);
		return "/janghak/JanghakView.jsp";
	}
	
	public JanghakDao getJanghakDao() {
		return janghakDao;
	}

	public void setJanghakDao(JanghakDao janghakDao) {
		this.janghakDao = janghakDao;
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
}
