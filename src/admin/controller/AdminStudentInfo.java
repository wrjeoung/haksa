package admin.controller;

import javax.servlet.http.HttpServletRequest;

import model.Member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.MemberDao;

@Controller
public class AdminStudentInfo {
	private MemberDao memberDao;
	private Member member;
	
	@RequestMapping("inputstudentinfo.do")
	public String inputStudentInfo() {
		return "admin/inputStudentInfo.jsp";
	}
	
	@RequestMapping("inputStudentInfoPro.do")
	public String inputStudentInfoPro(
			@ModelAttribute Member memberDto) {
		memberDao.insertMember(memberDto);
//		System.out.println("inputStudentInfoPro "+memberDto.getEntrace_date());
		
		return "admin/inputStudentInfoPro.jsp";
	}
	
	@RequestMapping("checkStdInfo.do")
	public String checkStdInfo() {
		return "admin/checkStdInfo.jsp";
	}
	
	@RequestMapping("checkStdInfoPro.do")
	public String checkStdInfoPro(
			@ModelAttribute Member memberDto,
			HttpServletRequest request) {
		boolean isStdInfoExist=false;
		member=memberDao.selectMember(memberDto.getStudentNumber());
		isStdInfoExist = member == null ? false : true;
		request.setAttribute("isStdInfoExist", isStdInfoExist);
		return "admin/checkStdInfoPro.jsp";
	}
	
	@RequestMapping("modifyStdInfo.do")
	public String modifyStdInfo(
			HttpServletRequest request) {
		String []cellphone = member.getCellphone().split("-");
		String []tel = member.getTel().split("-");
		
		for(int i=0; i<cellphone.length; i++)
		{
			request.setAttribute("cellphone"+i, cellphone[i]);
			request.setAttribute("tel"+i, tel[i]);
		}
		request.setAttribute("member", member);
		return "admin/modifyStdInfo.jsp";
	}
	
	@RequestMapping("modifyStdInfoPro.do")
	public String modifyStdInfoPro(@ModelAttribute Member memberDto	) 
	{
		memberDao.updateMember(memberDto);
		return "admin/modifyStdInfoPro.jsp";
	}	
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
}
