package es.borja.geo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import es.borja.geo.dao.ILocationDAO;
import es.borja.geo.model.Location;
import es.borja.geo.service.ILocationService;


@Component
@Transactional
public class LocationService implements ILocationService{

	@Autowired
	private ILocationDAO locationDAO;
	
	@Override
	public void save(Location data) {
		locationDAO.save(data);
		
	}

}
