<%@page import="kagoyume.JumsHelper"
        import="javax.servlet.http.HttpSession"
%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    String al = "";
    boolean alert = false;
    if(session.getAttribute("noadd") != null){
        alert = true;
        al = (String)session.getAttribute("noadd");
        session.setAttribute("noadd", null);
    }

%>
<%-- 
    Document   : login
    Created on : 2017/08/16, 13:20:48
    Author     : takahirokanno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <h1>ログインページ</h1><br>
        <hr>
        <%
            if(alert){
                out.print(al);
            }
        %>
        <form action="afterlogin" method="post">
            名前<br>
            <input type="text" name="name"><br><br>
            パスワード<br>
            <input type="password" name="pass"><br><br>
            <input type="hidden" name="ac" value="<%= hs.getAttribute("ac") %>">
            <input type="submit" name="btnSubmit" value="login!">
        </form>
        <br>
        <p>↓まだ会員ではない方はこちら↓</p>
        <form action="registration" method="post">
            <input type="submit" name="btn" value="新規登録画面">
        </form><br>
        <hr>
        <%= jh.top() %>
    </body>
</html>
