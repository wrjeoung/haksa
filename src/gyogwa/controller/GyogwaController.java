package gyogwa.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import dao.GyogwaDao;

@Controller
public class  GyogwaController{
	private GyogwaDao gyogwaDao;
	
	@RequestMapping("gyogwa.do")
	public String form(HttpServletRequest request) {
		return "gyogwa/gyogwa.jsp";
	}
	
	public GyogwaDao getGyogwaDao() {
		return gyogwaDao;
	}
	public void setGyogwaDao(GyogwaDao gyogwaDao) {
		this.gyogwaDao = gyogwaDao;
	}

	
}
