package kagoyume;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

/**
 *  myupdateresult.jspに対応するservlet
 * @author takahirokanno
 */
public class myupdateresult extends HttpServlet {

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
            //paramsの文字コード指定 + hiddenの値を取得
            request.setCharacterEncoding("UTF-8");
            String acschk = request.getParameter("ac");
            //不正アクセスチェック
            if(acschk.equals("null") || (Integer)session.getAttribute("ac") != Integer.parseInt(acschk)){
                throw new Exception("不正アクセスチェック");
            }
            
            //UserDataに格納
            UserData ud = new UserData();
            ud.setName(request.getParameter("name"));
            ud.setPassword(request.getParameter("password"));
            ud.setMail(request.getParameter("mail"));
            ud.setAddress(request.getParameter("address"));
            
            //DB用にマッピング
            UserDataDTO udd = new UserDataDTO();
            ud.UD2DTOMapping(udd);
            
            //userIDをwelcomeUDDから取ってくる
            UserDataDTO uddid = (UserDataDTO)session.getAttribute("welcomeUDD");
            udd.setUserID(uddid.getUserID());
            
            //ユーザー情報更新
            UserDataDAO.getInstance().update(udd);
            
            //mydata.jspの情報を更新
            session.removeAttribute("welcomeUDD");
            session.setAttribute("welcomeUDD", udd);
            
            //アクセスセッションクリア
            session.removeAttribute("ac");
            
            //結果画面用にudをリクエストスコープに登録 + ページ移行
            request.setAttribute("ud", ud);
            request.getRequestDispatcher("/myupdateresult.jsp").forward(request, response);
            
        }
        catch(Exception e){
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
