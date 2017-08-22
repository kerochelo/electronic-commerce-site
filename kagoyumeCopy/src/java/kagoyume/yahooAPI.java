package kagoyume;

import java.net.URL;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.util.ArrayList;


/**
 *  API関係の処理をまとめたクラス
 *  必要な情報はHitの以下の階層にあるため,Hitの内容処理と商品キーワード検索処理,コード検索処理などに分けてメソッド化
 *  商品検索,商品コード検索両方とも同じメソッドで対応
 * @author takahirokanno
 */
public class yahooAPI {
    
    
    //yahooAPIのID
    final String APPID = "dj00aiZpPUp4a1JYM3NZRnZuaSZzPWNvbnN1bWVyc2VjcmV0Jng9MTk-";
    
    //商品検索のurl
    final String searchURL = "http://shopping.yahooapis.jp/ShoppingWebService/V1/itemSearch";
    
    //商品コード検索のurl
    final String codeURL = "https://shopping.yahooapis.jp/ShoppingWebService/V1/itemLookup";
    
    //インスタンス生成
    public static yahooAPI getInstance(){
        return new yahooAPI();
    }
    
    
    
    //外部へのurlからxmlのdocumentを取得
    public Document returnDocument(URL url) throws Exception{
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setDoOutput(true);  //post可能
        con.connect();  //接続
        
        //ファイル読み込み準備~取得
        InputStream is = con.getInputStream();
        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = db.parse(is);    //読み込んで情報ページのdocument取得
        is.close();
        
        return doc;
    }
    
    
    //xmlのHit以下の処理を一括り(商品用JavaBeansであるProductDataを使用)
    public ProductData takeHit(Node hit){
        ProductData product = new ProductData();
        NodeList hitList = hit.getChildNodes();     //Hitの子ノード全て

        for(int i = 0; i < hitList.getLength(); i++){

            //Hitの子ノードを取得 + 必要な情報をProductDataにセット
            Node hitChild = hitList.item(i);

            if(hitChild.getNodeName().equals("Name")){
               product.setName(hitChild.getTextContent());
            }

            if(hitChild.getNodeName().equals("Code")){
                product.setId(hitChild.getTextContent());
            }

            if(hitChild.getNodeName().equals("Description")){
                product.setDescription(hitChild.getTextContent());
            }

            if(hitChild.getNodeName().equals("Image")){

                //imageのノードを取得
                Node img = hitList.item(i);
                NodeList imageList = img.getChildNodes();

                for(int j = 0; j < imageList.getLength(); j++){
                    //Imageの子ノードを取得
                    Node imgChild = imageList.item(j);

                    if(imgChild.getNodeName().equals("Medium")){
                        product.setImg(imgChild.getTextContent());
                    }
                }
            }

            if(hitChild.getNodeName().equals("ExImage")){
                //ExImageのノードを取得
                Node img = hitList.item(i);
                NodeList imageList = img.getChildNodes();
                
                for(int j = 0; j < imageList.getLength(); j++){
                    //子ノード取得
                    Node imgChild = imageList.item(j);
                    
                    if(imgChild.getNodeName().equals("Url")){
                        product.setImgEx(imgChild.getTextContent());
                    }
                }
            }
            
            
            if(hitChild.getNodeName().equals("Price")){
                product.setPrice(hitChild.getTextContent());
            }
        }
        return product;
    }
    
    
    //xmlから商品の情報(Hitの階層)を取得(商品検索用)
    public ArrayList<ProductData> resultPro(Document doc){
        
        ArrayList<ProductData> pd = new ArrayList<>();
        
        Node nd = doc.getFirstChild().getFirstChild();  //ResultSet直下のResultを取得
        
        NodeList nl = nd.getChildNodes();   //Hitがある階層
        
        //商品情報があるHitのタグ内の情報を取得(2番目からHit)
        for(int i = 0; i < nl.getLength(); i++){
            
            //Hitを取得
            Node resultChild = nl.item(i);
            
            //resultChildがHitなら必要な情報だけをProductData(商品用JaveBeans)に格納し,ArrayListに追加
            if(resultChild.getNodeName().equals("Hit")){
                ProductData p = takeHit(resultChild);   //ProductDataに格納
                pd.add(p);  //ArrayListに追加
            }
        }
        return pd;
    }
        
    
    //キーワード検索処理
    public ArrayList<ProductData> searchResult(String key) throws Exception{ 
            //引数でもらったキーワードを%コードに変換
            String key_en = URLEncoder.encode(key, "UTF-8");
            
            //キーワード検索のurl準備
            URL url = new URL(searchURL + "?appid=" + APPID + "&query=" + key_en);
            
            //上記のメソッドを使いdocumentを取得 + その商品の情報を取得
            Document doc = returnDocument(url);
            ArrayList<ProductData> pd = resultPro(doc);
            
            return pd;
    }
    
    //商品詳細の情報の取得処理
    public ArrayList<ProductData> searchRecord(String code){
        try{
            //コード検索url
            URL url = new URL(codeURL + "?appid=" + APPID + "&itemcode=" + code + "&responsegroup=medium"+ "&image_size=300");

            Document doc = returnDocument(url);
            ArrayList<ProductData> rd = resultPro(doc);
            
            return rd;
        }catch(Exception e){
            return null;
        }
    }
    
}
