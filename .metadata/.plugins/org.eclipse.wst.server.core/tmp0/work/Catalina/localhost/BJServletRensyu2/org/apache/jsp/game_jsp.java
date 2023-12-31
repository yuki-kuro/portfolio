/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.73
 * Generated at: 2023-06-27 02:58:54 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import servlet.BlackjackServlet;

public final class game_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("servlet.BlackjackServlet");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPではGET、POST、またはHEADのみが許可されます。 JasperはOPTIONSも許可しています。");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"ja\">\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("\n");
      out.write("<title>ブラックジャック</title>\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"卒業制作/css/kyoutuu.css\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/blackjack.css\">\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"\n");
      out.write("	integrity=\"sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=\"\n");
      out.write("	crossorigin=\"anonymous\"></script>\n");
      out.write("<script src=\"js/hamb.js\"></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("	<div class=\"content\">\n");
      out.write("		<button type=\"button\" class=\"btn js-btn\">\n");
      out.write("			<span class=\"btn-line\"></span>\n");
      out.write("		</button>\n");
      out.write("		<nav>\n");
      out.write("			<ul class=\"menu\">\n");
      out.write("				<li class=\"menu-list\"\n");
      out.write("					onclick=\"window.location.href='卒業制作/index.html'\">TOP</li>\n");
      out.write("				<li class=\"menu-list\"\n");
      out.write("					onclick=\"window.location.href='http://localhost:8080/JankenServletGame/JankenServlet'\">制作物1</li>\n");
      out.write("				<li class=\"menu-list\"\n");
      out.write("					onclick=\"window.location.href='http://localhost:8080/BJServletRensyu2/BlackjackServlet'\">制作物2</li>\n");
      out.write("				<li class=\"menu-list\"\n");
      out.write("					onclick=\"window.location.href='http://localhost:8080/TypingGame/TypingGameServlet'\">制作物3</li>\n");
      out.write("				<li class=\"menu-list\"\n");
      out.write("					onclick=\"window.location.href='卒業制作/furikaeri.html'\">訓練振り返り</li>\n");
      out.write("			</ul>\n");
      out.write("		</nav>\n");
      out.write("		<div class=\"wrapper\">\n");
      out.write("			<br> <br>\n");
      out.write("			<h1 class=\"gametitle\">ブラックジャック</h1>\n");
      out.write("			<br>\n");
      out.write("			<div class=\"gamebody\">\n");
      out.write("				<p>\n");
      out.write("					<strong>あなた :</strong>\n");
      out.write("					");
if((int)request.getSession().getAttribute("playerPoint")>21) {
      out.write("\n");
      out.write("					バースト\n");
      out.write("					");
}else if((int)request.getSession().getAttribute("playerPoint")==21){ 
      out.write("\n");
      out.write("					ブラックジャック!\n");
      out.write("					");
}else{ 
      out.write("\n");
      out.write("					");
      out.print( session.getAttribute("playerPoint"));
      out.write("点\n");
      out.write("					");
} 
      out.write("\n");
      out.write("				</p>\n");
      out.write("				<table border=\"1\"  class=\"myTable\">\n");
      out.write("					");
 
        List<Integer> player = (List<Integer>) request.getSession().getAttribute("player");
        
    
      out.write("\n");
      out.write("					<tr>\n");
      out.write("						");
for (int i =0;i<player.size();i++) { 
      out.write("\n");
      out.write("						<td>");
      out.print(i+1 );
      out.write("枚目</td>\n");
      out.write("\n");
      out.write("						");
} 
      out.write("\n");
      out.write("					</tr>\n");
      out.write("					<tr>\n");
      out.write("						");
for (int i =0;i<player.size();i++) { 
      out.write("\n");
      out.write("\n");
      out.write("						<td>");
      out.print( servlet.BlackjackServlet.toCardString(player.get(i)));
      out.write("</td>\n");
      out.write("						");
} 
      out.write("\n");
      out.write("					</tr>\n");
      out.write("\n");
      out.write("				</table>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("				");
 String result = (String) request.getAttribute("result");
       if (result != null) { 
      out.write("\n");
      out.write("				<p>\n");
      out.write("					<strong>PC :</strong>\n");
      out.write("					");
if((int)request.getSession().getAttribute("dealerPoint")>21) {
      out.write("\n");
      out.write("					バースト\n");
      out.write("					");
}else if((int)request.getSession().getAttribute("dealerPoint")==21){ 
      out.write("\n");
      out.write("					ブラックジャック!\n");
      out.write("					");
}else{ 
      out.write("\n");
      out.write("					");
      out.print( session.getAttribute("dealerPoint"));
      out.write("点\n");
      out.write("					");
} 
      out.write("\n");
      out.write("				</p>\n");
      out.write("\n");
      out.write("				<table border=\"1\" class=\"myTable\">\n");
      out.write("					");
 
        List<Integer> dealer = (List<Integer>) request.getSession().getAttribute("dealer");
        
    
      out.write("\n");
      out.write("					<tr>\n");
      out.write("						");
for (int i =0;i<dealer.size();i++) { 
      out.write("\n");
      out.write("						<td>");
      out.print(i+1 );
      out.write("枚目</td>\n");
      out.write("\n");
      out.write("						");
} 
      out.write("\n");
      out.write("					</tr>\n");
      out.write("					<tr>\n");
      out.write("						");
for (int i =0;i<dealer.size();i++) { 
      out.write("\n");
      out.write("						<td>");
      out.print(servlet.BlackjackServlet.toCardString(dealer.get(i)) );
      out.write("</td>\n");
      out.write("						");
} 
      out.write("\n");
      out.write("					</tr>\n");
      out.write("				</table>\n");
      out.write("\n");
      out.write("				<br><h2>\n");
      out.write("					結果:\n");
      out.write("					");
      out.print( result );
      out.write("</h2>\n");
      out.write("\n");
      out.write("				<form action=\"/BJServletRensyu2/BlackjackServlet\" method=\"post\">\n");
      out.write("					<input type=\"hidden\" name=\"action\" value=\"reset\"> <input\n");
      out.write("						type=\"submit\" value=\"初めから\" class=\"hajimekara\">\n");
      out.write("				</form>\n");
      out.write("				");
 } 
      out.write("\n");
      out.write("\n");
      out.write("				");
 if (result == null) { 
      out.write("\n");
      out.write("				");
 
        List<Integer> dealer = (List<Integer>) request.getSession().getAttribute("dealer");
    int firstCard = 0;
    if (!dealer.isEmpty()) {
        firstCard = dealer.get(0);
    }
    
      out.write("\n");
      out.write("				<p>\n");
      out.write("					<strong>PC :</strong>\n");
      out.write("					");
      out.print(servlet.BlackjackServlet.toNumber(firstCard) );
      out.write("\n");
      out.write("					+ ?点\n");
      out.write("				</p>\n");
      out.write("				<table border=\"1\" class=\"myTable\">\n");
      out.write("\n");
      out.write("					<tr>\n");
      out.write("						");
for (int i =0;i<2;i++) { 
      out.write("\n");
      out.write("						<td>");
      out.print(i+1 );
      out.write("枚目</td>\n");
      out.write("\n");
      out.write("						");
} 
      out.write("\n");
      out.write("					\n");
      out.write("					<tr>\n");
      out.write("					<tr>\n");
      out.write("						<td>");
      out.print(servlet.BlackjackServlet.toCardString(firstCard) );
      out.write("</td>\n");
      out.write("						<td>秘密</td>\n");
      out.write("					</tr>\n");
      out.write("				</table>\n");
      out.write("				<br>\n");
      out.write("<div class=\"button-container\">\n");
      out.write("				<form action=\"/BJServletRensyu2/BlackjackServlet\" method=\"post\">\n");
      out.write("					<input type=\"hidden\" name=\"action\" value=\"hit\"> \n");
      out.write("					<button type=\"submit\" class=\"bjbtn\"><span>一枚引く</span></button>\n");
      out.write("					\n");
      out.write("				</form>\n");
      out.write("\n");
      out.write("				<form action=\"/BJServletRensyu2/BlackjackServlet\" method=\"post\">\n");
      out.write("					<input type=\"hidden\" name=\"action\" value=\"stand\"> \n");
      out.write("					<button type=\"submit\" class=\"bjbtn\"><span>勝負する</span></button>\n");
      out.write("					\n");
      out.write("				</form>\n");
      out.write("</div>\n");
      out.write("				");
 } 
      out.write("\n");
      out.write("			</div>\n");
      out.write("		</div>\n");
      out.write("	</div>\n");
      out.write("	<footer>\n");
      out.write("		<p>2023 ALL RIGHT RESERVED.</p>\n");
      out.write("	</footer>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
