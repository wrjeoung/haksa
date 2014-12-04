package notice.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Notice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.NoticeDao;
import common.pagingAction; 

@Controller
public class NoticeController {
	private NoticeDao noticeDao;
	private int currentPage=1;	//현재페이지
	private int blockCount=10;	//한 페이지의 게시물의 수
	private int blockPage=5;	//한 화면에 보여줄 페이지 수
	private String pagingHtml;	//페이징을 구현한 HTMl
	private pagingAction page;	//페이징 클래스  
	private int searchType;
	private String searchWord;

	@RequestMapping("noticeList.do")
	public String List(HttpServletRequest request){
		List<Notice> list = null;
		int totalCount;
		
		if(request.getParameter("searchType") == null) {
			searchType = -1;
		}
		else {
			searchType = Integer.parseInt(request.getParameter("searchType"));
			searchWord = request.getParameter("searchWord");
		}
			
		list = noticeDao.getNoticeList(searchType,searchWord);
		totalCount = list.size();
		if(request.getParameter("currentPage") == null) {
			currentPage = 1;
		}
		else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		page=new pagingAction(currentPage, totalCount, blockCount, blockPage, "noticeList");
		pagingHtml=page.getPagingHtml().toString();	//페이지 HTML 생성
		
		//현재 페이지에서 보여줄 마지막 글의 번호 설정
		int lastCount=totalCount;
		
		//현재 페이지의 마지막 글의 번호가 전체의 마지막 글보다 작으면 lastCount를 +1 번호로 설정
		if(page.getEndCount()<totalCount)
			lastCount=page.getEndCount()+1;
		
		list=list.subList(page.getStartCount(), lastCount);
				
		request.setAttribute("list", list);
		request.setAttribute("totalCount", totalCount);
		request.setAttribute("currentPage",currentPage);
		request.setAttribute("pagingHtml",pagingHtml);
		if(searchType != -1)
		{
			request.setAttribute("searchType",searchType);
			request.setAttribute("searchWord",searchWord);
		}
		return "notice/noticeList.jsp";
	}	
	
	@RequestMapping("noticeView.do")
	public String View(HttpServletRequest request){
		int num = Integer.parseInt(request.getParameter("num"));
		
		noticeDao.updateReadCount(num);
		Notice notice = noticeDao.getNotice(num);

		request.setAttribute("notice", notice);
		request.setAttribute("currentPage",request.getParameter("currentPage"));
		return "notice/noticeView.jsp";
	}		
	
	public NoticeDao getNoticeDao() {
		return noticeDao;
	}

	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}	
}
