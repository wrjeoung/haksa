package hakgi.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import model.Member;
import model.Sungjuk;
import model.Registerclass;
import dao.HakgiDao;
import dao.MemberDao;
import dao.RegisterclassDao;


@Controller
public class HakgiController {
	private HakgiDao hakgiDao;
	private RegisterclassDao registerclassDao; 
	private MemberDao memberDao;
	int totalCount;
	@RequestMapping("hakgi.do")
	public String form(HttpSession session,			
			HttpServletRequest request) {
		List<Sungjuk> list = null;
		List<Sungjuk> list2 = null;//년도
		List<Sungjuk> list3 =null;//학기
		List<Sungjuk> list5 =null;//학기
		List<Registerclass> list6 =null;

		Member member;
		member = memberDao.selectMember((String)session.getAttribute("memId"));
		list  = hakgiDao.getSungjuklist();	// 
		list2 = hakgiDao.getAddyearlist(); //
		list3 = hakgiDao.getAddhakgilist();//
		list6 = registerclassDao.getList(member.getStudentNumber()); 		  //누적성적 List
		list5 = registerclassDao.getSumList(member.getStudentNumber()); //총 신청학점.
		totalCount = list6.size();
		System.out.println("리스트6의 총 갯수는? : "+totalCount);
		request.setAttribute("member", member);
		request.setAttribute("list3", list3);
		request.setAttribute("list2", list2);
		request.setAttribute("list", list);
		request.setAttribute("list5", list5);
		request.setAttribute("list6", list6);
		request.setAttribute("totalCount", totalCount);
		
		System.out.println();
		return "hakgisung/hakgi.jsp";		
	}

	public RegisterclassDao getRegisterclassDao() {
		return registerclassDao;
	}


	public void setRegisterclassDao(RegisterclassDao registerclassDao) {
		this.registerclassDao = registerclassDao;
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
