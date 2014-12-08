package hakgi.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import model.Member;
import model.Sungjuk;
import dao.HakgiDao;
import dao.MemberDao;

@Controller
public class HakgiController {

	private HakgiDao hakgiDao;
	private MemberDao memberDao;
	@RequestMapping("hakgi.do")
	public String form(HttpSession session,			
			HttpServletRequest request) {
		List<Sungjuk> list = null;
		List<Sungjuk> list2 = null;//년도
		List<Sungjuk> list3 =null;//학기
		
		Member member;
		member = memberDao.selectMember((String)session.getAttribute("memId"));
		 
		list = hakgiDao.getSungjuklist();
		list2 = hakgiDao.getAddyearlist();
		list3 = hakgiDao.getAddhakgilist();

		request.setAttribute("member", member);
		request.setAttribute("list3", list3);
		request.setAttribute("list2", list2);
		request.setAttribute("list", list);
		
		return "hakgisung/hakgi.jsp";		
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
