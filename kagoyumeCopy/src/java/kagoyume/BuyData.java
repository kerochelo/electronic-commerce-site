package kagoyume;

import java.io.Serializable;
import java.util.ArrayList;
/**
 *  画面表示で商品情報を持ち回るためのJavaBeans
 *  DTOへのマッピングもここに記述
 * @author takahirokanno
 */
public class BuyData implements Serializable {
    
    private int userID;
    private String itemCode;
    private int type;
    
    
    //userIDのget,set
    public int getUserID(){
        return userID;
    }
    public void setUserID(int userID){
        this.userID = userID;
    }
    
    //itemCodeのget.set
    public String getItemCode(){
        return itemCode;
    }
    public void setItemCode(String itemCode){
        this.itemCode = itemCode;
    }
        
    //typeのget,set
    public int getType(){
        return type;
    }
    public void setType(int type){
        this.type = type;
    }
     
    
    //BuyDataDTOにマッピング
    public void BD2DTOMapping(BuyDataDTO bdd){
        bdd.setUserID(this.userID);
        bdd.setItemCode(this.itemCode);
        bdd.setType(this.type);
    }
}