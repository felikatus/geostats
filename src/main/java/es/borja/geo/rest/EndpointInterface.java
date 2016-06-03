package es.borja.geo.rest;

import org.json.simple.JSONObject;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.Headers;
import retrofit.http.POST;

public interface EndpointInterface {

	@Headers({"Authorization: Basic MmY2UmI2QktrOVRoM2s0MDpoTWk2OTM1cDE0NjBaVGYx",
			"Content-Type: application/json"})
    @POST("/sendNotification/")
    void sendNotification(@Body JSONObject outputJsonObj, Callback<Integer> u);

}
