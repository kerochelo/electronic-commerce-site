<%@page import="kagoyume.JumsHelper"
        import="kagoyume.UserData"
%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    UserData ud = (UserData)request.getAttribute("ud");
    String name = ud.getName();
    String password = ud.getPassword();
    String mail = ud.getMail();
    String address = ud.getAddress();
%>


<%-- 
    Document   : myupdateresult
    Created on : 2017/08/21, 15:59:23
    Author     : takahirokanno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>更新完了 | かご夢</title>
    </head>
    <body>
        <h3>下記の内容で登録しました</h3>
        ユーザー名:<br>
        <%= name %><br><br>
        パスワード:<br>
        <%= password %><br><br>
        メールアドレス:<br>
        <%= mail %><br><br>
        住所:<br>
        <%= address %><br><br>
        
        <%= jh.mydata() %><br><br>
        <%= jh.top() %>
    </body>
</html>
