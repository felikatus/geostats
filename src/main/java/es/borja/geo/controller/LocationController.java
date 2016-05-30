package es.borja.geo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import es.borja.geo.service.ILocationService;



@Controller
public class LocationController {
	
	@Autowired
	private ILocationService locationService;
		
//	static Logger log = Logger.getLogger(UserController.class.getName());

	@RequestMapping("/savelocation")
	public String saveLocation (){
		return "savelocation";
	}
	
	@RequestMapping("/heat")
	public String Heat (){
		return "heat";
	}

	
}
