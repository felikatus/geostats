package es.borja.geo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.borja.geo.dao.IRoutePointDAO;
import es.borja.geo.model.Location;
import es.borja.geo.model.RoutePoint;


@Service("IRoutePointService")
@Transactional
public class RoutePointService implements IRoutePointService{

	@Autowired
	private IRoutePointDAO routePointDAO;
	
	@Override
	public void save(RoutePoint data) {
		routePointDAO.save(data);
	}
	
    public RoutePoint[] findAllLocations() {
    	List<RoutePoint> results = routePointDAO.getData();
    	RoutePoint[] routePoints = results.toArray(new RoutePoint[results.size()]);
        return routePoints;
    }
    
    public RoutePoint[] findRouteLocations(String timehi, String timelo, Double n, Double e, Double s, Double w) {
    	List<RoutePoint> results = routePointDAO.getRoute(timehi, timelo, n, e, s, w);
    	RoutePoint[] routePoints = results.toArray(new RoutePoint[results.size()]);
    	return routePoints;
    }
    
}
