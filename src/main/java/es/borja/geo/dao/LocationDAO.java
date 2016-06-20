package es.borja.geo.dao;

import org.springframework.stereotype.Repository;

import es.borja.geo.model.Location;

@Repository("LocationDAO")
public class LocationDAO extends AbstractDAO implements ILocationDAO {
	@Override
	public void save(Location data) {
		persist(data);
	}
}
