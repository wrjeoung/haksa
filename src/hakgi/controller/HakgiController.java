package hakgi.controller;

import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import model.Sungjuk;
import dao.HakgiDao;
import model.Registerclass;

@Controller
public class HakgiController {
	private HakgiDao hakgiDao;

	@RequestMapping("hakgi.do")
	public String form(HttpServletRequest request) {
		List<Sungjuk> list = null;
		HashMap params = new HashMap();
		
		params.put("year", 2013);
		params.put("hakgi", 1);
		
		list = hakgiDao.getSungjuklist(params);
		
		for(Object a : list)
		{
	
		}
		
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
