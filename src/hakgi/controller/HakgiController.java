package hakgi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Member;
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

	@RequestMapping("hakgi2.do")
	public String form2(HttpServletRequest request,@ModelAttribute Sungjuk sungjuk) {
		
		List<Sungjuk> list = null;
		List<Sungjuk> list2 = null;//년도
		List<Sungjuk> list3 =null;//학기
		List<Sungjuk> list4 =null;
		Map<String, String> params = new HashMap<String, String>();
		

		list4 = hakgiDao.getSuperlist(params);
		list = hakgiDao.getSungjuklist();
		list2 = hakgiDao.getAddyearlist();
		list3 = hakgiDao.getAddhakgilist();
		
	
		params.put("hakgi", "1"); 
		list4 = hakgiDao.getSuperlist(params);
		request.setAttribute("list4", 2014);
		
		request.setAttribute("list3", list3);
		request.setAttribute("list2", list2);
		System.out.println("hakgi2.do year = "+list4);
		System.out.println("hakgi2.do hakgi = "+list2);
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
