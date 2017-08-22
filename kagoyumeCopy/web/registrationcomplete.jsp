<%@page import="javax.servlet.http.HttpSession"
        import="kagoyume.JumsHelper"
        import="kagoyume.UserData"
%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    UserData ud = (UserData)request.getAttribute("ud");
%>

<%-- 
    Document   : registrationcomplete
    Created on : 2017/08/16, 17:26:41
    Author     : takahirokanno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>新規登録完了画面</title>
    </head>
    <body>
        <h3>下記の内容で登録しました</h3><br>
        ユーザー名<br>
        <%= ud.getName() %><br><br>
        パスワード<br>
        <%= ud.getPassword() %><br><br>
        メールアドレス<br>
        <%= ud.getMail() %><br><br>
        住所<br>
        <%= ud.getAddress() %><br>
        <p>トップ画面に戻りログインしてください</p>
        <hr>
        <%= jh.top() %>
    </body>
</html>
