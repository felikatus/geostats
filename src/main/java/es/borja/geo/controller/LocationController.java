package es.borja.geo.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import es.borja.geo.model.Location;
import es.borja.geo.service.ILocationService;




@Controller
public class LocationController {
	
	@Autowired
	private ILocationService locationService;
		
//	static Logger log = Logger.getLogger(UserController.class.getName());
	
	@RequestMapping("/updateLocations")
	public void saveLocation (@RequestBody String data) throws ParseException{
		System.out.println(data);
		
		JSONParser parser = new JSONParser();
		JSONObject jsonObj = (JSONObject) parser.parse(data);
		Set<?> keys = jsonObj.keySet();
		Iterator<?> iter = keys.iterator();
		while (iter.hasNext()) {
		    String key = (String)iter.next();
		    System.out.println(key);
		    if ( jsonObj.get(key) instanceof JSONObject ) {
				JSONObject j = (JSONObject) jsonObj.get(key);
				Set<?> keys2 = j.keySet();
				Iterator<?> iter2 = keys2.iterator();
				while (iter2.hasNext()) {
					String key2 = (String) iter2.next();
					String[] parts = key2.split(",");
					Double lat = Double.parseDouble(parts[0]);
					Double lon = Double.parseDouble(parts[1]);
					Location l = new Location();
					l.setLat(lat);
					l.setLon(lon);
					l.setTime(key);
					l.setQuantity((Integer.parseInt(j.get(key2).toString())));
					locationService.save(l);
			    }
		    }
		}
	}
	
}
