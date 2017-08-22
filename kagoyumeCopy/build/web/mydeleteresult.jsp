<%@page import="kagoyume.JumsHelper"
%>

<%
    JumsHelper jh = JumsHelper.getInstance();
%>
<%-- 
    Document   : mydeleteresult
    Created on : 2017/08/21, 17:18:44
    Author     : takahirokanno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>削除完了 | かご夢</title>
    </head>
    <body>
        <h3>ユーザー情報を削除しました</h3>
        <p>またのご利用をお待ちしております</p>
        <br>
        <%= jh.top() %>
    </body>
</html>
