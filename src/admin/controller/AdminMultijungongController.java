package admin.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Multijungong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.AdminMultijungongDao;

@Controller
public class AdminMultijungongController {
	private AdminMultijungongDao adminMultijungongDao;
	Calendar today=Calendar.getInstance();

	@RequestMapping("/adminmultijungongList.do")
	public String form1(HttpServletRequest request){
		List<Multijungong> list=null;
		list=adminMultijungongDao.getAdminMultijungongList();
		request.setAttribute("list", list);
		return "/adminmultijungong/adminMultijungongForm.jsp";
	}
	@RequestMapping("adminmultijungongUpdateCom.do")
	public String UpdateCom(HttpServletRequest request){
		String[] rnum=request.getParameterValues("rnum");
		for(int i=0;i<rnum.length;i++){
			String value=rnum[i];
			adminMultijungongDao.updatecomAdminMultijungong(value);
		}
		return "redirect:/adminmultijungongList.do";
	}
	@RequestMapping("adminmultijungongUpdateCan.do")
	public String UpdateCan(HttpServletRequest request){
		String[] rnum=request.getParameterValues("rnum");
		for(int i=0;i<rnum.length;i++){
			String value=rnum[i];
			adminMultijungongDao.updatecanAdminMultijungong(value);
		}
		return "redirect:/adminmultijungongList.do";
	}
	@RequestMapping("adminmultijungongDelete.do")
	public String Delete(HttpServletRequest request){
		String[] rnum=request.getParameterValues("rnum");
		for(int i=0;i<rnum.length;i++){
			String value=rnum[i];
			adminMultijungongDao.deleteAdminMultijungong(value);
		}
		return "redirect:/adminmultijungongList.do";
	}
	@RequestMapping("adminmultijungongmodify.do")
	public String infoModify(HttpServletRequest request){
		int num=Integer.parseInt(request.getParameter("num"));
		Multijungong multijungong;
		multijungong=adminMultijungongDao.getAdminMultijungong(num);
		request.setAttribute("multijungong", multijungong);
		return "/adminmultijungong/adminMultijungongModifyform.jsp";
	}
	@RequestMapping("adminmultijungonginfoPro.do")
	public ModelAndView Modify(@ModelAttribute Multijungong multijungong,HttpServletRequest request){
		multijungong.setMulti_reg_date(today.getTime());
		adminMultijungongDao.changeAdminMultijungong(multijungong);
		ModelAndView mv=new ModelAndView();
		mv.addObject("multijungong", multijungong);
		mv.setViewName("redirect:/adminmultijungongList.do");
		return mv;
	}
	
	public AdminMultijungongDao getAdminMultijungongDao() {
		return adminMultijungongDao;
	}
	public void setAdminMultijungongDao(AdminMultijungongDao adminMultijungongDao) {
		this.adminMultijungongDao = adminMultijungongDao;
	}
}
