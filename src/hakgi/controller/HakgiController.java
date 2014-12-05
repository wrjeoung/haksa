package hakgi.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import model.Sungjuk;
import dao.HakgiDao;

@Controller
public class HakgiController {
	private HakgiDao hakgiDao;

	@RequestMapping("hakgi.do")
	public String form(HttpServletRequest request) {
		List<Sungjuk> list = null;
		List<Sungjuk> list2 = null;//년도
		List<Sungjuk> list3 =null;//학기
		
		list = hakgiDao.getSungjuklist();
		list2 = hakgiDao.getAddyearlist();
		list3 = hakgiDao.getAddhakgilist();
	
		request.setAttribute("list3", list3);
		request.setAttribute("list2", list2);
		request.setAttribute("list", list);
		
		return "hakgisung/hakgi.jsp";
		
	}

	
	public HakgiDao getHakgiDao() {
		return hakgiDao;
	}

	public void setHakgiDao(HakgiDao hakgiDao) {
		this.hakgiDao = hakgiDao;
	}
	
	
}
