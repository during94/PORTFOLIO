package com.green.biz.view.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.green.biz.recontent.RecontentService;
import com.green.biz.recontent.RecontentVO;
import com.green.biz.test.testVO;


@Controller
@SessionAttributes("loginUser")
public class testController {
	
	@RequestMapping(value="test")
	public String test() {
		
		return "test";
	}
	
	@RequestMapping(value="test2", method = RequestMethod.GET)
	public String test2(testVO vo) {
		
		return "test2";
	}
	
	@RequestMapping(value="requestObject", method = RequestMethod.POST)
	@ResponseBody
	/*
	public Map<String,Object> ajax(HttpServletRequest request) throws Exception {
		
		String firstArg = request.getParameter("test1");
		String secondArg = request.getParameter("test2");
		
		System.out.println(firstArg + "/" +secondArg);
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("test1", firstArg);
		map.put("test1", secondArg);
		*/
	public Map<String,Object> simpleWithObject(@RequestBody testVO vo) {
		
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("name", vo.getName());
			map.put("age", vo.getAge());
		return map;
	}
	
	@Autowired
	private RecontentService recontentService;
	
	
	
	
	@RequestMapping(value="test_list" , method = RequestMethod.GET)
	public Object find_all_recontent(@RequestBody RecontentVO vo, Model model){
		
		List<RecontentVO> recontent = recontentService.find_all_recontent(vo);
		
        return recontent;
	}
	
}


