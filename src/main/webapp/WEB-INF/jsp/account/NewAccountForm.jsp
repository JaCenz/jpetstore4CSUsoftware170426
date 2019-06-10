<%@ include file="../common/IncludeTop.jsp"%>

<div id="Catalog">

	<form action="registerAction" method="post">
		<h3><s:text name="Information"/></h3>
		<table>
			<tr>
				<td><s:text name="userId"/></td>
				<td><input type="text" name="account.username" /></td>
			</tr>
			<tr>
				<td><s:text name="newRegisterPassword"/></td>
				<td><input type="text" name="account.password" /></td>
			</tr>
			<tr>
				<td><s:text name="repeatPassword"/></td>
				<td><input type="text" name="account.repeatedPassword" /></td>
			</tr>
		</table>
		<%@ include file="IncludeAccountFields.jsp"%>
		<input type="submit" name="newAccount" value=<s:text name="Save"/> />
	</form>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>