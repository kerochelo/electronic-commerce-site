<%@page import="kagoyume.JumsHelper"
        import="javax.servlet.http.HttpSession"
        import="kagoyume.UserDataDTO"
%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    String name = "";
    //ログイン状態変数 + 処理
    boolean log = false;
    if(hs.getAttribute("login") != null){
        log = true;
        //名前表示のためにセッションから取り出す
        UserDataDTO udd = (UserDataDTO)hs.getAttribute("welcomeUDD");
        name = udd.getName();
    }
    //検索結果変数 + 処理
    boolean research = false;
    if(hs.getAttribute("research") != null){
        research = true;
    }
    //login後のページ移行のために情報をセッションに格納
    hs.setAttribute("page", "top");

%>
<%-- 
    Document   : top
    Created on : 2017/08/10, 17:09:48
    Author     : takahirokanno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>かご夢</title>
    </head>
    <body>
        <header>
            <div class="logo">
                <strong>かご夢</strong>
            </div>
            <hr>
            <% //ログイン,アウト表示分岐
               if(!log){     
            %>
                <%= jh.login() %> 
            <% }else{ %>
                <%= jh.logout(name) %>
            <% } %>
        </header>
        <br>
        <main>
            <% if(research){ %>
            検索内容と一致する結果がありませんでした。<br>
            <% }
                hs.setAttribute("research", null);
            %>
            <form action="search" method="get">
                <p>検索フォーム</p>
                <input type="text" name="search" placeholder="例) 世界平和">
                <input type="submit" name="btn">
            </form>
        </main>
        <br>
        <footer>
            <hr>
            <ul>
                <li>利用規約</li>
                <li>会社概要</li>
                <li>about this site</li>
            </ul>
        </footer>
    </body>
</html>
