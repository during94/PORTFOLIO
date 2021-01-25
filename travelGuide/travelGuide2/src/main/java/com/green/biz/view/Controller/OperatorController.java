package com.green.biz.view.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.green.biz.Operator.OperatorService;
import com.green.biz.Operator.OperatorVO;
import com.green.biz.UserContent.UserContentService;
import com.green.biz.UserContent.UserContentVO;
import com.green.biz.banner.bannerService;
import com.green.biz.banner.bannerVO;
import com.green.biz.festival_event.eventService;
import com.green.biz.festival_event.eventVO;
import com.green.biz.festival_event.festivalService;
import com.green.biz.festival_event.festivalVO;
import com.green.biz.util.PageMaker;
import com.green.biz.util.SearchCriteria;

@Controller
@SessionAttributes("operatorUser")
public class OperatorController {
	
	@Autowired
	private OperatorService operatorService;
	
	@Autowired
	private UserContentService contentService;
	
	@Autowired
	private eventService eventService;
	
	@Autowired
	private festivalService festivalService;
	
	@Autowired
	private bannerService bannerService;
	
	@RequestMapping(value="oper_login_form", method = RequestMethod.GET)
	public String oper_form() {
		return "Admin/admin_login_form";
	}
	
	@RequestMapping(value="oper_login", method = RequestMethod.POST)
	public String oper_login_form(OperatorVO vo, Model model) {
		
		OperatorVO operatorUser = operatorService.getOperator(vo);
		
		if(operatorUser != null) {
			model.addAttribute("operatorUser", operatorUser);
			
			return "redirect: banner";
		} else {
			return "Admin/admin_login_fail";
		}
	}
	
	@RequestMapping(value="oper_logout")
	public String oper_logout(SessionStatus session) {
		
		session.setComplete();
		
		return "redirect: oper_login_form";
	}
	
	@RequestMapping(value="banner")
	public String oper_banner_form(HttpSession session, Model model, bannerVO vo) {
		
		OperatorVO operatorUser = (OperatorVO)session.getAttribute("operatorUser");
		
		if(operatorUser == null) {
			return "Admin/admin_login_form";
		} else {
		
			List<bannerVO> banner= bannerService.banner_list(vo);
			
			model.addAttribute("bannerList", banner);
			
			return "Admin/banner";
		}
	}
	
	@RequestMapping(value="all_content")
	public String oper_all_content_form(@ModelAttribute("scri") SearchCriteria scri,
										HttpSession session, Model model) {
		
	OperatorVO operatorUser = (OperatorVO)session.getAttribute("operatorUser");
		
		if(operatorUser == null) {
			return "Admin/admin_login_form";
		} else {
			
				List<UserContentVO> content= contentService.getUserContentList(scri);
				
				model.addAttribute("contentList", content);
				
				PageMaker pageMaker = new PageMaker();
				pageMaker.setCri(scri);
				pageMaker.setTotalCount(contentService.listCount(scri));
				
				model.addAttribute("pageMakers", pageMaker);
			
			return "Admin/all_content";
		
		}
	}
	
	@RequestMapping(value="event")
	public String oper_event_form(HttpSession session, Model model,eventVO vo,festivalVO fo) {
		
		OperatorVO operatorUser = (OperatorVO)session.getAttribute("operatorUser");
		
		if(operatorUser == null) {
			return "Admin/admin_login_form";
		} else {
			
			List<eventVO> event= eventService.event_list(vo);
			
			model.addAttribute("eventList", event);
			
			return "Admin/event";
		}
	}
	
	@RequestMapping(value="festival")
	public String oper_festival_form(HttpSession session, Model model,eventVO vo,festivalVO fo) {
		
		OperatorVO operatorUser = (OperatorVO)session.getAttribute("operatorUser");
		
		if(operatorUser == null) {
			return "Admin/admin_login_form";
		} else {
			
			List<festivalVO> festival= festivalService.festival_list(fo);
			
			model.addAttribute("festivalList", festival);
			
			return "Admin/festival";
		}
	}
}
