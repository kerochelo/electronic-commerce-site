<%@page import="kagoyume.JumsHelper"
        import="kagoyume.UserDataDTO"
        import="javax.servlet.http.HttpSession"
%>

<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    String name = "";
    //ログイン状態処理(cart.jspと同じく、ログイン状態のはずだが)
    boolean log = false;
    if(hs.getAttribute("login") != null){
        log = true;
        //名前表示のためにセッションから取り出す
        UserDataDTO udd = (UserDataDTO)hs.getAttribute("welcomeUDD");
        name = udd.getName();
    }
    
%>

<%-- 
    Document   : buycomplete
    Created on : 2017/08/22, 11:35:19
    Author     : takahirokanno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ご購入?完了 | かご夢</title>
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
        <main>
            <h3>ご購入(実際は買えませんが...)いただきありがとうございました！</h3>
            <p>また買い物ストレスが溜まったらこのサイトで爆買いしてくださいませ</p>
            <br>
            <%= jh.top() %><br>
        </main>
        <footer>
            <ul>
                <li>利用規約</li>
                <li>会社概要</li>
                <li>about this site</li>
            </ul>
        </footer>
    </body>
</html>
