//This is used to store common javascript function for our application. 

var googlemapkey = 'AIzaSyCh-t_LBkS9dKDRPTkScNoHhYLLYVtsStU';
var map;

function initializeMap() {
	var mapOptions = {
		center : new google.maps.LatLng(28.4211, 77.3078),
		zoom : 13,
		minZoom : 13
	};
	map = new google.maps.Map(document.getElementById("map-canvas"),
			mapOptions);
}

initializeMap();
//google.maps.event.addDomListener(window, 'load', initializeMap);
