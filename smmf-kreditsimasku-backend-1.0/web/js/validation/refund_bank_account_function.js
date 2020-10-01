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
//include('../js/hitung.js');

function cekAccountNumber(field){
	var accountNumber = /^[0-9][0-9]*$/;
	if(field.match(accountNumber)) {
		return true;
	}
	return false;
}

function ceknpwpkosong(field, fieldName, returnType){
	if(field == "000000000000000" || field.value == "00000000000000"){
		if(returnType == 0){
    		return false;
    	}else{
    		var errMsg = fieldName + 'must not be 000000000000000!';
        	return errMsg;
    	}
	}
	return true;
}

