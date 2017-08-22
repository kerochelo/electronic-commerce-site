<%@page import="kagoyume.JumsHelper"
        import="kagoyume.UserDataDTO"
        import="kagoyume.ProductData"
        import="javax.servlet.http.HttpSession"
        import="java.util.ArrayList"
%>

<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    ArrayList<ProductData> pd = (ArrayList<ProductData>)hs.getAttribute("cartList");
    String name = "";
    int cartTotal = 0;
    //ログイン状態処理(add.jspと同じく、ログイン状態のはずだが)
    boolean log = false;
    if(hs.getAttribute("login") != null){
        log = true;
        //名前表示のためにセッションから取り出す
        UserDataDTO udd = (UserDataDTO)hs.getAttribute("welcomeUDD");
        name = udd.getName();
    }
    //login後のページ移行のために情報をセッションに格納
    hs.setAttribute("page", "cart");
%>
<%-- 
    Document   : cart
    Created on : 2017/08/22, 0:15:38
    Author     : takahirokanno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>買い物かご | かご夢</title>
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
            <h3>買い物かご</h3>
            <% if(pd.size() != 0){%>
                <table border="1" bordercolor="#333" cellpadding="10" cellspacing="5">
                    <tr>
                        <th>サムネイル</th>
                        <th>商品名</th>
                        <th>価格(円)</th>
                        <th>詳細</th>
                    </tr>
                    <% for(int i = 0; i < pd.size(); i++){%>
                    <tr>
                        <td><a href="item?product_id=<%= pd.get(i).getId() %>"><img src="<%= pd.get(i).getImg() %>"></a></td>
                        <td><a href="item?product_id=<%= pd.get(i).getId() %>"><%= pd.get(i).getName() %></a></td>
                        <td><%= pd.get(i).getPrice() %>円</td>
                        <td>
                            <form action="cartdelete" method="post">
                                <input type="hidden" name="num" value="<%= i %>">
                                <input type="submit" name="btn" value="削除する">
                            </form>
                        </td>
                    </tr>
                    <% cartTotal += Integer.parseInt(pd.get(i).getPrice()); %>
                    <% } %>
                </table>
                <br>
                <p>合計金額<%= cartTotal %>円</p>
                <form action="buyconfirm" method="post">
                    <input type="submit" value="購入する">
                </form>
            <%}else{%>
            <h3>商品がはいっておりません</h3>
            <%}%>
            <br><br>
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
