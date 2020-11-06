

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息显示</title>
    <style>
        body{
            text-align: center;
            margin-top: 100px;
            background-size:cover;
        }
        .c{
            width: 300px;
            height: 450px;
            border-style:solid;
            border-width:5px;
            border-color: black;
            margin: 0 auto;
            text-align: center;
            background-size:cover;
        }
    </style>

    <%
        HttpSession loginSession = request.getSession();
        if (loginSession.getAttribute("name")==null){//如果session中的用户名为空
            request.getRequestDispatcher("nologin.jsp").forward(request,response);//转发至nologin（注册有误）界面
        }
    %>
</head>
<body>
    <%--通过session得到信息--%>
    <h1 style="color: orangered" >注册成功</h1>
    <div class="c">
        <div>
            <p>用户名：${sessionScope.name}</p>
            <p>密码：${sessionScope.psw1}</p>
            <p>性别：${sessionScope.sex}</p>
            <p>爱好：${sessionScope.favorite}</p>
            <p>个人简介：${sessionScope.mesg}</p>

            <a href="/css/login.jsp"><h2 style="color: chartreuse" >返回登录</h2></a>

        </div>

    </div>

        <!--添加注销按钮，用a标签跳转到loginOutServlet中的loginOut.do-->
    <p style="background-color: brown">
        <a href="/loginOut.do"><h1 style="color: midnightblue" >注销</h1></a>
    </p>
</body>
</html>
