package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class service_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<title>Repair & Healing</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div\r\n");
      out.write("\txmlns:jsp=\"http://java.sun.com/JSP/Page\" \r\n");
      out.write("\txmlns:spring=\"http://www.springframework.org/tags\"\r\n");
      out.write("\txmlns:c=\"http://java.sun.com/jsp/jstl/core\"\r\n");
      out.write("\tversion=\"2.0\"\r\n");
      out.write(">\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("    ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${newMaster}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("    \r\n");
      out.write("\t<form action=\"/service/form\" method=\"POST\">\r\n");
      out.write("\t\t<table>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<tr><td>NAME</td><td><input name=\"name\" type=\"text\" /></td></tr>\r\n");
      out.write("\t\t\t<tr><td>SPECIALIZATION</td><td><input name=\"spec\" type=\"text\" /></td></tr>\r\n");
      out.write("\t\t\t<tr><td>TAMETABLE</td><td><input name=\"timetable\" type=\"text\" /></td></tr>\r\n");
      out.write("\t\t\t<!-- <tr><td>TELEPHONE</td><td><input name=\"telephonNumber\" type=\"text\" /></td></tr> -->\r\n");
      out.write("\t\t\t<!-- <tr><td>LOGIN</td><td><input name=\"login\" type=\"text\" /></td></tr>\r\n");
      out.write("\t\t\t<tr><td>PASSWORD</td><td><input name=\"password\" type=\"text\" /></td></tr>\r\n");
      out.write("\t\t\t<tr><td>DEP_ID</td><td><input name=\"departmentId\" type=\"text\" /></td></tr> -->\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<tr><td></td><td><input type=\"submit\" /></td></tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t</form>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
