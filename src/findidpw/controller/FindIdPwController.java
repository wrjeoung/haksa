package findidpw.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpServletRequest;

import model.Member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.MemberDao;

@Controller
public class FindIdPwController {
	
	private MemberDao memberDao;
	
	@RequestMapping("findIdPwForm.do")
	public String findIdPwForm() {
		return "findidpw/findIdPwForm.jsp";
	}
	
	@RequestMapping("findIdPwPro.do")
	public String findIdPwPro(
			@ModelAttribute Member memberDto,
			HttpServletRequest request) {
		int check = 0;
		String id;
		
		Map params = new HashMap<>();
		String hp = memberDto.getHp1()+"-"+memberDto.getHp2()+"-"+memberDto.getHp3();
		
		System.out.println("findIdPw name : "+memberDto.getName());
		System.out.println("findIdPw hp1 : "+hp);
		System.out.println("findIdPw email : "+memberDto.getEmail());
		System.out.println("findIdPw selected : "+request.getParameter("selected"));
		
		params.put("cellphone", hp);
		params.put("name", memberDto.getName());
		params.put("email", memberDto.getEmail());
		
		Member member;
		member=(Member)memberDao.selectIdPw(params);
		if(((String)request.getParameter("selected")).equals("1"))
		{
			if(member==null)
				check=0;
			else
			{
				id=member.getStudentNumber();
				request.setAttribute("id", id);
				check=1;
			}
		}
		else if(((String)request.getParameter("selected")).equals("2"))
		{
			//check = member != null ? sendMail(member) : 0;
			if(member!=null)
				check=sendMail(member);
			else
				check=0;
		}
		request.setAttribute("selected", request.getParameter("selected"));
		request.setAttribute("check", Integer.valueOf(check));
		return "findidpw/findIdPwPro.jsp"; 
	}
	
	public int sendMail(Member member) {
		int result = 1;
		String host = "smtp.gmail.com";//smtp 서버
		String subject = member.getName()+" 님 회원정보 입니다.";
		String fromName = "관리자";
		String from = "ranser7@gmail.com";//보내는 메일
		String to1 = member.getEmail();
		
		String content = "아이디 : "+member.getStudentNumber()+"<br/> 패스워드 : "+member.getPassword();
		
		try{
		Properties props = new Properties();
        // G-Mail SMTP 사용시
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", host);
        props.setProperty("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.auth", "true");
		
        Session mailSession = Session.getInstance(props,
        		  new javax.mail.Authenticator() {
        			protected PasswordAuthentication getPasswordAuthentication() {
        				return new PasswordAuthentication("ranser7", "opentest");
        			}
        });
    
        Message msg = new MimeMessage(mailSession);
        msg.setFrom(new InternetAddress(from, MimeUtility.encodeText(fromName,"UTF-8","B")));//보내는 사람 설정
        
        InternetAddress[] address1 = {new InternetAddress(to1)};
        msg.setRecipients(Message.RecipientType.TO, address1);//받는 사람설정1
        msg.setSubject(subject);// 제목 설정
        msg.setSentDate(new java.util.Date());// 보내는 날짜 설정
        msg.setContent(content,"text/html;charset=euc-kr"); // 내용 설정 (HTML 형식)
        
        Transport.send(msg); // 메일 보내기
		}catch(MessagingException e) {
			result = -1;
			e.printStackTrace();
		}catch(Exception e) {
			result = -1;
			e.printStackTrace();
		}
		return result;
	}
	

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	
}
