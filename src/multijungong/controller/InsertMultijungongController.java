package multijungong.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Member;
import model.Multijungong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.MemberDao;
import dao.MultijungongDao;

@Controller
public class InsertMultijungongController {
	private MultijungongDao multijungongDao;
	Calendar today=Calendar.getInstance();
	private MemberDao memberDao;
	@RequestMapping("/insertmultijungongForm.do")
	public String form(HttpServletRequest request,HttpSession session){
		List<Multijungong> list=null;
		//세션1
		Member member;
		member=memberDao.selectMember((String)session.getAttribute("memId"));
		
		list=multijungongDao.getMultijungongList(member.getStudentNumber());
		request.setAttribute("list", list);
		request.setAttribute("member", member);
		return "/multijungong/insertmultijungongForm.jsp";
	}
	
	@RequestMapping("/insertmultijungongPro.do")
	public ModelAndView formPro(@ModelAttribute Multijungong multijungong,HttpServletRequest request,HttpSession session){
		multijungong.setMulti_reg_date(today.getTime());
		multijungongDao.insertMultijungong(multijungong);
		
		Member member;
		member=memberDao.selectMember((String)session.getAttribute("memId"));
		request.setAttribute("member", member);
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("multijungong", multijungong);
		
		mv.setViewName("redirect:/multijungongList.do");
		return mv;
	}
	@RequestMapping("/multijungongList.do")
	public String form1(HttpServletRequest request,HttpSession session){
		List<Multijungong> list=null;
		
		Member member;
		member=memberDao.selectMember((String)session.getAttribute("memId"));
		
		list=multijungongDao.getMultijungongList(member.getStudentNumber());
		
		request.setAttribute("list", list);
		request.setAttribute("member", member);
		return "/multijungong/insertmultijungongForm.jsp";
	}
	@RequestMapping("multijungongDelete.do")
	public String Delete(HttpServletRequest request){
		String[] rnum=request.getParameterValues("rnum");
		for(int i=0;i<rnum.length;i++){
			String value=rnum[i];
			multijungongDao.deleteMultijungong(value);
		}
		return "redirect:/multijungongList.do";
	}
	@RequestMapping("multijungongmodify.do")
	public String infoModify(HttpSession session,HttpServletRequest request){
		int num=Integer.parseInt(request.getParameter("num"));
		Multijungong multijungong;
		multijungong=multijungongDao.getMultijungong(num);
		Member member;
		member=memberDao.selectMember((String)session.getAttribute("memId"));
		request.setAttribute("multijungong", multijungong);
		request.setAttribute("member", member);
		return "/multijungong/modifyMultijungongForm.jsp";
	}
	@RequestMapping("multijungonginfoPro.do")
	public ModelAndView Modify(@ModelAttribute Multijungong multijungong,HttpServletRequest request,HttpSession session){
		multijungong.setMulti_reg_date(today.getTime());
		Member member;
		member=memberDao.selectMember((String)session.getAttribute("memId"));
		multijungongDao.changeMultijungong(multijungong);
		request.setAttribute("member", member);
		ModelAndView mv=new ModelAndView();
		mv.addObject("multijungong", multijungong);
		mv.addObject("member", member);
		mv.setViewName("redirect:/multijungongList.do");
		return mv;
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
