package notice.controller;

import javax.servlet.http.HttpServletRequest;

import model.Notice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.NoticeDao;

@Controller
public class NoticeModifyController {
	private NoticeDao noticeDao;
	
	@RequestMapping("noticeModify.do")
	public String write(HttpServletRequest request)
	{
		int num = Integer.parseInt(request.getParameter("num"));
		
		Notice notice = noticeDao.getNotice(num);
		
		request.setAttribute("notice", notice);
		return "notice/noticeModify.jsp";
	}
	
	@RequestMapping("noticeModifyPro.do")
	public String writePro(@ModelAttribute Notice notice)
	{
		noticeDao.updateNotice(notice);
		return "redirect:/noticeList.do";
	}
	
	public NoticeDao getNoticeDao() {
		return noticeDao;
	}

	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}	
}
