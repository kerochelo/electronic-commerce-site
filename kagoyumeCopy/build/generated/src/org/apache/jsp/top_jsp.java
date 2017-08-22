package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import kagoyume.JumsHelper;
import javax.servlet.http.HttpSession;
import kagoyume.UserDataDTO;

public final class top_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');

    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    String name = "";
    //ログイン状態変数 + 処理
    boolean log = false;
    if(hs.getAttribute("login") != null){
        log = true;
        //名前表示のためにセッションから取り出す
        UserDataDTO udd = (UserDataDTO)hs.getAttribute("welcomeUDD");
        name = udd.getName();
    }
    //検索結果変数 + 処理
    boolean research = false;
    if(hs.getAttribute("research") != null){
        research = true;
    }
    //login後のページ移行のために情報をセッションに格納
    hs.setAttribute("page", "top");


      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>かご夢</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("            <div class=\"logo\">\n");
      out.write("                <strong>かご夢</strong>\n");
      out.write("            </div>\n");
      out.write("            <hr>\n");
      out.write("            ");
 //ログイン,アウト表示分岐
               if(!log){     
            
      out.write("\n");
      out.write("                ");
      out.print( jh.login() );
      out.write(" \n");
      out.write("            ");
 }else{ 
      out.write("\n");
      out.write("                ");
      out.print( jh.logout(name) );
      out.write("\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("        </header>\n");
      out.write("        <br>\n");
      out.write("        <main>\n");
      out.write("            ");
 if(research){ 
      out.write("\n");
      out.write("            検索内容と一致する結果がありませんでした。<br>\n");
      out.write("            ");
 }
                hs.setAttribute("research", null);
            
      out.write("\n");
      out.write("            <form action=\"search\" method=\"get\">\n");
      out.write("                <p>検索フォーム</p>\n");
      out.write("                <input type=\"text\" name=\"search\" placeholder=\"例) 世界平和\">\n");
      out.write("                <input type=\"submit\" name=\"btn\">\n");
      out.write("            </form>\n");
      out.write("        </main>\n");
      out.write("        <br>\n");
      out.write("        <footer>\n");
      out.write("            <hr>\n");
      out.write("            <ul>\n");
      out.write("                <li>利用規約</li>\n");
      out.write("                <li>会社概要</li>\n");
      out.write("                <li>about this site</li>\n");
      out.write("            </ul>\n");
      out.write("        </footer>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
