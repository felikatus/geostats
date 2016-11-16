package es.borja.geo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import es.borja.geo.model.Location;
import es.borja.geo.model.RoutePoint;

@Repository("IRouterPointDAO")
public class RoutePointDAO extends AbstractDAO<Integer, RoutePoint> implements IRoutePointDAO {
    
	@Override
	public void save(RoutePoint data) {
		persist(data);
	}
	
    @SuppressWarnings("unchecked")
	public List<RoutePoint> getData() {
        Criteria criteria = createEntityCriteria();
        List<RoutePoint> results = criteria.list();
        return results;
	}
    
    @SuppressWarnings("unchecked")
	public List<RoutePoint> getRoute(String timelo, String timehi, Double n, Double e, Double s, Double w) {
    	Criteria criteria = createEntityCriteria()
    		.add(Restrictions.between("time", timelo, timehi))
    		.add(Restrictions.gt("lat", s))
    		.add(Restrictions.lt("lat", n))
    		.add(Restrictions.gt("lon", w))
    		.add(Restrictions.lt("lon", e))
    		.addOrder(Order.asc("device"))
    		.addOrder(Order.asc("time"));
    	List<RoutePoint> results = criteria.list();
    	return results;
    }
    
	
}
