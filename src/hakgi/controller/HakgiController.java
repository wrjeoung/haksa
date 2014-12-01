package hakgi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Sungjuk;
import dao.HakgiDao;
import model.Member;
import model.Sungjuk;
@Controller
public class HakgiController {
	private HakgiDao hakgidao;
	private List<Sungjuk> list = new ArrayList<Sungjuk>();

	public HakgiDao getHakgidao() {
		return hakgidao;
	}
	public void setHakgidao(HakgiDao hakgidao) {
		this.hakgidao = hakgidao;
	}



	

	@RequestMapping("hakgi.do")
	public String form(@ModelAttribute Sungjuk memberDto) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("gwamokcode", memberDto.getGwamokcode());
		params.put("ban", memberDto.getBan());
		params.put("ban", memberDto.getBan());
		params.put("gwamok_nm", memberDto.getGwamok_nm());
		params.put("isugubun", memberDto.getIsugubun());
		params.put("hakjum", memberDto.getHakjum());
		params.put("levels", memberDto.getLevels());
		params.put("bigo", memberDto.getBigo());
		


		
		
		return "/hakgisung/hakgi.jsp";
		
	}
}
