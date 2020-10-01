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
include('../js/validation/refund_bank_account_function.js');



function validateRefundBankAccount(){
	//validasi bank account name
	if(!requiredField(document.forms[0].bankAccountName.value, "Bank Account Name ", 0)){
		var errMsg = requiredField(document.forms[0].bankAccountName.value, "Bank Account Name ", 1);
		alert(errMsg);
		return false;
	}
	if(!requiredField(document.forms[0].accountType.value, "Account Type", 0)){
		var errMsg = requiredField(document.forms[0].accountType.value, "Account Type ", 1);
    	alert(errMsg);
    	return false;
	}else {
		if (!requiredField(document.forms[0].npwp.value, "NPWP", 0)){
			var errMsg = requiredField(document.forms[0].npwp.value, "NPWP ", 1);
	    	alert(errMsg);
	    	return false;
		}
		if(document.forms[0].npwp.value.length>0) {
			if(!ceknpwp(document.forms[0].npwp.value, "NPWP ", 14, 15, 0) || document.forms[0].npwp.value=='') {
				var errMsg = ceknpwp(document.forms[0].npwp.value, "NPWP ", 14, 15, 1);
		    	alert(errMsg);
				document.forms[0].npwp.focus();
				return false;
			}
		}
		if (document.forms[0].accountType.value == "PERORANGAN"){
			if (!requiredField(document.forms[0].ktp.value, "KTP ", 0)){
				var errMsg = requiredField(document.forms[0].ktp.value, "KTP ", 1);
		    	alert(errMsg);
		    	return false;
			}else {
				if(isNaN(document.forms[0].ktp.value)){
					alert("No. KTP must be numeric");
					return false;
		 		}
			}
		}else if (document.forms[0].accountType.value == "BADAN USAHA"){
			if(!ceknpwpkosong(document.forms[0].npwp.value, "NPWP ", 0)){
				var errMsg = ceknpwpkosong(document.forms[0].npwp.value, "NPWP ", 1);
		    	alert(errMsg);
		    	return false;
	 		}
		}
	}
	if(ceknpwpkosong(document.forms[0].npwp.value, "NPWP ", 0) && !requiredField(document.forms[0].npwpName.value, "NPWP Name ", 0)){
		var errMsg = requiredField(document.forms[0].npwpName.value, "NPWP Name ", 1);
    	alert(errMsg);
    	return false;
 	}
	
	if (!requiredField(document.forms[0].bankAccountName.value, "Name ", 0)){
		var errMsg = requiredField(document.forms[0].bankAccountName.value, "Name ", 1);
    	alert(errMsg);
    	return false;
	}
	
	if(document.forms[0].bankAccountNumber.value.length < 10 || document.forms[0].bankAccountNumber.value.length > 16){
		var errMsg = 'Account Number must be 10 - 16 digits of number';
		alert(errMsg);
		return false;
	}
	
	if(document.forms[0].bankAccountNumber.value.length>0) {
		if (cekAccountNumber(document.forms[0].bankAccountNumber.value)==false){
			alert('Account Number could not input by character')
			document.forms[0].bankAccountNumber.focus();
			return false;
		}
	}
	
	
	if(!requiredField(document.forms[0].placeOfBirth.value, "Place of Birth ", 0)){
		var errMsg = requiredField(document.forms[0].placeOfBirth.value, "Place of Birth ", 1);
    	alert(errMsg);
    	return false;
	}
	
	if(!requiredField(document.forms[0].dateOfBirth.value, "Date of birth ", 0)){
		var errMsg = requiredField(document.forms[0].dateOfBirth.value, "Date of birth ", 1);
    	alert(errMsg);
    	return false;
	}
	
	if(!requiredField(document.forms[0].phoneNumber1.value, "Phone Number 1 ", 0)){
		var errMsg = requiredField(document.forms[0].phoneNumber1.value, "Phone Number1 ", 1);
    	alert(errMsg);
    	return false;
	}
		
	if(!validPhoneNoOrHandphone(document.forms[0].phoneNumber1.value, "Phone Number 1 ", 0)){
		var errMsg = validPhoneNoOrHandphone(document.forms[0].phoneNumber1.value, "Phone Number1 ", 1);
    	alert(errMsg);
    	return false;
	}	
		
	if(!document.forms[0].phoneNumber2.value=='') {
		if(!validPhoneNoOrHandphone(document.forms[0].phoneNumber2.value, "Phone Number 2 ", 0)){
			var errMsg = validPhoneNoOrHandphone(document.forms[0].phoneNumber2.value, "Phone Number2 ", 1);
	    	alert(errMsg);
	    	return false;
		}
	}
	
	if(!requiredField(document.forms[0].idDateOfIssue.value, "Tanggal Terbit KTP ", 0)){
		var errMsg = requiredField(document.forms[0].idDateOfIssue.value, "Tanggal Terbit KTP ", 1);
    	alert(errMsg);
    	return false;
	}
	
	if(!requiredField(document.forms[0].idAddress.value, "Alamat KTP ", 0)){
		var errMsg = requiredField(document.forms[0].idAddress.value, "Alamat KTP ", 1);
    	alert(errMsg);
    	return false;
	}
	
	if(!requiredField(document.forms[0].type.value, "Type ", 0)){
		var errMsg = requiredField(document.forms[0].type.value, "Type ", 1);
    	alert(errMsg);
    	return false;
	}
	
	return true;
}		