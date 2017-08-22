<%@page import="kagoyume.JumsHelper"
        import="kagoyume.UserDataDTO"
        import="kagoyume.ProductData"
        import="java.util.ArrayList"
        import="javax.servlet.http.HttpSession"
%>

<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    String name = "";
    //ログイン状態処理(一応、ログイン状態のはずだが)
    boolean log = false;
    if(hs.getAttribute("login") != null){
        log = true;
        //名前表示のためにセッションから取り出す
        UserDataDTO udd = (UserDataDTO)hs.getAttribute("welcomeUDD");
        name = udd.getName();
    }
    ArrayList<ProductData> lastList = (ArrayList<ProductData>)hs.getAttribute("lastList");
    
%>
<%-- 
    Document   : myhistory
    Created on : 2017/08/22, 14:00:54
    Author     : takahirokanno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>購入履歴 | かご夢</title>
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
            <%if(lastList == null){%>
            <p>まだ商品を購入していません</p>
            <%}else{%>
            <table border="1" bordercolor="#333" cellpadding="5" cellspacing="3">
                <tr>
                    <th>イメージ</th>
                    <th>商品名</th>
                    <th>金額</th>
                </tr>
                <% for(ProductData pd : lastList){%>
                <tr>
                    <td><img src="<%= pd.getImg() %>"></td>
                    <td><%= pd.getName() %></td>
                    <td><%= pd.getPrice() %>円</td>
                </tr>
                <%}%>
            </table>
            <%}%><br><br>
            <%= jh.mydata() %><br><br>
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
