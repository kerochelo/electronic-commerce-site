<%@page import="kagoyume.JumsHelper"
        import="kagoyume.ProductData"
        import="kagoyume.UserDataDTO"
        import="java.util.ArrayList"
        import="javax.servlet.http.HttpSession"
%>

<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    ArrayList<ProductData> pd = (ArrayList<ProductData>)hs.getAttribute("pd");
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
    hs.setAttribute("page", "search");

%>

<%-- 
    Document   : search
    Created on : 2017/08/17, 15:32:18
    Author     : takahirokanno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>検索結果 | かご夢</title>
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
        </header><br>
        <hr>
        <main>
            <table border="1" bordercolor="#333" cellpadding="10" cellspacing="5">
                <tr>
                    <th>サムネイル</th>
                    <th>商品名</th>
                    <th>価格(円)</th>
                </tr>
                <% for(int i = 0; i < 10; i++){%>
                <tr>
                    <td><a href="item?product_id=<%= pd.get(i).getId() %>"><img src="<%= pd.get(i).getImg() %>"></a></td>
                    <td><a href="item?product_id=<%= pd.get(i).getId() %>"><%= pd.get(i).getName() %></a></td>
                    <td><%= pd.get(i).getPrice() %>円</td>
                </tr>
                <% } %>
            </table>
                <%= jh.top() %>
        </main><br>
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
