<%--
  Created by IntelliJ IDEA.
  User: 乔邦朔
  Date: 2020/11/3
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<form action="/show" method="post">
    用户名：<input type="text" name="name"/><br>
    密&emsp;码：<input type="password" name="password"/><br>
    性  别: <input type="radio" name="sex" value="boy" />男
    <input type="radio" name="sex"  value="girl"/>女<br>
    密码确认：<input type="passwordagain" name="passwordagain"/><br>
    兴趣爱好：<br>
    <input name="fav" type="checkbox" value="sing">唱歌
    <input name="fav" type="checkbox" value="dance">跳舞<br>
    <input name="fav" type="checkbox" value="ball">打球
    <input name="fav" type="checkbox" value="game">打游戏<br>
    <input type="submit" value="提交"/>
    <input type="reset" value="重置"/>
</form>

</body>
</html>
