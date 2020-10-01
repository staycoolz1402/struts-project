<% response.setHeader("Pragma", "No-cache");
response.setDateHeader("Expires", 0);
response.setHeader("Cache-Control", "no-cache");%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri='http://struts.apache.org/tags-tiles' prefix='tiles' %>
<%@ taglib uri='http://struts.apache.org/tags-nested' prefix='nested' %>


<logic:present scope="session" name="user">
<script type='text/javascript'>

<%
	int i=1, j=1, k=1, p=0;
%>

function Go(){return}
<logic:present name="viewAccess">
<logic:iterate id="view" name="viewAccess" type="com.ams.mufins.model.View">
<nested:root name="view">
<logic:match name="view" property="view" value="true" scope="page">

<logic:notPresent name="view" property="parent">
Menu<%=i%>=new Array("<bean:write name="view" property="viewName" scope="page"/>","<bean:write name="view" property="link" scope="page"/>","<html:rewrite page="/images/bg_menu.gif"/>",<bean:write name="view" property="childs" scope="page"/>,20,<bean:write name="view" property="length" scope="page"/>,"","","","","","",-1,-1,-1,"","");
<%
	i++;
	p++;
	j = 1;
%>
</logic:notPresent>
<logic:present name="view" property="parent">
<logic:notPresent name="view" property="parent.parent">
Menu<%=(i-1)+"_"+j%>=new Array("<bean:write name="view" property="viewName" scope="page"/>","<bean:write name="view" property="link" scope="page"/>","",<bean:write name="view" property="childs" scope="page"/>,20,<bean:write name="view" property="length" scope="page"/>,"","","","","","",-1,-1,-1,"","");
<%
	j++;
	k=1;
%>
</logic:notPresent>
<logic:present name="view" property="parent.parent">
<bean:size id="y" name="view" property="views"/>
Menu<%=(i-1)+"_"+(j-1)+"_"+k%>=new Array("<bean:write name="view" property="viewName" scope="page"/>","<bean:write name="view" property="link" scope="page"/>","",<%=y%>,20,<bean:write name="view" property="length" scope="page"/>,"","","","","","",-1,-1,-1,"","");
<%
	k++;
%>
</logic:present>
</logic:present>

</logic:match>
</nested:root>
</logic:iterate>
</logic:present>
 
	var NoOffFirstLineMenus=<%=i-1%>;
	var LowBgColor="#949492";//#8d1010
	var HighBgColor="#f62b2b";
	var FontLowColor="#f5f1f1";
	var FontHighColor="#f6e275";
	var BorderColor="#626260";//#8d1010
	var BorderWidthMain=1;
	var BorderWidthSub=1;
 	var BorderBtwnMain=1;
	var BorderBtwnSub=1;
	var FontFamily="Verdana, Arial, Helvetica, sans-serif";	
	var FontSize=11;
	var FontBold=0;
	var FontItalic=0;
	var MenuTextCentered="left";
	var MenuCentered="left";
	var MenuVerticalCentered="top";
	var ChildOverlap=0;
	var ChildVerticalOverlap=0;
	var StartTop=71;
	var StartLeft=0;
	var VerCorrect=0;
	var HorCorrect=0;
	var LeftPaddng=3;
	var TopPaddng=2;
	var FirstLineHorizontal=1;
	var MenuFramesVertical=1;
	var DissapearDelay=1000;
	var UnfoldDelay=100;
	var TakeOverBgColor=1;
	var FirstLineFrame="";
	var SecLineFrame="";
	var DocTargetFrame="";
	var TargetLoc="";
	var MenuWrap=1;
	var RightToLeft=0;
	var BottomUp=0;
	var UnfoldsOnClick=0;
	var BaseHref="<%=request.getContextPath()%>";		
	var Arrws=[BaseHref+"/images/tri.gif",5,10,BaseHref+"/images/tridown.gif",10,5,BaseHref+"/images/trileft.gif",5,10,BaseHref+"/images/triup.gif",10,5];		
	var BuildOnDemand=1;
	var MenuUsesFrames=0;	
	var RememberStatus=2;	
	var ScaleMenu=0;
	var OverFormElements=1;
	
	var HooverBold=0;
	var HooverItalic=0;
	var HooverUnderLine=0;
	var HooverTextSize=0;
	var HooverVariant=0;
	
	var PartOfWindow=.8;
	var MenuSlide="";
	//var MenuSlide="progid:DXImageTransform.Microsoft.RevealTrans(duration=.5, transition=19)";
	//var MenuSlide="progid:DXImageTransform.Microsoft.GradientWipe(duration=.5, wipeStyle=1)";
	var MenuShadow="";
	//var MenuShadow="progid:DXImageTransform.Microsoft.DropShadow(color=#888888, offX=2, offY=2, positive=1)";
	//var MenuShadow="progid:DXImageTransform.Microsoft.Shadow(color=#888888, direction=135, strength=3)";
	var MenuOpacity="";
	//var MenuOpacity="progid:DXImageTransform.Microsoft.Alpha(opacity=75)";
	
	function BeforeStart(){return}
	function AfterBuild(){return}
	function BeforeFirstOpen(){return}
	function AfterCloseAll(){return}

</script>
<script type='text/javascript' src='<html:rewrite page="/js/menu132_com.js"/>'></script>
<noscript>Your browser does not support script</noscript>

<%//p = p - 1;%>

</logic:present>
																						