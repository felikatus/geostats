package es.borja.geo.dao;

import java.util.List;

import es.borja.geo.model.Location;


public interface ILocationDAO {
	
	/**
	 * Save a user 
	 * @param data information that will be saved in the DataBase
	 */
	public void save(Location data);

	List<Location> getData();
	
	List<Location> getHeat(String timelo, String timehi, Double n, Double e, Double s, Double w);
		
}
