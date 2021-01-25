package com.green.biz.view.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.green.biz.UserContent.UserContentService;
import com.green.biz.UserContent.UserContentVO;
import com.green.biz.banner.bannerService;
import com.green.biz.banner.bannerVO;
import com.green.biz.member.MemberService;
import com.green.biz.member.MemberVO;
import com.green.biz.util.SearchCriteria;

@Controller
@SessionAttributes("loginUser")
public class memberController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private bannerService bannerService;
	
	@Autowired
	private UserContentService contentService;
	
	@RequestMapping(value="main", method = RequestMethod.GET)
	public String main(Model model, bannerVO vo, UserContentVO top_vo ) {
		
		List<bannerVO> banner= bannerService.banner_list(vo);
		
		model.addAttribute("bannerList", banner);
		
		List<UserContentVO> content= contentService.topList(top_vo);
		
		model.addAttribute("contentList", content);
		
		return "main";
	}
	
	@RequestMapping(value="/login_form", method=RequestMethod.GET)
	public String loginForm() {
		
		return "login/login_form";
	}
	
	@RequestMapping(value="/login" , method=RequestMethod.POST)
	public String login(MemberVO vo, Model model) {
		
		MemberVO loginUser = memberService.getUser(vo);
		if(loginUser != null) {
			model.addAttribute("loginUser", loginUser);
			
			return "redirect:main_form";
		} else {
			return "login/login_fail";
		}
	}
	
	@RequestMapping(value="/logout_form" ,method=RequestMethod.GET)
	public String logout(SessionStatus session) {
		
		session.setComplete();
		
		return "redirect:main";
	}
	
	@RequestMapping(value="/id_check_box")
	public String id_check_box() {
		
		return "/login/id_check_box";
	}
	
	@RequestMapping(value="id_check_form", method = RequestMethod.POST)
	public String find_check_id(@RequestParam(value="id", defaultValue = "" ,required = false)
												String id, Model model) {
		MemberVO userID = memberService.find_id(id);
		
		if(userID != null) {
			model.addAttribute("message", 1);
		} else {
			model.addAttribute("message", -1);
		}
		
		model.addAttribute("id", id);
		
		return "login/id_check_box";
	}
	
	@RequestMapping(value="/main_form")
	public String go_main(Model model, bannerVO vo, UserContentVO top_vo) {
		
		List<bannerVO> banner= bannerService.banner_list(vo);
		
		model.addAttribute("bannerList", banner);
		
		List<UserContentVO> content= contentService.topList(top_vo);
		
		model.addAttribute("contentList", content);
		
		return "main";
	}
	
	@RequestMapping(value="/main_login", method = RequestMethod.GET)
	public String go_main_login(Model model, bannerVO vo) {
		
		List<bannerVO> banner= bannerService.banner_list(vo);
		
		model.addAttribute("bannerList", banner);
			
		return "/login/main_login";
	}
	
	@RequestMapping(value="/join_form")
	public String join_form() {
		
		return "login/join_form";
	}
	
	@RequestMapping(value="new_join")
	public String join(MemberVO vo) {
		memberService.insertUser(vo);
		
		return "redirect:login_form";
	}
	
	@RequestMapping(value="mypage_main")
	public String mypage(MemberVO vo) {
		
		MemberVO member = memberService.getUser(vo);

		if(member != null) {
			return "mypage/mypage_main";
		} else {
			return "login/login_form";
		}
		
	}
	
	@RequestMapping(value="mypage_main2")
	public String mypage2(MemberVO vo, Model model) {
		
		MemberVO member = memberService.getUser(vo);

		if(member != null) {
			return "mypage/mypage_main2";
		} else {
			model.addAttribute("message", 1);
				
			return "mypage/mypage_main";				
		}
	}
	
	@RequestMapping(value="mypage_update" , method = RequestMethod.GET)
	public String mypage_update() {
		return "mypage/mypage_update";
	}
	
	@RequestMapping(value="myinfo_update", method = RequestMethod.POST)
	public String myinfo_update(MemberVO vo,HttpSession session) {
		
		memberService.updateInfo(vo);
		
		
		session.invalidate();
		
		return "login/login_form";
	}
	
	@RequestMapping(value="find_user")
	public String find_id_view() {
		
		return "/login/find_user";
	}
	
	@RequestMapping(value="find_myid")
	public String find_myid_check(MemberVO vo, Model model) {
		
		MemberVO member = memberService.find_name_email(vo);
		
		if(member != null) {
			model.addAttribute("message", "1");
			model.addAttribute("id",member.getId());
		} else {
			model.addAttribute("message", "-1");
		}
		
		return "login/findResult";
	}
	
	@RequestMapping(value="find_mypwd")
	public String find_mypwd(MemberVO vo, Model model) {
		MemberVO member = memberService.find_pwd(vo);
		
		if(member != null) {
			model.addAttribute("message", "1");
			model.addAttribute("id", member.getId());
		} else {
			model.addAttribute("message", "-1");
		}
		
		return "login/findPwdResult";
	}
	
	@RequestMapping(value="update_pwd")
	public String update_pwd(MemberVO vo) {
		memberService.update_pwd(vo);
		
		return "/login/login_form";
	}
	
}








































