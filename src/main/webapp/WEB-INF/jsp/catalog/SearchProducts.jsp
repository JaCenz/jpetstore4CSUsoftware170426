<%@ include file="../common/IncludeTop.jsp"%>

<div id="BackLink">
	<a href="mainAction">Return to Main Menu</a>
</div>

<div id="Catalog">

<table>
	<tr>
		<th>&nbsp;</th>
		<th>Product ID</th>
		<th>Name</th>
	</tr>
	<s:iterator var="product" value="#session.productList">
		<tr>
			<td>
				<a href="viewProductAction?productId=<s:property value="#product.productId"/>"><s:property escapeHtml="false" value="#product.description"/></a>
			</td>
			<td>
				<b>
					<a href="viewProductAction?productId=<s:property value="#product.productId"/>">
						<font color="BLACK"> <s:property value="#product.productId"/> </font>
					</a>
				</b>
			</td>
			<td><s:property value="#product.name" /></td>
		</tr>
	</s:iterator>
	<tr>
		<td></td>
	</tr>

</table>

</div>

<%@ include file="../common/IncludeBottom.jsp"%>




