<% response.setHeader("Pragma", "No-cache");
response.setDateHeader("Expires", 0);
response.setHeader("Cache-Control", "no-cache");%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title><bean:message key="page.index.title"/></title>
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
	<td style="background-image:url(<html:rewrite page="/images/bg_body.gif"/>); background-repeat:repeat-x; background-position:bottom; " height="627" bgcolor="#fbfdff" align="left" valign="top">
    
	<!-- content -->    
	<table width="900" border="0" cellspacing="0" cellpadding="5" style="margin-left:10px; ">
	<tr>
		<td align="left" class="text03"><b><logic:present name="viewName"><bean:write name="viewName"/></logic:present></b></td>
	</tr>
	
	<tr>
		<td align="center" width="100%">
		   
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="text04">
		<tr>
			<td width="1%"><html:img page="/images/round.gif"/></td>
			<td width="98%" class="smalltext" style="border-top:solid 1px #6b6b71; ">&nbsp;</td>
			<td width="1%"><html:img page="/images/round1.gif"/></td>
		</tr>
		
		<tr>
			<td style="border-left:solid 1px #6b6b71; ">&nbsp;</td>
			<td valign="top">
			
			<!-- CONTENT START --> 
			<TABLE cellSpacing=0 cellPadding=0 width="92%" border=0 height="100%">
			<tr valign="top"><td><html:errors/>&nbsp;</td></tr>
			
			<tr>
				<td>
				
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr valign="top">
					<td align="right">
						<logic:present name="title">
							<b><bean:write name="title"/></b>
						</logic:present>
					</td>
					<td align="center">:</td>
					<td align="left">
						<logic:present name="fill">
							<b><bean:write name="fill"/></b>
						</logic:present>
					</td>
				</tr>
				</table>
				
				</td>
			</tr>
			
			<tr><td colspan="3">&nbsp;</td></tr>
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
				<td colspan="3" align="center"><input class="Button" type="button" name="back" onclick="window.location.href=('<html:rewrite page="<%=url%>"/>');" value="<bean:message key="back.link"/>"></td>
			</tr>
			<%		}
				}
				HttpSession httpSession = request.getSession();
				httpSession.removeAttribute("title");
				httpSession.removeAttribute("fill");
			%>
			</table>
			<!-- CONTENT END -->
			
			</td>
			<td style="border-right:solid 1px #6b6b71; ">&nbsp;</td>
		</tr>
		
		<tr>
			<td width="1%"><html:img page="/images/round3.gif"/></td>
			<td class="smalltext" style="border-bottom:solid 1px #6b6b71; ">&nbsp;</td>
			<td width="1%"><html:img page="/images/round2.gif"/></td>
		</tr>
		</table>
					
		</td>
	</tr>
	</table>
			
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