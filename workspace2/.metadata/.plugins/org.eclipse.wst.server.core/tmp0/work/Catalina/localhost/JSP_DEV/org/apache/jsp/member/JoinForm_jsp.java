/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.73
 * Generated at: 2021-03-04 07:49:06 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class JoinForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
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

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=EUC-KR");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<title>회원가입 화면</title>\r\n");
      out.write("\r\n");
      out.write("\t<style type=\"text/css\">\r\n");
      out.write("\t\ttable{\r\n");
      out.write("\t\t\tmargin-left:auto; \r\n");
      out.write("\t\t\tmargin-right:auto;\r\n");
      out.write("\t\t\tborder:3px solid skyblue;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\ttd{\r\n");
      out.write("\t\t\tborder:1px solid skyblue\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t#title{\r\n");
      out.write("\t\t\tbackground-color:skyblue\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</style>\r\n");
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\r\n");
      out.write("\t\t// 필수 입력정보인 아이디, 비밀번호가 입력되었는지 확인하는 함수\r\n");
      out.write("\t\tfunction checkValue()\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\tif(!document.userInfo.id.value){\r\n");
      out.write("\t\t\t\talert(\"아이디를 입력하세요.\");\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif(!document.userInfo.password.value){\r\n");
      out.write("\t\t\t\talert(\"비밀번호를 입력하세요.\");\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t// 비밀번호와 비밀번호 확인에 입력된 값이 동일한지 확인\r\n");
      out.write("\t\t\tif(document.userInfo.password.value != document.userInfo.passwordcheck.value ){\r\n");
      out.write("\t\t\t\talert(\"비밀번호를 동일하게 입력하세요.\");\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// 취소 버튼 클릭시 첫화면으로 이동\r\n");
      out.write("\t\tfunction goFirstForm() {\r\n");
      out.write("\t\t\tlocation.href=\"MainForm.do\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t</script>\r\n");
      out.write("\t\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t\t<br><br>\r\n");
      out.write("\t\t<b><font size=\"6\" color=\"gray\">회원가입</font></b>\r\n");
      out.write("\t\t<br><br><br>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!-- 입력한 값을 전송하기 위해 form 태그를 사용한다 -->\r\n");
      out.write("\t\t<!-- 값(파라미터) 전송은 POST 방식, 전송할 페이지는 JoinPro.jsp -->\r\n");
      out.write("\t\t<form method=\"post\" action=\"MemberJoinAction.do\" \r\n");
      out.write("\t\t\t\tname=\"userInfo\" onsubmit=\"return checkValue()\">\r\n");
      out.write("\t\t\t<table>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td id=\"title\">아이디</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"id\" maxlength=\"50\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"button\" value=\"중복확인\">\t\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td id=\"title\">비밀번호</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"password\" name=\"password\" maxlength=\"50\">\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td id=\"title\">비밀번호 확인</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"password\" name=\"passwordcheck\" maxlength=\"50\">\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td id=\"title\">이름</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"name\" maxlength=\"50\">\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td id=\"title\">성별</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"radio\" name=\"gender\" value=\"남\" checked>남\r\n");
      out.write("\t\t\t\t\t\t<input type=\"radio\" name=\"gender\" value=\"여\" >여\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td id=\"title\">생일</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"birthyy\" maxlength=\"4\" placeholder=\"년(4자)\" size=\"6\" >\r\n");
      out.write("\t\t\t\t\t\t<select name=\"birthmm\">\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"\">월</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"01\" >1</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"02\" >2</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"03\" >3</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"04\" >4</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"05\" >5</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"06\" >6</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"07\" >7</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"08\" >8</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"09\" >9</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"10\" >10</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"11\" >11</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"12\" >12</option>\r\n");
      out.write("\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"birthdd\" maxlength=\"2\" placeholder=\"일\" size=\"4\" >\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td id=\"title\">이메일</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"mail1\" maxlength=\"50\">@\r\n");
      out.write("\t\t\t\t\t\t<select name=\"mail2\">\r\n");
      out.write("\t\t\t\t\t\t\t<option>naver.com</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option>daum.net</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option>gmail.com</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option>nate.com</option>\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td id=\"title\">휴대전화</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"phone\" />\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td id=\"title\">주소</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" size=\"50\" name=\"address\"/>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t<br>\r\n");
      out.write("\t\t\t<input type=\"submit\" value=\"가입\"/>  \r\n");
      out.write("\t\t\t<input type=\"button\" value=\"취소\" onclick=\"goFirstForm()\">\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
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
