package es.borja.geo.controller;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import es.borja.geo.rest.EndpointInterface;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

@Controller
@PropertySource(value={"classpath:application.properties"})
public class HeatController {
	@RequestMapping(value = "/heat", method = RequestMethod.GET)
	public ModelAndView getHeatForm() {
		ModelAndView model = new ModelAndView("heat");
		
		return model;
	}
	
	@RequestMapping(value = "/submitHeatForm", method = RequestMethod.POST)
	public ModelAndView submitHeatForm(@RequestParam("lat") String lat, @RequestParam("lon") String lon, @RequestParam("radius") String radius, @RequestParam("dateFrom") String dateFrom, @RequestParam("dateTo") String dateTo ) {
		ModelAndView model = new ModelAndView("heatResult");
	    RestAdapter restAdapter;
	    restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://api.nimbees.com/nimbees_platform_server_api/")
                .build();
		EndpointInterface apiService = restAdapter.create(EndpointInterface.class);
		JSONObject outputJsonObj = new JSONObject();
		JSONObject content = new JSONObject();
		
		String q = lat + ";" + lon;
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

		model.addObject("message", "Submitted: " + q);
		return model;

	}
	
	
}
