package es.borja.geo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import es.borja.geo.model.Distance;

@Repository("IDistanceDAO")
public class DistanceDAO extends AbstractDAO<Integer, Distance> implements IDistanceDAO {

	@Override
	public void save(Distance data) {
		persist(data);
		
	}
	
    @SuppressWarnings("unchecked")
	public List<Distance> getData() {
        Criteria criteria = createEntityCriteria()
        		.addOrder(Order.desc("distance"));
        List<Distance> results = criteria.list();
        return results;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Distance> getDistance(Integer query) {
		Criteria criteria = createEntityCriteria()
				.addOrder(Order.desc("distance"))
	    		.add(Restrictions.eq("query", query));
    	List<Distance> results = criteria.list();
    	return results;
	}

	@Override
	public int getMaxQuery() {
		Criteria criteria = createEntityCriteria()
			    .setProjection(Projections.max("query"));
		Integer maxQuery = (Integer)criteria.uniqueResult();
		if (maxQuery == null) maxQuery = 0;
		return maxQuery;
	}

	
}
