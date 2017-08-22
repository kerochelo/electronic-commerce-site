<%@page import="javax.servlet.http.HttpSession"
        import="kagoyume.JumsHelper"
        import="kagoyume.ProductData"
        import="kagoyume.UserDataDTO"
%>

<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    ProductData pd = (ProductData)session.getAttribute("detailData");
    String name = "";
    //ログイン状態処理
    boolean log = false;
    if(hs.getAttribute("login") != null){
        log = true;
        //名前表示のためにセッションから取り出す
        UserDataDTO udd = (UserDataDTO)hs.getAttribute("welcomeUDD");
        name = udd.getName();
    }
    //login後のページ移行のために情報をセッションに格納
    hs.setAttribute("page", "item");
%>
<%-- 
    Document   : item
    Created on : 2017/08/21, 11:26:39
    Author     : takahirokanno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>商品情報 | かご夢</title>
        <style>
            .data-subject{
                font-size: 20px;
                color: #008;
            }
        </style>
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
            <p><div class="data-subject">商品名:</div><br>
            <%= pd.getName()%></p>
            <br><br>
            <p><div class="data-subject">イメージ:</div></p>
            <img src="<%= pd.getImgEx()%>">
            <br><br>
            <p><div class="data-subject">概要:</div>
            <%= pd.getDescription()%></p>
            <br><br>
            <p><div class="data-subject">価格:<%= pd.getPrice()%> 円</div></p>
            <br>
            <form action="add" method="post">
                <input type="hidden" name="pro" value="<%=pd.getId()%>">
                <input type="submit" name="btn" value="カートに追加">
            </form><br>
            
            <%= jh.search() %>
            <br><br>
            <%= jh.top() %>
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
