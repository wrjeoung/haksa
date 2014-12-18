package janghak.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Janghak;
import model.Member;
import model.Multijungong;

import org.apache.catalina.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.JanghakDao;
import dao.MemberDao;
import dao.MultijungongDao;

@Controller
public class InsertJanghakController {
	private JanghakDao janghakDao;
	Calendar today=Calendar.getInstance();
	private MemberDao memberDao;
	@RequestMapping("/insertJanghakForm.do")
	public String form(HttpServletRequest request,HttpSession session){
		List<Janghak> list=null;
		//세션
		Member member;
		member=memberDao.selectMember((String)session.getAttribute("memId"));
		
		list=janghakDao.getJanghakList(member.getStudentNumber());
		request.setAttribute("list", list);
		request.setAttribute("member", member);
		return "/janghak/insertJanghakForm.jsp";
		
	}

	@RequestMapping("/insertJanghakPro.do")
	public ModelAndView formPro(@ModelAttribute Janghak janghak,HttpServletRequest request,HttpSession session){
		janghak.setJanghak_reg_date(today.getTime());
		janghakDao.insertJanghak(janghak);
		
		Member member;
		member=memberDao.selectMember((String)session.getAttribute("memId"));
		request.setAttribute("member", member);
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("janghak", janghak);
		mv.setViewName("redirect:/janghakList.do");
		return mv;
	}
	@RequestMapping("/janghakList.do")
	public String form1(HttpServletRequest request,HttpSession session){
		List<Janghak> list=null;
		Member member;
		member=memberDao.selectMember((String)session.getAttribute("memId"));
		
		
		list=janghakDao.getJanghakList(member.getStudentNumber());
		request.setAttribute("list", list);
		request.setAttribute("member", member);
		return "/janghak/insertJanghakForm.jsp";
	}
	@RequestMapping("janghakDelete.do")
	public String Delete(HttpServletRequest request){
		String[] rnum=request.getParameterValues("rnum");
		for(int i=0;i<rnum.length;i++){
			String value=rnum[i];
			janghakDao.deleteJanghak(value);
		}
		return "redirect:/janghakList.do";
	}
	@RequestMapping("janghakinfomodify.do")
	public String infoModify(HttpServletRequest request,HttpSession session){
		int num=Integer.parseInt(request.getParameter("num"));
		Janghak janghak;
		janghak=janghakDao.getJanghak(num);
		Member member;
		member=memberDao.selectMember((String)session.getAttribute("memId"));
		request.setAttribute("janghak", janghak);
		request.setAttribute("member", member);
		return "/janghak/modifyJanghakForm.jsp";
	}
	@RequestMapping("janghakinfoPro.do")
	public ModelAndView Modify(@ModelAttribute Janghak janghak,HttpServletRequest request,HttpSession session){
		janghak.setJanghak_reg_date(today.getTime());
		Member member;
		member=memberDao.selectMember((String)session.getAttribute("memId"));
		janghakDao.changeJanghak(janghak);
		request.setAttribute("member", member);
		ModelAndView mv=new ModelAndView();
		mv.addObject("janghak", janghak);
		mv.addObject("member", member);
		mv.setViewName("redirect:/janghakList.do");
		return mv;
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
