<%@ include file="../common/IncludeTop.jsp"%>

<div id="BackLink">
	<a href="viewCategoryAction?categoryId=<s:property value="#session.product.categoryId"/>">
		Return to <s:property value="#session.product.categoryId"/>
	</a>
</div>

<div id="Catalog">
	<h2><s:property value="#session.product.name"/></h2>
<table>
	<tr>
		<th>Item ID</th>
		<th>Product ID</th>
		<th>Description</th>
		<th>List Price</th>
		<th>&nbsp;</th>
	</tr>
	<s:iterator var="item" value="#session.itemList">
		<tr>
			<td>
				<a href="viewItemAction?itemId=<s:property value="#item.itemId"/>"><s:property value="#item.itemId"/></a>
			</td>
			<td>
					<s:property value="#item.product.productId"/>
			</td>
			<td>
				<s:property value="#item.attribute1"/> <s:property value="#item.attribute2"/> <s:property value="#item.attribute3"/>
				<s:property value="#item.attribute4"/> <s:property value="#item.attribute5"/> <s:property value="#product.name"/>
			</td>
			<td>
				<s:property value="%{formatDouble(#item.listPrice)}" />
			</td>
			<td>
				<a class="Button" href="addItemToCartAction?workingItemId=<s:property value="#item.itemId"/>">Add to Cart</a>
			</td>
		</tr>
	</s:iterator>
</table>

</div>

<%@ include file="../common/IncludeBottom.jsp"%>





