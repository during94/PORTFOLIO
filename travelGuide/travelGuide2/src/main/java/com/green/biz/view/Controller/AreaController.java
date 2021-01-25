package com.green.biz.view.Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.green.biz.Area.AreaService;
import com.green.biz.UserContent.UserContentService;
import com.green.biz.UserContent.UserContentVO;
import com.green.biz.member.MemberVO;
import com.green.biz.util.PageMaker;
import com.green.biz.util.SearchCriteria;

@Controller
@SessionAttributes("loginUser")
public class AreaController {
	
	@Autowired
	private AreaService AreaService;
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(UserController.class);
	
	@Resource(name = "uploadPath")
	String uploadPath;
	
	@Autowired
	private UserContentService contentService;
	
	@RequestMapping(value="Area_main", method = RequestMethod.GET)
	public String go_area_main() {
		return "Area/Area_main";
	}
	
	@RequestMapping(value="area_select", method = RequestMethod.GET)
	public String area_select(@RequestParam("area") int area,
			@ModelAttribute("scri") SearchCriteria scri, Model model){
			
			List<UserContentVO> content= contentService.getUserContentList(scri);
			
			model.addAttribute("contentList", content);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(scri);
			pageMaker.setTotalCount(contentService.listCount(scri));
			
			model.addAttribute("pageMaker", pageMaker);
			
			if(area == '1') {
				return "/Area/Seoul";
				
			} else if(area == '2') {
				return "/Area/Busan";
			} else {
				return "/Area/Daegu";
			}
		
	}
	
	@RequestMapping(value="Seoul", method = RequestMethod.GET)
	public String seoul_list(@ModelAttribute("scri") SearchCriteria scri, Model model){
			
			List<UserContentVO> content= contentService.getUserContentList(scri);
			
			model.addAttribute("contentList", content);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(scri);
			pageMaker.setTotalCount(contentService.listCount(scri));
			
			model.addAttribute("pageMaker", pageMaker);
			
		return "/Area/Seoul";
	}
	
	@RequestMapping(value="Busan", method = RequestMethod.GET)
	public String Busan_list(@ModelAttribute("scri") SearchCriteria scri, Model model){
			
			List<UserContentVO> content= contentService.getUserContentList(scri);
			
			model.addAttribute("contentList", content);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(scri);
			pageMaker.setTotalCount(contentService.listCount(scri));
			
			model.addAttribute("pageMaker", pageMaker);
			
		return "/Area/Busan";
	}
	
	@RequestMapping(value="Daegu", method = RequestMethod.GET)
	public String Daegu_list(@ModelAttribute("scri") SearchCriteria scri, Model model){
			
			List<UserContentVO> content= contentService.getUserContentList(scri);
			
			model.addAttribute("contentList", content);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(scri);
			pageMaker.setTotalCount(contentService.listCount(scri));
			
			model.addAttribute("pageMaker", pageMaker);
			
		return "/Area/Daegu";
	}
	
	@RequestMapping(value="Incheon", method = RequestMethod.GET)
	public String Incheon_list(@ModelAttribute("scri") SearchCriteria scri, Model model){
			
			List<UserContentVO> content= contentService.getUserContentList(scri);
			
			model.addAttribute("contentList", content);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(scri);
			pageMaker.setTotalCount(contentService.listCount(scri));
			
			model.addAttribute("pageMaker", pageMaker);
			
		return "/Area/Incheon";
	}
	
	@RequestMapping(value="Gwangju", method = RequestMethod.GET)
	public String Gwangju_list(@ModelAttribute("scri") SearchCriteria scri, Model model){
			
			List<UserContentVO> content= contentService.getUserContentList(scri);
			
			model.addAttribute("contentList", content);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(scri);
			pageMaker.setTotalCount(contentService.listCount(scri));
			
			model.addAttribute("pageMaker", pageMaker);
			
		return "/Area/Gwangju";
	}
	
	@RequestMapping(value="Daejeaon", method = RequestMethod.GET)
	public String Daejeaon_list(@ModelAttribute("scri") SearchCriteria scri, Model model){
			
			List<UserContentVO> content= contentService.getUserContentList(scri);
			
			model.addAttribute("contentList", content);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(scri);
			pageMaker.setTotalCount(contentService.listCount(scri));
			
			model.addAttribute("pageMaker", pageMaker);
			
		return "/Area/Daejeaon";
	}
	
	@RequestMapping(value="Ulsan", method = RequestMethod.GET)
	public String Ulsan_list(@ModelAttribute("scri") SearchCriteria scri, Model model){
			
			List<UserContentVO> content= contentService.getUserContentList(scri);
			
			model.addAttribute("contentList", content);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(scri);
			pageMaker.setTotalCount(contentService.listCount(scri));
			
			model.addAttribute("pageMaker", pageMaker);
			
		return "/Area/Ulsan";
	}
	
	@RequestMapping(value="Sejong", method = RequestMethod.GET)
	public String Sejong_list(@ModelAttribute("scri") SearchCriteria scri, Model model){
			
			List<UserContentVO> content= contentService.getUserContentList(scri);
			
			model.addAttribute("contentList", content);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(scri);
			pageMaker.setTotalCount(contentService.listCount(scri));
			
			model.addAttribute("pageMaker", pageMaker);
			
		return "/Area/Sejong";
	}
	
	@RequestMapping(value="Gyeonggi", method = RequestMethod.GET)
	public String Gyeonggi_list(@ModelAttribute("scri") SearchCriteria scri, Model model){
			
			List<UserContentVO> content= contentService.getUserContentList(scri);
			
			model.addAttribute("contentList", content);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(scri);
			pageMaker.setTotalCount(contentService.listCount(scri));
			
			model.addAttribute("pageMaker", pageMaker);
			
		return "/Area/Gyeonggi";
	}
	
	@RequestMapping(value="Gangwon", method = RequestMethod.GET)
	public String Gangwon_list(@ModelAttribute("scri") SearchCriteria scri, Model model){
			
			List<UserContentVO> content= contentService.getUserContentList(scri);
			
			model.addAttribute("contentList", content);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(scri);
			pageMaker.setTotalCount(contentService.listCount(scri));
			
			model.addAttribute("pageMaker", pageMaker);
			
		return "/Area/Gangwon";
	}
	
	@RequestMapping(value="Chungbuk", method = RequestMethod.GET)
	public String Chungbuk_list(@ModelAttribute("scri") SearchCriteria scri, Model model){
			
			List<UserContentVO> content= contentService.getUserContentList(scri);
			
			model.addAttribute("contentList", content);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(scri);
			pageMaker.setTotalCount(contentService.listCount(scri));
			
			model.addAttribute("pageMaker", pageMaker);
			
		return "/Area/Chungbuk";
	}
	
	@RequestMapping(value="Chungnam", method = RequestMethod.GET)
	public String Chungnam_list(@ModelAttribute("scri") SearchCriteria scri, Model model){
			
			List<UserContentVO> content= contentService.getUserContentList(scri);
			
			model.addAttribute("contentList", content);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(scri);
			pageMaker.setTotalCount(contentService.listCount(scri));
			
			model.addAttribute("pageMaker", pageMaker);
			
		return "/Area/Chungnam";
	}
	
	@RequestMapping(value="Jeonbuk", method = RequestMethod.GET)
	public String Jeonbuk_list(@ModelAttribute("scri") SearchCriteria scri, Model model){
			
			List<UserContentVO> content= contentService.getUserContentList(scri);
			
			model.addAttribute("contentList", content);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(scri);
			pageMaker.setTotalCount(contentService.listCount(scri));
			
			model.addAttribute("pageMaker", pageMaker);
			
		return "/Area/Jeonbuk";
	}
	
	@RequestMapping(value="Jeonnam", method = RequestMethod.GET)
	public String Jeonnam_list(@ModelAttribute("scri") SearchCriteria scri, Model model){
			
			List<UserContentVO> content= contentService.getUserContentList(scri);
			
			model.addAttribute("contentList", content);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(scri);
			pageMaker.setTotalCount(contentService.listCount(scri));
			
			model.addAttribute("pageMaker", pageMaker);
			
		return "/Area/Jeonnam";
	}
	
	@RequestMapping(value="Gyengbuk", method = RequestMethod.GET)
	public String Gyengbuk_list(@ModelAttribute("scri") SearchCriteria scri, Model model){
			
			List<UserContentVO> content= contentService.getUserContentList(scri);
			
			model.addAttribute("contentList", content);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(scri);
			pageMaker.setTotalCount(contentService.listCount(scri));
			
			model.addAttribute("pageMaker", pageMaker);
			
		return "/Area/Gyengbuk";
	}
	
	@RequestMapping(value="Gyengnam", method = RequestMethod.GET)
	public String Gyengnam_list(@ModelAttribute("scri") SearchCriteria scri, Model model){
			
			List<UserContentVO> content= contentService.getUserContentList(scri);
			
			model.addAttribute("contentList", content);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(scri);
			pageMaker.setTotalCount(contentService.listCount(scri));
			
			model.addAttribute("pageMaker", pageMaker);
			
		return "/Area/Gyengnam";
	}
	
	@RequestMapping(value="Jeju", method = RequestMethod.GET)
	public String Jeju_list(@ModelAttribute("scri") SearchCriteria scri, Model model){
			
			List<UserContentVO> content= contentService.getUserContentList(scri);
			
			model.addAttribute("contentList", content);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(scri);
			pageMaker.setTotalCount(contentService.listCount(scri));
			
			model.addAttribute("pageMaker", pageMaker);
			
		return "/Area/Jeju";
	}
	

	@RequestMapping(value="go_Area_write")
	public String go_write(HttpSession session, Model model, HttpServletRequest request) {
		
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		String kind = request.getParameter("c_kind");
		
		if(loginUser != null) {
			
			model.addAttribute("c_kind", kind);
			
			return "/Area/Area_content_write";
			
		} else {
			
			return "/login/login_form";
		}
	}
	
	@RequestMapping(value="Area_write", method = RequestMethod.POST)
	public String insert_content(@RequestParam(value="return_kind")String return_kind,
						UserContentVO vo, HttpSession session) throws IOException {
		String c_file=null;
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String root_path = 
					session.getServletContext().getRealPath("WEB-INF/resources/upload/");
			String originalFileName = uploadFile.getOriginalFilename();
			vo.setC_file(originalFileName);
			String ext = FilenameUtils.getExtension(originalFileName);
			UUID uuid = UUID.randomUUID();
			c_file=uuid+"." +ext;
			uploadFile.transferTo(new File(root_path + c_file));
		}
		
		vo.setC_file(c_file);
		
		contentService.insertContent(vo);
		
		if(return_kind.equals("0")) {
			return "redirect:Seoul";
		} else if(return_kind.equals("1")) {
			return "redirect:Busan";
		} else if(return_kind.equals("2")) {
			return "redirect:Daegu";
		} else if(return_kind.equals("3")) {
			return "redirect:Incheon";
		} else if(return_kind.equals("4")) {
			return "redirect:Gwangju";
		} else if(return_kind.equals("5")) {
			return "redirect:Daejeaon";
		} else if(return_kind.equals("6")) {
			return "redirect:Ulsan";
		} else if(return_kind.equals("7")) {
			return "redirect:Sejong";
		} else if(return_kind.equals("8")) {
			return "redirect:Gyeonggi";
		} else if(return_kind.equals("9")) {
			return "redirect:Gangwon";
		} else if(return_kind.equals("10")) {
			return "redirect:Chungbuk";
		} else if(return_kind.equals("11")) {
		 	return "redirect:Chungnam";
		} else if(return_kind.equals("12")) {
			return "redirect:Jeonbuk";
		} else if(return_kind.equals("13")) {
			return "redirect:Jeonnam";
		} else if(return_kind.equals("14")) {
			return "redirect:Gyengbuk";
		} else if(return_kind.equals("15")) {
			return "redirect:Gyengnam";
		} else if(return_kind.equals("16")) {
			return "redirect:Jeju";
		} else {
			
			return "redirect:UserContent_list";
		}
		
	}
	
	
}
