<%@ include file="../common/IncludeTop.jsp"%>

<div id="Catalog">
	<form action="editAccountAction" method="post">
		<h3>User Information</h3>
		<table>
			<tr>
				<td><s:text name="userId"/></td>
				<td><input type="text" name="account.username" value="<s:property value="#session.account.username"/>"/></td>
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

		<input type="submit" name="editAccount" value=<s:text name="Save"/> />
	</form>
	<a href="viewMyOrdersAction?username=<s:property value="#session.account.username"/>"><s:text name="myOrders"/></a>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>