<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.DateFormat" %><%--
  Created by IntelliJ IDEA.
  User: 乔邦朔
  Date: 2020/11/5
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>某宝</title>
    <h2 style="color: orangered">欢迎来到某宝，快给你喜欢的物品下单吧</h2>
    <hr>
    <style >
        body{
            text-align: center;
            margin-top: 100px;
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
<form action="/shopping.jsp" method="post" name="form">

    <a href="/css/Home_Appliances.jsp"><h3 style="color: midnightblue" >家电</h3></a>
    <a href="/css/smart.jsp"><h3 style="color: midnightblue" >智能电子产品</h3></a>
    <a href="/css/usually.jsp"><h3 style="color: midnightblue" >日常物品</h3></a>

</form>
<hr>

<a href="remove.jsp">删除商品</a>
<br><br>

登陆时间是：
<% out.print(new Date());%> <br>
<br>
上一次的登陆时间是：
<%
    //获取客户端所有cookie
    Cookie[] cookies = request.getCookies();
    Cookie cookie = null;
    for (int i = 0 ; i < cookies.length ; i++){
        if (cookies[i].getName().equals("visitTime")){
            cookie = cookies[i];
            long time = Long.parseLong(cookie.getValue());
            DateFormat df=new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
            Date date = new Date(time);
            out.print(date);
        }
    }
%>

</body>
</html>
