package es.borja.geo.dao;

import es.borja.geo.model.Location;

public class LocationDAO extends AbstractDAO implements ILocationDAO {
	@Override
	public void save(Location data) {
		persist(data);
	}
}
