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
    <h1>登录</h1>
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
    <br action="/regist.jsp " method="post">
        <br class="b">

                用户名：
                <input type="text" name="name"></br></br>

                密&ensp;码：
                <input type="password" name="psw1"></br></br>

                <div>
                    <input type="submit" value="提交">
                    <input type="reset"value="重置">
                </div>

</body>
</html>
