function nulis(a){
	var tulis = "";
	var koma = a.indexOf(".");
	if(koma == -1){
		var string1 = a;
		var string2 = "";
	}
	else{
		var string1 = a.substring(0, koma);
		var string2 = a.substring(koma, a.length);
	}
	for(i=0;i<string1.length;i++){
		if((string1.length-i)%3==0 && i!=0)
		{
			tulis+=",";
		}
		tulis+=string1.charAt(i);
	}
	tulis = tulis + string2;
	return tulis;
}

function angka(a){
	var tulis="";
	for(i=0;i<a.length;i++){
		if(a.charAt(i)==",")
		{
			continue;
		}
		tulis+=a.charAt(i);
	}
	return eval(tulis);
}

function cek(a){
	var tulis="";
	for(i=0;i<a.length;i++){
		if(a.charAt(i)==",")
		{
			continue;
		}
		tulis+=a.charAt(i);
	}
	return tulis;
}

function cekDigit(nilai,digit){
	hitung = 0, flag = 0;
	for(i=0; i<nilai.length; i++){
		if(nilai.charAt(i)==".") flag = 1;
		if(flag==1)hitung++; 				
	}
	return hitung-1;
}

function splitName(name,input,msg){

	var formname = document.forms[0].elements[name];
	var fullName = trim(formname.value);
	
	var fullNameResult = fullName.split(" ");
	for(i = 0; i < fullNameResult.length; i++){
		for(j = 0; j < input.length; j++){
			if(ValidateName(fullNameResult[i])){
				alert( 'Name only containing letter' );
				return true;
			}
			if (fullNameResult[i].toLowerCase() == 'i' && i > 0) {
				alert( msg+' must not contain title or abbreviation. Like I ');
				return true;
			}
			if(fullNameResult[i].toLowerCase()==input[j].toLowerCase()) {
				alert( msg+' must not contain title or abbreviation. Like '+fullNameResult[i] );
				return true;
			}
		}
	}
	
}

function validateEmail(field, fieldName, returnType)
{		
	if(!field.match("^[a-zA-Z0-9]+(([_]|\\.|-)?[a-zA-Z0-9])*@([a-zA-Z0-9]+([_]|-?[a-zA-Z0-9])*(\\.))+[a-zA-Z]{2,4}$")) {
		if(returnType == 0){
    		return false;
    	}else{
    		var errMsg = fieldName + 'is invalid format!';
        	return errMsg;
    	}
	}
	
	return true;
}

function ValidateName(object_value)
{		
	name_pattern=new RegExp("^[a-zA-Z\\s]+(\\s)*$");
	return object_value.search(name_pattern);
}

function cekDOBMin(field, openingdate, tenor, returnType, min) {
    var dayNow=eval(openingdate.substring(0,openingdate.indexOf("/")));
    var monthNow=eval(openingdate.substring(openingdate.indexOf("/")+1,openingdate.indexOf("/",openingdate.indexOf("/")+1)));
    var yearNow=eval(openingdate.substring(openingdate.indexOf("/",openingdate.indexOf("/")+1)+1));
    var dayDOB=eval(field.substring(0,field.indexOf("/")));
    var monthDOB=eval(field.substring(field.indexOf("/")+1,field.indexOf("/",field.indexOf("/")+1)));
    var yearDOB=eval(field.substring(field.indexOf("/",field.indexOf("/")+1)+1));
    if ((((((((yearNow-yearDOB)*12) - monthDOB + monthNow)/12)*365)- dayDOB + dayNow)/365) < min)  {
        if(returnType == 0){
            return false;
        }else{
            var errMsg = 'di bawah ' + min + ' tahun.';
            return errMsg;
        }
    }
    return true;
} 

function cekDOBMax(field, openingdate, tenor, returnType, max) {
	var monthNow=eval(openingdate.substring(openingdate.indexOf("/")+1,openingdate.indexOf("/",openingdate.indexOf("/")+1)));
	var yearNow=eval(openingdate.substring(openingdate.indexOf("/",openingdate.indexOf("/")+1)+1));
	
	var monthDOB=eval(field.substring(field.indexOf("/")+1,field.indexOf("/",field.indexOf("/")+1)));
	var yearDOB=eval(field.substring(field.indexOf("/",field.indexOf("/")+1)+1));
	
	if (((((yearNow-yearDOB)*12) - monthDOB + monthNow)/12) + (tenor/12) > max) {
		if(returnType == 0){
			return false;
		}else{
			var errMsg = 'di atas ' + max + ' tahun.';
			return errMsg;
		}
	}
	return true;
}

function isNum(e){	//angka only
	var key = window.event ? e.keyCode : e.which;
	 
	if ((key > 47 && key < 58) || key == 8 || key == 0) return true; 
	return false;
}

function trim(sString){
	while (sString.substring(0,1) == ' ')
	{
		sString = sString.substring(1, sString.length);
	}
	while (sString.substring(sString.length-1, sString.length) == ' ')
	{
		sString = sString.substring(0,sString.length-1);
	}
	return sString;
}

function maxLengthField(field, fieldName, maxLength, returnType){
	if(field.length > maxLength) {
		if(returnType == 0){
    		return false;
    	}else{
    		var errMsg = fieldName + 'maksimal ' + maxLength + ' huruf';
        	return errMsg;
    	}
	}
	
	return true;
}

function minLengthField(field, fieldName, minLength, returnType){
	if(field.length < minLength) {
		if(returnType == 0){
    		return false;
    	}else{
    		var errMsg = fieldName + 'minimal ' + minLength + ' huruf';
        	return errMsg;
    	}
	}
	
	return true;
}

function checkNumber(field, fieldName, returnType){
	if(!field.match("^[0-9]*$")) {
		if(returnType == 0){
    		return false;
    	}else{
    		var errMsg = fieldName + 'must numeric!';
        	return errMsg;
    	}
	}
	
	return true;
}

function containLetter(field, fieldName, returnType){
	if(!field.match("^[a-zA-Z][a-zA-Z ]*$")) {
		if(returnType == 0){
    		return false;
    	}else{
    		var errMsg = fieldName + 'can only contain letter!';
        	return errMsg;
    	}
	}
	
	return true;
}

function containLetterNumber(field, fieldName, returnType){
	if(!field.match("^[a-zA-Z][a-zA-Z 0-9 ]*$")) {
		if(returnType == 0){
    		return false;
    	}else{
    		var errMsg = fieldName + 'can only contain letter!';
        	return errMsg;
    	}
	}
	
	return true;
}

function containLetterNumDotComSlashSpace(field, fieldName, returnType){
	if(!field.match("^[a-zA-Z][a-zA-Z0-9.,'/ ]*$")) {
		if(returnType == 0){
    		return false;
    	}else{
    		var errMsg = fieldName + 'must start with a letter and contain only letters, numbers, dot, comma, slash, and space!';
        	return errMsg;
    	}
	}
	
	return true;
}

function requiredField(field, fieldName, returnType){
	if(field=="") {
		if(returnType == 0){
    		return false;
    	}else{
    		var errMsg = fieldName + 'is required!';
        	return errMsg;
    	}
	}
	
	return true;
}

function validnote(maxchars,x) {
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
		
	   alert("Batas maks 255 karakter  pada note, anda telah memasukkan "+valueLength+" karakter!");
	   returnValue = false;
	   
	}
	
	if(note.length>0) {
		
		if (note[0].charCodeAt(0) == '32') {
			alert("Cek kembali catatan. First Input Tidak Boleh SPASI, TAB, DAN ENTER");
			returnValue = false;
		}
		if (note[note.length-1].charCodeAt(0) == '32' || note[note.length-1].charCodeAt(0) == '9' || note[note.length-1].charCodeAt(0) == '10') {
			alert("Cek kembali catatan. Last Input Tidak Boleh SPASI, TAB, DAN ENTER");
			returnValue = false;
		}
		
	}
	
	return returnValue;
}

var lastKeyPress = 0;
var countEnter = 0;
var countEvent = 0;
$(document).keypress(
		function(event){
			if(countEvent==0){
				if(event.which != lastKeyPress){
					if(event.which == '13'){
						countEnter = countEnter + 1;
					}else{
						countEnter = 0;
					}
		    		lastKeyPress = event.which;
		    		countEvent++;
		    	}else{
		    		if(event.which == '13') {
		    			if(countEnter <= 1){
		    				countEnter = countEnter + 1;
		    			}else{
		    				event.preventDefault();
		    			}
			    	}else if(event.which == '32'){
			    		event.preventDefault();
			    	}
		    		countEvent++;
		    	}
			}else{
				countEvent=0;
				return true;
			}
		}
	);

