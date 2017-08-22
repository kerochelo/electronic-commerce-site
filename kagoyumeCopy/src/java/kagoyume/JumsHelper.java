package kagoyume;

import java.util.ArrayList;
/**
 * 画面の表示、処理などのhelper
 * 画面遷移のメソッドも
 * @author takahirokanno
 */
public class JumsHelper {
    
    //topページurl
    private final String topURL = "top.jsp";
    
    //searchページurl
    private final String searchURL = "search.jsp";
    
    //itemページurl
    private final String itemURL = "item.jsp";    
    
    //mydataページurl
    private final String mydataURL = "mydata.jsp";
    
    
    //インスタンス生成
    public static JumsHelper getInstance(){
        return new JumsHelper();
    }
    
    
    //トップページリンク
    public String top(){
        return "<a href=\"" + topURL + "\">トップ画面へ</a>";
    }
    
    //検索結果ページリンク
    public String search(){
        return "<a href=\"" + searchURL + "\">検索結果画面へ</a>";
    }
    
    //商品詳細画面ページリンク
    public String item(){
        return "<a href=\"" + itemURL + "\">商品詳細画面へ</a>";
    }
    
    //ユーザー情報ページリンク
    public String mydata(){
        return "<a href=\"" + mydataURL + "\">ユーザー情報画面へ</a>";
    }
    
    //ログイン表示
    public String login(){
        String in = "ようこそ'ゲスト'さん\n" +
                    "<form action=\"login\" method=\"post\">\n" +
                    "  <input type=\"submit\" name=\"btn\" value=\"ログイン\">\n" +
                    "</form>";
        return in;
    }
    
    //ユーザー名 + ログアウト + 買い物かご表示　　
    public String logout(String name){
        String out = "ようこそ<a href=\"mydata\">" + name +
                     "</a>さん\n" +
                     "<form action=\"cart\" method=\"post\">\n" +
                     "<input type=\"submit\" name=\"btn\" value=\"買い物かご\">\n" +
                     "</form>" +
                     "<form action=\"login\" method=\"post\">\n" +
                     "<input type=\"submit\" name=\"btn\" value=\"ログアウト\">\n" +
                     "</form>";
        return out;
    }
    
    
    /*
        引数(chkList) フォーム未入力の項目を表示する
        UserDataで生成されるchkListに従う
    */
    public String chkin(ArrayList<String> chkList){
        String output = "";
        
        for(String v : chkList){
            if(v.equals("name")){
                output += "ユーザー名";
            }
            if(v.equals("password")){
                output += "パスワード";
            }
            if(v.equals("mail")){
                output += "メールアドレス";
            }
            if(v.equals("address")){
                output += "住所";
            }
            output += " の項目に不備があります<br>";
        }
        return output;
    }
    
}
