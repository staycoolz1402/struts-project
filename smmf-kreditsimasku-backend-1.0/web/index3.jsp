<%@ page contentType="text/html;charset=iso-8859-1" language="java" %>
<% response.setHeader("Pragma", "No-cache");
response.setDateHeader("Expires", 0);
response.setHeader("Cache-Control", "no-cache");%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested" %>
<%
	int sequence = 0;
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title><bean:message key="page.index.title"/></title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<link href="<html:rewrite page="/js/simas.css"/>" rel="stylesheet" type="text/css">
</head>

<body style="margin:0px;" >
<table width="100%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td style="background-image: url(<html:rewrite page="/images/bg_header.gif"/>); background-repeat:repeat-x; " height="94" valign="top" align="left">
    
    <!-- header start -->
    
<tiles:insert template='/common/header.jsp'/>
    
    <!-- header end -->
    
    </td>
  </tr>
  <tr>
    <td style="background-image:url(<html:rewrite page="/images/list.gif"/>); background-repeat:repeat-x; " height="24">&nbsp;</td>
  </tr>
  <tr>
    <td style="background-image:url(<html:rewrite page="/images/bg_body.gif"/>); background-repeat:repeat-x; background-position:bottom; " height="589" bgcolor="#fbfdff" align="left" valign="top">
    
<!-- content -->    
      <logic:notPresent scope="session" name="user">
      
      <table width="30%" border="0" cellspacing="0" cellpadding="5" style="margin-left:200px; margin-top:140px; ">
	      <tr>
	        <td><html:img page="/images/img_login.png"/></td>
	        <td>
	        
	        <html:form action="/logon" focus="passCode">
	        <html:hidden property="userName"/>
	        <html:hidden property="userPass" />
	        <table width="150"  border="0" cellspacing="0" cellpadding="0">
	          <tr>
	            <td colspan="3" class="text06" align="center">Selamat Datang Guest!</td>
	          </tr>
	          <tr>
	            <td colspan="3" align="center"><html:errors/></td>
	          </tr>
	          <tr>
	            <td align="right" width="1%"><html:img page="/images/round_login.gif"/></td>
	            <td style="background-image:url(<html:rewrite page="/images/top_login.gif"/>); background-repeat:repeat-x " align="right"><html:img page="/images/img_login.gif"/></td>
	            <td align="left" width="1%"><html:img page="/images/round_login1.gif"/></td>
	          </tr>
	          <tr>
	            <td style="background-image:url(<html:rewrite page="/images/left_login.gif"/>); background-repeat:repeat-y ">&nbsp;</td>
	            <td bgcolor="#a3a5a7" class="text06" align="left" nowrap>
								<b>Silahkan mengisi passcode<br>yang dikirimkan ke email anda.</b><br><br>
			    			<bean:message key="page.passCode.title"/>&nbsp;:<br>
			 		 <html:password property="passCode" size="8" styleClass="textbox"/>
			    <div align="center"><br>
			      <input type="image" src="<html:rewrite page="/images/button_login.gif"/>" border="0"/></div>
				</form>
				</td>
	            <td style="background-image:url(<html:rewrite page="/images/right_login.gif"/>); background-repeat:repeat-y ">&nbsp;</td>
	          </tr>
	          <tr>
	            <td align="right"><html:img page="/images/round_login2.gif"/></td>
	            <td style="background-image:url(<html:rewrite page="/images/bottom_login.gif"/>); background-repeat:repeat-x ">&nbsp;</td>
	            <td align="left"><html:img page="/images/round_login3.gif"/></td>
	          </tr>
	        </table>
	        </html:form>
	        
	        
	        </td>
	      </tr>

	    </table>
      
      
      
<script type="text/javascript">
 function gowait(form) {
 	var t;
 	t = true;
 	//eval(t = validateRopForm(form));
 	if (t) {
 		document.getElementById("main").style.visibility="hidden";
   document.getElementById("wait").style.visibility="visible";
   window.setTimeout('showProgress()', 400);
 	}
 }
 function showProgress(){ 
   var wg = document.getElementById("progressbar");
   wg.src=wg.src;
 }
 
</script>

      </logic:notPresent>
      
      
      
            
    <!-- content end -->
    
    
    
    
    </td>
  </tr>
  <tr>
    <td style="background-image:url(<html:rewrite page="/images/list1.gif"/>); background-repeat:repeat-x; " height="24">&nbsp;</td>
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
</html>