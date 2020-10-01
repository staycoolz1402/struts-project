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
	<link href="<html:rewrite page="/js/bb.css"/>" rel="stylesheet" type="text/css">
	<style type="text/css">
<!--
.style1 {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 14px;
	color: #030a6c;
	text-decoration:none;
}
.style1 a:link, .style1 a:visited, .style1 a:active {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 14px;
	color: #030a6c;
	text-decoration:underline;
}
.style1 a:hover{
	font-family: Arial, Helvetica, sans-serif;
	font-size: 14px;
	color: #08a2ce;
	text-decoration:underline;
}

-->
    </style>
</head>
<body bgcolor="#e7e7e7" text="#000000" topmargin="0" leftmargin="0">
    
<!-- content -->    

      <TABLE height=50 cellSpacing=1 cellPadding=1 border=0 width="600" valign="top" class="style1"><BR><BR>
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
			  			<logic:present name="journalNumber">	
							<tr valign="top">
								<td align="right"><b><bean:message key="print.journalNumber"/></b></td>
								<td align="center">:</td>
								<td align="left"><b><bean:write name="journalNumber"/></b></td>
							</tr>
							<logic:present name="xJournal">
							
							</logic:present>
						</logic:present>
						<tr>
							<td colspan="3">&nbsp;</td>
						</tr>
						<logic:present name="KPNOJournalNumber">	
							<tr valign="top">
								<td align="right">
									<b><bean:message key="print.KPNOJournalNumber"/></b></td>
								<td align="center">:</td>
								<td align="left"><b><bean:write name="KPNOJournalNumber"/></b></td>
							</tr>
						</logic:present>	
					</table>
				</td>
			  </tr>
			<tr>
				<td colspan="3">&nbsp;</td>
			</tr>
			<%
				if(request.getParameter("redir")!=null){
				HttpSession httpSession = request.getSession();
				String url = request.getParameter("redir");
				if(url.length()>0){
					if(httpSession.getAttribute("parameter")!=null){
						url = url + httpSession.getAttribute("parameter");
					}
			%>
			<tr>
				<a href="<html:rewrite page="/terminationApproval/list.do"/>?start=<bean:write name="start" scope="session"/>&count=<bean:write name="count" scope="session"/>" >
						<bean:message key="back.link"/>
				</a>&nbsp;	  
				<!-- <td colspan="3" align="center"><input class="Button" type="button" name="back" onclick="window.location.href=('<html:rewrite page="<%=url%>"/>');" value="<bean:message key="back.link"/>"></td> -->
			</tr>
			<%}
			}
			HttpSession httpSession = request.getSession();
			httpSession.removeAttribute("journalNumber");
			httpSession.removeAttribute("xJournal");
			httpSession.removeAttribute("KPNOJournalNumber");
			%>
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