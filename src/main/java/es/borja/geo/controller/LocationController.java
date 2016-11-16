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
import org.springframework.context.annotation.PropertySource;
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

import es.borja.geo.model.Distance;
import es.borja.geo.model.Location;
import es.borja.geo.model.RoutePoint;
import es.borja.geo.service.IDistanceService;
import es.borja.geo.service.ILocationService;
import es.borja.geo.service.IRoutePointService;




@Controller
public class LocationController {
	
	@Autowired
	private ILocationService locationService;
	
	@Autowired
	private IDistanceService distanceService;
	
	@Autowired
	private IRoutePointService routePointService;
		
	
	@RequestMapping("/updateLocations")
	public int saveLocation (@RequestBody String data) throws ParseException{
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
		return 1;
	}
	
	@RequestMapping("/updateDistance")
	public int saveDistance (@RequestBody String data) throws ParseException{
		JSONParser parser = new JSONParser();
		JSONObject jsonObj = (JSONObject) parser.parse(data);
		Set<?> keys = jsonObj.keySet();
		Iterator<?> iter = keys.iterator();
		int query = 0;
		int distance = 0;
		while (iter.hasNext()) {
		    String key = (String)iter.next();
		    System.out.println(key);
		    if (key.equals("query")) {
		    	query = Integer.parseInt(jsonObj.get(key).toString());
		    }
		    else if (key.equals("distance")) {
		    	distance = Integer.parseInt(jsonObj.get(key).toString());
		    }
		    	    
		}
		if (query != 0 && distance != 0) {
			Distance d = new Distance();
			d.setDistance(distance);
			d.setQuery(query);
			distanceService.save(d);
		}
		
		return 1;
	}
	
	@RequestMapping("/updateRoutes")
	public int saveRoutes (@RequestBody String data) throws ParseException{
		JSONParser parser = new JSONParser();
		JSONObject jsonObj = (JSONObject) parser.parse(data);
		Set<?> keys = jsonObj.keySet();
		Iterator<?> iter = keys.iterator();
		String device = (String) jsonObj.get("device");
		
		while (iter.hasNext()) {
		    String key = (String)iter.next();
		    if ( jsonObj.get(key) instanceof JSONObject ) {
				JSONObject j = (JSONObject) jsonObj.get(key);
				Set<?> keys2 = j.keySet();
				Iterator<?> iter2 = keys2.iterator();
				while (iter2.hasNext()) {
					String key2 = (String) iter2.next();
					String[] parts = key2.split(",");
					Double lat = Double.parseDouble(parts[0]);
					Double lon = Double.parseDouble(parts[1]);
					RoutePoint p = new RoutePoint();
					p.setDevice(device);
					p.setLat(lat);
					p.setLon(lon);
					p.setTime(key);
					p.setQuantity((Integer.parseInt(j.get(key2).toString())));
					routePointService.save(p);
			    }
		    }
		}
		return 1;
	}
}
