package kagoyume;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *  画面表示でのユーザー情報を持ち回るためのJavaBeans
 *  入力チェックのメソッドも
 *  DTOへのマッピングも
 * @author takahirokanno
 */
public class UserData implements Serializable {
    
    private String name;
    private String password;
    private String mail;
    private String address;
    
    
    public UserData(){
        this.name = "";
        this.password = "";
        this.mail = "";
        this.address = "";
    }
    
    
    //名前のget,set
    public String getName(){
        return name;
    }
    public void setName(String name){
        //未入力は空文字をセット
        if(name.trim().length() == 0){
            this.name = "";
        }else{
            this.name = name;
        }
    }
    
    
    //パスワードのget,set
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        if(password.trim().length() == 0){
            this.password = "";
        }else{
            this.password = password;
        }
    }
    
    
    //メールアドレスのget.set
    public String getMail(){
        return mail;
    }
    public void setMail(String mail){
        if(mail.trim().length() == 0){
            this.mail = "";
        }else{
            this.mail = mail;
        }
    }
    
    
    //住所のget,set
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        if(address.trim().length() == 0){
            this.address = "";
        }else{
            this.address = address;
        }
    }
    
    
    //入力チェックメソッド
    public ArrayList<String> chkpro(){
        ArrayList<String> chkList = new ArrayList<>();
        
        if(this.name.equals("")){
            chkList.add("name");
        }
        if(this.password.equals("")){
            chkList.add("password");
        }
        if(this.mail.equals("")){
            chkList.add("mail");
        }
        if(this.address.equals("")){
            chkList.add("address");
        }
        
        return chkList;
    }
    
    
    //DTOにマッピング
    public void UD2DTOMapping(UserDataDTO udd){
        udd.setName(this.name);
        udd.setPassword(this.password);
        udd.setMail(this.mail);
        udd.setAddress(this.address);
    }
}
