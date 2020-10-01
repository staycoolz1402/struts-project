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

function ceknpwp(field, fieldName, minLength, maxLength, returnType){
	var npwpExp = /^[0-9][0-9]*$/;
	if(!field.match(npwpExp)) {
		if(returnType == 0){
			return false;
		}else{
			var errMsg = fieldName + 'must numbers!';
        	return errMsg;
		}
	}
	if(eval(field.length) > maxLength || eval(field.length) < minLength){
		if(returnType == 0){
    		return false;
    	}else{
    		var errMsg = fieldName + 'must have ' + minLength + ' or ' + maxLength + ' numbers';
        	return errMsg;
    	}
	}
	return true;
}

function cek_create_account(nilai, min, max, warning, returnType) {
	if (nilai.length < min || nilai.length > max) {
		if(returnType == 0){
    		return false;
    	}else{
    		var errMsg = 'Kolom ' + warning + ' tidak boleh kurang dari ' + min + ' karakter atau lebih dari ' + max + ' karakter';
        	return errMsg;
    	}
	}
	return true;
}

function checkDateGtNow(field, field2, fieldName, returnType){
	
	var tglNow=eval(field.substring(0, field.indexOf("/")));
	var bulanNow=eval(field.substring(field.indexOf("/")+1,field.indexOf("/",field.indexOf("/")+1)));
	var tahunNow=eval(field.substring(field.indexOf("/",field.indexOf("/")+1)+1));

	var tglField=eval(field2.substring(0, field2.indexOf("/")));
	var bulanField=eval(field2.substring(field2.indexOf("/")+1,field2.indexOf("/",field2.indexOf("/")+1)));
	var tahunField=eval(field2.substring(field2.indexOf("/",field2.indexOf("/")+1)+1));
	
	if((tahunField > tahunNow) || (tahunField == tahunNow && bulanField > bulanNow) || (tahunField == tahunNow && bulanField == bulanNow && tglField > tglNow)){
		if(returnType == 0){
    		return false;
    	}else{
    		var errMsg = fieldName + 'must less than or equal today!';
        	return errMsg;
    	}
	}
	
	return true;
}

function requiredPhoneNumberOrHandphone(field, field2, fieldName, returnType){
	if(field=="" && field2=="") {
		if(returnType == 0){
    		return false;
    	}else{
    		var errMsg = fieldName + 'salah satu harus diisi!';
        	return errMsg;
    	}
	}
	
	return true;
}

function validPhoneNumber(field, fieldName, returnType){
	if(!field.match("^(0)[0-9]{2,3}(-)[0-9]{5,8}$")) {
		if(returnType == 0){
    		return false;
    	}else{
    		var errMsg = 'Format ' + fieldName + 'tidak sesuai(Format Kode Area-No.Telepon Cth. 021-31902888)';
        	return errMsg;
    	}
	}
	
	return true;
}

function validHandphone(field, fieldName, returnType){
	if(!field.match("^(0)(8)[0-9]{2}(-)[0-9]{6,9}$")) {
		if(returnType == 0){
    		return false;
    	}else{
    		var errMsg = 'Format ' + fieldName + 'tidak sesuai(Format Kode Provider-No.Telepon Cth. 0812-22334455)';
        	return errMsg;
    	}
	}
	
	return true;
}

function validPhoneNoOrHandphone(field, fieldName, returnType){
	if(!field.match("^(0)[0-9]{2,3}(-)[0-9]{5,9}$")) {
		if(returnType == 0){
    		return false;
    	}else{
    		var errMsg = 'Format ' + fieldName + 'tidak sesuai(Format Kode Area/Kode Provider-No.Telepon Cth. 021-31902888/0812-22334455)';
        	return errMsg;
    	}
	}
	
	return true;
}

function validLength(field, fieldName, length, returnType){
	if(field.length > length || field.length < length) {
		if(returnType == 0){
    		return false;
    	}else{
    		var errMsg = fieldName + 'must be ' + length + ' digits of number';
        	return errMsg;
    	}
	}
	
	return true;
}

function validName(field, fieldName, validasiNama, type, returnType, minLength, maxLength){
	if(type==1){
		if(!requiredField(field, fieldName, 0)){
	    	if(returnType == 0){
        		return false;
        	}else{
        		var errMsg = requiredField(field, fieldName, 1);
        		return errMsg;
        	}
		}
	}
	if(!containNa(field, fieldName, 0)){
    	if(returnType == 0){
    		return false;
    	}else{
    		var errMsg = containNa(field, fieldName, 1);
    		return errMsg;
    	}
	}
	if(!containLetter(field, fieldName, 0)){
    	if(returnType == 0){
    		return false;
    	}else{
    		var errMsg = containLetter(field, fieldName, 1);
    		return errMsg;
    	}
	}
	if(!minLengthField(field, fieldName, minLength, 0)){
    	if(returnType == 0){
    		return false;
    	}else{
    		var errMsg = minLengthField(field, fieldName, minLength, 1);
    		return errMsg;
    	}
	}
	if(!maxLengthField(field, fieldName, maxLength, 0)){
    	if(returnType == 0){
    		return false;
    	}else{
    		var errMsg = maxLengthField(field, fieldName, maxLength, 1);
    		return errMsg;
    	}
	}
	//jika ada perubahan pada fungsi NameValid mohon merubah juga di cfApplicationAction.java fungsi validatePersonal
	for(var i = 0; i < field.length; i++)
    {	
        if(field.charAt(0) == ' '){
        	if(returnType == 0){
        		return false;
        	}else{
        		var errMsg = fieldName + 'tidak boleh ada spasi di depan';
        		return errMsg;
        	}
        }	
        if(field.charAt(i) == ' ' && field.charAt(i-1) == ' '){
        	if(returnType == 0){
        		return false;
        	}else{
        		var errMsg = fieldName + 'tidak boleh ada dobel spasi di tengah';
        		return errMsg;
        	}
        }	
        if(field.charAt(field.length-1) == ' '){
            if(returnType == 0){
        		return false;
        	}else{
        		var errMsg = fieldName + 'tidak boleh ada spasi di akhir';
        		return errMsg;
        	}
        }
        if(field.charAt(i) == 'i' && field.charAt(i-1) == ' ' && field.charAt(i+1) == ' '){
        	 if(returnType == 0){
        		return false;
        	}else{
        		var errMsg = fieldName + 'tidak boleh ada huruf i di tengah';
        		return errMsg;
        	}
        }
        if(field.charAt(i) == 'I' && field.charAt(i-1) == ' ' && field.charAt(i+1) == ' '){
        	 if(returnType == 0){
        		return false;
        	}else{
        		var errMsg = fieldName + 'tidak boleh ada huruf I di tengah';
        		return errMsg;
        	}
        }
    }
    var elementSplit = field.split(" ");
	var validasiNamaSplit = validasiNama.split(";");
	var errMsg = '';
	for(i = 0; i < elementSplit.length; i++){
		for(j = 0; j < validasiNamaSplit.length; j++){
			if(elementSplit[i].toLowerCase()==validasiNamaSplit[j].toLowerCase()) {
				if(returnType == 0){
        			return false;
        		}else{
	        		var errMsg = fieldName + 'tidak boleh mengandung gelar seperti '+elementSplit[i];
	        		return errMsg;
	        	}
			}
		}
	}
	return true;
}

function validPob(field, fieldName, returnType){
	if(field.length>0){
		if(!containNa(field, fieldName, 0)){
	    	if(returnType == 0){
	    		return false;
	    	}else{
	    		var errMsg = containNa(field, fieldName, 1);
	    		return errMsg;
	    	}
		}
	}
	return true;
}

function validDob(field, field2, fieldName, minUmur, maxUmur, returnType){
	if(!requiredField(field, fieldName, 0)){
    	if(returnType == 0){
    		return false;
    	}else{
    		var errMsg = requiredField(field, fieldName, 1);
    		return errMsg;
    	}
	}
	if(!cekDOBMin(field, field2, 0, 0, minUmur)){
		if(returnType == 0){
    		return false;
    	}else{
    		var errMsg = cekDOBMin(field, field2, 0, 1, minUmur);
    		return 'Umur personal tidak boleh '+ errMsg;
    	}
	}
	if(!cekDOBMax(field, field2, 0, 0, maxUmur)){
		if(returnType == 0){
    		return false;
    	}else{
    		var errMsg = cekDOBMax(field, field2, 0, 1, maxUmur);
    		return 'Umur personal tidak boleh '+ errMsg;
    	}
	}
	return true;
}

function validIDNumber(field, fieldName, returnType){
	if(!requiredField(field, fieldName, 0)){
    	if(returnType == 0){
    		return false;
    	}else{
    		var errMsg = requiredField(field, fieldName, 1);
    		return errMsg;
    	}
	}
	if(field.length>0) {
		if(!idNumberCek(field, fieldName, 0)) {
	    	if(returnType == 0){
	    		return false;
	    	}else{
	    		var errMsg = idNumberCek(field, fieldName, 1);
	    		return errMsg;
	    	}
		}
		if(!containNa(field, fieldName, 0)){
	    	if(returnType == 0){
	    		return false;
	    	}else{
	    		var errMsg = containNa(field, fieldName, 1);
	    		return errMsg;
	    	}
		}
	}
	return true;
}

function validAddress(field, fieldName, returnType){
	if(field.length>0){
		if(!containNa(field, fieldName, 0)){
	    	if(returnType == 0){
	    		return false;
	    	}else{
	    		var errMsg = containNa(field, fieldName, 1);
	    		return errMsg;
	    	}
		}
	}
	return true;
}

function validRtRw(field, fieldName, returnType){
	if(!checkNumber(field, fieldName, 0)){
    	if(returnType == 0){
	    	return false;
    	}else{
    		var errMsg = checkNumber(field, fieldName, 1);
    		return errMsg;
    	}
	}
	return true;
}

function validPostalCode(field, fieldName, length, returnType){
	if(!checkNumber(field, fieldName, 0)){
    	if(returnType == 0){
	    	return false;
    	}else{
    		var errMsg = checkNumber(field, fieldName, 1);
    		return errMsg;
    	}
	}
	if(!validLength(field, fieldName, length, 0)){
    	if(returnType == 0){
	    	return false;
    	}else{
    		var errMsg = validLength(field, fieldName, length, 1);
    		return errMsg;
    	}
	}
	if(field == "00000"){
    	if(returnType == 0){
	    	return false;
    	}else{
    		var errMsg = fieldName + "tidak valid";
    		return errMsg;
    	}
	}
	return true;
}

function validPhoneNo(field, fieldName, returnType){
	if(field.length>0){
		if(!validPhoneNumber(field, fieldName, 0)){
	    	if(returnType == 0){
		    	return false;
	    	}else{
	    		var errMsg = validPhoneNumber(field, fieldName, 1);
	    		return errMsg;
	    	}
		}
		if(!containNa(field, fieldName, 0)){
	    	if(returnType == 0){
		    	return false;
	    	}else{
	    		var errMsg = containNa(field, fieldName, 1);
	    		return errMsg;
	    	}
		}
	}
	return true;	
}

function validHandphoneNo(field, fieldName, returnType){
	if(field.length>0){
		if(!validHandphone(field, fieldName, 0)){
	    	if(returnType == 0){
		    	return false;
	    	}else{
	    		var errMsg = validHandphone(field, fieldName, 1);
	    		return errMsg;
	    	}
		}
		if(!containNa(field, fieldName, 0)){
	    	if(returnType == 0){
		    	return false;
	    	}else{
	    		var errMsg = containNa(field, fieldName, 1);
	    		return errMsg;
	    	}
		}
	}
	return true;
}

function containNa(field, fieldName, returnType){
	var check = trim(field).toLowerCase();
	if(check=="na" || check=="n.a" || check=="n/a"){
		if(returnType == 0){
    		return false;
    	}else{
    		var errMsg = fieldName + 'must not like NA, N.A, N/A!';
        	return errMsg;
    	}
	}
	
	return true;
}

function idNumberCek(element, fieldName, returnType){
	var rex = /^[0-9A-Z]*$/;
	if(!element.match(rex)) {
		if(returnType == 0){
    		return false;
    	}else{
    		var errMsg = fieldName + 'harus angka atau huruf besar, tidak boleh menggunakan tanda baca, spesial karakter dan huruf kecil';
    		return errMsg;
    	}
	}
	return true;
}

function cekIdPaspor(element, fieldName, returnType){
	if(element.length > 8 ) {
		if(returnType == 0){
    		return false;
    	}else{
    		var errMsg = fieldName + 'tidak boleh lebih dari 8 karakter';
    		return errMsg;
    	}
	}
	element = element.replace(/[0-9]/g,'');
	if(element.length > 1 || element.length < 1) {
		if(returnType == 0){
    		return false;
    	}else{
    		var errMsg = fieldName + 'hanya boleh menggunakan 1 huruf';
    		return errMsg;
    	}
	}
	
	return true;
}

function cekIdKtp(element, fieldName, returnType){
	element = element.replace(/[0-9]/g,'');
	if(element.length > 0) {
		if(returnType == 0){
    		return false;
    	}else{
    		var errMsg = fieldName + 'tidak boleh menggunakan huruf';
    		return errMsg;
    	}
	}
	
	return true;
}



