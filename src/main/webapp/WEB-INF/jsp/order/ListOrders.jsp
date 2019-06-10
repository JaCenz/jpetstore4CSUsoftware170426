<%@ include file="../common/IncludeTop.jsp"%>

<h2>My Orders</h2>

<table>
	<tr>
		<th>Order ID</th>
		<th>Date</th>
		<th>Total Price</th>
	</tr>

	<s:iterator var="order" value="#session.orderList">
		<tr>
			<td>
				<a href="viewOrderByIdAction?orderId=<s:property value="#order.orderId"/>" name="orderId" value=<s:property value="#order.orderId"/>><s:property value="#order.orderId"/></a>
			</td>
			<td><s:property value="#order.orderDate"/></td>
			<td><s:property value="#order.totalPrice"/></td>
		</tr>
	</s:iterator>

</table>

<%@ include file="../common/IncludeBottom.jsp"%>


