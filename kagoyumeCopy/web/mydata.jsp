<%@page import="kagoyume.JumsHelper"
        import="kagoyume.UserDataDTO"
        import="javax.servlet.http.HttpSession"
%>

<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    String name = "";
    String password = "";
    String mail = "";
    String address = "";
    //ログイン状態処理
    boolean log = false;
    if(hs.getAttribute("login") != null){
        log = true;
        //名前表示を含めたユーザー情報表示のためにセッションから取り出す
        UserDataDTO udd = (UserDataDTO)hs.getAttribute("welcomeUDD");
        name = udd.getName();
        password = udd.getPassword();
        mail = udd.getMail();
        address = udd.getAddress();
    }
%>

<%-- 
    Document   : mydata
    Created on : 2017/08/18, 17:01:44
    Author     : takahirokanno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>会員情報 | かご夢</title>
    </head>
    <body>
        <header>
            <div class="logo">
                <strong>かご夢</strong>
            </div>
            <hr>
            <% //ログイン,アウト表示分岐(ログアウト状態では来れない?)
               if(!log){     
            %>
                <%= jh.login() %> 
            <% }else{ %>
                <%= jh.logout(name) %>
            <% } %>
        </header>
        <hr>
        <main>
            <h3>会員情報</h3>
            <table border="1" bordercolor="#333" cellpadding="5" cellspacing="3">
                <tr>
                    <th>ユーザー名</th>
                    <th>パスワード</th>
                    <th>メールアドレス</th>
                    <th>住所</th>
                </tr>
                <tr>
                    <td width="200"><%= name %></td>
                    <td width="200"><%= password %></td>
                    <td width="200"><%= mail %></td>
                    <td width="200"><%= address %></td>
                </tr>
            </table>
            <br><br>
            <form action="myhistory" method="post">
                <input type="hidden" name="ac" value="<%= hs.getAttribute("ac")%>">
                <input type="submit" name="history" value="購入履歴を確認する">
            </form>
            <br>
            <form action="myupdate" method="post">
                <input type="hidden" name="ac" value="<%= hs.getAttribute("ac")%>">
                <input type="submit" name="update" value="会員情報を更新する">
            </form>
            <br>
            <form action="mydelete" method="post">
                <input type="hidden" name="ac" value="<%= hs.getAttribute("ac")%>">
                <input type="submit" name="delete" value="会員情報を削除する">
            </form>
            <br><br>
            <%= jh.top() %>
        </main>
        <hr>
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
