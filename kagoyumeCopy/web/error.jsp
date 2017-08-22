<%@page import="kagoyume.JumsHelper" %>
<%-- 
    Document   : error
    Created on : 2017/08/16, 14:27:25
    Author     : takahirokanno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>エラー</title>
    </head>
    <body>
        エラーが発生しました。エラー内容の確認後、トップページからやり直してください。<br><br>
        エラー理由:<%= request.getAttribute("error") %><br><br>
        <hr>
        <%= JumsHelper.getInstance().top() %>
    </body>
</html>
