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
	private int currentPage=1;	//����������
	private int blockCount=10;	//�� �������� �Խù��� ��
	private int blockPage=5;	//�� ȭ�鿡 ������ ������ ��
	private String pagingHtml;	//����¡�� ������ HTMl
	private pagingAction page;	//����¡ Ŭ����  
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
		pagingHtml=page.getPagingHtml().toString();	//������ HTML ����
		
		//���� ���������� ������ ������ ���� ��ȣ ����
		int lastCount=totalCount;
		
		//���� �������� ������ ���� ��ȣ�� ��ü�� ������ �ۺ��� ������ lastCount�� +1 ��ȣ�� ����
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
