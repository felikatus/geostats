package es.borja.geo.bean;

import javax.validation.constraints.NotNull;

import es.borja.geo.model.Location;

public class LocationBean {

	private Integer id;
	
	@NotNull
	private String time;	
	
	@NotNull
	private Double lat;
	
	@NotNull
	private Double lon;
	
	@NotNull
	private int quantity;
	
	

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
	 * @return the email
	 */
	public String getTime() {
		return time;
	}


	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * @return the lat
	 */
	public Double getLat() {
		return lat;
	}

	/**
	 * @param lat the lat to set
	 */
	public void setLat(Double lat) {
		this.lat = lat;
	}

	/**
	 * @return the lon
	 */
	public Double getLon() {
		return lon;
	}

	/**
	 * @param lon the lon to set
	 */
	public void setLon(Double lon) {
		this.lon = lon;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Location toModel(){
		Location location = new Location();
		location.setTime(this.getTime());
		location.setId(this.getId());
		location.setLat(this.getLat());
		location.setLon(this.getLon());
		location.setQuantity(this.getQuantity());
		
		return location;
	}
}
