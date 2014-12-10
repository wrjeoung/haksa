package huhak.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Huhak;
import model.Member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.HuhakDao;
import dao.MemberDao;

@Controller
public class InsertHuhakController {
	private HuhakDao huhakDao;
	Calendar today = Calendar.getInstance();
	
	private MemberDao memberDao;
	
	@RequestMapping("/insertHuhakForm.do")
	public String form(HttpServletRequest request,HttpSession session){
		List<Huhak> list=null;
		//세션1
		Member member;
		member=memberDao.selectMember((String)session.getAttribute("memId"));
		
		list=huhakDao.getHuhakList(member.getStudentNumber());
		
		request.setAttribute("list", list);
		//세션2
		request.setAttribute("member", member);
		
		return "/huhak/insertHuhakForm.jsp";
		
		//return "huhak/insertHuhakForm.jsp";
	}
	
	@RequestMapping("/insertHuhakPro.do")
	public ModelAndView formPro(@ModelAttribute Huhak huhak,HttpServletRequest request,HttpSession session){
		System.out.println("2");
		huhak.setHuhak_reg_date(today.getTime());
		huhakDao.insertHuhak(huhak);
		Member member;
		member=memberDao.selectMember((String)session.getAttribute("memId"));
		
		request.setAttribute("member", member);
		ModelAndView mv=new ModelAndView();
		mv.addObject("huhak",huhak);
		mv.setViewName("redirect:/huhakList.do");
		return mv;
		
	}
	@RequestMapping("/huhakList.do")
	public String form1(HttpServletRequest request,HttpSession session){
		System.out.println("3");
		List<Huhak> list=null;
		//세션
		Member member;
		member=memberDao.selectMember((String)session.getAttribute("memId"));
		list=huhakDao.getHuhakList(member.getStudentNumber());
		request.setAttribute("list", list);
		request.setAttribute("member", member);
		
		return "/huhak/insertHuhakForm.jsp";
	}
	
	public HuhakDao getHuhakDao() {
		return huhakDao;
	}

	public void setHuhakDao(HuhakDao huhakDao) {
		this.huhakDao = huhakDao;
	}
	//세션
	public MemberDao getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	
}
