<%--
  Created by IntelliJ IDEA.
  User: 乔邦朔
  Date: 2020/11/5
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>登录</title>
    <h1 style="color: chartreuse">登录</h1>
    <style >
        body{
            text-align: center;
            margin-top: 200px;
            background-size:cover;
        }
        .b{
            width: 300px;
            height: 600px;
            border-style:solid;
            border-width:5px;
            border-color: black;
            margin: 0 auto;
            text-align: center;
            background-size:cover;
        }
    </style>
</head>

<body>

<%
    // 获取cookie
    Cookie[] cookies = request.getCookies();
    // 如果为空，则停留在该页面
    if(cookies == null){
        return ;
        // 不为空则获取用户名和密码
    }else {
        if (cookies!= null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie temp = cookies[i];
                if (temp.getName().equals("user")) {
                    request.getRequestDispatcher("/css/shopping.jsp").forward(request, response);
                }
            }
        }
    }
%>

<form action="/login" method="post">
    用户名：
    <input type="text" name="name"></br></br>

    密&ensp;码：
    <input type="password" name="psw1"></br></br>

    验证码：
    <input type="text" name="chknumber">
    <img src="/images/checkcode.png" /> </br></br>

    <input type="checkbox" name="keep" >两周免登陆 </br></br>

    <input type="submit" value="登录">

</form>

</body>
</html>
