package notice.controller;

import javax.servlet.http.HttpServletRequest;
import model.Notice;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import dao.NoticeDao;

@Controller
public class NoticeWriteController {
	private NoticeDao noticeDao;
	
	@RequestMapping("noticeWrite.do")
	public String write(HttpServletRequest request)
	{
		request.setAttribute("currentPage",request.getParameter("currentPage"));
		return "notice/noticeWrite.jsp";
	}
	
	@RequestMapping("noticeWritePro.do")
	public String writePro(@ModelAttribute Notice notice)
	{
		noticeDao.insertNotice(notice);
		return "redirect:/noticeList.do";
	}
	
	public NoticeDao getNoticeDao() {
		return noticeDao;
	}

	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}		
}
