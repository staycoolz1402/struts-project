<% response.setHeader("Pragma", "No-cache");
response.setDateHeader("Expires", 0);
response.setHeader("Cache-Control", "no-cache");%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested" %>
<%@page isErrorPage="true" import="com.ams.mufins.model.*, com.mpe.common.*,java.io.*, org.apache.log4j.Logger, com.ams.mufins.action.UserAction" %>
<% Users users = (Users)session.getAttribute(CommonConstants.USER); Logger log = Logger.getLogger(UserAction.class);%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>ERROR</title>
<link href="<html:rewrite page="/js/simas.css"/>" rel="stylesheet" type="text/css"/>
<script>
history.pushState({ page: 1 }, "title 1", "#no-back-browser");
window.onhashchange = function (event) {
window.location.hash = "no-back-browser";
};
</script>
</head>
<body style="margin:0px;">
<table width="100%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td style="background-image: url(<html:rewrite page="/images/bg_header.gif"/>); background-repeat:repeat-x; " height="93" valign="top" align="left">
    
    <!-- header start -->
    
    
    <!-- header end -->
    
    </td>
  </tr>
  <tr>
    <td style="background-image:url(<html:rewrite page="/images/list.gif"/>); background-repeat:repeat-x;">&nbsp;</td>
  </tr>
  <tr>
    <td style="background-image:url(<html:rewrite page="/images/bg_body.gif"/>); background-repeat:repeat-x; background-position:bottom;" height="589" bgcolor="#fbfdff" align="left" valign="top">
    
<!-- content -->          
      <table width="900" border="0" cellspacing="0" cellpadding="5" style="margin-left:10px; ">
	   <tr>
	      <td align="left" class="text03"><b>Error</b></td>
	   </tr>
	   <tr>
          <td align="center" width="100%">
          
          <table width="100%" border="0" cellspacing="0" cellpadding="0">
          	  <tr>
	            <td width="1%"><html:img page="/images/round.gif"/></td>
	            <td width="98%" class="smalltext" style="border-top:solid 1px #6b6b71; ">&nbsp;</td>
	            <td width="1%"><html:img page="/images/round1.gif"/></td>
	          </tr>
	          <tr>
	            <td style="border-left:solid 1px #6b6b71; ">&nbsp;</td>
	            <td valign="top">
	            <table width="100%" border="0" cellspacing="2" cellpadding="0">
				  <%
				     if(exception != null )
				     {
				    	try{
				   %>    	 
				    	 
				      <tr>
				       	   <td width="30%" align="right"><font color="red">Error Message</font></td>
			               <td width="5%">:</td>
			               <td width="65%" align="left"><font color="red"><%=exception.getMessage()%></font>
			               </td>
			          <tr>
			          	<%}catch(Exception ex){
							log.error("Error Page",ex);
						%>
						<tr class="tablecolumnbody">
							<td width="30%"  align="right"><font color="red">Error Message</font></td>
							<td width="5%">:</td>
							<td width="65%" align="left"><font color="red">The System found unexpected error.</font>
							</td>
						</tr>
						<%}
				     	}else{
				     		if(response.getStatus()==404){%>
				     		<tr>
					       	   <td colspan="3"><font color="red"><font color="red">Halaman tidak ditemukan</font></td>
			             	</tr>
			             	<%} else { %>
				     	 <tr>
				       	   <td width="30%" align="right"><font color="red">Error Code</font></td>
			               <td width="5%">:</td>
			               <td width="65%" align="left"><font color="red"><%=response.getStatus() %><font color="red"></td>
			             </tr>
			             <tr>  
			               <td colspan="3">Please contact helpdesk for this problem</td>
			          	<tr>
						<%}
				     }%>
				  </td>
				  
				  <td>
				   	<input class="button" type="button" name="home" onclick="backToHome();" value="<bean:message key="backToHome.link"/>">
				</td>
									
			</tr>
			</table>
			</td>
				<td  style="border-right:solid 1px #6b6b71; ">&nbsp;</td>
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
			
	    </table>
	  </td>
	</tr>
	<tr>
    <td style="background-image:url(<html:rewrite page="/images/list1.gif"/>); background-repeat:repeat-x;">&nbsp;</td>
  </tr>
  <tr>
    <td valign="top" height="57" style="background-image: url(<html:rewrite page="/images/footer2.jpg"/>); background-repeat:repeat-x;">
    
    <!-- footer start -->
	<tiles:insert template='/common/footer.jsp'/>
	<!-- footer end -->
    
    </td>
  </tr>
</table>
</body>	



<script language="javascript">

function backToHome(){
	window.location.href=('<html:rewrite page="/home.do"/>');
}

</script>
</html>	