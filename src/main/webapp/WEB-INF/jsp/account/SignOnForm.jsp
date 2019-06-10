<%@ include file="../common/IncludeTop.jsp"%>
<div id="Catalog">

	<%
		String error = (String)session.getAttribute("error1");
		if(error!=null){
			out.println(error);
		}
		String error2 = (String)session.getAttribute("error2");
		if(error2!=null){
			out.println(error2);
		}
	%>

	<form action="signOnAction" method="post">
		<p><s:text name="please"/></p>
		<p><s:text name="username"/><input type="text"  name="account.username"/> <br />
			<s:text name="password"/><input type="password" name="account.password"/></p>

		<p><s:text name="verCode"/><input type="text" name="securityCode"/><br/>
			<img id="Verify" src="SecurityCodeImageAction" style="cursor:hand;" alt="看不清，换一张"/>
		<br/>

		<input type="submit" name="signon" value=<s:text name="Login"/> />
	</form>

	<s:text name="need"/>
	<a href="registerFormAction"><s:text name="registerNow"/></a>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>