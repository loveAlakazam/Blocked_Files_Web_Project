package com.madras.check;

import java.util.ArrayList;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.madras.check.model.service.BlockedFileService;
import com.madras.check.model.vo.BlockedFile;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private BlockedFileService fService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, ModelAndView mv) {
		
		ArrayList<BlockedFile> customFilesList = fService.selectAllCustomFile();
		int customCnt= customFilesList.size();
		mv.addObject("customList" , customFilesList);
		mv.addObject("customCnt", customCnt);
		mv.setViewName("home");
		return mv;
	}
	
	
	
}
