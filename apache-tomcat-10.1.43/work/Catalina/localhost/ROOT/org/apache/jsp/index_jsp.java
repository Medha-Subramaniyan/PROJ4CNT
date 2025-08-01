/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.43
 * Generated at: 2025-07-30 00:32:19 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
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

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
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

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, false, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');
      out.write('\n');

java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy");
request.setAttribute("year", sdf.format(new java.util.Date()));
request.setAttribute("tomcatUrl", "https://tomcat.apache.org/");
request.setAttribute("tomcatDocUrl", "/docs/");
request.setAttribute("tomcatExamplesUrl", "/examples/");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\" />\n");
      out.write("        <title>");
      out.print(request.getServletContext().getServerInfo() );
      out.write("</title>\n");
      out.write("        <link href=\"favicon.ico\" rel=\"icon\" type=\"image/x-icon\" />\n");
      out.write("        <link href=\"tomcat.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div id=\"wrapper\">\n");
      out.write("            <div id=\"navigation\" class=\"curved container\">\n");
      out.write("                <span id=\"nav-home\"><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tomcatUrl}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">Home</a></span>\n");
      out.write("                <span id=\"nav-hosts\"><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tomcatDocUrl}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">Documentation</a></span>\n");
      out.write("                <span id=\"nav-config\"><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tomcatDocUrl}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("config/\">Configuration</a></span>\n");
      out.write("                <span id=\"nav-examples\"><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tomcatExamplesUrl}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">Examples</a></span>\n");
      out.write("                <span id=\"nav-wiki\"><a href=\"https://cwiki.apache.org/confluence/display/TOMCAT/\">Wiki</a></span>\n");
      out.write("                <span id=\"nav-lists\"><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tomcatUrl}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("lists.html\">Mailing Lists</a></span>\n");
      out.write("                <span id=\"nav-help\"><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tomcatUrl}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("findhelp.html\">Find Help</a></span>\n");
      out.write("                <br class=\"separator\" />\n");
      out.write("            </div>\n");
      out.write("            <div id=\"asf-box\">\n");
      out.write("                <h1>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.serverInfo}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</h1>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"upper\" class=\"curved container\">\n");
      out.write("                <div id=\"congrats\" class=\"curved container\">\n");
      out.write("                    <h2>If you're seeing this, you've successfully installed Tomcat. Congratulations!</h2>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"notice\">\n");
      out.write("                    <img id=\"tomcat-logo\" src=\"tomcat.svg\" alt=\"[tomcat logo]\" />\n");
      out.write("                    <div id=\"tasks\">\n");
      out.write("                        <h3>Recommended Reading:</h3>\n");
      out.write("                        <h4><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tomcatDocUrl}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("security-howto.html\">Security Considerations How-To</a></h4>\n");
      out.write("                        <h4><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tomcatDocUrl}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("manager-howto.html\">Manager Application How-To</a></h4>\n");
      out.write("                        <h4><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tomcatDocUrl}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("cluster-howto.html\">Clustering/Session Replication How-To</a></h4>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"actions\">\n");
      out.write("                    <div class=\"button\">\n");
      out.write("                        <a class=\"container shadow\" href=\"/manager/status\"><span>Server Status</span></a>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"button\">\n");
      out.write("                        <a class=\"container shadow\" href=\"/manager/html\"><span>Manager App</span></a>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"button\">\n");
      out.write("                        <a class=\"container shadow\" href=\"/host-manager/html\"><span>Host Manager</span></a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <br class=\"separator\" />\n");
      out.write("            </div>\n");
      out.write("            <div id=\"middle\" class=\"curved container\">\n");
      out.write("                <h3>Developer Quick Start</h3>\n");
      out.write("                <div class=\"col25\">\n");
      out.write("                    <div class=\"container\">\n");
      out.write("                        <p><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tomcatDocUrl}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("setup.html\">Tomcat Setup</a></p>\n");
      out.write("                        <p><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tomcatDocUrl}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("appdev/\">First Web Application</a></p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col25\">\n");
      out.write("                    <div class=\"container\">\n");
      out.write("                        <p><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tomcatDocUrl}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("realm-howto.html\">Realms &amp; AAA</a></p>\n");
      out.write("                        <p><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tomcatDocUrl}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("jndi-datasource-examples-howto.html\">JDBC DataSources</a></p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col25\">\n");
      out.write("                    <div class=\"container\">\n");
      out.write("                        <p><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tomcatExamplesUrl}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">Examples</a></p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col25\">\n");
      out.write("                    <div class=\"container\">\n");
      out.write("                        <p><a href=\"https://cwiki.apache.org/confluence/display/TOMCAT/Specifications\">Servlet Specifications</a></p>\n");
      out.write("                        <p><a href=\"https://cwiki.apache.org/confluence/display/TOMCAT/Tomcat+Versions\">Tomcat Versions</a></p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <br class=\"separator\" />\n");
      out.write("            </div>\n");
      out.write("            <div id=\"lower\">\n");
      out.write("                <div id=\"low-manage\" class=\"\">\n");
      out.write("                    <div class=\"curved container\">\n");
      out.write("                        <h3>Managing Tomcat</h3>\n");
      out.write("                        <p>For security, access to the <a href=\"/manager/html\">manager webapp</a> is restricted.\n");
      out.write("                        Users are defined in:</p>\n");
      out.write("                        <pre>$CATALINA_HOME/conf/tomcat-users.xml</pre>\n");
      out.write("                        <p>In Tomcat 10.1 access to the manager application is split between\n");
      out.write("                           different users. &nbsp; <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tomcatDocUrl}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("manager-howto.html\">Read more...</a></p>\n");
      out.write("                        <br />\n");
      out.write("                        <h4><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tomcatDocUrl}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("RELEASE-NOTES.txt\">Release Notes</a></h4>\n");
      out.write("                        <h4><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tomcatDocUrl}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("changelog.html\">Changelog</a></h4>\n");
      out.write("                        <h4><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tomcatUrl}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("migration.html\">Migration Guide</a></h4>\n");
      out.write("                        <h4><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tomcatUrl}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("security.html\">Security Notices</a></h4>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"low-docs\" class=\"\">\n");
      out.write("                    <div class=\"curved container\">\n");
      out.write("                        <h3>Documentation</h3>\n");
      out.write("                        <h4><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tomcatDocUrl}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">Tomcat 10.1 Documentation</a></h4>\n");
      out.write("                        <h4><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tomcatDocUrl}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("config/\">Tomcat 10.1 Configuration</a></h4>\n");
      out.write("                        <h4><a href=\"https://cwiki.apache.org/confluence/display/TOMCAT/\">Tomcat Wiki</a></h4>\n");
      out.write("                        <p>Find additional important configuration information in:</p>\n");
      out.write("                        <pre>$CATALINA_HOME/RUNNING.txt</pre>\n");
      out.write("                        <p>Developers may be interested in:</p>\n");
      out.write("                        <ul>\n");
      out.write("                            <li><a href=\"https://tomcat.apache.org/bugreport.html\">Tomcat 10.1 Bug Database</a></li>\n");
      out.write("                            <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tomcatDocUrl}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("api/index.html\">Tomcat 10.1 JavaDocs</a></li>\n");
      out.write("                            <li><a href=\"https://github.com/apache/tomcat/tree/10.1.x\">Tomcat 10.1 Git Repository at GitHub</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"low-help\" class=\"\">\n");
      out.write("                    <div class=\"curved container\">\n");
      out.write("                        <h3>Getting Help</h3>\n");
      out.write("                        <h4><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tomcatUrl}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("faq/\">FAQ</a> and <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tomcatUrl}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("lists.html\">Mailing Lists</a></h4>\n");
      out.write("                        <p>The following mailing lists are available:</p>\n");
      out.write("                        <ul>\n");
      out.write("                            <li id=\"list-announce\"><strong><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tomcatUrl}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("lists.html#tomcat-announce\">tomcat-announce</a><br />\n");
      out.write("                                Important announcements, releases, security vulnerability notifications. (Low volume).</strong>\n");
      out.write("                            </li>\n");
      out.write("                            <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tomcatUrl}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("lists.html#tomcat-users\">tomcat-users</a><br />\n");
      out.write("                                User support and discussion\n");
      out.write("                            </li>\n");
      out.write("                            <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tomcatUrl}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("lists.html#taglibs-user\">taglibs-user</a><br />\n");
      out.write("                                User support and discussion for <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tomcatUrl}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("taglibs/\">Apache Taglibs</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tomcatUrl}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("lists.html#tomcat-dev\">tomcat-dev</a><br />\n");
      out.write("                                Development mailing list, including commit messages\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <br class=\"separator\" />\n");
      out.write("            </div>\n");
      out.write("            <div id=\"footer\" class=\"curved container\">\n");
      out.write("                <div class=\"col20\">\n");
      out.write("                    <div class=\"container\">\n");
      out.write("                        <h4>Other Downloads</h4>\n");
      out.write("                        <ul>\n");
      out.write("                            <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tomcatUrl}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("download-connectors.cgi\">Tomcat Connectors</a></li>\n");
      out.write("                            <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tomcatUrl}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("download-native.cgi\">Tomcat Native</a></li>\n");
      out.write("                            <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tomcatUrl}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("taglibs/\">Taglibs</a></li>\n");
      out.write("                            <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tomcatDocUrl}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("deployer-howto.html\">Deployer</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col20\">\n");
      out.write("                    <div class=\"container\">\n");
      out.write("                        <h4>Other Documentation</h4>\n");
      out.write("                        <ul>\n");
      out.write("                            <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tomcatUrl}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("connectors-doc/\">Tomcat Connectors</a></li>\n");
      out.write("                            <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tomcatUrl}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("connectors-doc/\">mod_jk Documentation</a></li>\n");
      out.write("                            <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tomcatUrl}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("native-doc/\">Tomcat Native</a></li>\n");
      out.write("                            <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tomcatDocUrl}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("deployer-howto.html\">Deployer</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col20\">\n");
      out.write("                    <div class=\"container\">\n");
      out.write("                        <h4>Get Involved</h4>\n");
      out.write("                        <ul>\n");
      out.write("                            <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tomcatUrl}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("getinvolved.html\">Overview</a></li>\n");
      out.write("                            <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tomcatUrl}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("source.html\">Source Repositories</a></li>\n");
      out.write("                            <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tomcatUrl}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("lists.html\">Mailing Lists</a></li>\n");
      out.write("                            <li><a href=\"https://cwiki.apache.org/confluence/display/TOMCAT/\">Wiki</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col20\">\n");
      out.write("                    <div class=\"container\">\n");
      out.write("                        <h4>Miscellaneous</h4>\n");
      out.write("                        <ul>\n");
      out.write("                            <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tomcatUrl}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("contact.html\">Contact</a></li>\n");
      out.write("                            <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tomcatUrl}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("legal.html\">Legal</a></li>\n");
      out.write("                            <li><a href=\"https://www.apache.org/foundation/sponsorship.html\">Sponsorship</a></li>\n");
      out.write("                            <li><a href=\"https://www.apache.org/foundation/thanks.html\">Thanks</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col20\">\n");
      out.write("                    <div class=\"container\">\n");
      out.write("                        <h4>Apache Software Foundation</h4>\n");
      out.write("                        <ul>\n");
      out.write("                            <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tomcatUrl}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("whoweare.html\">Who We Are</a></li>\n");
      out.write("                            <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tomcatUrl}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("heritage.html\">Heritage</a></li>\n");
      out.write("                            <li><a href=\"https://www.apache.org\">Apache Home</a></li>\n");
      out.write("                            <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tomcatUrl}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("resources.html\">Resources</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <br class=\"separator\" />\n");
      out.write("            </div>\n");
      out.write("            <p class=\"copyright\">Copyright &copy;1999-");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${year}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" Apache Software Foundation.  All Rights Reserved</p>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
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
