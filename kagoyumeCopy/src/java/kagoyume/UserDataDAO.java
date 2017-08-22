package kagoyume;

import base.DBManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *  ユーザー情報をDBのテーブルへ処理を全て行う
 *  DB接続はDBManagerクラスで
 *  行う処理１つに対して１つのメソッド
 * @author takahirokanno
 */
public class UserDataDAO {
    
    //インスタンスの生成
    public static UserDataDAO getInstance(){
        return new UserDataDAO();
    }
    
    /*
        データの挿入処理
    */
    
    //DBに新規登録
    public void register(UserDataDTO udd) throws SQLException{
        
        Connection con = null;
        PreparedStatement st;
        
        try{
            con = DBManager.getConnection();
            st = con.prepareStatement("INSERT INTO user_t(name, password, mail, address, newDate) VALUES(?, ?, ?, ?, ?)");
            st.setString(1, udd.getName());
            st.setString(2, udd.getPassword());
            st.setString(3, udd.getMail());
            st.setString(4, udd.getAddress());
            st.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
            System.out.println("register completed");
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
    
    //ログインのためのDBからユーザー情報検索処理
    public UserDataDTO search(UserDataDTO udd) throws SQLException{
        Connection con = null;
        PreparedStatement st;
        ResultSet rs;
        
        try{
            con = DBManager.getConnection();
            st = con.prepareStatement("SELECT * FROM user_t WHERE name = ? AND password = ? AND deleteFlg = ?");
            st.setString(1, udd.getName());
            st.setString(2, udd.getPassword());
            st.setInt(3, 0);
            
            rs = st.executeQuery();
            System.out.println("search completed");
            
            UserDataDTO reudd = new UserDataDTO();
            
            //情報があればUserDataDTOに情報を入れて返す
            if(rs.next()){
                reudd.setUserID(rs.getInt("userID"));
                reudd.setName(rs.getString("name"));
                reudd.setPassword(rs.getString("password"));
                reudd.setMail(rs.getString("mail"));
                reudd.setAddress(rs.getString("address"));
                reudd.setTotal(rs.getInt("total"));
                reudd.setNewDate(rs.getTimestamp("newDate"));
            }
            else{
                reudd = null;
            }
            return reudd;
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
    
    
    //ユーザー情報更新のDB操作処理
    public void update(UserDataDTO udd) throws SQLException{
        Connection con = null;
        PreparedStatement st;
        
        try{
            con = DBManager.getConnection();
            st = con.prepareStatement("UPDATE user_t SET name = ?, password = ?, mail = ?, address = ?, newDate = ? WHERE userID = ?");
            st.setString(1, udd.getName());
            st.setString(2, udd.getPassword());
            st.setString(3, udd.getMail());
            st.setString(4, udd.getAddress());
            st.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            st.setInt(6, udd.getUserID());
            st.executeUpdate();
            System.out.println("update completed");
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
    
    
    //ユーザー情報削除処理(deleteFlgを1にする)
    public void delete(int userid) throws SQLException{
        Connection con = null;
        PreparedStatement st;
        
        try{
            con = DBManager.getConnection();
            st = con.prepareStatement("UPDATE user_t SET deleteFlg = ? WHERE userID = ?");
            st.setInt(1, 1);
            st.setInt(2, userid);
            st.executeUpdate();
            System.out.println("delete completed");
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
    
    //商品購入に伴い、totalの値を更新
    public void totalUp(UserDataDTO udd) throws SQLException{
        Connection con = null;
        PreparedStatement st;
        
        try{
            con = DBManager.getConnection();
            st = con.prepareStatement("UPDATE user_t SET total = ? WHERE userID = ?");
            st.setInt(1, udd.getTotal());
            st.setInt(2, udd.getUserID());
            st.executeUpdate();
            System.out.println("update total completed");
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
