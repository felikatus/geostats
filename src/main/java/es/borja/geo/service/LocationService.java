package es.borja.geo.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import es.borja.geo.model.Location;

@Component
@Transactional
public class LocationService implements ILocationService{

	@Override
	public void save(Location data) {
		// TODO Auto-generated method stub
		
	}

}
