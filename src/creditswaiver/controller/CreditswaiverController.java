package creditswaiver.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Member;
import model.Registerclass;
import model.Sungjuk;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.CreditDao;
import dao.HakgiDao;
import dao.MemberDao;
import dao.RegisterclassDao;

@Controller
public class CreditswaiverController {
	//private HakgiDao hakgiDao;
	private CreditDao creditDao;
	private RegisterclassDao registerclassDao; 
	private MemberDao memberDao;
	int totalCount;
	@RequestMapping("creditwaiverList.do")
	public String form(HttpSession session,			
			HttpServletRequest request) {
		List<Sungjuk> list = null;
		List<Sungjuk> list2 = null;//년도
		List<Sungjuk> list3 =null;//학기
		List<Sungjuk> list5 =null;//학기
		List<Registerclass> list6 =null;

		Member member;
		member = memberDao.selectMember((String)session.getAttribute("memId"));
		list  = creditDao.getSungjuklist();	// 
		list2 = creditDao.getAddyearlist(); //
		list3 = creditDao.getAddhakgilist();//
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
		return "/Creditswaiver/credits.jsp";		
	}

	public RegisterclassDao getRegisterclassDao() {
		return registerclassDao;
	}


	public void setRegisterclassDao(RegisterclassDao registerclassDao) {
		this.registerclassDao = registerclassDao;
	}


	public CreditDao getCreditDao() {
		return creditDao;
	}

	public void setCreditDao(CreditDao creditDao) {
		this.creditDao = creditDao;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

}
