package janghak.controller;

import javax.servlet.http.HttpServletRequest;

import model.Janghak;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.JanghakDao;

@Controller
public class ViewJanghakController {
	private JanghakDao janghakDao;

	@RequestMapping("janghakView.do")
	public String View(HttpServletRequest request){
		int num=Integer.parseInt(request.getParameter("num"));
		
		Janghak janghak=janghakDao.getJanghak(num);
		request.setAttribute("janghak", janghak);
		
		return "/janghak/JanghakView.jsp";
	}
	
	public JanghakDao getJanghakDao() {
		return janghakDao;
	}

	public void setJanghakDao(JanghakDao janghakDao) {
		this.janghakDao = janghakDao;
	}
}
