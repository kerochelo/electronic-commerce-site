<%@page import="javax.servlet.http.HttpSession"
        import="kagoyume.JumsHelper"
        import="kagoyume.UserData"
%>

<%
    HttpSession hs = request.getSession();
    JumsHelper jh = JumsHelper.getInstance();
    UserData ud = null;
    boolean reinput = false;
    if(request.getParameter("mode") != null && request.getParameter("mode").equals("reinput")){
        reinput = true;
        ud = (UserData)hs.getAttribute("ud");
    }
%>
<%-- 
    Document   : registration
    Created on : 2017/08/16, 14:03:43
    Author     : takahirokanno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>新規登録 | かご夢</title>
    </head>
    <body>
        <h2>新規登録フォーム</h2><br>
        <hr>
        <form action="registrationconfirm" method="post">
            ユーザー名<br>
            <input type="text" name="name" size="20" value="<% if(reinput){out.print(ud.getName());} %>"><br><br>
            パスワード<br>
            <input type="password" name="password" size="20"><br><br>
            メールアドレス<br>
            <input type="email" name="mail" size="30" value="<% if(reinput){out.print(ud.getMail());} %>"><br><br>
            住所<br>
            <input type="text" name="address" size="50" value="<% if(reinput){out.print(ud.getAddress());} %>"><br><br>
            <input type="hidden" name="ac" value="<%= hs.getAttribute("ac") %>">
            <input type="submit" name="btn" value="確認画面へ">
        </form><br>
        <hr>
        <%= jh.top() %>
    </body>
</html>

