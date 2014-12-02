package studentinfo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.MemberDao;

@Controller
public class PwModifyController {
	private MemberDao memberDao;
	private boolean isConfirmPw;
	
	@RequestMapping("pwCheck.do")
	public String pwCheckform(){
		return "/studentinfo/pwcheck.jsp";
	}
	
	@RequestMapping(value="pwCheckPro.do", method=RequestMethod.POST)
	public ModelAndView pwCheckformPro(HttpSession session,
			@ModelAttribute Member memberDto){
		List members;
		Map<String, String> params = new HashMap();
		params.put("id", (String)session.getAttribute("memId"));
		params.put("pw", memberDto.getPassword());
		members=memberDao.pwCheck(params);
		
		if(members.size() == 1)
			isConfirmPw = true;
		else
			isConfirmPw = false;
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("isConfirmPw",isConfirmPw);
		mv.setViewName("/studentinfo/pwcheckPro.jsp");
		return mv;
	}
	
	@RequestMapping("pwModify.do")
	public String pwModifyForm() {
		return "/studentinfo/pwmodify.jsp";
	}
	
	@RequestMapping(value="pwModifyPro.do", method=RequestMethod.POST)
	public ModelAndView pwModifyPro(HttpServletRequest request, 
			HttpSession session,
			HttpServletResponse response,
			@ModelAttribute Member memberDto) {

		Member member = new Member();
		member.setPassword(memberDto.getPassword());
		member.setStudentNumber(memberDto.getStudentNumber());
		int result=memberDao.changePw(member);
		System.out.println("update : "+result);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/studentinfo/pwmodifypro.jsp");
		return mv;
	}

	public boolean isConfirmPw() {
		return isConfirmPw;
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
}

