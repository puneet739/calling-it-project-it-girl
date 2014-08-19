<!DOCTYPE html>
<html>
  <head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <style type="text/css">
      html { height: 100% }
      body { height: 100%; margin: 0; padding: 0 }
      #map-canvas { height: 100% }
    </style
>    <script type="text/javascript"
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCh-t_LBkS9dKDRPTkScNoHhYLLYVtsStU">
    </script>
    <script type="text/javascript">
      function initialize() {
        var mapOptions = {
          center: new google.maps.LatLng(28.4211, 77.3078),
          zoom: 13,
        minZoom:13
        };
        var map = new google.maps.Map(document.getElementById("map-canvas"),
            mapOptions);

         var contentOfMarker = '<div id="content"> This is the content, Balle balle Lod of content here..asdasdasdasd  </div>';
         var infowindow = new google.maps.InfoWindow({
            content: contentOfMarker
          });

         var myLatlng = new google.maps.LatLng(28.4792083,77.310794,17);
         var marker = new google.maps.Marker({
      position: myLatlng,
      map: map,
      title: 'Puneet Market Area'
  });
         google.maps.event.addListener(marker, 'click', function() {
    infowindow.open(map,marker);  });


      }

      google.maps.event.addDomListener(window, 'load', initialize);
    </script>
  </head>
  <body>
    <div id="map-canvas"/>
  </body>
</html>
