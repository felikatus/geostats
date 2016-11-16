/**
 * 
 */
var map, heatmap;



function initMap() {
	  var map = new google.maps.Map(document.getElementById('map'), {
		    zoom: 15,
		    center: {lat: parseFloat(myModel.lat), lng: parseFloat(myModel.lon)},
		    mapTypeId: google.maps.MapTypeId.MAP
		  });
	  
	  var routes = getPoints();
	  
	  
    var f1 = [
    {lat: 39.4719, lng: -6.39},
    {lat: 39.4729, lng: -6.3895},
    {lat: 39.4759, lng: -6.39},
    {lat: 39.4736, lng: -6.3940},
    {lat: 39.47, lng: -6.3913},
  ];

var f2 = [
    {lat: 39.4530, lng: -6.37},
    {lat: 39.4545, lng: -6.36},
    {lat: 39.4569, lng: -6.37},
    {lat: 39.4563, lng: -6.3739},
    {lat: 39.45, lng: -6.36},
  ];
	  
routes.push(f1);
routes.push(f2);
	  
	  var Colors = [
		    "#FF0000", 
		    "#00FF00", 
		    "#0000FF", 
		    "#FFFFFF", 
		    "#000000", 
		    "#FFFF00", 
		    "#00FFFF", 
		    "#FF00FF"
		];
	  
      for (i in routes) {
    	  r = routes[i];
    	  var routesMap = new google.maps.Polyline({
   		    path: r,
  		    strokeColor: '#'+(0x1000000+(Math.random())*0xffffff).toString(16).substr(1,6),
  		    strokeOpacity: 1.0,
  		    strokeWeight: 2
  		  });
    	  routesMap.setMap(map);
      }
	  
}
	

function getPoints() {

	var result = [];
	var routes = [];
	var locations = myModel.locations;
	var devices = locations.slice(1, -1);
	devices = devices.split("], ");
	for (d in devices) {
		var locs = devices[d].slice(1, -1);
		locs = locs.split(",")
		for (i in locs) {
			loc = locs[i].split("#");
			var point = {
					lat: +loc[0],
					lng: +loc[1]
			}
			routes.push(point);
	
		}
		result.push(routes);
		routes = [];
	}
	return result;
}

	
jQuery(document).ready(function($) {
	


});