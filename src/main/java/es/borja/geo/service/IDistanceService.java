package es.borja.geo.service;

import es.borja.geo.model.Distance;

public interface IDistanceService {
	/**
	 * This method save a user creating a new ID
	 * @param data
	 */
	public void save(Distance data);
	
	public Distance[] findAllDistances();

	public Distance[] findDistances(Integer query);

	public int getMaxQuery();
}
