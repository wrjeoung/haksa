package notice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NoticeController {

	@RequestMapping("noticeList.do")
	public String form(){
		return "notice/noticeList.jsp";
	}	
	
}
