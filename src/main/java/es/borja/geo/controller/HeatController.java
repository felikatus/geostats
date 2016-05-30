package es.borja.geo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import es.borja.geo.model.NimbeesQuery;

@Controller
public class HeatController {
	@RequestMapping(value = "/geo/newHeatQuery", method = RequestMethod.GET)
	public String heatForm(NimbeesQuery query) {
		return "newHeatQuery";
	}
	
	@RequestMapping(value = "/geo/newHeatQuery", method = RequestMethod.POST)
	public String heatForm(NimbeesQuery query, BindingResult bindingResult, RedirectAttributes redirectAttributes, ModelMap model) {
		try{
			String q = query.getLat() + ';' + query.getlon();
			return q;
		} catch (Exception e) {
			return "newHeatQuery";
		}
	}
}
