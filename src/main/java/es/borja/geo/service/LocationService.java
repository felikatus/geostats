package es.borja.geo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.borja.geo.dao.ILocationDAO;
import es.borja.geo.model.Location;
import es.borja.geo.service.ILocationService;


@Service("ILocationService")
@Transactional
public class LocationService implements ILocationService{

	@Autowired
	private ILocationDAO locationDAO;
	
	@Override
	public void save(Location data) {
		locationDAO.save(data);
	}
	
    public Location[] findAllLocations() {
    	List<Location> results = locationDAO.getData();
    	Location[] locations = results.toArray(new Location[results.size()]);
        return locations;
    }
    
    public Location[] findHeatLocations(String timehi, String timelo, Double n, Double e, Double s, Double w) {
    	List<Location> results = locationDAO.getHeat(timehi, timelo, n, e, s, w);
    	Location[] locations = results.toArray(new Location[results.size()]);
    	return locations;
    }

}
