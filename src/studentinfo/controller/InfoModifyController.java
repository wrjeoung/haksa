package studentinfo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.MemberDao;

@Controller
public class InfoModifyController {
	private MemberDao memberDao;

	@RequestMapping("infomodify.do")
	public String pwCheckform(
			HttpSession session,
			HttpServletRequest request){
			
			Member member;
			member = memberDao.selectMember((String)session.getAttribute("memId"));
//			System.out.println("InfoModifycontorller id : "+member.getStudentNumber());
//			System.out.println("InfoModifycontorller pw : "+member.getPassword());
//			System.out.println("InfoModifycontorller date : "+member.getEntrace_date());
//			System.out.println("InfoModifycontorller major : "+member.getMajor());
			request.setAttribute("member", member);
		return "/studentinfo/infomodify.jsp";
	}
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
}
