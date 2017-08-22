<%@page import="kagoyume.JumsHelper"
        import="kagoyume.UserDataDTO"
        import="javax.servlet.http.HttpSession"
        import="kagoyume.ProductData"
%>

<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    ProductData pd = (ProductData)session.getAttribute("detailData");
    String name = "";
    //ログイン状態処理(ログイン状態のはずだが)
    boolean log = false;
    if(hs.getAttribute("login") != null){
        log = true;
        //名前表示のためにセッションから取り出す
        UserDataDTO udd = (UserDataDTO)hs.getAttribute("welcomeUDD");
        name = udd.getName();
    }
    //login後のページ移行のために情報をセッションに格納
    hs.setAttribute("page", "add");
    
%>


<%-- 
    Document   : add
    Created on : 2017/08/21, 20:01:59
    Author     : takahirokanno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>商品追加ページ | かご夢</title>
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
        <hr>
        <main>
            <h3>商品を買い物かごに追加しました</h3><br><br>
            
            商品名:<br>
            <%= pd.getName() %><br><br>
            価格:<br>
            <%= pd.getPrice() %><br><br>
            
            <%= jh.item() %><br><br>
            <%= jh.search() %><br><br>
            <%= jh.top() %><br>
        </main>
        <hr>
        <footer>
            <ul>
                <li>利用規約</li>
                <li>会社概要</li>
                <li>about this site</li>
            </ul>
        </footer>
    </body>
</html>
