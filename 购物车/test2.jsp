<%--
  Created by IntelliJ IDEA.
  User: 乔邦朔
  Date: 2020/11/3
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login.jsp</title>
</head>
<body>
<h2>登录</h2>

<%
    //首先检查
    Cookie[] cookies = request.getCookies();
    String name = "";
    String password = "";
    if (cookies != null && cookies.length != 0) {
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i] != null) {
                if (cookies[i].getName().equals("name")) {
                    name = cookies[i].getValue();
                }
            }
            if (cookies[i] != null) {
                if (cookies[i].getName().equals("password")) {
                    password = cookies[i].getValue();
                }
            }
        }
    }
    if (!name.equals("") && !(password.equals(""))
            && name.equals("user")) {
        request.getRequestDispatcher("/hello.jsp").forward(request,response);
    } else {
%>

<form action="/cookie" method="post">
    用户名：<input type="text" name="name" /><br>
    密码：<input type="password" name="password" /><br>
    是否保存两个周免登陆状态:
    <%--<input type="checkbox" name="keep">两个周免登陆<br>--%>
    <input type="radio" name="saveLoginState" value="1" checked="checked">是
    <input type="radio" name="saveLoginState" value="0">否<br>
    <input type="submit" value="登录">
</form>
<%
    }
%>
<%
    Cookie[] cookie = request.getCookies();
    if(cookie!=null){
        for(int i=0;i<cookie.length;i++){
            if(cookie[i].getName().equals("user")){
                request.getRequestDispatcher("hello.jsp");
            }
        }
    }
%>

</body>
</html>
