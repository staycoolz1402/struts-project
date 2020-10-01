<%@ page contentType="text/html;charset=iso-8859-1" language="java" %>
<% response.setHeader("Pragma", "No-cache");
response.setDateHeader("Expires", 0);
response.setHeader("Cache-Control", "no-cache");%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><bean:message key="page.index.title"/></title>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
	<link href="<html:rewrite page="/js/simas.css"/>" rel="stylesheet" type="text/css">
</head>
<body bgcolor="#e7e7e7" text="#000000" topmargin="0" leftmargin="0">
	<table width="100%" cellpadding="0" cellspacing="0">
    <tr align="center"> 
    	<td colspan="2"><tiles:insert template='/common/header.jsp'/></td>
    </tr>
    <tr valign="top">
    	<td width="20%"><tiles:insert template='/common/menu.jsp'/></td>
      <td>
    
<!-- content -->    

      <TABLE height=50 cellSpacing=1 cellPadding=1 border=0 width="600" valign="top"><BR><BR>
        <TR>
          <TD align=middle width="80%" height=10>&nbsp;</TD></TR>
        <TR>
          <TD align=middle width="80%"> 
						<TABLE cellSpacing=0 cellPadding=0 width="92%" border=0 height="100%">
						  <TR valign="top">
						    <TD><html:errors/>&nbsp;</TD>
						  </TR>
						  <tr>
						  	<td>
						  	
						  		<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr valign="top">
											<td align="center">
												<b>Next routing of this workflow error</b><br>
												Maybe next routing or end routing is missing.<br>
												Contact your administrator.<br>
											</td>
										</tr>
									</table>
									
						  	</td>
						  </td>						  
						</TABLE>
          </TD>
        </TR>
      </TABLE>
            
<!-- end content-->            
    </td>
	</tr>
</table>

</body>
</html>