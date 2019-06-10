<%@ include file="../common/IncludeTop.jsp"%>

<div id="Catalog">
	<form action="confirmOrderAction" method="post">  <!--传的order可能有问题-->
		<table id="shippingtable">
			<tr>
				<th colspan=2>Shipping Address</th>
			</tr>

			<tr>
				<td>First name:</td>
				<td><input type="text" name="order.shipToFirstName" value="<s:property value="#session.order.shipToFirstName"/>"/></td>
			</tr>
			<tr>
				<td>Last name:</td>
				<td><input type="text" name="order.shipToLastName" value="<s:property value="#session.order.shipToLastName"/>"/></td>
			</tr>
			<tr>
				<td>Address 1:</td>
				<td><input type="text" size="40" name="order.shipAddress1" value="<s:property value="#session.order.shipAddress1"/>"/></td>
			</tr>
			<tr>
				<td>Address 2:</td>
				<td><input type="text" size="40" name="order.shipAddress2" value="<s:property value="#session.order.shipAddress2"/>"/></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><input type="text" name="order.shipCity" value="<s:property value="#session.order.shipCity"/>"/></td>
			</tr>
			<tr>
				<td>State:</td>
				<td><input type="text" size="4" name="order.shipState" value="<s:property value="#session.order.shipState"/>"/></td>
			</tr>
			<tr>
				<td>Zip:</td>
				<td><input type="text" size="10" name="order.shipZip" value="<s:property value="#session.order.shipZip"/>"/></td>
			</tr>
			<tr>
				<td>Country:</td>
				<td><input type="text" size="15" name="order.shipCountry" value="<s:property value="#session.order.shipCountry"/>"/></td>
			</tr>
		</table>

		<input type="submit" name="newOrder" value="Continue" />

	</form>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>