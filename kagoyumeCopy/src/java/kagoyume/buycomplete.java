package kagoyume;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *  buycomplete.jspに対応するservlet
 * @author takahirokanno
 */
public class buycomplete extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        try{
            //不正アクセスチェック
            request.setCharacterEncoding("UTF-8");
            String acschk = request.getParameter("ac");
            if(acschk.equals("null") || (Integer)session.getAttribute("ac") != Integer.parseInt(acschk)){
                throw new Exception("不正アクセスです");
            }
            
            //ラジオボタンの値取得(選択されていない場合はデフォルトでゆうパック)
            String radioType = request.getParameter("radiotype");
            
            //userIDはユーザーのログイン情報から取得
            UserDataDTO udd = (UserDataDTO)session.getAttribute("welcomeUDD");
            int id = udd.getUserID();
            
            //total(総購入金額も更新するために取得)
            int total = udd.getTotal();
            
            //買い物かご(ArrayList)から商品情報を１つずつ取り出しBuyDataに格納、マッピング後にDB挿入
            ArrayList<ProductData> cartList = (ArrayList<ProductData>)session.getAttribute("cartList");
            for (ProductData pro : cartList) {
                BuyData bd = new BuyData();
                bd.setUserID(id);
                bd.setItemCode(pro.getId());
                bd.setType(Integer.parseInt(radioType));
                
                //DTOにマッピング
                BuyDataDTO bdd = new BuyDataDTO();
                bd.BD2DTOMapping(bdd);
                
                //DBに挿入
                BuyDataDAO.getInstance().insertPro(bdd);
            }
            
            //合計の購入金額も合わせてDBに挿入
            int cartTotal = Integer.parseInt(request.getParameter("total"));
            total += cartTotal;
            udd.setTotal(total);
            UserDataDAO.getInstance().totalUp(udd);
            
            //アクセス用とcartList用のセッション破棄
            session.removeAttribute("ac");
            session.removeAttribute("cartList");
            
            request.getRequestDispatcher("/buycomplete.jsp").forward(request, response);
            
        }
        catch(Exception e){
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
