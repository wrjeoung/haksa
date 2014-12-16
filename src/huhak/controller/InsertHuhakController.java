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
	
	@RequestMapping("huhakDelete.do")
	public String Delete(HttpServletRequest request){
		System.out.println("1:"+request.getParameterValues("rnum"));
		String[] rnum=request.getParameterValues("rnum");
		System.out.println("rnum="+rnum[0]);
		for(int i=0;i<rnum.length;i++){
			String value = rnum[i];
			System.out.println("value="+value);
			huhakDao.deleteHuhak(value);
		}
		System.out.println("되?3");
		return "redirect:/huhakList.do";
	}
	
	@RequestMapping("huhakinfomodify.do")
	public String infoModify(HttpSession session,HttpServletRequest request){
		int num=Integer.parseInt(request.getParameter("num"));
		Huhak huhak;
		huhak=huhakDao.getHuhak(num);
		Member member;
		member=memberDao.selectMember((String)session.getAttribute("memId"));
		request.setAttribute("huhak", huhak);
		request.setAttribute("member", member);
		return "/huhak/modifyHuhakForm.jsp";
	}
	
	@RequestMapping("/huhakeinfoPro.do")
	public ModelAndView Modify(@ModelAttribute Huhak huhak,HttpServletRequest request,HttpSession session){
		System.out.println("2");
		huhak.setHuhak_reg_date(today.getTime());
		//huhakDao.insertHuhak(huhak);
		Member member;
		member=memberDao.selectMember((String)session.getAttribute("memId"));
		huhakDao.changeHuhak(huhak);
		request.setAttribute("member", member);
		ModelAndView mv=new ModelAndView();
		mv.addObject("huhak",huhak);
		mv.addObject("member",member);
		mv.setViewName("redirect:/huhakList.do");
		return mv;
		
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
