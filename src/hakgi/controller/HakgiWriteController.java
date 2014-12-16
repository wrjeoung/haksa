package hakgi.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Hakgi;
import model.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import dao.HakgiDao;
import dao.MemberDao;

@Controller
public class HakgiWriteController {

	HakgiDao hakgiDao;
	MemberDao memberDao;
	
	
	@RequestMapping("hakgiwrite.do")
	public String form(HttpServletRequest request,HttpSession session) {
		List<Hakgi> list=null;
		Member member;
		member=memberDao.selectMember((String)session.getAttribute("memId"));
		list=hakgiDao.getHakgilist();
		request.setAttribute("list", list);
		request.setAttribute("member", member);
		System.out.println("스투던트넘버는? " + member.getStudentNumber());
		return "/hakgisung/hakgiinsert.jsp";
	}
	
	@RequestMapping("insertHakgiPro.do")
	public ModelAndView formPro(@ModelAttribute Hakgi hakgi,HttpServletRequest request,HttpSession session){

		hakgiDao.insertHakgi(hakgi);
		Member member;
		member=memberDao.selectMember((String)session.getAttribute("memId"));
		request.setAttribute("member", member);
		ModelAndView mv=new ModelAndView();
		mv.addObject("hakgi",hakgi);
		mv.setViewName("redirect:/hakgiwrite.do");
		return mv;
	}

	public HakgiDao getHakgiDao() {
		return hakgiDao;
	}

	public void setHakgiDao(HakgiDao hakgiDao) {
		this.hakgiDao = hakgiDao;
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	
	
}
