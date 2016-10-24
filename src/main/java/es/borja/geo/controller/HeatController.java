package es.borja.geo.controller;
import java.awt.geom.Point2D;
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

import es.borja.geo.model.Distance;
import es.borja.geo.model.Location;
import es.borja.geo.rest.EndpointInterface;
import es.borja.geo.service.IDistanceService;
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
	
	@Autowired
	IDistanceService distanceService;
	
	
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
		
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
		
		double range = Double.parseDouble(radius);
		
        Point2D origin = new Point2D.Float(Float.parseFloat(lat), Float.parseFloat(lon));
        Point2D north = calculateDerivedPosition(origin, range, 0);
        Point2D east = calculateDerivedPosition(origin, range, 90);
        Point2D south = calculateDerivedPosition(origin, range, 180);
        Point2D west = calculateDerivedPosition(origin, range, 270);
        
        Double n = north.getX();
        Double e = east.getY();
        Double s = south.getX();
        Double w = west.getY();
        

		Location[] locations = locationService.findHeatLocations(dateFrom, dateTo, n, e, s, w);
		List<String> results = new ArrayList<String>();
		
		for (int i =0; i < locations.length; i++){
			results.add(locations[i].getLat().toString() + "#" +  locations[i].getLon().toString() + "#" + String.valueOf(locations[i].getQuantity()));		
		}
		
		model.addObject("locations", results);
		return model;
	}
	
	
	@RequestMapping(value = "/distance", method = RequestMethod.GET)
	public ModelAndView getDistanceForm() {
		ModelAndView model = new ModelAndView("distance");
		
		return model;
	}
	
	@RequestMapping(value = "/submitDistanceForm", method = RequestMethod.POST)
	public ModelAndView submitDistanceForm(@RequestParam("lat") String lat, @RequestParam("lon") String lon, @RequestParam("radius") String radius, @RequestParam("dateFrom") String dateFrom, @RequestParam("dateTo") String dateTo ) {
		ModelAndView model = new ModelAndView("redirect:distanceTable");
		int query = distanceService.getMaxQuery();
	    RestAdapter restAdapter;
	    restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://api.nimbees.com/nimbees_platform_server_api/")
                .build();
		EndpointInterface apiService = restAdapter.create(EndpointInterface.class);
		JSONObject outputJsonObj = new JSONObject();
		JSONObject content = new JSONObject();
//		
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
        

		query++;
		String q = "distance;" + lat + ";" + lon + ";" + radius + ";" + dfr + ";" + dto + ";" + query;
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
		
		model.addObject("query", query);
		
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return model;

	}
	
	@RequestMapping(value = "/distanceTable", method = RequestMethod.GET)
	public ModelAndView getDistancetTable(@RequestParam("query") String q) {
		ModelAndView model = new ModelAndView();
		Distance[] distances = distanceService.findAllDistances();

		int totalDistance = 0;
		for (int i = 0; i < distances.length; i++){
			totalDistance += distances[i].getDistance();
		}
		model.addObject("distances", distances);
		model.addObject("total", totalDistance);
		return model;
	}
	
	private static Point2D calculateDerivedPosition(Point2D point, double range, double bearing){
		double EarthRadius = 6371000; // m
		
		double latA = Math.toRadians(point.getX());
		double lonA = Math.toRadians(point.getY());
		double angularDistance = range / EarthRadius;
		double trueCourse = Math.toRadians(bearing);
		
		double lat = Math.asin(
		Math.sin(latA) * Math.cos(angularDistance) +
		Math.cos(latA) * Math.sin(angularDistance)
		* Math.cos(trueCourse));
		
		double dlon = Math.atan2(
		Math.sin(trueCourse) * Math.sin(angularDistance)
		* Math.cos(latA),
		Math.cos(angularDistance) - Math.sin(latA) * Math.sin(lat));
		
		double lon = ((lonA + dlon + Math.PI) % (Math.PI * 2)) - Math.PI;
		
		lat = Math.toDegrees(lat);
		lon = Math.toDegrees(lon);
		
		Point2D newPoint = new Point2D.Float((float) lat, (float) lon);
		
		return newPoint;
	
	}
	
}
