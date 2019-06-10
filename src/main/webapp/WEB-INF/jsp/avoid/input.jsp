<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<title>MyPetStore</title>
</head>
<body>

<s:form action="avoid">
    <s:token></s:token>
    <s:textfield name="username" label="Enter your name"></s:textfield>
    <s:textfield name="birthday" label="Enter your birthday"></s:textfield>
    <s:submit value="submit"></s:submit>
</s:form>
</body>
</html>