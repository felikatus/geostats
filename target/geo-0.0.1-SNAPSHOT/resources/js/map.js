/**
 * 
 */
var map, heatmap;

function initMap() {
	  map = new google.maps.Map(document.getElementById('map'), {
		    zoom: 15,
		    center: {lat: parseFloat(myModel.lat), lng: parseFloat(myModel.lon)},
		    mapTypeId: google.maps.MapTypeId.SATELLITE
		  });
	  heatmap = new google.maps.visualization.HeatmapLayer({
		    data: getPoints(),
		    map: map
		  });
	  heatmap.set('radius', heatmap.get('radius') ? null : 10);
}
	


function getPoints() {
	var result = [];
	var locations = myModel.locations;
	locations = locations.slice(1, -1);
	locations = locations.split(",");
	alert(locations[0]);
	for (i in locations) {
		loc = locations[i].split("#");
		result.push(new google.maps.LatLng(loc[0], loc[1]), loc[2]);

	}
	alert(result);
	  return result;
}
	
jQuery(document).ready(function($) {
	


	$('#msg').html(myModel.locations)

});