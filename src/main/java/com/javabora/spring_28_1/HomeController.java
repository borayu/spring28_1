package com.javabora.spring_28_1;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javabora.spring_28_1.dao.IDao;
import com.javabora.spring_28_1.dto.ContentDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	
	@Autowired
	private SqlSession sqlSession;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		
		//ArrayList<ContentDto> dtos = dao.listDao();
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		model.addAttribute("list", dao.listDao());
		
		return "list";
	}
	
	@RequestMapping("/writeForm")
	public String writeForm() {
		return "writeForm";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.writeDao(request.getParameter("mname"), request.getParameter("mphone"), request.getParameter("maddress"), request.getParameter("mdate"));
		
		return "redirect:list";
	}
	
	@RequestMapping("/view")
	public String view(HttpServletRequest request, Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		ContentDto dto = dao.viewDao(request.getParameter("mid"));
		
		model.addAttribute("dto", dto);
		
		return "view";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.deleteDao(request.getParameter("mid"));
		
		return "redirect:list";
	}
	
	@RequestMapping("/modifyDao")
	public String modifyDao(HttpServletRequest request, Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.modifyDao(request.getParameter("mname"),request.getParameter("mphone"),request.getParameter("maddress"),request.getParameter("maddress"));
		
		return "redirect:list";
	
	}
	
}