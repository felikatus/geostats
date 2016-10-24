package es.borja.geo.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Distance")
public class Distance implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Id
	@Column(name="query")
	private Integer query;	
	
	@Id
	@Column(name="distance")
	private Integer distance;	
	
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the query
	 */
	public Integer getQuery() {
		return query;
	}

	/**
	 * @param email the email to set
	 */
	public void setQuery(Integer query) {
		this.query = query;
	}

	/**
	 * @return the lat
	 */
	public Integer getDistance() {
		return distance;
	}

	/**
	 * @param lat the lat to set
	 */
	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	
 
	
}
