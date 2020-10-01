<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
    
	<table width="100%"  border="0" cellspacing="0" cellpadding="0" align="left" style="background-image:url(<html:rewrite page="/images/header.jpg"/>); background-position:top left; background-repeat:no-repeat;">
      <tr>
      	<td width="900" style="padding-right:10px;" height="72" align="right" valign="bottom">
      		<%-- <a href="<html:rewrite page="/home.do"/>"><div style="width:191px; height:55px; border:none; position:absolute; left:3em; top:0.6em">&nbsp;</div></a> --%>
      		<span class="text01"><logic:present name="sod"><bean:message key="page.sod.title"/>&nbsp;:&nbsp;<b><bean:write name="sod"/></b></logic:present></span><br><span class="text02"><logic:present name="user" scope="session"><bean:message key="page.welcome.title"/> <b><bean:write name="user" property="userName" scope="session"/></b></logic:present></span>
      	</td>
        <td>
			<script language="javascript">
				function mouse_over(){document.but.src='<%=request.getContextPath()%>/images/logoff2.png'};
				function mouse_out(){document.but.src='<%=request.getContextPath()%>/images/logoff1.png'};
			</script>
			<logic:present name="user">
			<html:link page="/logoff.do" onmouseover="mouse_over()" onmouseout="mouse_out()">
				<html:img page="/images/logoff1.png" border="0" imageName="but"/>
			</html:link>
			<br /><span class="text05">Logout</span></logic:present>
		</td>

      </tr>
    </table>
    
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
        <TR>
          <TD align="middle" width="100%">
          
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
					<table width="100%" border="0" cellspacing="2" cellpadding="0">
						<tr valign="top"><td><html:errors/></td></tr>
						<tr valign="top"><td>&nbsp;</td></tr>
						<tr>
								<td><bean:message key="error.multiple.tab"/></td>
						</tr>
							
					</table> 
			<!-- CONTENT END -->
					</td>
											<td  style="border-right:solid 1px #6b6b71; ">&nbsp;</td>
										</tr>
										<tr>
					            <td width="1%"><html:img page="/images/round3.gif"/></td>
					           	<td class="smalltext" style="border-bottom:solid 1px #6b6b71; ">&nbsp;</td>
					            <td width="1%"><html:img page="/images/round2.gif"/></td>
					          </tr>
									</table>
									
			          </TD>
        </TR>
      </TABLE>
      
			
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

<html:javascript formName="personalForm" />

</html>


<script language="javascript">

</script>