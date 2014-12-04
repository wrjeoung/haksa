package loginout.controller;

import java.util.HashMap;
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
public class LogInOutController {
	private MemberDao memberDao;
	
	@RequestMapping("loginOutPro.do")
	public ModelAndView formPro(HttpServletRequest request, 
								HttpSession session,
								HttpServletResponse response,
								@ModelAttribute Member memberDto) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", memberDto.getStudentNumber());
		params.put("pw", memberDto.getPassword());
		
		int loginCheck=0;
		int invalid=0;
		if((String)session.getAttribute("memId")!=null)
		{
			session.removeAttribute("memId");
		}
		else
		{
			loginCheck = memberDao.loginCheck(params);
			if(loginCheck==1)
				session.setAttribute("memId", memberDto.getStudentNumber());
			else
				invalid=1;
		}
		System.out.println("loginCheck : "+loginCheck);
				
		ModelAndView mv = new ModelAndView();
		mv.addObject("invalid",invalid);
		mv.setViewName("/loginout/loginout.jsp");
		return mv;
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

}
