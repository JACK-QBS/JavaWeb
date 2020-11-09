
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>注册</title>
    <h1>注册</h1>
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
    <form action="/regist.jsp " method="post">

                用户名：
                <input type="text" name="name"></br></br>

                密&ensp;码：
                <input type="password" name="psw1"></br></br>
                密码确认：
                <input type="password" name="psw2"></br></br>


                性别：
                <input type="radio" name="sex" value="man" checked> 男
                <input type="radio" name="sex" value="female" checked> 女</br></br>


                请选择你可能会感兴趣的项目：</br>
                <input type="checkbox" name="favorite" value="nba"> 运动 &nbsp;
                <input type="checkbox" name="favorite" value="music"> 音乐 &nbsp;</br>
                <input type="checkbox" name="favorite" value="movie"> 旅游 &nbsp;
                <input type="checkbox" name="favorite" value="movie"> 健身 &nbsp;</br>
                <input type="checkbox" name="favorite" value="movie"> 家居 &nbsp;
                <input type="checkbox" name="favorite" value="internet"> 美食 &nbsp;</br></br>


                让别人认识一下你吧：</br>
                <textarea name="mesg"></textarea></br></br>


                <input type="submit" value="提交">
                <input type="reset"value="重置">


    </form>
</body>

</html>
