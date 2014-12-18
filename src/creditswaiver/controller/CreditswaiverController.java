package creditswaiver.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Hakgi;
import model.Member;
import model.Sungjuk;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.net.httpserver.HttpServer;

import dao.CreditwaiverDao;
import dao.MemberDao;

@Controller
public class CreditswaiverController {
	private CreditwaiverDao creditwaiverDao;
	private Hakgi hakgi;
	private MemberDao memberDao;
	int totalCount;
	@RequestMapping("creditwaiver.do")
	public String form(HttpSession session,HttpServletRequest request){
		List<Hakgi> list=null;
		List<Sungjuk> list2=null;
		List<Sungjuk> list3=null;
		List<Hakgi> list5=null;
		HashMap params=new HashMap();
		
		Member member;
		member=memberDao.selectMember((String)session.getAttribute("memId"));
		
		Hakgi hakgi;
		hakgi=creditwaiverDao.selectCredits(request.getParameter("subjectnum"));
		
		params.put("stnumber", member.getStudentNumber());
		
		list=creditwaiverDao.getHakgilist(params);
		list2=creditwaiverDao.getAddyearlist();
		list3=creditwaiverDao.getAddhakgilist();
		list5=creditwaiverDao.getTotalList(params);
		
		totalCount=list.size();
		
		request.setAttribute("member", member);
		request.setAttribute("hakgi", hakgi);
		request.setAttribute("list", list);
		request.setAttribute("list2", list2);
		request.setAttribute("list3", list3);
		request.setAttribute("list5", list5);
		request.setAttribute("totalCount", totalCount);
		return "/Creditswaiver/credits.jsp";
		
	}
	//삭제
	@RequestMapping("creditswaiverdelete.do")
	public String Delete(HttpServletRequest request){
		String subjectnum=request.getParameter("subjectnum");
		//Hakgi hakgi;
		//hakgi=creditwaiverDao.selectCredits(subjectnum);
		creditwaiverDao.deleteCredits(subjectnum);
		//request.setAttribute("hakgi", hakgi);
		return "redirect:/creditwaiver.do";
	}
	//삭제 전 상세보기
	@RequestMapping("creditsView.do")
	public String View(HttpServletRequest request,HttpSession session){
		String subjectnum=request.getParameter("subjectnum");
		Member member;
		member=memberDao.selectMember((String)session.getAttribute("memId"));
		Hakgi hakgi=creditwaiverDao.selectCredits(subjectnum);
		request.setAttribute("hakgi", hakgi);
		request.setAttribute("member", member);
		return "/Creditswaiver/creditsView.jsp";
	}
	
	public CreditwaiverDao getCreditwaiverDao() {
		return creditwaiverDao;
	}
	public void setCreditwaiverDao(CreditwaiverDao creditwaiverDao) {
		this.creditwaiverDao = creditwaiverDao;
	}
	public Hakgi getHakgi() {
		return hakgi;
	}
	public void setHakgi(Hakgi hakgi) {
		this.hakgi = hakgi;
	}
	public MemberDao getMemberDao() {
		return memberDao;
	}
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
}
	