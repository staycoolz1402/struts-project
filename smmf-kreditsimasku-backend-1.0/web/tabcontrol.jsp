<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<html>
<body>
<html:form styleId="tabForm" action="/tab/tabCheck"><html:hidden property="windowId" value="default"/></html:form>
</body>
</html>
<script type="text/javascript">
	function generateWindowId(){
		var v = window.name;
	    if(v == ''){
			window.name = new Date().getTime();
	    }
		document.tabForm.windowId.value = window.name;
		
		checkTabId();
		submitTabId();
	}
	function checkTabId() {
		var check = true;
		$.ajax({
			type : "GET",
			url : '<html:rewrite page="/tab/tabCheck.do"/>?windowId=' + document.tabForm.windowId.value + '~' + window.location.href,
			async : false,
			success : function(response) {
				if (response.redirect) {
					window.location.assign(response.redirect);
				}		
				check = true;
			},
			error : function(e) {  
				window.location.assign('<html:rewrite page="/tab/multiple.do"/>');
				check = false;
			}
		});
		return check;
	}
	function submitTabId() {
		$.ajax({
			type : "GET",
			url : '<html:rewrite page="/tab/tabSet.do"/>?windowId=' + window.name + '~' + window.location.href,
			success : function(response) {},
			error : function(e) {}
		});
	}
	$(document).ready(function() {
		var wName = '<%= session.getAttribute("windowId") %>';
		var str = 'TEXT01';
		if(window.name == str.toLowerCase() && wName != null){
			window.name = wName;
		}
		generateWindowId();
	});
</script>