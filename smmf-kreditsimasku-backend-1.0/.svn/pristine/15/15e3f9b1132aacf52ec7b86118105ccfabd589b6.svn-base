<% response.setHeader("Pragma", "No-cache");
response.setDateHeader("Expires", 0);
response.setHeader("Cache-Control", "no-cache");%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested" %>
<%@ page language="java" import="org.apache.commons.configuration.PropertiesConfiguration" %> 
<%
  String pathHeaderImage = com.mpe.common.CommonUtil.getHeader();
%>
<!--Calendar-->
<script language="javascript" type="text/javascript" src="<html:rewrite page="/js/jquery.min.js"/>"></script>
<script language="javascript" type="text/javascript" src="<html:rewrite page="/js/date.js"/>"></script><!--buat perhitungan tanggal-->
<script language="javascript" type="text/javascript" src="<html:rewrite page="/js/hitung.js"/>"></script><!--buat tampilan-->
<script language="javascript" type="text/javascript" src="<html:rewrite page="/js/dhtmlgoodies_calendar.js"/>"></script><!--buat calender-->
<link type="text/css" rel="stylesheet" href="<html:rewrite page="/js/dhtmlgoodies_calendar.css"/>" media="screen"></link>
<script language="javascript" type="text/javascript" src="<html:rewrite page="/js/Ajax.js"/>"></script><!--buat AJAX-->

<script language="javascript">
link=document.createElement('link');
link.type='image/x-icon';
link.rel='shortcut icon';
link.href='<html:rewrite page="/images/favicon.ico"/>';
document.getElementsByTagName('head')[0].appendChild(link);
</script>

	<table width="100%"  border="0" cellspacing="0" cellpadding="0" align="left" style="background-image:url(<html:rewrite page="<%=pathHeaderImage %>"/>); background-position:top left; background-repeat:no-repeat;">
      <tr>
      	<td width="900" style="padding-right:10px;" height="72" align="right" valign="bottom">
      		<a id="blokNewTab" href="<html:rewrite page="/home.do"/>"><div style="width:191px; height:55px; border:none; position:absolute; left:3em; top:0.6em">&nbsp;</div></a>
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
      <tr>
        <td colspan="2" style=" cursor:pointer"><div style="width:100%;"><tiles:insert template='/common/menu.jsp'/></div></td>
      </tr>
    </table>
  
  
  
  