/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.73
 * Generated at: 2023-06-27 02:59:29 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Result;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("model.Result");
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

      out.write('\n');
      out.write('\n');
      out.write('\n');

String userHand = (String) request.getAttribute("userHand");
userHand = userHand == null ? "" : userHand;
String pcHand = (String) request.getAttribute("pcHand");
pcHand = pcHand == null ? "" : pcHand;
String result = (String) request.getAttribute("result");
result = result == null ? "" : result;

Result r = (Result) session.getAttribute("r");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\" />\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\n");
      out.write("	href=\"../BJServletRensyu2/卒業制作/css/kyoutuu.css\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/janken.css\">\n");
      out.write("<title>じゃんけんゲーム</title>\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"\n");
      out.write("	integrity=\"sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=\"\n");
      out.write("	crossorigin=\"anonymous\"></script>\n");
      out.write("<script src=\"js/hamb.js\"></script>\n");
      out.write("<script>\n");
      out.write("	function selectHand(handValue) {\n");
      out.write("		document.getElementById('selected-hand').value = handValue;\n");
      out.write("		document.getElementById('jankenForm').submit();\n");
      out.write("	}\n");
      out.write("\n");
      out.write("	setTimeout(\n");
      out.write("			function() {\n");
      out.write("				document.getElementById(\"jann\").style.display = \"inline\";\n");
      out.write("				setTimeout(\n");
      out.write("						function() {\n");
      out.write("							document.getElementById(\"kenn\").style.display = \"inline\";\n");
      out.write("							setTimeout(\n");
      out.write("									function() {\n");
      out.write("										document.getElementById(\"ponn\").style.display = \"inline\";\n");
      out.write("										document\n");
      out.write("												.getElementById(\"result-container\").style.display = \"block\";\n");
      out.write("									}, 700);\n");
      out.write("						}, 700);\n");
      out.write("			}, 0);\n");
      out.write("</script>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("	<div class=\"content\">\n");
      out.write("		<button type=\"button\" class=\"btn js-btn\">\n");
      out.write("			<span class=\"btn-line\"></span>\n");
      out.write("		</button>\n");
      out.write("		<nav>\n");
      out.write("			<ul class=\"menu\">\n");
      out.write("				<li class=\"menu-list\"\n");
      out.write("					onclick=\"window.location.href='../BJServletRensyu2/卒業制作/index.html'\">TOP</li>\n");
      out.write("				<li class=\"menu-list\" onclick=\"window.location.href='http://localhost:8080/JankenServletGame/JankenServlet'\">制作物1</li>\n");
      out.write("				<li class=\"menu-list\" onclick=\"window.location.href='http://localhost:8080/BJServletRensyu2/BlackjackServlet'\">制作物2</li>\n");
      out.write("				<li class=\"menu-list\" onclick=\"window.location.href='http://localhost:8080/TypingGame/TypingGameServlet'\">制作物3</li>\n");
      out.write("				<li class=\"menu-list\"\n");
      out.write("					onclick=\"window.location.href='../BJServletRensyu2/卒業制作/furikaeri.html'\">訓練振り返り</li>\n");
      out.write("			</ul>\n");
      out.write("		</nav>\n");
      out.write("		<div class=\"wrapper\">\n");
      out.write("			<br>\n");
      out.write("			<br>\n");
      out.write("			<h1 class=\"gametitle\">じゃんけんゲーム</h1>\n");
      out.write("			<br>\n");
      out.write("			<div class=\"wrapper-content\">\n");
      out.write("			<form id=\"jankenForm\" action=\"/JankenServletGame/JankenServlet\"\n");
      out.write("				method=\"post\">\n");
      out.write("				手を選んでね<br> <br><input type=\"hidden\" id=\"selected-hand\" name=\"hand\"\n");
      out.write("					value=\"");
      out.print(userHand);
      out.write("\">\n");
      out.write("			</form>\n");
      out.write("\n");
      out.write("			<div class=\"image-container\">\n");
      out.write("				<button class=\"janbutton\" onclick=\"selectHand('0')\">グー</button>\n");
      out.write("				<button class=\"janbutton\" onclick=\"selectHand('1')\">チョキ</button>\n");
      out.write("				<button class=\"janbutton\" onclick=\"selectHand('2')\">パー</button>\n");
      out.write("			</div>\n");
      out.write("\n");
      out.write("			");

			if (result.length() > 0) {
			
      out.write("\n");
      out.write("<br>\n");
      out.write("			<p id=\"jann\" style=\"display: none;\">じゃん</p>\n");
      out.write("			<p id=\"kenn\" style=\"display: none;\">けん</p>\n");
      out.write("			<p id=\"ponn\" style=\"display: none;\">ぽん!</p><br>\n");
      out.write("			<div id=\"result-container\" style=\"display: none;\">\n");
      out.write("				<div class =\"image-container2\">\n");
      out.write("					<div class=\"hand\">\n");
      out.write("						<b>あなた</b><br>\n");
      out.write("						");

						if (userHand.equals("グー")) {
						
      out.write("\n");
      out.write("						<img src=\"images/gu.png\" alt=\"グー\">\n");
      out.write("						");

						} else if (userHand.equals("チョキ")) {
						
      out.write("\n");
      out.write("						<img src=\"images/choki.png\" alt=\"チョキ\">\n");
      out.write("						");

						} else if (userHand.equals("パー")) {
						
      out.write("\n");
      out.write("						<img src=\"images/pa.png\" alt=\"パー\">\n");
      out.write("						");

						}
						
      out.write("\n");
      out.write("					</div>\n");
      out.write("					<div class=\"hand\">\n");
      out.write("						<b>PC</b><br>\n");
      out.write("						");

						if (pcHand.equals("グー")) {
						
      out.write("\n");
      out.write("						<img src=\"images/gu.png\" alt=\"グー\">\n");
      out.write("						");

						} else if (pcHand.equals("チョキ")) {
						
      out.write("\n");
      out.write("						<img src=\"images/choki.png\" alt=\"チョキ\">\n");
      out.write("						");

						} else if (pcHand.equals("パー")) {
						
      out.write("\n");
      out.write("						<img src=\"images/pa.png\" alt=\"パー\">\n");
      out.write("						");

						}
						
      out.write("\n");
      out.write("					</div>\n");
      out.write("				</div><br>\n");
      out.write("\n");
      out.write("				<p>");
      out.print(result);
      out.write("</p>\n");
      out.write("				<p>\n");
      out.write("					勝:");
      out.print(r.getWin());
      out.write("\n");
      out.write("					負:");
      out.print(r.getLose());
      out.write("\n");
      out.write("					分:");
      out.print(r.getDraw());
      out.write("\n");
      out.write("				</p>\n");
      out.write("\n");
      out.write("				<form action=\"/JankenServletGame/JankenServlet\" method=\"post\">\n");
      out.write("					<input type=\"hidden\" name=\"action\" value=\"reset\"> \n");
      out.write("					<input\n");
      out.write("						type=\"submit\" value=\"初めから\" class=\"hajimekara\">\n");
      out.write("				</form>\n");
      out.write("\n");
      out.write("				");

				}
				session.removeAttribute("r");
				
      out.write("\n");
      out.write("				</div>\n");
      out.write("			</div>\n");
      out.write("		</div>\n");
      out.write("	</div>\n");
      out.write("\n");
      out.write("	<footer>\n");
      out.write("		<p>2023 ALL RIGHT RESERVED.</p>\n");
      out.write("	</footer>\n");
      out.write("</body>\n");
      out.write("</html>");
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