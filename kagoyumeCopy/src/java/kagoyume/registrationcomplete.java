package kagoyume;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;
/**
 *  registrationcomplete.jspに対応するservlet
 *  session経由でユーザー情報の値を受け取りDBに登録
 * @author takahirokanno
 */
public class registrationcomplete extends HttpServlet {

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
        
        //セッションスタート
        HttpSession session = request.getSession();
        
        try{
            //文字コードをセット
            request.setCharacterEncoding("UTF-8");
            
            //不正アクセスチェック
            String acschk = request.getParameter("ac");
            if(acschk.equals("null") || (Integer)session.getAttribute("ac") != Integer.parseInt(acschk)){
                throw new Exception("不正なアクセスです");
            }
            
            //DBに挿入処理
            UserData ud = (UserData)session.getAttribute("ud");
            
            //mapping DB専用に変換
            UserDataDTO userdata = new UserDataDTO();
            ud.UD2DTOMapping(userdata);
            
            //DBに挿入
            UserDataDAO.getInstance().register(userdata);
            
            //挿入完了したためセッションの値削除
            session.removeAttribute("ac");
            
            //結果画面表示用にリクエストスコープに登録
            request.setAttribute("ud", ud);
            
            request.getRequestDispatcher("/registrationcomplete.jsp").forward(request, response);
        }
        catch(Exception e){
            //不正アクセスorDBでのエラー
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
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
