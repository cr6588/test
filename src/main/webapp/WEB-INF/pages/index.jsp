<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/resources/css/hui/H-ui.css" />
<link rel="stylesheet" href="/resources/css/hui/H-ui.admin.css" />
<script src="/resources/js/jquery/jquery-1.10.2.js" type="text/javascript"></script>
<script src="/resources/js/layer/layer/layer.min.js" type="text/javascript"></script>
<script src="/resources/js/hui/H-ui.js" type="text/javascript"></script>
<script src="/resources/js/hui/H-ui.admin.js" type="text/javascript"></script>
<title>Insert title here</title>
</head>
<body>
asdf
    <div class="header-language">
        <div onmouseover="language_hover()" onmouseout="language_mout()" class="header-hover-div">
            <span style="font-size: 12px;cursor: pointer;" id="language_span">
                <font><c:if test="${locale=='zh' }">简体中文</c:if><c:if test="${locale=='en' }">English</c:if></font>
                <img class="language-hover" src="/resources/images/triangle_down.png" />
            </span>
            <div class="language-dropDown-menu" id="language-dropDown-menu" >
                <ul>
                    <li><a onclick="changeLanguage('zh')">简体中文</a></li>
                    <li><a onclick="changeLanguage('en')">English</a></li>
                </ul>
            </div>
        </div>
    </div>
    <spring:message code="hello"></spring:message>
    <script type="text/javascript">
    function changeLanguage(locale) {
        
    }
    function requestBody() {
        var i18n = {};
        i18n.code = 1;
        i18n.language = 'zh';
        $.ajax({
            type: "post",
            url: "/requestBody",
            data: JSON.stringify(i18n),
            dataType: "json",
            contentType: "application/json",
            success:function(result) {
                
            }
        });
    }
    </script>
</body>
</html>