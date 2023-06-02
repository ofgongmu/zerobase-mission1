/**
 * 
 */

let lat = "";
let lnt = "";

function getLocation() {
	if (navigator.geolocation) {
		navigator.geolocation.getCurrentPosition(Success, Error);	
		document.getElementById("LAT").value = lat;
 		document.getElementById("LNT").value = lnt;
	} 
}



 function Success(position) {
	 lat = position.coords.latitude;
	 lnt = position.coords.longitude;
 }
 
 function Error(err) {
	lat = "N/A";
	lnt = "N/A";
	console.warn(`ERROR(${err.code}): ${err.message}`);
 }
 
 
 
 