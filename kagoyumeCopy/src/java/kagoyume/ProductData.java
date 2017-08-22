/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

/**
 *  商品情報を格納、持ち回るためのJaveBeans
 * @author takahirokanno
 */
public class ProductData {
    private String name = "";
    private String id = "";
    private String description = "";
    private String price = "";
    private String img = "";
    private String imgEx = "";
    
    //商品名のget,set
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    //商品idのget,set
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    
    //商品説明のget,set
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    
    //商品価格のget,set
    public String getPrice(){
        return price;
    }
    public void setPrice(String price){
        this.price = price;
    }
    
    //商品画像のget,set
    public String getImg(){
        return img;
    }
    public void setImg(String img){
        this.img = img;
    }
    
    //商品画像(large)のget,set
    public String getImgEx(){
        return imgEx;
    }
    public void setImgEx(String imgEx){
        this.imgEx = imgEx;
    }
}
