package multijungong.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Member;
import model.Multijungong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.MemberDao;
import dao.MultijungongDao;

@Controller
public class ViewMultijungongController {
	private MultijungongDao multijungongDao;
	private MemberDao memberDao;
	
	@RequestMapping("multijungongView.do")
	public String View(HttpServletRequest request,HttpSession session){
		int num=Integer.parseInt(request.getParameter("num"));
		Member member;
		member=memberDao.selectMember((String)session.getAttribute("memId"));
		Multijungong multijungong=multijungongDao.getMultijungong(num);
		request.setAttribute("multijungong", multijungong);
		request.setAttribute("member", member);
		return "/multijungong/viewMultijungongForm.jsp";
	}
	
	public MultijungongDao getMultijungongDao() {
		return multijungongDao;
	}
	public void setMultijungongDao(MultijungongDao multijungongDao) {
		this.multijungongDao = multijungongDao;
	}
	public MemberDao getMemberDao() {
		return memberDao;
	}
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
}
