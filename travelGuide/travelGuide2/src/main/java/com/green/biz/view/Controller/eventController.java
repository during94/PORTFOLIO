package com.green.biz.view.Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
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
import com.green.biz.festival_event.eventService;
import com.green.biz.festival_event.eventVO;
import com.green.biz.festival_event.festivalService;
import com.green.biz.festival_event.festivalVO;

@Controller
@SessionAttributes("operatorUser")
public class eventController {
	
	@Autowired
	private eventService eventService;
	@Autowired
	private festivalService festivalService;
	
	@RequestMapping(value="go_event_festival")
	public String go_event_festival( Model model,eventVO vo,festivalVO fo) {
		
		List<eventVO> event= eventService.event_list(vo);
		
		model.addAttribute("eventList", event);
		
		List<festivalVO> festival= festivalService.festival_list(fo);
		
		model.addAttribute("festivalList", festival);
		
		return "e&f/ef_main";
		
	}
	
	@RequestMapping(value="event_insert_form")
	public String event_insert_form(HttpSession session, Model model) {
		
		OperatorVO operatorUser = (OperatorVO)session.getAttribute("operatorUser");
		
		if(operatorUser == null) {
			return "Admin/admin_login_form";
		} else {
		
		return "event/event_wirte";
		}
	}
	
	@RequestMapping(value="event_insert", method = RequestMethod.POST)
	public String event_insert(HttpSession session, Model model,eventVO vo) throws IOException {
		
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
			
			
				vo.setE_image(file);
			} else {
				vo.setE_image("noimage.jpg");
			}
			
			eventService.insert_event(vo);
			
		return "redirect:event_festival";
		}
	}
	
	
	@RequestMapping(value="event_update_form")
	public String event_update_form(HttpSession session, Model model, eventVO vo) {
		
		OperatorVO operatorUser = (OperatorVO)session.getAttribute("operatorUser");
		
		if(operatorUser == null) {
			return "Admin/admin_login_form";
		} else {
		
			eventVO event = eventService.get_event(vo);
			
			model.addAttribute("event",event);
			
		return "event/event_update";
		}
	}
	
	@RequestMapping(value="event_update", method = RequestMethod.POST)
	public String event_update(HttpSession session, Model model,eventVO vo) throws IOException {
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
					
					vo.setE_image(file);
				}
			} else {	//새로운 이미지 없음
				
				if(vo.getE_image() != null) {		//기존 이미지 있음
					//no action
					
				} else {		//기존이미지 없음,새로운 이미지 없음
					vo.setE_image("noimage.jpg");
				}
			}
		
			eventService.update_event(vo);
			
			return "redirect:event_festival";
		}
	}
	
	@RequestMapping(value="event_delete")
	public String event_delete(HttpSession session, Model model,eventVO vo) {
		OperatorVO operatorUser = (OperatorVO)session.getAttribute("operatorUser");
		
		if(operatorUser == null) {
			return "Admin/admin_login_form";
		} else {
			
			
			eventService.delete_event(vo);
			
			return "redirect:event_festival";
		}
	}
	
	@RequestMapping(value="festival_insert_form")
	public String festival_insert_form(HttpSession session, Model model) {
		
		OperatorVO operatorUser = (OperatorVO)session.getAttribute("operatorUser");
		
		if(operatorUser == null) {
			return "Admin/admin_login_form";
		} else {
		
		return "festival/festival_wirte";
		}
	}
	
	@RequestMapping(value="festival_insert", method = RequestMethod.POST)
	public String festival_insert(HttpSession session, Model model,festivalVO vo) throws IOException {
		
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
			
			
				vo.setF_image(file);
			} else {
				vo.setF_image("noimage.jpg");
			}
			
			festivalService.insert_festival(vo);
			
		return "redirect:event_festival";
		}
	}
	
	
	@RequestMapping(value="festival_update_form")
	public String festival_update_form(HttpSession session, Model model, festivalVO vo) {
		
		OperatorVO operatorUser = (OperatorVO)session.getAttribute("operatorUser");
		
		if(operatorUser == null) {
			return "Admin/admin_login_form";
		} else {
		
			festivalVO festival = festivalService.get_festival(vo);
			
			model.addAttribute("festival",festival);
			
		return "festival/festival_update";
		}
	}
	
	@RequestMapping(value="festival_update", method = RequestMethod.POST)
	public String festival_update(HttpSession session, Model model,festivalVO vo) throws IOException {
		OperatorVO operatorUser = (OperatorVO)session.getAttribute("operatorUser");
		
		if(operatorUser == null) {
			return "Admin/admin_login_form";
		} else {
			
			if(vo.getUploadFile() != null) {		//새로운 이미지가 들어옴
				
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
				
				
					vo.setF_image(file);
				}
			} else {
				if(vo.getF_image() != null) {		//기존이미지 있음
					//no action
				} else {
					vo.setF_image("noimage.jpg");
				}
			}
			
			
			
			festivalService.update_festival(vo);
			
			return "redirect:event_festival";
		}
	}
	
	@RequestMapping(value="festival_delete")
	public String festival_delete(HttpSession session, Model model,festivalVO vo) {
		OperatorVO operatorUser = (OperatorVO)session.getAttribute("operatorUser");
		
		if(operatorUser == null) {
			return "Admin/admin_login_form";
		} else {
			
			
			festivalService.delete_festival(vo);
			
			return "redirect:event_festival";
		}
	}
	
}
