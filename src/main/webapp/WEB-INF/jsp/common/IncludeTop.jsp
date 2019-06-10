<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <link rel="StyleSheet" href="css/jpetstore.css" type="text/css" media="screen" />

    <meta name="generator" content="HTML Tidy for Linux/x86 (vers 1st November 2002), see www.w3.org" />
    <title>MyPetStore</title>
    <meta content="text/html; charset=windows-1252" http-equiv="Content-Type" />
    <meta http-equiv="Cache-Control" content="max-age=0" />
    <meta http-equiv="Cache-Control" content="no-cache" />
    <meta http-equiv="expires" content="0" />
    <meta http-equiv="Expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
    <meta http-equiv="Pragma" content="no-cache" />

    <script type="text/javascript">
        window.onload=function(){
            var verifyObj = document.getElementById("Verify");
            verifyObj.onclick=function(){
                this.src="SecurityCodeImageAction?timestamp="+new Date().getTime();
            };

            var verifyObj2 = document.getElementById("refresh");
            verifyObj2.onclick=function(){
                this.src="SecurityCodeImageAction?timestamp="+new Date().getTime();
            };
        }
        var str1="";
        function fun1(obj)
        {
            if(str1!=obj.value)
            {
                str1 = obj.value;
                document.getElementById("update").click();
            }
        }
    </script>

</head>

<body>

<div id="Header">

    <div id="Logo">
        <div id="LogoContent">
            <a href="mainAction"><img src="images/logo-topbar.gif" /></a>
        </div>
    </div>

    <div id="Menu">
        <div id="MenuContent">
            <a href="viewCartAction"><img align="middle" name="img_cart" src="images/cart.gif" /></a>
            <img align="middle" src="images/separator.gif" />

            <s:if test="%{#session.account == null}">
                <a href="signOnFormAction"> <s:text name="login"/> </a>
            </s:if>

            <s:if test="%{#session.account != null}">
                <s:if test="%{!#session.authenticated}">
                    <a href="signOnFormAction"> <s:text name="login"/></a>
                </s:if>
            </s:if>

            <s:if test="%{#session.account != null}">
                <s:if test="%{#session.authenticated}">
                    <a href="signOutAction"> <s:text name="signOut"/></a>
                    <img align="middle" src="images/separator.gif" />
                    <a href="editAccountFormAction"> <s:text name="myAccount"/> </a>
                </s:if>
            </s:if>

            <img align="middle" src="images/separator.gif" />
            <a href="changelanAction?request_locale=zh_CN">简体中文</a>
            <img align="middle" src="images/separator.gif" />
            <a href="changelanAction?request_locale=en_US">English</a>
            <img align="middle" src="images/separator.gif" />
            <a href="help.html">?</a>
        </div>
    </div>

    <div id="Search">
        <div id="SearchContent">
            <form action="searchProductAction" method="post">
                <input type="text" name="keyword" size="14" />
                <input type="submit" name="searchProducts" value=<s:text name="search"/> />
            </form>
        </div>
    </div>

    <div id="QuickLinks">
        <a href="viewCategoryAction?categoryId=FISH">
            <img src="images/sm_fish.gif" />
        </a>
        <img src="images/separator.gif" />
        <a href="viewCategoryAction?categoryId=DOGS">
            <img src="images/sm_dogs.gif" />
        </a>
        <img src="images/separator.gif" />
        <a href="viewCategoryAction?categoryId=REPTILES">
            <img src="images/sm_reptiles.gif" />
        </a>
        <img src="images/separator.gif" />
        <a href="viewCategoryAction?categoryId=CATS">
            <img src="images/sm_cats.gif" />
        </a>
        <img src="images/separator.gif" />
        <a href="viewCategoryAction?categoryId=BIRDS">
            <img src="images/sm_birds.gif" />
        </a>
    </div>

</div>

<div id="Content">