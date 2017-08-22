<%@page import="kagoyume.JumsHelper"
        import="kagoyume.UserData"
        import="javax.servlet.http.HttpSession"
        import="java.util.ArrayList"
%>
<%
    HttpSession hs = request.getSession();
    JumsHelper jh = JumsHelper.getInstance();
    UserData ud = (UserData)hs.getAttribute("ud");
    ArrayList<String> chkList = ud.chkpro();
%>
<%-- 
    Document   : registrationconfirm
    Created on : 2017/08/16, 15:05:48
    Author     : takahirokanno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>登録確認画面</title>
    </head>
    <body>
        <% if(chkList.size() == 0){ %>
            <h2>登録確認</h2>
            ユーザー名<br>
            <%= ud.getName() %><br><br>
            パスワード<br>
            <%= ud.getPassword() %><br><br>
            メールアドレス<br>
            <%= ud.getMail() %><br><br>
            住所<br>
            <%= ud.getAddress() %><br><br>
            上記の内容で登録します、よろしいですか？
            <form action="registrationcomplete" method="post">
                <input type="hidden" name="ac" value="<%= hs.getAttribute("ac") %>">
                <input type="submit" name="ok" value="登録OKです！">
            </form>
        <% }else{ %>
            <h2>入力に不備があります</h2>
            <%= jh.chkin(chkList) %>
            <p>もう一度登録画面からやり直してください</p>
        <% } %><br>
        <form action="registration" method="post">
            <input type="hidden" name="mode" value="reinput">
            <input type="submit" name="no" value="登録画面に戻る">
        </form><br>
        <hr>
        <%= jh.top() %>
    </body>
</html>
