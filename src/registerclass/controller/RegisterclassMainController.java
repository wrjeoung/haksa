package registerclass.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Member;
import model.Registerclass;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import common.pagingAction;
import dao.MemberDao;
import dao.RegisterclassDao;

@Controller
public class RegisterclassMainController {

	private RegisterclassDao registerclassDao;
	private MemberDao	memberDao;
	private int currentPage = 1;  // 현재페이지
	private int blockCount = 5;   // 한 페이지의 게시물의 수
	private int blockPage = 5;    // 한 화면에 보여줄 페이지 수
	private String pagingHtml;    // 페이징을 구현한 HTML
	private pagingAction page;    // 페이징 클래스
	
	@RequestMapping("registerclass.do")
	public String form(
			HttpSession session,
			HttpServletRequest request){
		List<Registerclass> list = null;
		HashMap params = new HashMap();
		int totalCount;
		String gradej = "전선";
		
		Member member;
		member = memberDao.selectMember((String)session.getAttribute("memId"));
		
		params.put("major", member.getMajor());
		params.put("grade", member.getGrade());
		params.put("gradeJ", gradej);
		list = registerclassDao.getRegisterclassList(params);
		totalCount = list.size();
		System.out.println("totalCount : " + totalCount);
		
		if(request.getParameter("currentPage") == null){
			currentPage = 1;
		}else{
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		page = new pagingAction(currentPage, totalCount, blockCount, blockPage, "registerclass");
		pagingHtml = page.getPagingHtml().toString();  // 페이지 HTML 생성
		
		//현재 페이지에서 보여줄 마지막 글의 번호 설정
		int lastCount = totalCount;
		
		//현재 페이지의 마지막 글의 번호가 전체의 마지막 글보다 작으면 lastCount를 +1 번호로 설정
		if(page.getEndCount()<totalCount)
			lastCount=page.getEndCount()+1;
		
		list=list.subList(page.getStartCount(), lastCount);
		/*
		for(Object a : list)
		{
			System.out.println(((Registerclass)a).getSubjectnum());
		}*/
		request.setAttribute("list", list);
		request.setAttribute("member", member);
		request.setAttribute("currentPage",currentPage);
		request.setAttribute("pagingHtml",pagingHtml);
		return "registerclass/main.jsp";
		
	}

	public RegisterclassDao getRegisterclassDao() {
		return registerclassDao;
	}

	public void setRegisterclassDao(RegisterclassDao registerclassDao) {
		this.registerclassDao = registerclassDao;
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
}