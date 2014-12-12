package tuition.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.Tuition;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.TuitionDao;

@Controller
public class TuitionController {
	TuitionDao tuitionDao;
	@RequestMapping("tuition.do")
	public String form(HttpServletRequest request) {
		
		List<Tuition> list=null;
		list=tuitionDao.getTuitionList();
		request.setAttribute("list", list);
		return "/tuition/tuition.jsp";
	}
	
	@RequestMapping("noticeWritePro.do")
	public String writePro(@ModelAttribute Tuition tuition)
	{
		tuitionDao.insertTuition(tuition);
		return "redirect:/tuitioninsert.do";
	}
	
	
}



