package es.borja.geo.service;

import java.util.List;

import es.borja.geo.model.Location;

public interface ILocationService {
	/**
	 * This method save a user creating a new ID
	 * @param data
	 */
	public void save(Location data);
	
	 public Location[] findAllLocations();

}
