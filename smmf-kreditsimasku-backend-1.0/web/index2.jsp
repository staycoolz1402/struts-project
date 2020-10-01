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
	int z = 0;
%>

<%@ page import="com.ams.mufins.model.*, com.mpe.common.*" %>
<% Users users = (Users)session.getAttribute(CommonConstants.USER); %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title><bean:message key="page.index.title"/></title>
<link href="<html:rewrite page="/js/simas.css"/>" rel="stylesheet" type="text/css"/>
<script>
history.pushState({ page: 1 }, "title 1", "#no-back-browser");
window.onhashchange = function (event) {
window.location.hash = "no-back-browser";
};
</script>
<script language="javascript" type="text/javascript" src="<html:rewrite page="/js/server_date.js"/>"></script>
<script language="javascript" type="text/javascript" src="<html:rewrite page="/js/aes.js"/>"></script>

</head>

<body style="margin:0px;">
<table width="100%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td style="background-image: url(<html:rewrite page="/images/bg_header.gif"/>); background-repeat:repeat-x; " height="93" valign="top" align="left">
    
    <!-- header start -->
    
<tiles:insert template='/common/header.jsp'/>
    
    <!-- header end -->
    
    </td>
  </tr>
  <tr>
    <td style="background-image:url(<html:rewrite page="/images/list.gif"/>); background-repeat:repeat-x;">&nbsp;</td>
  </tr>
  <tr>
    <td style="background-image:url(<html:rewrite page="/images/bg_body.gif"/>); background-repeat:repeat-x; background-position:bottom;" height="589" bgcolor="#fbfdff" align="left" valign="top">
    
<!-- content -->    
      <logic:notPresent scope="session" name="user">
      
      <table width="80%" border="0" cellspacing="0" cellpadding="5" style="margin-left:150px; margin-top:90px; ">
	      <tr>
	        <td width="25%" valign="bottom">
                <html:img page="/images/img_login.png"/>
            </td>
	        <td align="left">
	        
	        <html:form action="/logon" focus="userName">
	        <html:hidden property="userPassEncrypted" styleId="userPassEncrypted"/>
  			<html:hidden property="userPass" />
	        <table width="150"  border="0" cellspacing="0" cellpadding="0">
	          <tr>
	            <td colspan="3" class="text06" align="center">Selamat Datang Guest!</td>
	          </tr>
	          <tr>
	            <td colspan="3" align="center"><html:errors/></td>
	          </tr>
	          <tr>
	          	<td colspan="3">
	          		<div style="position:absolute; margin-top:9.5em; margin-left:9em"><a href="#" onclick="javascript:window.open('<html:rewrite page="/jsp/thawte.jsp"/>','gg','toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=yes,copyhistory=yes,width=530,height=100');"><html:img page="/images/thawte.png" border="0" /></a></div>
	          	</td>
	          </tr>
	          <tr>
	            <td align="right" width="1%"><html:img page="/images/round_login.gif"/></td>
	            <td style="background-image:url(<html:rewrite page="/images/top_login.gif"/>); background-repeat:repeat-x " align="right"><html:img page="/images/img_login.gif"/></td>
	            <td align="left" width="1%"><html:img page="/images/round_login1.gif"/></td>
	          </tr>
	          <tr>
	            <td style="background-image:url(<html:rewrite page="/images/left_login.gif"/>); background-repeat:repeat-y ">&nbsp;</td>
	            <td bgcolor="#a3a5a7" class="text06" align="left" nowrap>
				<bean:message key="page.userName.title"/><br>
	                <html:text property="userName" styleId="userName" size="20" styleClass="textbox" onchange="chUserName();" maxlength="32"/><br>
			    	<bean:message key="page.userPass.title"/><br>
					<input type="password" name="plainText" id="plainText" size="20" autocomplete="false" class="textbox" onkeyup="changePassword();" onclick="changePassword();" onchange="changePassword();"/><br>
			    	<span id="capsWarning" style="display:none"><font color="red">Caps lock is ON.</font></span>
			    	
			    <div align="center"><br>
			      <input type="button" name="btnLogin" value="Login" class="button" onclick="changePasswordType();"/>
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
 function chUserName(){
		if(document.forms[0].userName.value != null && document.forms[0].userName.value.length > 0){
			if(!document.forms[0].userName.value.match("^[A-Za-z0-9\.]+$")){
				alert('Harap input alphabet, angka, titik saja pada kolom username ')
				document.forms[0].userName.value = "";
				document.forms[0].userName.focus();
				return false;
			}
			if(document.forms[0].userName.value.length > 32){
				alert('Username tidak boleh lebih dari 32 karakter ')
				document.forms[0].userName.value = "";
				return false;
			}
		}
	}
 <logic:notPresent scope="session" name="user">
 //Get the input field
 var input = document.getElementById("plainText");
 //Get the warning text
 var text = document.getElementById("capsWarning");
 input.addEventListener("keyup", function(event) {

 	  // If "caps lock" is pressed, display the warning text
 	  if (event.getModifierState("CapsLock")) {
 	    text.style.display = "block";
 	  } else {
 	    text.style.display = "none"
 	  }
 	});
</logic:notPresent>
</script>

      </logic:notPresent>
      
      
      <logic:present scope="session" name="user">
      <table width="900" border="0" cellspacing="0" cellpadding="5" style="margin-left:10px; " class="text04">
        <TR>
          <td align="left" class="text03" width="20%"><b><logic:present name="viewName"><bean:write name="viewName"/></logic:present></b></td>
        <tr>  
          <TD align="center" width="80%"> 
						<TABLE cellSpacing=0 cellPadding=0 width="92%" border=0 height="100%">
						  <TR valign="top">
						    <TD><html:errors/>&nbsp;</TD>
						  </TR>
						<logic:present name="errorMessage" >
                          <TR valign="top">
                            <TD>
                                <font color="red"><b><bean:write name="errorMessage" /></b>
                            </TD>
                          </TR>
                        </logic:present>
						<logic:present name="lastLogin" >
						  <TR valign="top">
							<TD>
								<font color="red">Anda terakhir login pada : <b><bean:write name="lastLogin" /></b>
							</TD>
						  </TR>
						</logic:present>
						<logic:present name="nextChangePass" scope="request">
						  <TR valign="top">
							<TD>
								<font color="red">Anda harus mengganti password sebelum : <b><bean:write name="nextChangePass" scope="request"/></b>
							</TD>
						  </TR>
						</logic:present>
						  <TR valign="top">
						    <TD>&nbsp;</TD>
						  </TR>
						  <tr>
						  	<td >
						  	
						  		<table width="100%" border="0" cellspacing="0" cellpadding="0">
										
										<tr>
					            <td width="1%"><html:img page="/images/round.gif"/></td>
					            <td width="98%" class="smalltext" style="border-top:solid 1px #6b6b71; ">&nbsp;</td>
					            <td width="1%"><html:img page="/images/round1.gif"/></td>
					          </tr>
										<tr valign="top">
											<td align="left" style="border-left:solid 1px #6b6b71; ">&nbsp;</td>
											<td>
											
											<!-- CF APPLICATION LIST -->
												<table width="100%" border="0" cellspacing="0" cellpadding="0">
												
													<logic:greaterThan name="totalAktaFiduciaNotif" value="0">
													<% if(users.getRole("ADMIN LEGAL") || users.getRole("LEGAL")) { %>
														 	<h3>
																<font color="red">*Ada <span ID="blink4"><b><bean:write name="totalAktaFiduciaNotif" scope=  "request"/></b> aplikasi yang warkah sudah lengkap </span>. Untuk proses generate akta fiducia</font> <b><a href="<html:rewrite page="/aktaFiducia/list.do"/>?subaction=search&kelengkapanWarkah=Y&type=create&flag=blinkAktaFiduciaNotif"><font color="blue">Klik Disini</font></a></b>
																<br>
																<br>
															</h3>
														<% } %>
													</logic:greaterThan>
													
													<!-- START DASHBOARD HOME LIST -->
													<tiles:insert template='/jsp/dashboard_home_list.jsp'/>
													<!-- END DASHBOARD HOME LIST -->
													
													<tr>
								                        <td>&nbsp;</td>
								                    </tr>
								                    
													<logic:notEmpty name="roleGroupList">
													
								                    <tr>
								                        <td>&nbsp;</td>
								                    </tr>
													
								                    <!-- TERMINATION APPROVAL LIST -->
													
													</logic:notEmpty>
													<!-- END HOME LIST -->
													
													<tr>
								                        <td>&nbsp;</td>
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
						  
						  <%-- <tr>
						  	<td>
						  	
						  		<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr valign="top">
											<td width="49%" align="left">
												<table width="100%" border="0" cellspacing="0" cellpadding="0">

													
													<logic:equal name="user" property="showProduct" scope="session" value="true">
													<!-- Top item's sale -->
													<tr valign="top">
														<td>
															<table border="0" cellspacing=0 cellpadding=0 width="100%">
																<tr align="center"> 
																	<td width="100%" nowrap="nowrap" bgcolor="#1e272d" class="borderLeft text05 padding">Product Monthly</td>
																</tr>
																<tr bgcolor="#FFFFFF" align="center"> 
																	<td>
																		<img src="<%=request.getContextPath()%>/productMonthlyChart.do" border="0" height="150" width="290"/>
																	</td>
																</tr>
															</table>
														</td>
													</tr>
													<tr>
														<td>&nbsp;</td>
													</tr>
													</logic:equal>
													
													
												</table>
											</td>
											<td>&nbsp;</td>
											<td width="49%" align="right">
												<table width="100%" border="0" cellspacing="0" cellpadding="0">
													
													<logic:equal name="user" property="showCashBank" scope="session" value="true">
													<tr>
														<td>
															<table border="0" cellspacing=1 cellpadding=0 bgcolor="#cccccc" width="100%">
																<tr align="center"> 
																	<td nowrap="nowrap" bgcolor="#1e272d" class="borderLeft text05 padding">Cash and Bank Chart</td>
																</tr>
																<tr bgcolor="#FFFFFF" align="center"> 
																	<td>
																		<img src="<%=request.getContextPath()%>/bankChartOfAccount/chart.do" border="0" height="200" width="300"/>
																	</td>
																</tr>
															</table>
														</td>
													</tr>
													<tr>
														<td>&nbsp;</td>
													</tr>
													</logic:equal>
													
													<logic:equal name="user" property="showNewApplication" scope="session" value="true">
													<!-- minimum inventory -->
													<tr valign="top">
														<td>
														
														<table border="0" cellspacing=0 cellpadding=0 width="100%" style="margin-top:20px;">
														<tr>
					            <td width="1%"><html:img page="/images/round.gif"/></td>
					            <td width="98%" class="smalltext" style="border-top:solid 1px #6b6b71; ">&nbsp;</td>
					            <td width="1%"><html:img page="/images/round1.gif"/></td>
					          </tr>
					          
										<tr valign="top">
											<td align="left" style="border-left:solid 1px #6b6b71;">&nbsp;</td>
											<td>
														
															<table border="0" cellspacing=0 cellpadding=0 width="100%">
																<tr align="center"> 
                                                                    <td width="1%" align="right"><html:img page="/images/round_table.gif"/></td>
																	<td width="100%" nowrap="nowrap" bgcolor="#1e272d" class="text05 padding">New CF Application Monthly</td>
                                                                    <td width="1%" align="left"><html:img page="/images/round_table1.gif"/></td>
                                                                </tr>
																<tr bgcolor="#FFFFFF" align="center"> 
                                                                	<td></td>
																	<td>
																		<img src="<%=request.getContextPath()%>/cfApplicationMonthlyChart.do" border="0" height="150" width="290"/>
																	</td>
                                                                    <td></td>
																</tr>
                                                                <tr>
                                                                  <td width="1%" class="smalltext" align="right"><html:img page="/images/round_table2.gif"/></td>
                                                                  <td bgcolor="#1e272d"></td>
                                                                  <td width="1%" align="left"><html:img page="/images/round_table3.gif"/></td>
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
													<tr>
														<td>&nbsp;</td>
													</tr>
													</logic:equal>
													
													<logic:equal name="user" property="showNewPersonalCorporate" scope="session" value="true">
													<!-- profit loss chart -->
													<tr valign="top">
														<td>
															<table border="0" cellspacing=1 cellpadding=0 width="100%">
																<tr align="center"> 
																	<td width="100%" nowrap="nowrap" bgcolor="#1e272d" class="borderLeft text05 padding">New Personal - Corporate Monthly</td>
																</tr>
																<tr bgcolor="#FFFFFF" align="center"> 
																	<td>
																		<img src="<%=request.getContextPath()%>/personalCorporateMonthlyChart.do" border="0" height="150" width="290"/>
																	</td>
																</tr>
															</table>
														</td>
													</tr>
													<tr>
														<td>&nbsp;</td>
													</tr>
													</logic:equal>
													
													
												</table>
											</td>
										</tr>
									</table>
									
						  	</td>
						  </tr>			 --%>			  
						  						  
						</TABLE>
          </TD>
        </TR>
      </TABLE>
      </logic:present>
            
    <!-- content end -->
    
    
    
    
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
</html>
<script language="javascript" type="text/javascript" src="<html:rewrite page="/js/openWindows.js"/>" ></script>
<script language="javascript">
var totalBlink = <%=z%>;

Blink();

function Blink() {
	for(var a = 1; a <= totalBlink ; a++){
		obj=document.getElementById("blink"+a);
		if(obj!=null){
			if (obj.style.visibility=="hidden") obj.style.visibility="visible";
		    else obj.style.visibility="hidden";
		}
		
	}
   window.setTimeout("Blink();",500);
}

function changePassword(){
	var t=document.getElementById("plainText").value,n=document.getElementById("userName").value,u=enkripAES(date);
	document.getElementById("userPassEncrypted").value=CryptoJS.AES.encrypt(t+u,n);
}

function changePasswordType(){
	changePassword();
	 document.forms[0].userPass.value = document.getElementById("userPassEncrypted").value;
	 document.getElementById("plainText").value="";
	 document.getElementById("plainText").type= "text";
	 
	document.forms[0].submit();
}

function js_yyyy_mm_dd_hh_mm_ss (date) {
	  now = date;
	  year = "" + now.getFullYear();
	  month = "" + (now.getMonth() + 1); if (month.length == 1) { month = "0" + month; }
	  day = "" + now.getDate();
	  hour = "" + now.getHours(); if (hour.length == 1) { hour = "0" + hour; }
	  minute = "" + now.getMinutes(); if (minute.length == 1) { minute = "0" + minute; }
	  return "SMMF"+day + "" + month + "" + year + "" + hour + "" + minute;
	}

function enkripAES(date){
		return js_yyyy_mm_dd_hh_mm_ss(date);
	}

function goToPartnerReportList(newPartnerSimaskuList){	
	addParam('subaction','search');
	addParam('roleIdUser',26);
	addParam('source','dashboard');
	addParam('newPartnerSimaskuList', newPartnerSimaskuList);
	submitFormPost('<html:rewrite page="/userPartnerReport/list.do"/>');	
}
</script>

