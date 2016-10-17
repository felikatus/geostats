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
	  heatmap.set('radius', heatmap.get('radius') ? null : 25);
}
	


function getPoints() {
	var result = [];
	var locations = myModel.locations;
	locations = locations.slice(1, -1);
	locations = locations.split(",");
	for (i in locations) {
		loc = locations[i].split("#");
		var point = {
				location: new google.maps.LatLng(loc[0], loc[1]), 
				weight: +loc[2]
		}
		result.push(point);

	}
	return result;
}

//function getPoints() {
//	var result = [];
//	var locations = myModel.locations;
//	locations = locations.slice(1, -1);
//	locations = locations.split(",");
//	for (i in locations) {
//		loc = locations[i].split("#");
//		result.push(new google.maps.LatLng(loc[0], loc[1]));
//	}
//	return result;
//}
	
jQuery(document).ready(function($) {
	


});