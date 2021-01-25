package com.green.biz.view.Controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.green.biz.Operator.OperatorVO;
import com.green.biz.banner.bannerService;
import com.green.biz.banner.bannerVO;

@Controller
@SessionAttributes("operatorUser")
public class bannerController {
	
	@Autowired
	private bannerService bannerService;

	@RequestMapping(value="banner_insert_form")
	public String event_insert_form(HttpSession session, Model model) {
		
		OperatorVO operatorUser = (OperatorVO)session.getAttribute("operatorUser");
		
		if(operatorUser == null) {
			return "Admin/admin_login_form";
		} else {
		
		return "banner/banner_write";
		}
	}
	
	@RequestMapping(value="banner_insert", method = RequestMethod.POST)
	public String event_insert(HttpSession session, Model model,bannerVO vo) throws IOException {
		
		OperatorVO operatorUser = (OperatorVO)session.getAttribute("operatorUser");
		
		if(operatorUser == null) {
			return "Admin/admin_login_form";
		} else {
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
			
			
				vo.setB_image(file);
			} else {
				vo.setB_image("noimage.jpg");
			}
			
			bannerService.banner_insert(vo);
			
		return "redirect:banner";
		}
	}
	
	
	@RequestMapping(value="banner_update_form")
	public String event_update_form(HttpSession session, Model model, bannerVO vo) {
		
		OperatorVO operatorUser = (OperatorVO)session.getAttribute("operatorUser");
		
		if(operatorUser == null) {
			return "Admin/admin_login_form";
		} else {
		
			bannerVO banner = bannerService.get_banner(vo);
			
			model.addAttribute("banner",banner);
			
		return "banner/banner_update";
		}
	}
	
	@RequestMapping(value="banner_update", method = RequestMethod.POST)
	public String event_update(HttpSession session, Model model,bannerVO vo) throws IOException {
		OperatorVO operatorUser = (OperatorVO)session.getAttribute("operatorUser");
		
		if(operatorUser == null) {
			return "Admin/admin_login_form";
		} else {
			
			if(vo.getUploadFile() != null) {		//새로운 이미지 있음 == 무조건 새 이미지
				
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
					
					vo.setB_image(file);
				}
			} else {	//새로운 이미지 없음
				
				if(vo.getB_image() != null) {		//기존 이미지 있음
					//no action
					
				} else {		//기존이미지 없음,새로운 이미지 없음
					vo.setB_image("noimage.jpg");
				}
			}
		
			bannerService.update_banner(vo);
			
			return "redirect:banner";
		}
	}
	
	@RequestMapping(value="banner_delete")
	public String event_delete(HttpSession session, Model model,bannerVO vo) {
		OperatorVO operatorUser = (OperatorVO)session.getAttribute("operatorUser");
		
		if(operatorUser == null) {
			return "Admin/admin_login_form";
		} else {
			
			
			bannerService.delete_banner(vo);
			
			return "redirect:banner";
		}
	}
	
}
