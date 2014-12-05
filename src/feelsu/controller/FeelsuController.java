package feelsu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import dao.FeelsuDao;
@Controller
public class  FeelsuController{
	private FeelsuDao feelsuDao;
	@RequestMapping("feelsu.do")
	public String form() {
		
		return "/feelsu/feelsu.jsp";
		
	}
	public FeelsuDao getFeelsuDao() {
		return feelsuDao;
	}
	public void setFeelsuDao(FeelsuDao feelsuDao) {
		this.feelsuDao = feelsuDao;
	}
	
	
}
