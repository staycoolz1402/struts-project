<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% response.setHeader("Pragma", "No-cache");
response.setDateHeader("Expires", 0);
response.setHeader("Cache-Control", "no-cache");%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title><bean:message key="page.index.title"/></title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<link href="<html:rewrite page="/js/simas.css"/>" rel="stylesheet" type="text/css">
</head>

<script language="javascript" type="text/javascript" src="<html:rewrite page="/js/date.js"/>"></script><!--buat perhitungan tanggal-->
<script language="javascript" type="text/javascript" src="<html:rewrite page="/js/hitung.js"/>"></script><!--buat tampilan-->
<script language="javascript" type="text/javascript" src="<html:rewrite page="/js/dhtmlgoodies_calendar.js"/>"></script><!--buat calender-->
<link type="text/css" rel="stylesheet" href="<html:rewrite page="/js/dhtmlgoodies_calendar.css"/>" media="screen"></link>
<script language="javascript" type="text/javascript" src="<html:rewrite page="/js/Ajax.js"/>"></script><!--buat AJAX-->

<body style="margin:0px;" >
<table width="100%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td style="background-image:url(<html:rewrite page="/images/footer1.jpg"/>); background-position:top center; background-repeat:repeat-x; " height="57">&nbsp;</td>
  </tr>
  <tr>
    <td style="background-image:url(<html:rewrite page="/images/list.gif"/>); background-repeat:repeat-x; " height="24">&nbsp;</td>
  </tr>
  <%-- <tr>
    <td style="background-image:url(<html:rewrite page="/images/bg_body.gif"/>); background-repeat:repeat-x; background-position:bottom; " height="627" bgcolor="#fbfdff" align="left" valign="top">
  </tr>	 --%>    
<!-- content -->    
			    <tr align="center">
			    	<td>
			    		Apakah anda yakin ingin ke halaman home? semua session anda akan expired!
			    	</td>
			    </tr>
			    <tr align="center">
			    	<td>
			    		<input type="button" value="OK" onclick="backToHome();">
			    		<input type="button" value="Cancel" onclick="continueWork();">
			    	</td>
			    </tr>
			   
<!-- end content-->            
    </td>
  </tr>
  <tr>
    <td style="background-image: url(<html:rewrite page="/images/bg_footer.gif"/>); background-repeat:repeat-x; " height="57" align="left" valign="top">
    
    <!-- footer start -->
	<tiles:insert template='/common/footer.jsp'/>
    
    <!-- footer end -->
    
    </td>
  </tr>
</table>
</body>
<script language="javascript">

function backToHome(){
	
	
    /* var urlpath = opener.window.location;
    var urlnew = String(urlpath).replace("//","~");
    var stringSplit = urlnew.split("/");
    var urlFinal = stringSplit[0].replace("~","//") + "/" + stringSplit[1] +"/home.do"; 
	window.opener.location.href = urlFinal;
    window.close(); */
    
    window.opener.location.href = '<html:rewrite page="/home.do"/>';
    window.close();
}

function continueWork(){
	window.close();
}
</script>
</html>

