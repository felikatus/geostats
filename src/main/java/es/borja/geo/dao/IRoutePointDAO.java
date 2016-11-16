package es.borja.geo.dao;

import java.util.List;

import es.borja.geo.model.RoutePoint;


public interface IRoutePointDAO {
	
	/**
	 * Save a user 
	 * @param data information that will be saved in the DataBase
	 */
	public void save(RoutePoint data);

	List<RoutePoint> getData();
	
	List<RoutePoint> getRoute(String timelo, String timehi, Double n, Double e, Double s, Double w);
	
		
}
