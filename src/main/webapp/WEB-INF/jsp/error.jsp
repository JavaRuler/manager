<%--
  Created by IntelliJ IDEA.
  User: 孙建荣
  Date: 2017/3/8/008
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
    pageContext.setAttribute("basePath", basePath);
%>
<!DOCTYPE html>
<html>
<head>
    <title>错误页面</title>
</head>
<body>
<meta http-equiv="refresh" content="60;url=${basePath}/index.jsp" property="">
<!-- content="60，即60秒后返回主页，可根据需要修改或者删除这段代码 -->
<link href="${basePath}/css/error.css" rel="stylesheet" type="text/css"/>
<!-- 代码 开始 -->
<div id="container"><img class="png" src="${basePath}/images/error/404.png"/> <img
        class="png msg" src="${basePath}/images/error/404_msg.png"/>

    <p><a href="${basePath}/adminView.html">
        <img class="png"
             src="${basePath}/images/error/404_to_index.png"/></a>
    </p>
</div>
<div id="cloud" class="png"></div>
<!-- 代码 结束 -->

</body>
</html>
