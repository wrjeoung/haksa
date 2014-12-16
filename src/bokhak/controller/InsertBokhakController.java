package bokhak.controller;

import java.awt.print.Book;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Bokhak;
import model.Member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.BokhakDao;
import dao.MemberDao;

@Controller
public class InsertBokhakController {
	private BokhakDao bokhakDao;
	Calendar today=Calendar.getInstance();
	
	private MemberDao memberDao;
	
	@RequestMapping("/insertBokhakForm.do")
	public String form(HttpServletRequest request,HttpSession session){
		List<Bokhak> list=null;
		
		//세션1
		Member member;
		member=memberDao.selectMember((String)session.getAttribute("memId"));
		
		list=bokhakDao.getBokhakList(member.getStudentNumber());
		
		request.setAttribute("list", list);
		//세션2
		request.setAttribute("member", member);
		return "/bokhak/insertBokhakForm.jsp";
	}
	
	@RequestMapping("/insertBokhakPro.do")
	public ModelAndView formPro(@ModelAttribute Bokhak bokhak,HttpServletRequest request,HttpSession session){
		bokhak.setBokhak_reg_date(today.getTime());
		bokhakDao.insertBokhak(bokhak);
		//세션
		Member member;
		member=memberDao.selectMember((String)session.getAttribute("memId"));
		
		request.setAttribute("member", member);
		ModelAndView mv=new ModelAndView();
		mv.addObject("bokhak", bokhak);
		mv.setViewName("redirect:/bokhakList.do");
		return mv;
	}
	@RequestMapping("/bokhakList.do")
	public String form1(HttpServletRequest request,HttpSession session){
		List<Bokhak> list=null;
		//세션
		Member member;
		member=memberDao.selectMember((String)session.getAttribute("memId"));
		
		list=bokhakDao.getBokhakList(member.getStudentNumber());
		request.setAttribute("list", list);
		request.setAttribute("member", member);
		return "/bokhak/insertBokhakForm.jsp";
	}
	@RequestMapping("bokhakDelete.do")
	public String Delete(HttpServletRequest request){
		String[] rnum=request.getParameterValues("rnum");
		
		for(int i=0;i<rnum.length;i++){
			String value=rnum[i];
			bokhakDao.deleteBokhak(value);
		}
		return "redirect:/bokhakList.do";
	}
	@RequestMapping("bokhakinfomodify.do")
	public String infoModify(HttpSession session,HttpServletRequest request){
		int num=Integer.parseInt(request.getParameter("num"));
		Bokhak bokhak;
		bokhak=bokhakDao.getBokhak(num);
		Member member;
		member=memberDao.selectMember((String)session.getAttribute("memId"));
		request.setAttribute("bokhak", bokhak);
		request.setAttribute("member", member);
		return "/bokhak/modifyBokhakForm.jsp";
	}
	@RequestMapping("bokhakinfoPro.do")
	public ModelAndView Modify(@ModelAttribute Bokhak bokhak,HttpServletRequest request,HttpSession session){
		bokhak.setBokhak_reg_date(today.getTime());
		Member member;
		member=memberDao.selectMember((String)session.getAttribute("memId"));
		bokhakDao.changeBokhak(bokhak);
		request.setAttribute("member", member);
		ModelAndView mv=new ModelAndView();
		mv.addObject("bokhak",bokhak);
		mv.addObject("member", member);
		mv.setViewName("redirect:/bokhakList.do");
		return mv;
	}
	public BokhakDao getBokhakDao() {
		return bokhakDao;
	}
	public void setBokhakDao(BokhakDao bokhakDao) {
		this.bokhakDao = bokhakDao;
	}

	public Calendar getToday() {
		return today;
	}

	public void setToday(Calendar today) {
		this.today = today;
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	
}
