<%--
  Created by IntelliJ IDEA.
  User: JaCen
  Date: 2018/12/6
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="../common/IncludeTop.jsp"%>

<div id="Welcome">
    <div id="WelcomeContent">
        <s:text name="welcome" />
    </div>
</div>

<div id="Main">
    <div id="Sidebar">
        <div id="SidebarContent">
            <a href="viewCategoryAction?categoryId=FISH"><img src="images/fish_icon.gif" /></a>
            <br/> <s:text name="fishAttribute" /><br/>
            <a href="viewCategoryAction?categoryId=DOGS"><img src="images/dogs_icon.gif" /></a>
            <br /> <s:text name="dogAttribute" /><br />
            <a href="viewCategoryAction?categoryId=CATS"><img src="images/cats_icon.gif" /></a>
            <br /> <s:text name="catAttribute" /><br />
            <a href="viewCategoryAction?categoryId=REPTILES"><img src="images/reptiles_icon.gif" /></a>
            <br /> <s:text name="reptileAttribute" /><br />
            <a href="viewCategoryAction?categoryId=BIRDS"><img src="images/birds_icon.gif" /></a>
            <br /> <s:text name="birdAttribute" />
        </div>
    </div>

    <div id="MainImage">
        <div id="MainImageContent">
            <map name="estoremap">
                <area alt="Birds" coords="72,2,280,250" href="viewCategoryAction?categoryId=BIRDS" shape="rect" />
                <area alt="Fish" coords="2,180,72,250" href="viewCategoryAction?categoryId=FISH" shape="rect" />
                <area alt="Dogs" coords="60,250,130,320" href="viewCategoryAction?categoryId=DOGS" shape="rect" />
                <area alt="Reptiles" coords="140,270,210,340" href="viewCategoryAction?categoryId=REPTILES" shape="rect" />
                <area alt="Cats" coords="225,240,295,310" href="viewCategoryAction?categoryId=CATS" shape="rect" />
                <area alt="Birds" coords="280,180,350,250" href="viewCategoryAction?categoryId=BIRDS" shape="rect" />
            </map>
            <img height="355" src="images/splash.gif" align="middle" usemap="#estoremap" width="350" />
        </div>
    </div>
    <div id="Separator">&nbsp;</div>
    <div id="Favorite">
        <p>Maybe you like:</p>
    </div>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>