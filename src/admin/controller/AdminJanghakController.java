package admin.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Janghak;
import model.Member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.AdminJanghakDao;
import dao.MemberDao;

@Controller
public class AdminJanghakController {
	private AdminJanghakDao adminJanghakDao;
	Calendar today=Calendar.getInstance();
	private MemberDao memberDao;
	@RequestMapping("/adminjanghakList.do")
	public String form1(HttpServletRequest request){
		List<Janghak> list=null;
		list=adminJanghakDao.getAdminJanghakList();
		request.setAttribute("list", list);
		
		return "/adminjanghak/adminJanghakForm.jsp";
	}
	@RequestMapping("adminjanghakUpdateCom.do")
	public String UpdateCom(HttpServletRequest request){
		String[] rnum=request.getParameterValues("rnum");
		for(int i=0;i<rnum.length;i++){
			String value=rnum[i];
			adminJanghakDao.updatecomAdminJanghak(value);
		}
		return "redirect:/adminjanghakList.do";
	}
	@RequestMapping("adminjanghakUpdateCan.do")
	public String UpdateCan(HttpServletRequest request){
		String[] rnum=request.getParameterValues("rnum");
		for(int i=0;i<rnum.length;i++){
			String value=rnum[i];
			adminJanghakDao.updatecanAdminJanghak(value);
		}
		return "redirect:/adminjanghakList.do";
	}
	//삭제
	@RequestMapping("adminjanghakDelete.do")
	public String Delete(HttpServletRequest request){
		String[] rnum=request.getParameterValues("rnum");
		for(int i=0;i<rnum.length;i++){
			String value=rnum[i];
			adminJanghakDao.deleteAdminJanghak(value);
		}
		return "redirect:/adminjanghakList.do";
	}
	//수정
	@RequestMapping("adminjanghakinfomodify.do")
	public String infoModify(HttpServletRequest request){
		int num=Integer.parseInt(request.getParameter("num"));
		Janghak janghak;
		janghak=adminJanghakDao.getAdminJanghak(num);
		//Member member;
		//member=memberDao.selectMember((String)session.getAttribute("memId"));
		//request.setAttribute("member", member);
		request.setAttribute("janghak", janghak);
		return "/adminjanghak/adminJanghakModifyForm.jsp";
	}
	@RequestMapping("adminjanghakinfoPro.do")
	public ModelAndView Modify(@ModelAttribute Janghak janghak,HttpServletRequest request){
		janghak.setJanghak_reg_date(today.getTime());
		//Member member;
		//member=memberDao.selectMember((String)session.getAttribute("memId"));
		
		adminJanghakDao.changeAdminJanghak(janghak);
		//request.setAttribute("member", member);
		ModelAndView mv=new ModelAndView();
		mv.addObject("janghak", janghak);
		mv.setViewName("redirect:/adminjanghakList.do");
		return mv;
	}
	
	public AdminJanghakDao getAdminJanghakDao() {
		return adminJanghakDao;
	}
	public void setAdminJanghakDao(AdminJanghakDao adminJanghakDao) {
		this.adminJanghakDao = adminJanghakDao;
	}
	public MemberDao getMemberDao() {
		return memberDao;
	}
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
}
