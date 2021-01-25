package com.green.biz.view.Controller;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.green.biz.recontent.RecontentService;
import com.green.biz.recontent.RecontentVO;

@Controller
@SessionAttributes("loginUser")
public class RecontentController {

	@Autowired
	private RecontentService recontentService;
	
	@ResponseBody
	@RequestMapping(value="list_recontent", method = RequestMethod.GET, produces="application/json; charset=utf8")
	public List<RecontentVO> find_all_recontent(RecontentVO vo, Model model){
		
	        List<RecontentVO> recontent = recontentService.find_all_recontent(vo);
	        for(int i = 0; i<recontent.size(); i++) {
	        	System.out.println(recontent.get(i));
	        }
	        model.addAttribute("recontentlist", recontent);
	        
	        return recontent;
	}
	
	@ResponseBody
	@RequestMapping(value="re_recontent", method = RequestMethod.POST, produces="application/json; charset=utf8")
	public Object find_re_number(RecontentVO vo, Model model){
		
		RecontentVO recontent = recontentService.find_re_number(vo);
		
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("re_number", recontent.getRe_number());
		map.put("re_num", recontent.getRe_num());
		map.put("re_content", recontent.getRe_content());
		
	    		
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="insert_recontent")
	public Object insert_recontent(@RequestBody RecontentVO vo, Model model){
		
		recontentService.insert_recontent(vo);
		
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("re_num", vo.getRe_num());
		
		return map;
		
	}
	
	@ResponseBody
	@RequestMapping(value="delete_recontent", method = RequestMethod.POST)
	public int delete_recontent(RecontentVO vo) {
		System.out.println("성공");
		recontentService.delete_recontent(vo);
		
		return 1;
		
	}
	
	@ResponseBody
	@RequestMapping(value="update_recontent", method = RequestMethod.POST)
	public int update_recontent(RecontentVO vo) {
		System.out.println("업데이트 성공");
		
		recontentService.update_recontent(vo);
		
		return 1;
	}
}
