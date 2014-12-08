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
	private int currentPage = 1;  // ����������
	private int blockCount = 5;   // �� �������� �Խù��� ��
	private int blockPage = 5;    // �� ȭ�鿡 ������ ������ ��
	private String pagingHtml;    // ����¡�� ������ HTML
	private pagingAction page;    // ����¡ Ŭ����
	
	@RequestMapping("registerclass.do")
	public String form(
			HttpSession session,
			HttpServletRequest request){
		List<Registerclass> list = null;
		HashMap params = new HashMap();
		int totalCount;
		String gradej = "��";
		
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
		pagingHtml = page.getPagingHtml().toString();  // ������ HTML ��
		
		//���� ���������� ������ ������ ���� ��ȣ ����
		int lastCount = totalCount;
		
		//���� �������� ������ ���� ��ȣ�� ��ü�� ������ �ۺ��� ������ lastCount�� +1 ��ȣ�� ����
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