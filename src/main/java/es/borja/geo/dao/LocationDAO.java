package es.borja.geo.dao;

import java.util.List;

import org.hibernate.Criteria;
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
	
}
