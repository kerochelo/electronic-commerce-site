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
%>

<%-- 
    Document   : buyconfirm
    Created on : 2017/08/22, 1:11:52
    Author     : takahirokanno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>商品購入確認 | かご夢</title>
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
            <table border="1" bordercolor="#333" cellpadding="10" cellspacing="5">
                <tr>
                    <th>商品名</th>
                    <th>価格</th>
                </tr>
                <% for(int i = 0; i < pd.size(); i++){%>
                <tr>
                    <td><%= pd.get(i).getName() %></td>
                    <td><%= pd.get(i).getPrice() %></td>
                </tr>
                <% cartTotal += Integer.parseInt(pd.get(i).getPrice()); %>
                <%}%>
            </table>
            合計金額:<%= cartTotal %>円
            <form action="buycomplete" method="post">
                発送方法:<br>
                ゆうパック:<input type="radio" name="radiotype" value="1" checked="checked">
                宅急便:<input type="radio" name="radiotype" value="2">
                <input type="hidden" name="total" value="<%= cartTotal %>">
                <br>
                <input type="hidden" name="ac" value="<%= session.getAttribute("ac") %>">
                <input type="submit" name="btn" value="購入する">
            </form>
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
