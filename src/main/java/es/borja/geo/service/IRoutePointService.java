package es.borja.geo.service;

import es.borja.geo.model.Location;
import es.borja.geo.model.RoutePoint;

public interface IRoutePointService {
	/**
	 * This method save a user creating a new ID
	 * @param data
	 */
	public void save(RoutePoint data);
	
	 public RoutePoint[] findAllLocations();

	public RoutePoint[] findRouteLocations(String dateFrom, String dateTo, Double n, Double e, Double s, Double w);
}
