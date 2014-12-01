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
	private int blockCount=5;	//�� �������� �Խù��� ��
	private int blockPage=5;	//�� ȭ�鿡 ������ ������ ��
	private String pagingHtml;	//����¡�� ������ HTMl
	private pagingAction page;	//����¡ Ŭ����  
	

	@RequestMapping("noticeList.do")
	public String form(HttpServletRequest request){
		List<Notice> list = null;
		int totalCount;
		
		list = noticeDao.getNoticeList();
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
		request.setAttribute("currentPage",currentPage);
		request.setAttribute("pagingHtml",pagingHtml);
		return "notice/noticeList.jsp";
	}	
	
	public NoticeDao getNoticeDao() {
		return noticeDao;
	}

	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}	
}
