package kagoyume;

import base.DBManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *  商品情報のDB処理を全て行う
 *  DB接続はDBManagerクラスで
 *  処理１つに対して１つのメソッド
 * @author takahirokanno
 */
public class BuyDataDAO {
    
    //インスタンス生成
    public static BuyDataDAO getInstance(){
        return new BuyDataDAO();
    }
    
    //商品情報の挿入処理
    public void insertPro(BuyDataDTO bdd) throws SQLException{
        Connection con = null;
        PreparedStatement st;
        
        try{
            con = DBManager.getConnection();
            st = con.prepareStatement("INSERT INTO buy_t(userID, itemCode, type, buyDate) VALUES(?, ?, ?, ?)");
            st.setInt(1, bdd.getUserID());
            st.setString(2, bdd.getItemCode());
            st.setInt(3, bdd.getType());
            st.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
            System.out.println("insert completed");
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }
        finally{
            if(con != null){
                con.close();
            }
        }
    }
    
    //購入履歴のための処理
    public ArrayList<BuyDataDTO> searchHistory(int id) throws SQLException{
        Connection con = null;
        PreparedStatement st;
        ResultSet rs;
        
        ArrayList<BuyDataDTO> buyList = new ArrayList<>();
        
        try{
            con = DBManager.getConnection();
            st = con.prepareStatement("SELECT * FROM buy_t WHERE userID = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            System.out.println("search buy completed");
            
            while(rs.next()){
                BuyDataDTO bdd = new BuyDataDTO();
                bdd.setBuyID(rs.getInt(1));
                bdd.setUserID(rs.getInt(2));
                bdd.setItemCode(rs.getString(3));
                bdd.setType(rs.getInt(4));
                bdd.setBuyDate(rs.getTimestamp(5));
                buyList.add(bdd);
            }
            return buyList;
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }
        finally{
            if(con != null){
                con.close();
            }
        }
    }
    
}
