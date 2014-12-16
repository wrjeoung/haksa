package tuition.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Member;
import model.Tuition;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import dao.MemberDao;
import dao.TuitionDao;

@Controller
public class TuitionWriteController {
	TuitionDao tuitionDao;
	private MemberDao memberDao;
	
	@RequestMapping("tuitionwrite.do")
	public String form(HttpServletRequest request,HttpSession session) {
		List<Tuition> list=null;
		Member member;
		member=memberDao.selectMember((String)session.getAttribute("memId"));
		list=tuitionDao.getTuitionList();
		request.setAttribute("list", list);
		request.setAttribute("member", member);
		System.out.println("스투던트넘버는? " + member.getStudentNumber());
		return "/tuition/tuitioninsert.jsp";
	}
	
	@RequestMapping("insertTuitionPro.do")
	public ModelAndView formPro(@ModelAttribute Tuition tuition,HttpServletRequest request,HttpSession session){

		tuitionDao.insertTuition(tuition);
		Member member;
		member=memberDao.selectMember((String)session.getAttribute("memId"));
		request.setAttribute("member", member);
		ModelAndView mv=new ModelAndView();
		mv.addObject("tuition",tuition);
		mv.setViewName("redirect:/tuitionwrite.do");
		return mv;
	}

	public TuitionDao getTuitionDao() {
		return tuitionDao;
	} 

	public void setTuitionDao(TuitionDao tuitionDao) {
		this.tuitionDao = tuitionDao;
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	
}
