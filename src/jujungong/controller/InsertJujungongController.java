package jujungong.controller;


import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.Jujungong2Dao;
import dao.JujungongDao;
import dao.MemberDao;
import model.Jujungong;
import model.Jujungong2;
import model.Member;

@Controller
public class InsertJujungongController {
	
	private JujungongDao jujungongDao;
	private MemberDao memberDao;
	Calendar today=Calendar.getInstance();
	//전공신청dao
	private Jujungong2Dao jujungong2Dao;
	
	@RequestMapping("/insertJujungongForm.do")
	public String form(HttpSession session,HttpServletRequest request){
		List<Jujungong> list=null;
		Member member;
		member=memberDao.selectMember((String)session.getAttribute("memId"));
		System.out.println("1");
	//	String major=request.getParameter("major");
		//System.out.println(major);
	//	list=jujungongDao.getList(major);
		System.out.println(member.getMajor());
		list=jujungongDao.getList(member.getMajor());
		System.out.println("2");
		
		List<Jujungong2> list2=null;
		list2=jujungong2Dao.getJujungongList(member.getStudentNumber());
		
		request.setAttribute("list", list);
		request.setAttribute("member", member);
		
		request.setAttribute("list2", list2);
		
		return "/jujungong/insertJujungongForm.jsp";
	}
	@RequestMapping("/insertJujungongPro.do")
	public ModelAndView formPro(@ModelAttribute Jujungong2 jujungong2,HttpSession session,HttpServletRequest request){
		jujungong2.setJujungong_reg_date(today.getTime());
		
		jujungong2Dao.insertJujungong(jujungong2);
		Member member;
		member=memberDao.selectMember((String)session.getAttribute("memId"));
		request.setAttribute("member", member);
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("jujungong2", jujungong2);
		mv.setViewName("redirect:/jujungongList.do");
		return mv;
	}
	@RequestMapping("/jujungongList.do")
	public String form1(HttpServletRequest request,HttpSession session){
		List<Jujungong> list=null;
		Member member;
		member=memberDao.selectMember((String)session.getAttribute("memId"));
		list=jujungongDao.getList(member.getMajor());
		
		List<Jujungong2> list2=null;
		list2=jujungong2Dao.getJujungongList(member.getStudentNumber());
		
		
		request.setAttribute("list", list);
		request.setAttribute("member", member);
		request.setAttribute("list2", list2);
		return "/jujungong/insertJujungongForm.jsp";
	}
	
	public JujungongDao getJujungongDao() {
		return jujungongDao;
	}

	public void setJujungongDao(JujungongDao jujungongDao) {
		this.jujungongDao = jujungongDao;
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public Jujungong2Dao getJujungong2Dao() {
		return jujungong2Dao;
	}

	public void setJujungong2Dao(Jujungong2Dao jujungong2Dao) {
		this.jujungong2Dao = jujungong2Dao;
	}
	
}
