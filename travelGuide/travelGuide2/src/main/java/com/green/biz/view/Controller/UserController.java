package com.green.biz.view.Controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.UploadContext;
import org.apache.commons.io.FilenameUtils;
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

import com.green.biz.UserContent.UserContentService;
import com.green.biz.UserContent.UserContentVO;
import com.green.biz.like.likeService;
import com.green.biz.like.likeVO;
import com.green.biz.member.MemberVO;
import com.green.biz.recontent.RecontentService;
import com.green.biz.recontent.RecontentVO;
import com.green.biz.util.PageMaker;
import com.green.biz.util.SearchCriteria;
import org.slf4j.Logger;

@Controller
@SessionAttributes("loginUser")
public class UserController {
	
	@Autowired
	private UserContentService contentService;
	
	@Autowired
	private likeService likeService;
	
	@Autowired
	private RecontentService recontentService;
	
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(UserController.class);
	
	@Resource(name = "uploadPath")
	String uploadPath;
	
	@RequestMapping(value="UserContent_list", method = RequestMethod.GET)
	public String content_list(@ModelAttribute("scri") SearchCriteria scri, Model model){
		
		List<UserContentVO> content= contentService.getUserContentList(scri);
		
		model.addAttribute("contentList", content);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(contentService.listCount(scri));
		
		model.addAttribute("pageMaker", pageMaker);
		
		return "/userContent/UserContent_main";
	}
	
	@RequestMapping(value="go_write")
	public String go_write(HttpSession session) {
		
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		if(loginUser != null) {
			
			return "/userContent/content_write";
			
		} else {
			
			return "/login/login_form";
		}
	}
	
	@RequestMapping(value="content_write", method = RequestMethod.POST)
	public String insert_content(UserContentVO vo, HttpSession session) throws IOException {
		
		String file=null;
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String root_path = 
					session.getServletContext().getRealPath("WEB-INF/resources/upload/");
			String originalFileName = uploadFile.getOriginalFilename();
			String ext = FilenameUtils.getExtension(originalFileName);
			UUID uuid = UUID.randomUUID();
			file=uuid+"." +ext;
			uploadFile.transferTo(new File(root_path + file));
		
			vo.setC_file(file);
			} else {
				vo.setC_file("noimage.jpg");
			}
		
		contentService.insertContent(vo);
		
		return "redirect:UserContent_list";
	}
	
	/*
	 
	@RequestMapping(value="detail_content")
	public String detail_content(UserContentVO vo, Model model) {
		
		contentService.c_count_up(vo);
		
		UserContentVO content = contentService.detailContent(vo);
		
		model.addAttribute("detail", content);
				
		return "/userContent/content_detail";
	}
	
	*/
	
	@RequestMapping(value="go_update_detail")
	public String go_detail_update(UserContentVO vo, Model model) {
		
		UserContentVO content = contentService.detailContent(vo);
		
		model.addAttribute("detail", content);
		
		return "/userContent/update_detail";
	}
	
	@RequestMapping(value="update_detail", method = RequestMethod.POST)
	public String detail_update(UserContentVO vo, HttpSession session) throws IOException {
		
		if(vo.getUploadFile() != null) {		//�깉濡쒖슫 �씠誘몄� �엳�쓬 == 臾댁“嫄� �깉 �씠誘몄�
			
			String file=null;
			MultipartFile uploadFile  = vo.getUploadFile();
			if(!uploadFile.isEmpty()) {
				String root_path = 
						session.getServletContext().getRealPath("WEB-INF/resources/upload/");
				String originalFileName = uploadFile.getOriginalFilename();
				String ext = FilenameUtils.getExtension(originalFileName);
				UUID uuid = UUID.randomUUID();
				file=uuid+"." +ext;
				uploadFile.transferTo(new File(root_path + file));
				
				vo.setC_file(file);
			}
		} else {	//�깉濡쒖슫 �씠誘몄� �뾾�쓬
			
			if(vo.getC_file() != null) {		//湲곗〈 �씠誘몄� �엳�쓬
				//no action
				
			} else {		//湲곗〈�씠誘몄� �뾾�쓬,�깉濡쒖슫 �씠誘몄� �뾾�쓬
				vo.setC_file("noimage.jpg");
			}
		}
		contentService.detail_update(vo);
		
		return "redirect:UserContent_list";
	}
	
	@RequestMapping(value="delete_content")
	public String delete_content(UserContentVO vo) {
		
		contentService.delete_content(vo);
		
		return "redirect:UserContent_list";
	}
	
	@ResponseBody
	@RequestMapping(value="like_up", method = RequestMethod.GET)
	public Object id_num_get(@RequestBody likeVO vo) {
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("num", vo.getNum());
		map.put("id", vo.getId());
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="like_up", method = RequestMethod.POST)
	public Object id_num_post(@RequestBody likeVO vo, Model model) {
		
		
		likeVO like = likeService.find_like(vo);
		
		if(like.getLike_check() == 0) {
			likeService.like_up(vo);
			
		} else {
			likeService.like_down(vo);
		}
		
		int like_up = likeService.find_c_like(vo);
		
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("num", like.getNum());
		map.put("id", like.getId());
		map.put("like_check", like.getLike_check());
		map.put("like_up", like_up);
		
		
		return map;
	}
	
	@RequestMapping(value="detail_content")
	public String detail_content(likeVO like,@RequestParam("id") String id,
			UserContentVO vo, Model model, HttpSession session, RecontentVO recontentvo) {
		
			MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
			List<RecontentVO> recontent = recontentService.find_all_recontent(recontentvo);
			
			int count_like = likeService.find_c_like(like);
			
			contentService.c_count_up(vo);
			
			UserContentVO content = contentService.detailContent(vo);
		
		if(loginUser != null) {
			likeVO like_check = likeService.find_like(like);
			
			if(like_check == null) {
				likeService.insert_like(like);
				model.addAttribute("like_check",0);
			}else if(like_check != null && like_check.getLike_check() == 1) {
				model.addAttribute("like_check", 1);
			} else {
				model.addAttribute("like_check", 0);
			}
		} else {}
		
		model.addAttribute("detail", content);
		model.addAttribute("count_like", count_like);
		model.addAttribute("recontentlist",recontent);
		
		return "/userContent/content_detail";
	}
	
}





















































