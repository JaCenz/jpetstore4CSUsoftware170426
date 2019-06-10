<%@ include file="../common/IncludeTop.jsp"%>
<div id="BackLink">
	<a href="viewProductAction?productId=<s:property value="#session.product.productId"/>">Return to <s:property value="#session.product.productId"/></a>
</div>

<div id="Catalog">

<table>
	<tr>
		<td><s:property escapeHtml="false" value="#session.product.description" /></td>
	</tr>
	<tr>
		<td><b> <s:property value="#session.item.itemId"/> </b></td>
	</tr>
	<tr>
		<td><b><font size="4"> <s:property value="#session.item.attribute1"/>
			<s:property value="#session.item.attribute2"/> <s:property value="#session.item.attribute3"/>
			<s:property value="#session.item.attribute4"/> <s:property value="#session.item.attribute5"/>
			<s:property value="#session.product.name"/> </font></b></td>
	</tr>
	<tr>
		<td><s:property value="#session.product.name"/></td>
	</tr>
	<tr>
		<td>
			<s:if test="%{#session.item.quantity <= 0}">
				Back ordered.
			</s:if>
			<s:if test="%{#session.item.quantity > 0}">
				<s:property value="#session.item.quantity"/>
			</s:if>
		</td>
	</tr>
	<tr>
		<td>
			<s:property value="%{formatDouble(#session.item.listPrice)}" />
		</td>
	</tr>

	<tr>
		<td>
			<a class="Button" href="addItemToCartAction?workingItemId=<s:property value="#item.itemId"/>">Add to Cart</a>
		</td>
	</tr>
</table>

</div>

<%@ include file="../common/IncludeBottom.jsp"%>



