<html>
<head>
<jsp:include page="headingscript.jsp" />
</head>
<body>
	<jsp:include page="header.jsp" />

	<div id="map-canvas" style="height: 100%"></div>

	<jsp:include page="footer.jsp" />
</body>

<script type="text/javascript" src="js/fairdeal-maps.js"></script>

<script>
	var listing = ${listing};
	drawMarkerList(listing);
</script>
</html>
