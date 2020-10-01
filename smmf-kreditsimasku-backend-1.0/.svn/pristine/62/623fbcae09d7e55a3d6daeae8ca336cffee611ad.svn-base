
function submitFormWithPost(url, data) {
    var form = document.createElement("form");
    form.method = "POST";
    form.action = url;
    form.style.display = "none";
    
    var param = JSON.parse(data);

    for (var key in param) {
        var input = document.createElement("input");
        input.type = "hidden";
        input.name = key;
        input.value = param[key];
        form.appendChild(input);
    } 

    document.body.appendChild(form); 
    form.submit();    
    document.body.removeChild(form);
}

function openWindowsWithPost(url, data, windowName, windowFeatures) {
	    var form = document.createElement("form");
	    form.method = "POST";
	    form.action = url;
	    form.style.display = "none";
	    
	    var param = JSON.parse(data);
	    
	    for (var key in param) {
	        var input = document.createElement("input");
	        input.type = "hidden";
	        input.name = key;
	        input.value = param[key];
	        form.appendChild(input);
	    } 

	    document.body.appendChild(form); 
	    window.open('', windowName,windowFeatures);
	    form.target = windowName;
	    form.submit();    
	    document.body.removeChild(form);
}
var newParam = [];
function clearParams(){
	newParam = [];
}
function addParam(key, value){
    var obj = [];
    obj.key= key;
    obj.value= value;
    if(newParam.length > 0){
        for (var i=0; i<newParam.length; i++) {
            if(newParam[i].key == obj.key){
                newParam.splice(i,1, obj);
            }else{
                newParam.push(obj);
            }
        }
    }else{
        newParam.push(obj);
    }
} 
function submitFormPost(url) {
    var form = document.createElement("form");
    form.method = "POST";
    form.action = url; 
    form.style.display = "none";
    
    for (var i=0; i<newParam.length; i++) {
        var input = document.createElement("input");
        input.type = "hidden";
       // alert(newParam[i].key);
        input.name = newParam[i].key;
        input.value = newParam[i].value;
        form.appendChild(input);
    } 
    
    document.body.appendChild(form); 
    form.submit();    
    document.body.removeChild(form);
}
function openWindowsPost(url, windowName, windowFeatures) {
    var form = document.createElement("form");
    form.method = "POST";
    form.action = url;
    form.style.display = "none";
       
    for (var i=0; i<newParam.length; i++) {
        var input = document.createElement("input");
        input.type = "hidden";
      //  alert(newParam[i].key);
        input.name = newParam[i].key;
        input.value = newParam[i].value;
        form.appendChild(input);
    } 

    document.body.appendChild(form); 
    window.open('', windowName,windowFeatures);
    form.target = windowName;
    form.submit();    
    document.body.removeChild(form);
}
