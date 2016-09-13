package es.borja.geo.controller;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.borja.geo.model.Location;
import es.borja.geo.rest.EndpointInterface;
import es.borja.geo.service.ILocationService;
import es.borja.geo.service.LocationService;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

@Controller
@PropertySource(value={"classpath:application.properties"})
@RequestMapping("/")
public class HeatController {
	
	@Autowired
	ILocationService locationService;
	
	
	@RequestMapping(value = "/heat", method = RequestMethod.GET)
	public ModelAndView getHeatForm() {
		ModelAndView model = new ModelAndView("heat");
		
		return model;
	}
	
	@RequestMapping(value = "/submitHeatForm", method = RequestMethod.POST)
	public ModelAndView submitHeatForm(@RequestParam("lat") String lat, @RequestParam("lon") String lon, @RequestParam("radius") String radius, @RequestParam("dateFrom") String dateFrom, @RequestParam("dateTo") String dateTo ) {
		ModelAndView model = new ModelAndView("redirect:heatMap");
	    RestAdapter restAdapter;
	    restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://api.nimbees.com/nimbees_platform_server_api/")
                .build();
		EndpointInterface apiService = restAdapter.create(EndpointInterface.class);
		JSONObject outputJsonObj = new JSONObject();
		JSONObject content = new JSONObject();
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		DateFormat dfo = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmZ");
		df.setTimeZone(TimeZone.getDefault());
        Date dateF = null;
        Date dateT = null;
        String dfr = null;
        String dto = null;
        try {
			dateF = df.parse(dateFrom);
			dateT = df.parse(dateTo);
			dfr = dfo.format(dateF);
			dto = dfo.format(dateT);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        

		
		String q = "heat;" + lat + ";" + lon + ";" + radius + ";" + dfr + ";" + dto;
		content.put("type","CUSTOM");
		content.put("message", q);
		outputJsonObj.put("content", content);
		
		apiService.sendNotification(outputJsonObj, new Callback<JSONObject>() {
			@Override
			public void failure(RetrofitError error) {
				System.out.println("error");
				
			}

			@Override
			public void success(JSONObject arg0, Response arg1) {
				System.out.println("success");
				
			}
        });
		
		model.addObject("lat", lat);
		model.addObject("lon", lon);
		model.addObject("radius", radius);
		model.addObject("dateFrom", dateFrom);
		model.addObject("dateTo", dateTo);
		
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		return model;

	}
	
	@RequestMapping(value = "/heatMap", method = RequestMethod.GET)
	public ModelAndView getHeatMap(@RequestParam("lat") String lat, @RequestParam("lon") String lon, @RequestParam("radius") String radius, @RequestParam("dateFrom") String dateFrom, @RequestParam("dateTo") String dateTo ) {
		ModelAndView model = new ModelAndView();
		model.addObject("lat", lat);
		model.addObject("lon", lon);
		model.addObject("radius", radius);
		model.addObject("dateFrom", dateFrom);
		model.addObject("dateTo", dateTo);

		Location[] locations = locationService.findAllLocations();
		List<String> results = new ArrayList<String>();
		
		for (int i =0; i < locations.length; i++){
			results.add(locations[i].getLat().toString() + "#" +  locations[i].getLon().toString() + "#" + String.valueOf(locations[i].getQuantity()));		
		}
		
		model.addObject("locations", results);
		return model;
	}
	
}
