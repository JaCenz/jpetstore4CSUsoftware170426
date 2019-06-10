<%@ include file="../common/IncludeTop.jsp"%>

<div id="Catalog">
	<s:form action="viewConfirmOrderAction" method="post">   <!--要不要传order-->
	<table>
		<tr>
			<th colspan=2>Payment Details</th>
		</tr>
		<tr>
			<td>Card Type:</td>
			<td>
				<select name="order.creditCardTypes">
					<option value="Visa">Visa</option>
					<option value="MasterCard">MasterCard</option>
					<option value="American Express">American Express</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>Card Number:</td>
			<td>
				<input name="order.creditCard" value="<s:property value="#session.order.creditCard"/>">* Use a fake
				number!
			</td>
		</tr>
		<tr>
			<td>Expiry Date (MM/YYYY):</td>
			<td>
				<input name="order.expiryDate" value="<s:property value="#session.order.expiryDate"/>">
			</td>
		</tr>
		<tr>
			<th colspan=2>Billing Address</th>
		</tr>

		<tr>
			<td>First name:</td>
			<td>
				<input name="order.billToFirstName" value="<s:property value="#session.order.billToFirstName"/>">
			</td>
		</tr>
		<tr>
			<td>Last name:</td>
			<td>
				<input name="order.billToLastName" value="<s:property value="#session.order.billToLastName"/>">
			</td>
		</tr>
		<tr>
			<td>Address 1:</td>
			<td>
				<input size="40" name="order.billAddress1" value="<s:property value="#session.order.billAddress1"/>">
			</td>
		</tr>
		<tr>
			<td>Address 2:</td>
			<td>
				<input size="40" name="order.billAddress2" value="<s:property value="#session.order.billAddress2"/>">
			</td>
		</tr>
		<tr>
			<td>City:</td>
			<td>
				<input name="order.billCity" value="<s:property value="#session.order.billCity"/>">
			</td>
		</tr>
		<tr>
			<td>State:</td>
			<td>
				<input size="4" name="order.billState" value="<s:property value="#session.order.billState"/>">
			</td>
		</tr>
		<tr>
			<td>Zip:</td>
			<td>
				<input size="10" name="order.billZip" value="<s:property value="#session.order.billZip"/>">
			</td>
		</tr>
		<tr>
			<td>Country:</td>
			<td>
				<input size="15" name="order.billCountry" value="<s:property value="#session.order.billCountry"/>">
			</td>
		</tr>

		<tr>
			<td colspan=2>
				<input  type="checkbox" name="shippingAddressRequired" value="shippingAddress" id="shipping">
			Ship to different address...
			</td>
		</tr>

	</table>

		<input type="submit" name="newOrder" value="Continue" class="Button">
	</s:form>
</div>

<script type="text/javascript" src="js/showDetails.js"></script>

<%@ include file="../common/IncludeBottom.jsp"%>