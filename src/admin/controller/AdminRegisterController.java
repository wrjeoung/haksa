package admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Registerclass;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import common.pagingAction;
import dao.RegisterclassDao;

@Controller
public class AdminRegisterController {

	private RegisterclassDao registerclassDao;
	private int currentPage = 1;
	private int blockCount = 5;
	private int blockPage = 5;
	private String pagingHtml;
	private pagingAction page;
	
	@RequestMapping("adminRegisterEnglish.do")
	public String form(
			HttpSession session,
			HttpServletRequest request){
		List<Registerclass> list = null;
		int totalCount;
		list = registerclassDao.getTotalList();
		totalCount = list.size();
		System.out.println("totalCount : " + totalCount);
		
		if(request.getParameter("currentPage") == null){
			currentPage = 1;
		}else{ 
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		page = new pagingAction(currentPage, totalCount, blockCount, blockPage, "adminRegisterEnglish");
		pagingHtml = page.getPagingHtml().toString();
		
		int lastCount = totalCount;
		if(page.getEndCount()<totalCount)
			lastCount=page.getEndCount()+1;
		
		list=list.subList(page.getStartCount(), lastCount);
		
		request.setAttribute("list", list);
		request.setAttribute("currentPage",currentPage);
		request.setAttribute("pagingHtml",pagingHtml);
		
		return "adminRegister/adminRegisterEnglish.jsp";
	}
	
	@RequestMapping("adminRegisterMain.do")
	public String adminMain(){
		
		
		return "adminRegister/adminRegisterMain.jsp";
	}
	
	@RequestMapping("adminRegisterAdd.do")
	public String add(){
		return "adminRegister/adminRegisterAdd.jsp";
	}
	
	@RequestMapping("adminRegisterAddPro.do")
	public String addPro(@ModelAttribute Registerclass registerclass){
		registerclassDao.insertRegisterclass(registerclass);
		return "adminRegister/adminRegisterAddPro.jsp";
	}

	public void setRegisterclassDao(RegisterclassDao registerclassDao) {
		this.registerclassDao = registerclassDao;
	}	
}
