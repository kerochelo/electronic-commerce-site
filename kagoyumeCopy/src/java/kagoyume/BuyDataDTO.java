package kagoyume;

import java.sql.Timestamp;
/**
 *  商品情報をもちまわすJavaBeans
 *  DBの型、カラムに対応
 * @author takahirokanno
 */
public class BuyDataDTO {
    
    private int buyID;
    private int userID;
    private String itemCode;
    private int type;
    private Timestamp buyDate;
    
    //それぞれのget,set
    public int getbuyID(){
        return buyID;
    }
    public void setBuyID(int buyID){
        this.buyID = buyID;
    }
    
    public int getUserID(){
        return userID;
    }
    public void setUserID(int userID){
        this.userID = userID;
    }
    
    public String getItemCode(){
        return itemCode;
    }
    public void setItemCode(String itemCode){
        this.itemCode = itemCode;
    }
    
    public int getType(){
        return type;
    }
    public void setType(int type){
        this.type = type;
    }
    
    public Timestamp getBuyDate(){
        return buyDate;
    }
    public void setBuyDate(Timestamp buyDate){
        this.buyDate = buyDate;
    }
    
}
