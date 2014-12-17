package junkwa.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Junkwa;
import model.Member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.JunkwaDao;
import dao.MemberDao;

@Controller
public class InsertJunkwaController {
	private JunkwaDao junkwaDao;
	Calendar today=Calendar.getInstance();
	private MemberDao memberDao;
	@RequestMapping("/insertJunkwaForm.do")
	public String form(HttpServletRequest request,HttpSession session){
		List<Junkwa> list=null;
		//세션1
		Member member;
		member=memberDao.selectMember((String)session.getAttribute("memId"));
		
		list=junkwaDao.getJunkwaList(member.getStudentNumber());
		request.setAttribute("list", list);
		//세션2
		request.setAttribute("member", member);
		return "/junkwa/insertJunkwaForm.jsp";
	}
	
	@RequestMapping("/insertJunkwaPro.do")
	public ModelAndView formPro(@ModelAttribute Junkwa junkwa,HttpServletRequest request,HttpSession session){
		
		junkwa.setJunkwa_reg_date(today.getTime());
		junkwaDao.insertJunkwa(junkwa);
		//세션
		Member member;
		member=memberDao.selectMember((String)session.getAttribute("memId"));
		request.setAttribute("member", member);
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("junkwa", junkwa);
		mv.setViewName("redirect:/junkwaList.do");
		return mv;
	}
	@RequestMapping("/junkwaList.do")
	public String form1(HttpServletRequest request,HttpSession session){
		List<Junkwa> list=null;
		//세션
		Member member;
		member=memberDao.selectMember((String)session.getAttribute("memId"));
		list=junkwaDao.getJunkwaList(member.getStudentNumber());
		request.setAttribute("list", list);
		request.setAttribute("member", member);
		return "/junkwa/insertJunkwaForm.jsp";
	}
	@RequestMapping("junkwaDelete.do")
	public String Delete(HttpServletRequest request){
		String[] rnum=request.getParameterValues("rnum");
		for(int i=0;i<rnum.length;i++){
			String value=rnum[i];
			junkwaDao.deleteJunkwa(value);
		}
		
		return "redirect:/junkwaList.do";
	}
	//상세보기
	@RequestMapping("junkwaView.do")
	public String View(HttpServletRequest request,HttpSession session){
		int num=Integer.parseInt(request.getParameter("num"));
		Member member;
		member=memberDao.selectMember((String)session.getAttribute("memId"));
		Junkwa junkwa=junkwaDao.getJunkwa(num);
		request.setAttribute("junkwa", junkwa);
		request.setAttribute("member", member);
		return "/junkwa/viewJunkwaForm.jsp";
	}
	@RequestMapping("junkwainfomodify.do")
	public String infoModify(HttpSession session,HttpServletRequest request){
		int num=Integer.parseInt(request.getParameter("num"));
		Junkwa junkwa;
		junkwa=junkwaDao.getJunkwa(num);
		Member member;
		member=memberDao.selectMember((String)session.getAttribute("memId"));
		request.setAttribute("junkwa", junkwa);
		request.setAttribute("member", member);
		return "/junkwa/modifyJunkwaForm.jsp";
	}
	@RequestMapping("junkwainfoPro.do")
	public ModelAndView Modify(@ModelAttribute Junkwa junkwa,HttpServletRequest request,HttpSession session){
		//int num=Integer.parseInt(request.getParameter("num"));
		junkwa.setJunkwa_reg_date(today.getTime());
		Member member;
		member=memberDao.selectMember((String)session.getAttribute("memId"));
		junkwaDao.changeJunkwa(junkwa);
		request.setAttribute("member", member);
		ModelAndView mv=new ModelAndView();
		mv.addObject("junkwa",junkwa);
		mv.addObject("member",member);
		mv.setViewName("redirect:/junkwaList.do");
		return mv;
	}
	public JunkwaDao getJunkwaDao() {
		return junkwaDao;
	}

	public void setJunkwaDao(JunkwaDao junkwaDao) {
		this.junkwaDao = junkwaDao;
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	
}

