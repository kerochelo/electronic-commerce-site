package kagoyume;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
/**
 *  add.jspに対応するservlet
 * @author takahirokanno
 */
public class add extends HttpServlet {

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
//        request.setCharacterEncoding("UTF-8");
//        String proID = request.getParameter("pro");
        
        //ここでログアウト状態ならログイン画面へ
        if(session.getAttribute("login") == null){
            session.setAttribute("noadd", "先にログインしてください");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }else{
            //ログイン状態なら買い物かごに商品を入れて、add.jspへ
            ArrayList<ProductData> cartList = (ArrayList<ProductData>)session.getAttribute("cartList");

            //買い物かごに初めて商品を入れる場合
            if(cartList == null){
                cartList = new ArrayList<>();
            }
            
            //商品情報を買い物かご用リストに追加
            cartList.add((ProductData)session.getAttribute("detailData"));
            session.setAttribute("cartList", cartList);
            
            
            request.getRequestDispatcher("/add.jsp").forward(request, response);
            
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
