package hakgi.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Member;
import model.Sungjuk;
import model.Hakgi;
import model.Registerclass;
import dao.HakgiDao;
import dao.MemberDao;
import dao.RegisterclassDao;

@Controller
public class HakgiController {
	private HakgiDao hakgiDao;
	private Hakgi hakgi;
	private RegisterclassDao registerclassDao; 
	private MemberDao memberDao;
	int totalCount;
	@RequestMapping("hakgi.do")
	public String form(HttpSession session,			
		HttpServletRequest request) {
		List<Sungjuk> list2 = null;//년도
		List<Sungjuk> list3 =null;//학기
		List<Hakgi> list5 =null;
		List<Registerclass> list6 =null;
		List<Hakgi> list = null;
		HashMap params = new HashMap(); 
		
		Member member;
		member = memberDao.selectMember((String)session.getAttribute("memId"));
		
		params.put("stnumber", member.getStudentNumber());
		System.out.println("학번은?? : "+ params);

		list = hakgiDao.getHakgilist(params);
		list2 = hakgiDao.getAddyearlist(); //
		list3 = hakgiDao.getAddhakgilist();//
		list6 = hakgiDao.getHakgilist(params);
		list5 = hakgiDao.getTotalList();
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

	public Hakgi getHakgi() {
		return hakgi;
	}

	public void setHakgi(Hakgi hakgi) {
		this.hakgi = hakgi;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

}
