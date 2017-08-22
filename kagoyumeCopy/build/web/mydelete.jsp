<%@page import="kagoyume.JumsHelper"
        import="kagoyume.UserDataDTO"
        import="javax.servlet.http.HttpSession"
%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataDTO udd = (UserDataDTO)hs.getAttribute("welcomeUDD");
    String name = udd.getName();
    String mail = udd.getMail();
    String address = udd.getAddress();
%>


<%-- 
    Document   : mydelete
    Created on : 2017/08/21, 16:39:53
    Author     : takahirokanno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript">
            function check(){
                if(confirm("本当に削除しますか？"))
                    {return true;}
                else
                    {return false;}
            }
        </script>
        <title>会員情報削除確認 | かご夢</title>
    </head>
    <body>
        <h3>このユーザー情報を削除しますか?</h3>
        ユーザー名:<br>
        <%= name %><br><br>
        メールアドレス:<br>
        <%= mail %><br><br>
        住所:<br>
        <%= address %><br><br>
        <form action="mydeleteresult" method="post" onsubmit="return check()">
            <input type="hidden" name="ac" value="<%= hs.getAttribute("ac") %>">
            <input type="submit" name="yesbtn" value="削除する">
        </form>
            <br>
        <form action="mydata" method="post">
            <input type="submit" name="nobtn" value="前ページに戻る">
        </form>
    </body>
</html>
