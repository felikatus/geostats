/**
 * 
 */
var map, heatmap;

function initMap() {
	  map = new google.maps.Map(document.getElementById('map'), {
		    zoom: 13,
		    center: {lat: 37.775, lng: -122.434},
		    mapTypeId: google.maps.MapTypeId.SATELLITE
		  });
	  heatmap = new google.maps.visualization.HeatmapLayer({
		    data: getPoints(),
		    map: map
		  });
	  heatmap.set('radius', heatmap.get('radius') ? null : 10);
}
	


function getPoints() {
	  return [
	    { location: new google.maps.LatLng(37.782745, -122.444586), weight: 50  },
	    { location: new google.maps.LatLng(37.782842, -122.443688), weight: 5   },
	    { location: new google.maps.LatLng(37.782919, -122.442815), weight: 5   },
	    { location: new google.maps.LatLng(38.782992, -122.442112), weight: 500 },
	    { location: new google.maps.LatLng(37.783100, -122.441461), weight: 5   },
	    { location: new google.maps.LatLng(37.783206, -122.440829), weight: 100 }


	  ];
}
	
jQuery(document).ready(function($) {
	


	$('#msg').html(myModel.paramOne)
	alert(myModel.paramOne)

});