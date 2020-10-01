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
           
         <table width="100%" border="0" cellspacing="2" cellpadding="0">
	      	<tr valign="top"><td><html:errors/></td></tr>
	      	
          <tr bgcolor="#FFFFFF"> 
            <td align="center"> 
              <table border="0" cellspacing=1 cellpadding=2 bgcolor="#cccccc" width="100%">
                <tr align="center"> 
                  <td width="5%" nowrap="nowrap" bgcolor="#1e272d" class="borderLeft text05 padding">&nbsp;</td>
                  <td nowrap="nowrap" bgcolor="#1e272d" class="borderLeft text05 padding">Server Connection Timeout</font></td>
                </tr>
<%
int i = 0;
try {
i = Integer.parseInt(request.getParameter("start"));
}catch(Exception ex){
i = 0;
}
%>
                <logic:iterate id="s" name="serverList" type="com.ams.mufins.model.UserStream">
                <logic:present name="s" property="server" scope="page">
								<% 
									sequence++;
									String bgcolor = "#FFFFFF";
									if(sequence%2 == 0){
										bgcolor = "#F5F9EE";
									}
								 %>
								<tr bgcolor="<% out.print(bgcolor); %>">
                	<td class="Cell" align="right"><%=++i%>.</td>
                  <td class="Cell"><font color="red"  font-weight="12" face="arial" size="+2"><bean:write name="s" property="server" scope="page"/></font></td>
                </tr>
                </logic:present>
                </logic:iterate>
              </table>
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
</html>

<script language="javascript">
function page(start,count) {
	document.forms[0].gotoPage.value = '';
	document.forms[0].start.value = start;
	document.forms[0].count.value = count;
	document.forms[0].submit();
};

function gotoPager() {
	if (document.forms[0].gotoPage.value >= 1) {
		if (document.forms[0].count.value == '' || document.forms[0].count.value == 0) document.forms[0].count.value = 10; 
		var a = (document.forms[0].gotoPage.value - 1) * document.forms[0].count.value;
		document.forms[0].start.value = a;
		document.forms[0].gotoPage2.value = document.forms[0].gotoPage.value;
		document.forms[0].submit();
	}
};

function gotoPager2() {
	if (document.forms[0].gotoPage2.value >= 1) {
		if (document.forms[0].count.value == '' || document.forms[0].count.value == 0) document.forms[0].count.value = 10; 
		var a = (document.forms[0].gotoPage2.value - 1) * document.forms[0].count.value;
		document.forms[0].start.value = a;
		document.forms[0].gotoPage.value = document.forms[0].gotoPage2.value;
		document.forms[0].submit();
	}
};

function sort(orderBy) {
	document.forms[0].orderBy.value = orderBy;
	if (document.forms[0].ascDesc.value=='') {
		document.forms[0].ascDesc.value='desc';
	} else if (document.forms[0].ascDesc.value=='desc') {
		document.forms[0].ascDesc.value='asc';
	} else {
		document.forms[0].ascDesc.value='desc';
	}
	document.forms[0].submit();
};

</script>