package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.http.HttpSession;
import kagoyume.JumsHelper;
import kagoyume.UserData;

public final class registration_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write('\n');

    HttpSession hs = request.getSession();
    JumsHelper jh = JumsHelper.getInstance();
    UserData ud = null;
    boolean reinput = false;
    if(request.getParameter("mode") != null && request.getParameter("mode").equals("reinput")){
        reinput = true;
        ud = (UserData)hs.getAttribute("ud");
    }

      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>新規登録 | かご夢</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h2>新規登録フォーム</h2><br>\n");
      out.write("        <hr>\n");
      out.write("        <form action=\"registrationconfirm\" method=\"post\">\n");
      out.write("            ユーザー名<br>\n");
      out.write("            <input type=\"text\" name=\"name\" size=\"20\" value=\"");
 if(reinput){out.print(ud.getName());} 
      out.write("\"><br><br>\n");
      out.write("            パスワード<br>\n");
      out.write("            <input type=\"password\" name=\"password\" size=\"20\"><br><br>\n");
      out.write("            メールアドレス<br>\n");
      out.write("            <input type=\"email\" name=\"mail\" size=\"30\" value=\"");
 if(reinput){out.print(ud.getMail());} 
      out.write("\"><br><br>\n");
      out.write("            住所<br>\n");
      out.write("            <input type=\"text\" name=\"address\" size=\"50\" value=\"");
 if(reinput){out.print(ud.getAddress());} 
      out.write("\"><br><br>\n");
      out.write("            <input type=\"hidden\" name=\"ac\" value=\"");
      out.print( hs.getAttribute("ac") );
      out.write("\">\n");
      out.write("            <input type=\"submit\" name=\"btn\" value=\"確認画面へ\">\n");
      out.write("        </form><br>\n");
      out.write("        <hr>\n");
      out.write("        ");
      out.print( jh.top() );
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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
