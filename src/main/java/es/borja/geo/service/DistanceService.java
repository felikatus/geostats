package es.borja.geo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.borja.geo.dao.IDistanceDAO;
import es.borja.geo.model.Distance;
import es.borja.geo.service.IDistanceService;


@Service("IDistanceService")
@Transactional
public class DistanceService implements IDistanceService{

	@Autowired
	private IDistanceDAO distanceDAO;
	
	@Override
	public void save(Distance data) {
		distanceDAO.save(data);
	}
	
    public Distance[] findAllDistances() {
    	List<Distance> results = distanceDAO.getData();
    	Distance[] distances = results.toArray(new Distance[results.size()]);
        return distances;
    }
    
    public Distance[] findDistances(Integer query) {
    	List<Distance> results = distanceDAO.getDistance(query);
    	Distance[] distances = results.toArray(new Distance[results.size()]);
    	return distances;
    }

	@Override
	public int getMaxQuery() {
		int query = distanceDAO.getMaxQuery();
		return query;
	}

}
