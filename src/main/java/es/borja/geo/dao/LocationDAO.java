package es.borja.geo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import es.borja.geo.model.Location;

@Repository("ILocationDAO")
public class LocationDAO extends AbstractDAO<Integer, Location> implements ILocationDAO {
    
	@Override
	public void save(Location data) {
		persist(data);
	}
	
    @SuppressWarnings("unchecked")
	public List<Location> getData() {
        Criteria criteria = createEntityCriteria();
        List<Location> results = criteria.list();
        return results;
	}
    
    @SuppressWarnings("unchecked")
	public List<Location> getHeat(String timelo, String timehi, Double n, Double e, Double s, Double w) {
    	Criteria criteria = createEntityCriteria()
    		.add(Restrictions.between("time", timelo, timehi))
    		.add(Restrictions.gt("lat", s))
    		.add(Restrictions.lt("lat", n))
    		.add(Restrictions.gt("lon", w))
    		.add(Restrictions.lt("lon", e))
    		.addOrder(Order.asc("time"));
    	List<Location> results = criteria.list();
    	return results;
    }
    
    @SuppressWarnings("unchecked")
	public List<Location> getStops(String timelo, String timehi, Double n, Double e, Double s, Double w) {
    	Criteria criteria = createEntityCriteria()
    		.add(Restrictions.between("time", timelo, timehi))
    		.add(Restrictions.gt("lat", s))
    		.add(Restrictions.lt("lat", n))
    		.add(Restrictions.gt("lon", w))
    		.add(Restrictions.lt("lon", e))
    		.add(Restrictions.gt("quantity", 5));
    	List<Location> results = criteria.list();
    	return results;
    }

	
}
