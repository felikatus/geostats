package es.borja.geo.dao;

import java.util.List;

import es.borja.geo.model.Distance;


public interface IDistanceDAO {
	
	/**
	 * Save a user 
	 * @param data information that will be saved in the DataBase
	 */
	public void save(Distance data);

	List<Distance> getData();
	
	List<Distance> getDistance(Integer query);

	public int getMaxQuery();
		
}
