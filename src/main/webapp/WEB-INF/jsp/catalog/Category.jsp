<%@ include file="../common/IncludeTop.jsp"%>

<div id="BackLink">
	<a href="mainAction">Return to Main Menu</a>
</div>

<div id="Catalog">

	<h2><s:property value="#session.category.name"/></h2>

<table>
	<tr>
		<th>Product ID</th>
		<th>Name</th>
	</tr>
	<s:iterator var="product" value="#session.productList">
		<tr>
			<td>
				<a href="viewProductAction?productId=<s:property value="#product.productId"/>"><s:property value="#product.productId"/></a>
			</td>
			<td><s:property value="#product.name"/></td>
		</tr>
	</s:iterator>
</table>

</div>

<%@ include file="../common/IncludeBottom.jsp"%>


