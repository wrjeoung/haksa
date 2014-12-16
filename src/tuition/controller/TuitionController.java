package tuition.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Member;
import model.Tuition;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import dao.MemberDao;
import dao.TuitionDao;

@Controller
public class TuitionController {
	TuitionDao tuitionDao;
	private MemberDao memberDao;
	
	@RequestMapping("tuition.do")
	public String form(HttpServletRequest request,HttpSession session) {
		
		List<Tuition> list=null;
		Member member;
		member=memberDao.selectMember((String)session.getAttribute("memId"));
		list=tuitionDao.getTuitionList();
		request.setAttribute("list", list);
		request.setAttribute("member", member);

		return "/tuition/tuition.jsp";
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