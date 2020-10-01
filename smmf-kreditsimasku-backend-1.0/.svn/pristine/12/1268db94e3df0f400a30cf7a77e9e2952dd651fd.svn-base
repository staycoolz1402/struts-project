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
include('../js/validation/personal_function.js');


function onChangeDateOfIssue(field, field2){
	if(!checkDateGtNow(field, field2, "ID date of issue ", 0)){
		var errMsg = checkDateGtNow(field, field2, "ID date of issue ", 1);
    	alert(errMsg);
		document.forms[0].idDateOfIssue.value = field;
		return false;
	}
}

function validCreateEdit(){
	//validasi full name
	if(!validName(document.forms[0].fullName.value, "Full Name ", document.forms[0].validasiNama.value, 1, 0, 1, 50)){
		var errMsg = validName(document.forms[0].fullName.value, "Full Name ", document.forms[0].validasiNama.value, 1, 1, 1, 50);
		alert(errMsg);
		return false;
	}
	
	//validasi place of birth
	if(!requiredField(document.forms[0].placeOfBirth.value, "Place of Birth ", 0)){
    	var errMsg = requiredField(document.forms[0].placeOfBirth.value, "Place of Birth ", 1);
    	alert(errMsg);
    	return false;
	}
	if(!validPob(document.forms[0].placeOfBirth.value, "Place of Birth ", 0)){
		var errMsg = validPob(document.forms[0].placeOfBirth.value, "Place of Birth ", 1);
    	alert(errMsg);
    	return false;
	}
	//validasi date of birth
	if(!validDob(document.forms[0].dateOfBirth.value, document.forms[0].personalOpeningDate.value, "Date of birth ", document.forms[0].minimumUmur.value, document.forms[0].maximumUmur.value, 0)){
		var errMsg = validDob(document.forms[0].dateOfBirth.value, document.forms[0].personalOpeningDate.value, "Date of birth ", document.forms[0].minimumUmur.value, document.forms[0].maximumUmur.value, 1);
    	alert(errMsg);
    	return false;
	}
	
	//validasi gender
	if(!requiredField(document.forms[0].gender.value, "Gender ", 0)){
    	var errMsg = requiredField(document.forms[0].gender.value, "Gender ", 1);
    	alert(errMsg);
    	return false;
	}
	
	//validasi mother maiden name
	if(!validName(document.forms[0].motherMaidenName.value, "Mother maiden name ", document.forms[0].validasiNama.value, 1, 0, 2, 50)){
		var errMsg = validName(document.forms[0].motherMaidenName.value, "Mother maiden name ", document.forms[0].validasiNama.value, 1, 1, 2, 50);
		alert(errMsg);
		return false;
	}
	
	//validasi id number
	if(!validIDNumber(document.forms[0].idNumber.value, "ID Number ", 0)){
		var errMsg = validIDNumber(document.forms[0].idNumber.value, "ID Number ", 1);
		alert(errMsg);
		return false;
	}
	
	if(document.forms[0].identificationCardId.value ==13){
		var cek = document.forms[0].idNumber.value;
		if(!cekIdKtp(cek,"Nomor KTP ", 0)){
	    	var errMsg = cekIdKtp(cek,"Nomor KTP ", 1);
	    	alert(errMsg);
	    	return false;
		}
	}
	
	if(document.forms[0].identificationCardId.value ==181){
		var cek = document.forms[0].idNumber.value;
		if(!cekIdPaspor(cek,"Nomor Paspor ", 0)){
	    	var errMsg = cekIdPaspor(cek,"Nomor Paspor ", 1);
	    	alert(errMsg);
	    	return false;
		}
	}
	
	//validasi id date of issue
	if(!requiredField(document.forms[0].idDateOfIssue.value, "ID date of issue ", 0)){
    	var errMsg = requiredField(document.forms[0].idDateOfIssue.value, "ID date of issue ", 1);
    	alert(errMsg);
    	return false;
	}
	if(!checkDateGtNow(document.forms[0].hiddenNowDate.value, document.forms[0].idDateOfIssue.value, "ID date of issue ", 0)){
		var errMsg = checkDateGtNow(document.forms[0].hiddenNowDate.value, document.forms[0].idDateOfIssue.value, "ID date of issue ", 1);
    	alert(errMsg);
		document.forms[0].idDateOfIssue.value = document.forms[0].hiddenNowDate.value;
		return false;
	}
	
	//validasi id date of expired
	if( document.forms[0].lifeTime.checked ) {
		document.forms[0].idExpiredDate.value="";
	}else{
		if(!requiredField(document.forms[0].idExpiredDate.value, "ID expired date ", 0)){
	    	var errMsg = requiredField(document.forms[0].idExpiredDate.value, "ID expired date ", 1);
	    	alert(errMsg);
	    	return false;
		}
	}
	
	//validasi number of dependent
	if(!requiredField(document.forms[0].numberOfDependent.value, "Number of dependent ", 0)){
    	var errMsg = requiredField(document.forms[0].numberOfDependent.value, "Number of dependent ", 1);
    	alert("Number of dependent "+errMsg);
    	return false;
	}
	if(!checkNumber(document.forms[0].numberOfDependent.value, "Number of dependent ", 0)){
    	var errMsg = checkNumber(document.forms[0].numberOfDependent.value, "Number of dependent ", 1);
    	alert(errMsg);
    	return false;
	}
	
	return true;
}

function validAddCreateEdit(){
	if(validCreateEdit()){
		//validasi address1
		if(!requiredField(document.forms[0].address1.value, "Address1 ", 0)){
			var errMsg = requiredField(document.forms[0].address1.value, "Address1 ", 1);
			alert(errMsg);
			return false;
		}
		if(!validAddress(document.forms[0].address1.value, "Address1 ", 0)){
			var errMsg = validAddress(document.forms[0].address1.value, "Address1 ", 1);
	    	alert(errMsg);
	    	return false;
		}
		
		//validasi rt
		if(!requiredField(document.forms[0].rt.value, "RT ", 0)){
	    	var errMsg = requiredField(document.forms[0].rt.value, "RT ", 1);
	    	alert(errMsg);
	    	return false;
		}
		if(!validRtRw(document.forms[0].rt.value, "RT ", 0)){
			var errMsg = validRtRw(document.forms[0].rt.value, "RT ", 1);
	    	alert(errMsg);
	    	return false;
		}
		
		//validasi rw
		if(!requiredField(document.forms[0].rw.value, "RW ", 0)){
	    	var errMsg = requiredField(document.forms[0].rw.value, "RW ", 1);
	    	alert(errMsg);
	    	return false;
		}
		if(!validRtRw(document.forms[0].rw.value, "RW ", 0)){
			var errMsg = validRtRw(document.forms[0].rw.value, "RW ", 1);
	    	alert(errMsg);
	    	return false;
		}
		
		//validasi province
		if(!requiredField(document.getElementById("provinceId").value, "Province ", 0)){
	    	var errMsg = requiredField(document.getElementById("provinceId").value, "Province ", 1);
	    	alert(errMsg);
	    	return false;
		}
		
		//validasi city
		if(!requiredField(document.getElementById("cityId").value, "City ", 0)){
	    	var errMsg = requiredField(document.getElementById("cityId").value, "City ", 1);
	    	alert(errMsg);
	    	return false;
		}
		
		//validasi kecamatan
		if(!requiredField(document.getElementById("kecamatanId").value, "Kecamatan ", 0)){
	    	var errMsg = requiredField(document.getElementById("kecamatanId").value, "Kecamatan ", 1);
	    	alert(errMsg);
	    	return false;
		}
		
		//validasi kelurahan
		if(!requiredField(document.getElementById("kelurahanId").value, "Kelurahan ", 0)){
	    	var errMsg = requiredField(document.getElementById("kelurahanId").value, "Kelurahan ", 1);
	    	alert(errMsg);
	    	return false;
		}
		
		//validasi postal code
		if(!requiredField(document.getElementById("postalCode").value, "Postal code ", 0)){
	    	var errMsg = requiredField(document.getElementById("postalCode").value, "Postal code ", 1);
	    	alert(errMsg);
	    	return false;
		}
		if(!validPostalCode(document.getElementById("postalCode").value, "Postal code ", 5, 0)){
			var errMsg = validPostalCode(document.getElementById("postalCode").value, "Postal code ", 5, 1);
	    	alert(errMsg);
	    	return false;
		}
		
		//validasi phone number1
		if(!requiredPhoneNumberOrHandphone(document.forms[0].phoneNumber1.value, document.forms[0].handphone1.value, "Phone number 1 atau Handphone 1 ", 0)){
	    	var errMsg = requiredPhoneNumberOrHandphone(document.forms[0].phoneNumber1.value, document.forms[0].handphone1.value, "Phone number 1 atau Handphone 1 ", 1);
	    	alert(errMsg);
	    	return false;
		}
		if(!validPhoneNo(document.forms[0].phoneNumber1.value, "Phone number 1 ", 0)){
			var errMsg = validPhoneNo(document.forms[0].phoneNumber1.value, "Phone number 1 ", 1);
	    	alert(errMsg);
	    	return false;
		}
		
		//validasi phone number2
		if(!validPhoneNo(document.forms[0].phoneNumber2.value, "Phone number 2 ", 0)){
			var errMsg = validPhoneNo(document.forms[0].phoneNumber2.value, "Phone number 2 ", 1);
	    	alert(errMsg);
	    	return false;
		}
		
		//validasi handphone1
		if(!validHandphoneNo(document.forms[0].handphone1.value, "Handphone 1 ", 0)){
			var errMsg = validHandphoneNo(document.forms[0].handphone1.value, "Handphone 1 ", 1);
	    	alert(errMsg);
	    	return false;
		}
		
		//validasi handphone2
		if(!validHandphoneNo(document.forms[0].handphone2.value, "Handphone 2 ", 0)){
			var errMsg = validHandphoneNo(document.forms[0].handphone2.value, "Handphone 2 ", 1);
	    	alert(errMsg);
	    	return false;
		}
		
		//validasi email
		if(document.forms[0].email.value.length>0){
			if(!validateEmail(document.forms[0].email.value, "Email ", 0)){
				var errMsg = validateEmail(document.forms[0].email.value, "Email ", 1);
		    	alert(errMsg);
		    	return false;
			}
		}
		
		//validasi letter address1
		if(!requiredField(document.getElementById("letterAddress1").value, "Letter address1 ", 0)){
	    	var errMsg = requiredField(document.getElementById("letterAddress1").value, "Letter address1 ", 1);
	    	alert(errMsg);
	    	return false;
		}
		if(!validAddress(document.getElementById("letterAddress1").value, "Letter address1 ", 0)){
			var errMsg = validAddress(document.getElementById("letterAddress1").value, "Letter address1 ", 1);
	    	alert(errMsg);
	    	return false;
		}
		
		//validasi letter rt
		if(!requiredField(document.getElementById("letterRt").value, "Letter RT ", 0)){
	    	var errMsg = requiredField(document.getElementById("letterRt").value, "Letter RT ", 1);
	    	alert(errMsg);
	    	return false;
		}
		if(!validRtRw(document.getElementById("letterRt").value, "Letter RT ", 0)){
			var errMsg = validRtRw(document.getElementById("letterRt").value, "Letter RT ", 1);
	    	alert(errMsg);
	    	return false;
		}
		
		//validasi letter rw
		if(!requiredField(document.getElementById("letterRw").value, "Letter RW ", 0)){
	    	var errMsg = requiredField(document.getElementById("letterRw").value, "Letter RW ", 1);
	    	alert(errMsg);
	    	return false;
		}
		if(!validRtRw(document.getElementById("letterRw").value, "Letter RW ", 0)){
			var errMsg = validRtRw(document.getElementById("letterRw").value, "Letter RW ", 1);
	    	alert(errMsg);
	    	return false;
		}
		
		//validasi letter province
		if(!requiredField(document.getElementById("letterProvinceId").value, "Letter province ", 0)){
	    	var errMsg = requiredField(document.getElementById("letterProvinceId").value, "Letter province ", 1);
	    	alert(errMsg);
	    	return false;
		}
		
		//validasi letter city
		if(!requiredField(document.getElementById("letterCityId").value, "Letter city ", 0)){
	    	var errMsg = requiredField(document.getElementById("letterCityId").value, "Letter city ", 1);
	    	alert(errMsg);
	    	return false;
		}
		
		//validasi letter kecamatan
		if(!requiredField(document.getElementById("letterKecamatanId").value, "Letter kecamatan ", 0)){
	    	var errMsg = requiredField(document.getElementById("letterKecamatanId").value, "Letter kecamatan ", 1);
	    	alert(errMsg);
	    	return false;
		}
		
		//validasi letter kelurahan
		if(!requiredField(document.getElementById("letterKelurahanId").value, "Letter kelurahan ", 0)){
	    	var errMsg = requiredField(document.getElementById("letterKelurahanId").value, "Letter kelurahan ", 1);
	    	alert(errMsg);
	    	return false;
		}
		
		//validasi letter postal code
		if(!requiredField(document.getElementById("letterPostalCode").value, "Letter postal code ", 0)){
	    	var errMsg = requiredField(document.getElementById("letterPostalCode").value, "Letter postal code ", 1);
	    	alert(errMsg);
	    	return false;
		}
		if(!validPostalCode(document.getElementById("letterPostalCode").value, "Letter postal code ", 5, 0)){
			var errMsg = validPostalCode(document.getElementById("letterPostalCode").value, "Letter postal code ", 5, 1);
	    	alert(errMsg);
	    	return false;
		}
		
		return true;
	}else{
		return false;
	}
}

function validIsi(){
	if(!requiredField(document.forms[0].fullName.value, "Full Name ", 0)){
		var errMsg = requiredField(document.forms[0].fullName.value, "Full Name ", 1);
		alert(errMsg);
		return false;
	}
	if(!requiredField(document.forms[0].motherMaidenName.value, "Mother Maiden Name ", 0)){
		var errMsg = requiredField(document.forms[0].motherMaidenName.value, "Mother Maiden Name ", 1);
		alert(errMsg);
		return false;
	}
	if(!requiredField(document.forms[0].dateOfBirth.value, "Date Of Birth ", 0)){
		var errMsg = requiredField(document.forms[0].dateOfBirth.value, "Date Of Birth ", 1);
		alert(errMsg);
		return false;
	}
	
	return true;
}

function validSubmitCreateEdit(){
	
	var cek = validnote(255, document.forms[0].note.value);
	if (cek == false) {
		return false;
	}
	
	if (document.forms[0].atmPinMailerId.value > 0){	
		if (!cek_create_account(document.forms[0].fullName.value, 3, 35, "Full Name")) return false;
		if (!cek_create_account(document.forms[0].placeOfBirth.value, 3, 35, "Place Of Birth")) return false;
		if (!cek_create_account(document.forms[0].motherMaidenName.value, 3, 35, "Mother Maiden Name")) return false;
		if (!cek_create_account(document.forms[0].idNumber.value, 3, 35, "Id Number")) return false;
	}
	
	if(validCreateEdit()){
		if(jum_address==0){
			alert('Address is required');
			document.forms[0].address1.focus();
			return false;
		}
		
		if(cek == false){
			alert("Tolong lengkapi alamat rumah pada Address Type HOME dan klik ADD"); 
			return false;
		}
		
		//validasi address1 di address
		for (var i = 0; i < address.length; i++) {
			if(!address[i]==""){
				if(!containNa(new String(address[i]), "Address in Personal Address ", 0)){
			    	var errMsg = containNa(new String(address[i]), "Address in Personal Address ", 1);
			    	alert(errMsg);
			    	return false;
				}
			}
		}
		
		//validasi phone number1, phone number2, handphone1, handphone2 di address
		for (var i = 0; i < phoneNumber.length; i++) {
			if(!phoneNumber[i]==""){
				if(!validPhoneNumber(phoneNumber[i], "Phone Number 1 pada daftar Address ", 0)){
			    	var errMsg = validPhoneNumber(phoneNumber[i], "Phone Number 1 pada daftar Address ", 1);
			    	alert(errMsg);
			    	return false;
			    	break;
				}
	    	}
	    	if(!phoneNumber2[i]==""){
				if(!validPhoneNumber(phoneNumber2[i], "Phone Number 2 pada daftar Address ", 0)){
			    	var errMsg = validPhoneNumber(phoneNumber2[i], "Phone Number 2 pada daftar Address ", 1);
			    	alert(errMsg);
			    	return false;
			    	break;
				}
	    	}
	    	if(!handphone[i]==""){
				if(!validHandphone(handphone[i], "Handphone 1 pada daftar Address ", 0)){
			    	var errMsg = validHandphone(handphone[i], "Handphone 1 pada daftar Address ", 1);
			    	alert(errMsg);
			    	return false;
			    	break;
				}
	    	}
	    	if(!handphone2[i]==""){
				if(!validHandphone(handphone2[i], "Handphone 2 pada daftar Address ", 0)){
			    	var errMsg = validHandphone(handphone2[i], "Handphone 2 pada daftar Address ", 1);
			    	alert(errMsg);
			    	return false;
			    	break;
				}
	    	}
		}
		
		//validasi postal code di address
		for(i = 0; i < postalCode.length; i++){
			if(!validLength(postalCode[i], "Postal code in Personal Address ", 5, 0)){
		    	var errMsg = validLength(postalCode[i], "Postal code in Personal Address ", 5, 1);
		    	alert(errMsg);
		    	return false;
			}
		}
		
		if(document.forms[0].atmPinMailerId.value > 0){
			if (!cek_create_account(alamat, 3, 35, "address1")) return false;
			if (!cek_create_account(kota, 3, 35, "city")) return false;
			if (!cek_create_account(kode_pos, 3, 35, "postalCode")) return false;
		}
		
		if(marriageStatus=="Kawin"){
			//validasi spouse full name
			if(!validName(document.forms[0].spouseFullName.value, "Spouse Full Name ", document.forms[0].validasiNama.value, 1, 0, 1, 50)){
				var errMsg = validName(document.forms[0].spouseFullName.value, "Spouse Full Name ", document.forms[0].validasiNama.value, 1, 1, 1, 50);
		    	alert(errMsg);
		    	return false;
			}
			if(!requiredField(document.forms[0].spousePlaceOfBirth.value, "Spouse Place of birth ", 0)){
		    	var errMsg = requiredField(document.forms[0].spousePlaceOfBirth.value, "Spouse Place of birth ", 1);
		    	alert(errMsg);
		    	return false;
			}
			if(!validPob(document.forms[0].spousePlaceOfBirth.value, "Spouse Place of birth ", 0)){
				var errMsg = validPob(document.forms[0].spousePlaceOfBirth.value, "Spouse Place of birth ", 1);
		    	alert(errMsg);
		    	return false;
			}
			if(!requiredField(document.forms[0].spouseDateOfBirth.value, "Spouse Date of Birth ", 0)){
		    	var errMsg = requiredField(document.forms[0].spouseDateOfBirth.value, "Spouse Date of Birth ", 1);
		    	alert(errMsg);
		    	return false;
			}
			var spouseDateOfBirth = document.forms[0].spouseDateOfBirth.value; 
			var yearSpouseDateOfBirth = eval(spouseDateOfBirth.substring(spouseDateOfBirth.indexOf("/",spouseDateOfBirth.indexOf("/")+1)+1));
			if(yearSpouseDateOfBirth < 1900){
		    	var errMsg = "Spouse Date Of Birth tidak boleh kurang dari tahun 1900";
		    	alert(errMsg);
		    	return false;
			}
			if(!requiredField(document.forms[0].spouseIdentificationCardId.value, "Spouse Identification Card ", 0)){
		    	var errMsg = requiredField(document.forms[0].spouseIdentificationCardId.value, "Spouse Identification Card  ", 1);
		    	alert(errMsg);
		    	return false;
			}
			
			if(!requiredField(document.forms[0].spouseIdNumber.value, "Spouse Id Number ", 0)){
		    	var errMsg = requiredField(document.forms[0].spouseIdNumber.value, "Spouse Id Number  ", 1);
		    	alert(errMsg);
		    	return false;
			}
			
			if(document.forms[0].spouseIdentificationCardId.value ==13){
				var cek = document.forms[0].spouseIdNumber.value;
				if(!cekIdKtp(cek,"Nomor KTP Pasangan ", 0)){
			    	var errMsg = cekIdKtp(cek,"Nomor KTP Pasangan ", 1);
			    	alert(errMsg);
			    	return false;
				}
			}
			
			if(document.forms[0].spouseIdentificationCardId.value ==181){
				var cek = document.forms[0].spouseIdNumber.value;
				if(!cekIdPaspor(cek,"Spouse Id Number Paspor ", 0)){
			    	var errMsg = cekIdPaspor(cek,"Spouse Id Number Paspor ", 1);
			    	alert(errMsg);
			    	return false;
				}
			}
		}
		
		//validasi spouse company name
		if(document.forms[0].spouseCompanyName.value.length>0){
			if(!containLetterNumDotComSlashSpace(document.forms[0].spouseCompanyName.value, "Spouse company name ", 0)){
		    	var errMsg = containLetterNumDotComSlashSpace(document.forms[0].spouseCompanyName.value, "Spouse company name ", 1);
		    	alert(errMsg);
		    	return false;
			}
		}
		
		//validasi spouse rt
		if(document.forms[0].spouseCompanyRt.value.length>0) {
			if(!validRtRw(document.forms[0].spouseCompanyRt.value, "Spouse company RT ", 0)){
				var errMsg = validRtRw(document.forms[0].spouseCompanyRt.value, "Spouse company RT ", 1);
		    	alert(errMsg);
		    	return false;
			}
		}
		
		//validasi spouse rw
		if(document.forms[0].spouseCompanyRw.value.length>0) {
			if(!validRtRw(document.forms[0].spouseCompanyRw.value, "Spouse company RW ", 0)){
				var errMsg = validRtRw(document.forms[0].spouseCompanyRw.value, "Spouse company RW ", 1);
		    	alert(errMsg);
		    	return false;
			}
		}
		
		//validasi spouse postal code
		if(document.getElementById("spouseCompanyPostalCode").value.length>0) {
			if(!validPostalCode(document.getElementById("spouseCompanyPostalCode").value, "Spouse company postal code ", 5, 0)){
				var errMsg = validPostalCode(document.getElementById("spouseCompanyPostalCode").value, "Spouse company postal code ", 5, 1);
		    	alert(errMsg);
		    	return false;
			}
		}
		
		//validasi spouse phone number1
		if(!validPhoneNo(document.forms[0].spouseCompanyPhoneNumber1.value, "Spouse phone number 1 ", 0)){
			var errMsg = validPhoneNo(document.forms[0].spouseCompanyPhoneNumber1.value, "Spouse phone number 1 ", 1);
	    	alert(errMsg);
	    	return false;
		}
		
		//validasi spouse phone number2
		if(!validPhoneNo(document.forms[0].spouseCompanyPhoneNumber2.value, "Spouse phone number 2 ", 0)){
			var errMsg = validPhoneNo(document.forms[0].spouseCompanyPhoneNumber2.value, "Spouse phone number 2 ", 1);
	    	alert(errMsg);
	    	return false;
		}
		
		//validasi spouse handphone1
		if(!validHandphoneNo(document.forms[0].spouseHandphone1.value, "Spouse handphone 1 ", 0)){
			var errMsg = validHandphoneNo(document.forms[0].spouseHandphone1.value, "Spouse handphone 1 ", 1);
	    	alert(errMsg);
	    	return false;
		}
		
		//validasi spouse handphone2
		if(!validHandphoneNo(document.forms[0].spouseHandphone2.value, "Spouse handphone 2 ", 0)){
			var errMsg = validHandphoneNo(document.forms[0].spouseHandphone2.value, "Spouse handphone 2 ", 1);
	    	alert(errMsg);
	    	return false;
		}
		
		//validasi spouse job length / duration
		if(document.forms[0].spouseJobLength.value.length>0) {
			if(!checkNumber(document.forms[0].spouseJobLength.value, "Spouse job duration ", 0)){
		    	var errMsg = checkNumber(document.forms[0].spouseJobLength.value, "Spouse job duration ", 1);
		    	alert(errMsg);
		    	return false;
			}
		}
		
		//validasi spouse npwp
		if(document.forms[0].spouseNPWP.value.length>0) {
			if(!ceknpwp(document.forms[0].spouseNPWP.value, "Spouse NPWP ", 14, 15, 0) || document.forms[0].spouseNPWP.value=='') {
				var errMsg = ceknpwp(document.forms[0].spouseNPWP.value, "Spouse NPWP ", 14, 15, 1);
		    	alert(errMsg);
				document.forms[0].spouseNPWP.focus();
				return false;
			}
		}
		return true;
	}else{
		return false;
	}
}

function validSubmitCreateEditCompany(){
	//validasi company name
	if(!requiredField(document.forms[0].companyName.value, "Company name ", 0)){
    	var errMsg = requiredField(document.forms[0].companyName.value, "Company name ", 1);
    	alert(errMsg);
    	return false;
	}
	if(!containLetterNumDotComSlashSpace(document.forms[0].companyName.value, "Company name ", 0)){
    	var errMsg = containLetterNumDotComSlashSpace(document.forms[0].companyName.value, "Company name ", 1);
    	alert(errMsg);
    	return false;
	}
	
	//validasi company address1
	if(!requiredField(document.forms[0].companyAddress1.value, "Company address1 ", 0)){
    	var errMsg = requiredField(document.forms[0].companyAddress1.value, "Company address1 ", 1);
    	alert(errMsg);
    	return false;
	}
	if(!validAddress(document.forms[0].companyAddress1.value, "Company address1 ", 0)){
		var errMsg = validAddress(document.forms[0].companyAddress1.value, "Company address1 ", 1);
    	alert(errMsg);
    	return false;
	}
	
	//validasi company rt
	if(!requiredField(document.forms[0].companyRt.value, "Company RT ", 0)){
    	var errMsg = requiredField(document.forms[0].companyRt.value, "Company RT ", 1);
    	alert(errMsg);
    	return false;
	}
	if(!validRtRw(document.forms[0].companyRt.value, "Company RT ", 0)){
		var errMsg = validRtRw(document.forms[0].companyRt.value, "Company RT ", 1);
    	alert(errMsg);
    	return false;
	}
	
	//validasi company rw
	if(!requiredField(document.forms[0].companyRw.value, "Company RW ", 0)){
    	var errMsg = requiredField(document.forms[0].companyRw.value, "Company RW ", 1);
    	alert(errMsg);
    	return false;
	}
	if(!validRtRw(document.forms[0].companyRw.value, "Company RW ", 0)){
		var errMsg = validRtRw(document.forms[0].companyRw.value, "Company RW ", 1);
    	alert(errMsg);
    	return false;
	}
	
	//validasi company province
	if(!requiredField(document.getElementById("companyProvinceId").value, "Company province ", 0)){
    	var errMsg = requiredField(document.getElementById("companyProvinceId").value, "Company province ", 1);
    	alert(errMsg);
    	return false;
	}
	
	//validasi company city
	if(!requiredField(document.getElementById("companyCityId").value, "Company city ", 0)){
    	var errMsg = requiredField(document.getElementById("companyCityId").value, "Company city ", 1);
    	alert(errMsg);
    	return false;
	}
	
	//validasi company kecamatan
	if(!requiredField(document.getElementById("companyKecamatanId").value, "Company kecamatan ", 0)){
    	var errMsg = requiredField(document.getElementById("companyKecamatanId").value, "Company kecamatan ", 1);
    	alert(errMsg);
    	return false;
	}
	
	//validasi company kelurahan
	if(!requiredField(document.getElementById("companyKelurahanId").value, "Company kelurahan ", 0)){
    	var errMsg = requiredField(document.getElementById("companyKelurahanId").value, "Company kelurahan ", 1);
    	alert(errMsg);
    	return false;
	}
	
	//validasi company postal code
	if(!requiredField(document.getElementById("companyPostalCode").value, "Company postal code ", 0)){
		var errMsg = requiredField(document.getElementById("companyPostalCode").value, "Company postal code ", 1);
		alert(errMsg);
		return false;
	}
	if(!validPostalCode(document.getElementById("companyPostalCode").value, "Company postal code ", 5, 0)){
		var errMsg = validPostalCode(document.getElementById("companyPostalCode").value, "Company postal code ", 5, 1);
		alert(errMsg);
		return false;
	}
	
	//validasi company phone number1
	if(!requiredField(document.forms[0].companyPhoneNumber1.value, "Company Phone Number 1 ", 0)){
		var errMsg = requiredField(document.forms[0].companyPhoneNumber1.value, "Company Phone Number 1 ", 1);
		alert(errMsg);
		return false;
	}
	if(!validPhoneNo(document.forms[0].companyPhoneNumber1.value, "Company phone number 1 ", 0)){
		var errMsg = validPhoneNo(document.forms[0].companyPhoneNumber1.value, "Company phone number 1 ", 1);
		alert(errMsg);
		return false;
	}
	
	
	//validasi company phone ext 1
	if(!requiredField(document.forms[0].companyPhoneExt1.value, "Company Ext1 ", 0)){
		var errMsg = requiredField(document.forms[0].companyPhoneExt1.value, "Company Ext1 ", 1);
		alert(errMsg);
		return false;
	}
	if(!checkNumber(document.forms[0].companyPhoneExt1.value, "Company Ext1 ", 0)){
    	var errMsg = checkNumber(document.forms[0].companyPhoneExt1.value, "Company Ext1 ", 1);
    	alert(errMsg);
    	return false;
	}
	
	//validasi company phone number2
	if(document.forms[0].companyPhoneNumber2.value.length>0){
		if(!validPhoneNo(document.forms[0].companyPhoneNumber2.value, "Company phone number 2 ", 0)){
			var errMsg = validPhoneNo(document.forms[0].companyPhoneNumber2.value, "Company phone number 2 ", 1);
	    	alert(errMsg);
	    	return false;
		}
	}
	
	if(document.forms[0].companyPhoneExt2.value.length>0){
		if(!checkNumber(document.forms[0].companyPhoneExt2.value, "Company Ext2 ", 0)){
	    	var errMsg = checkNumber(document.forms[0].companyPhoneExt2.value, "Company Ext2 ", 1);
	    	alert(errMsg);
	    	return false;
		}
	}
	
	//validasi job rank
	if(!requiredField(document.forms[0].jobRank.value, "Job rank ", 0)){
		var errMsg = requiredField(document.forms[0].jobRank.value, "Job rank ", 1);
		alert(errMsg);
		return false;
	}
	
	//validasi job length / duration
	if(!requiredField(document.forms[0].jobLength.value, "Job duration ", 0)){
		var errMsg = requiredField(document.forms[0].jobLength.value, "Job duration ", 1);
		alert(errMsg);
		return false;
	}
	if(!checkNumber(document.forms[0].jobLength.value, "Job duration ", 0)){
    	var errMsg = checkNumber(document.forms[0].jobLength.value, "Job duration ", 1);
    	alert(errMsg);
    	return false;
	}
	
	//validasi company npwp
	if(document.forms[0].NPWP.value.length>0) {
		if(!ceknpwp(document.forms[0].NPWP.value, "NPWP ", 14, 15, 0) || document.forms[0].NPWP.value=='') {
			var errMsg = ceknpwp(document.forms[0].NPWP.value, "NPWP ", 14, 15, 1);
	    	alert(errMsg);
			document.forms[0].NPWP.focus();
			return false;
		}
	}
	
	return true;
}

function validSubmitCreateEditContact(){
	if(document.forms[0].guarantorName.value.length>0){
		if(!validName(document.forms[0].guarantorName.value, "Guarantor Name ", document.forms[0].validasiNama.value, 0, 0, 1, 50)){
			var errMsg = validName(document.forms[0].guarantorName.value, "Guarantor Name ", document.forms[0].validasiNama.value, 0, 1, 1, 50);
	    	alert(errMsg);
			return false;
		}
	}
	if(document.forms[0].guarantorPostalCode.value.length>0){
		if(!validPostalCode(document.forms[0].guarantorPostalCode.value, "Guarantor postal code ", 5, 0)){
			var errMsg = validPostalCode(document.forms[0].guarantorPostalCode.value, "Guarantor postal code ", 5, 1);
	    	alert(errMsg);
			return false;
		}
	}
	if(!document.forms[0].guarantorTelephone.value=='' && !validPhoneNumber(document.forms[0].guarantorTelephone.value, "Guarantor Telephone ", 0)) {
		var errMsg = validPhoneNumber(document.forms[0].guarantorTelephone.value, "Guarantor Telephone ", 1);
		alert(errMsg);
		return false;
	}
	if(!document.forms[0].guarantorMobile.value=='' && !validHandphone(document.forms[0].guarantorMobile.value, "Guarantor Mobile ", 0)) {
		var errMsg = validHandphone(document.forms[0].guarantorMobile.value, "Guarantor Mobile ", 1);
		alert(errMsg);
		return false;
	}
	
	return true;
}

function validAddCreateEditRelation(){
	if(!requiredField(document.forms[0].relativeRelationshipId.value, "Relative Relationship ", 0)){
		var errMsg = requiredField(document.forms[0].relativeRelationshipId.value, "Relative Relationship ", 1);
		alert(errMsg);
		return false;
	}
	if(document.forms[0].name.value.length>0){
		if(!validName(document.forms[0].name.value, "Relative Name ", document.forms[0].validasiNama.value, 0, 0, 1, 50)){
			var errMsg = validName(document.forms[0].name.value, "Relative Name ", document.forms[0].validasiNama.value, 0, 1, 1, 50);
			alert(errMsg);
			return false;
		}
	}
	if(document.forms[0].postalCode.value.length>0){
		if(!validPostalCode(document.forms[0].postalCode.value, "Relative postal code ", 5, 0)){
			var errMsg = validPostalCode(document.forms[0].postalCode.value, "Relative postal code ", 5, 1);
			alert(errMsg);
			return false;
		}
	}
	if(!document.forms[0].telephone.value=='' && !validPhoneNoOrHandphone(document.forms[0].telephone.value, "Relative Telephone ", 0)) {
		var errMsg = validPhoneNoOrHandphone(document.forms[0].telephone.value, "Relative Telephone ", 1);
		alert(errMsg);
		return false;
	}
	
	return true;
}