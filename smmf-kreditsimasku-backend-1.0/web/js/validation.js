//this function includes all necessary js files for the application
function include(file)
{
  var script  = document.createElement('script');
  script.src  = file;
  script.type = 'text/javascript';
  script.defer = true;

  document.getElementsByTagName('head').item(0).appendChild(script);
}

/* include any js files here */
include('../js/hitung.js');

function validasinote(maxchars,x,property) {
	var note = x;
	var valueLength = 0;
	var returnValue = true;

	for(var i = 0 ; i < note.length ; i++){
		if (note[i].charCodeAt(0) == '10') {
			valueLength++;
		}
		valueLength++;
	}
	
	if(valueLength> maxchars) {
		
	   alert("Batas maks "+maxchars+" karakter pada "+property+", anda telah memasukkan "+valueLength+" karakter!");
	   returnValue = false;
	   
	}
	
	if(note.length>0) {
		
		if (note[0].charCodeAt(0) == '32') {
			alert("Cek kembali "+property+". First Input Tidak Boleh SPASI, TAB ATAU ENTER");
			returnValue = false;
		}
		if (note[note.length-1].charCodeAt(0) == '32' || note[note.length-1].charCodeAt(0) == '9' || note[note.length-1].charCodeAt(0) == '10') {
			alert("Cek kembali "+property+". Last Input Tidak Boleh SPASI, TAB ATAU ENTER");
			returnValue = false;
		}
		
	}
	
	return returnValue;
}
