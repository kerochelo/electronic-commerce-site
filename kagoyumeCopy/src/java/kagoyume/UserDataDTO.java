package kagoyume;

import java.sql.Timestamp;

/**
 *  ユーザー情報を持ち回すJavaBeans
 *  DBのカラム、型に対応
 * @author takahirokanno
 */
public class UserDataDTO {
    
    private int userID;
    private String name;
    private String password;
    private String mail;
    private String address;
    private int total;
    private Timestamp newDate;
    
    //idのget,set
    public int getUserID(){
        return userID;
    }
    public void setUserID(int userID){
        this.userID = userID;
    }
    
    //ユーザー名のget,set
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    //パスワードのget,set
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    
    //メールアドレスのget,set
    public String getMail(){
        return mail;
    }
    public void setMail(String mail){
        this.mail = mail;
    }
    
    //住所のget,set
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }
    
    //totalのget,set
    public int getTotal(){
        return total;
    }
    public void setTotal(int total){
        this.total = total;
    }
    
    //登録、更新時間のget,set
    public Timestamp getNewDate(){
        return newDate;
    }
    public void setNewDate(Timestamp newDate){
        this.newDate = newDate;
    }
    
}
