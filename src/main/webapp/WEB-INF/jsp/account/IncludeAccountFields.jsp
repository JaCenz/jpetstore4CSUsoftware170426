<h3>Account Information</h3>
<table>
	<tr>
	<td><s:text name="firstName"/></td>
		<td><input type="text" name="account.firstName"  value="<s:property value="#session.account.firstName"/>"/></td>
	</tr>
	<tr>
		<td><s:text name="lastName"/>/td>
		<td><input type="text"  name="account.lastName" value="<s:property value="#session.account.lastName"/>" /></td>
	</tr>
	<tr>
		<td><s:text name="email"/></td>
		<td><input type="text"  size="40" name="account.email" value="<s:property value="#session.account.email"/>"/></td>
	</tr>
	<tr>
		<td><s:text name="phone"/></td>
		<td><input type="text"  name="account.phone" value="<s:property value="#session.account.phone"/>"/></td>
	</tr></td>
	</tr>
	<tr>
		<td><s:text name="address1"/></td>
		<td><input type="text"  size="40" name="account.address1" value="<s:property value="#session.account.address1"/>"/></td>
	</tr></td>
	</tr>
	<tr>
		<td><s:text name="address2"/></td>
		<td><input type="text"  size="40" name="account.address2" value="<s:property value="#session.account.address2"/>"/></td>
	</tr></td>
	</tr>
	<tr>
		<td><s:text name="city"/></td>
		<td><input type="text"  name="account.city" value="<s:property value="#session.account.city"/>"/></td>
	</tr></td>
	</tr>
	<tr>
		<td><s:text name="state"/></td>
		<td><input type="text"  size="4" name="account.state" value="<s:property value="#session.account.state"/>"/></td>
	</tr></td>
	</tr>
	<tr>
		<td><s:text name="zip"/></td>
		<td><input type="text"  size="10" name="account.zip" value="<s:property value="#session.account.zip"/>"/></td>
	</tr></td>
	</tr>
	<tr>
		<td><s:text name="country"/></td>
		<td><input type="text"  size="15" name="account.country" value="<s:property value="#session.account.country"/>"/></td>
	</tr></td>
	</tr>
</table>

<h3><s:text name="profile"/></h3>

<table>
	<tr>
		<td><s:text name="language"/></td>
		<td>
			<select name="account.languagePreference">
				<option>english</option>
				<option>japanese</option>
			</select>
		</td>
	</tr>
	<tr>
		<td>Favourite Category:</td>
		<td>
			<select name="account.favouriteCategoryId">
				<option>FISH</option>
				<option>DOGS</option>
				<option>REPTILES</option>
				<option>CATS</option>
				<option>BIRDS</option>
			</select>
		</td>
	</tr>
	<tr>
		<td><s:text name="myList"/></td>
		<td><input type="checkbox" name="account.listOption" checked="true"/></td>
	</tr>
	<tr>
		<td><s:text name="myBanner"/></td>
		<td><input type="checkbox" name="account.bannerOption" checked="true"/></td>
	</tr>

</table>
