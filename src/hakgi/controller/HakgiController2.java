package hakgi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.corba.se.spi.legacy.connection.GetEndPointInfoAgainException;

import model.Sungjuk;
import dao.HakgiDao;

@Controller
public class HakgiController2 {
	private HakgiDao hakgiDao;

	

	@RequestMapping("hakgi2.do")
	public String form(HttpServletRequest request,@ModelAttribute Sungjuk sungjuk) {
		
		List<Sungjuk> list = null;
		List<Sungjuk> list2 = null;//년도
		List<Sungjuk> list3 =null;//학기
		List<Sungjuk> list4 =null;
		Map<String, String> params = new HashMap<String, String>();
		

		
		list = hakgiDao.getSungjuklist();
		list2 = hakgiDao.getAddyearlist(); //년도
		list3 = hakgiDao.getAddhakgilist();//학기
				

//		params.put("year", list2.);
		
		

		params.put("year", "2013");
		params.put("hakgi", "2"); 
		list4 = hakgiDao.getSuperlist(params);
		
		request.setAttribute("list4", list4);
		request.setAttribute("list3", list3);
		request.setAttribute("list2", list2);
		System.out.println("hakgi2.do list2 year = "+list2);
		System.out.println("hakgi2.do list3 hakgi = "+list3.size());
		System.out.println("hakgi2.do list4 = "+list4);
		request.setAttribute("list", list);
		 
		return "hakgisung/hakgi2.jsp";
		
	}
	
	public HakgiDao getHakgiDao() {
		return hakgiDao;
	}

	public void setHakgiDao(HakgiDao hakgiDao) {
		this.hakgiDao = hakgiDao;
	}
	
	
}
