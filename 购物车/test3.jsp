<%--
  Created by IntelliJ IDEA.
  User: 乔邦朔
  Date: 2020/11/3
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p> 这里是网上商城，选择您需要的商品添加到购物车 ：

    <form action="/addcar" method="post" name="form">
        <select name="item" value="未选择">
            <option value="TV" />电视机
            <option value="apple"/>苹果
            <option value="coke"/>可口可乐
            <option value="milk"/>牛奶
            <option value="tea"/>茶叶
        </select>
        <select name="item" value="未选择">
            <option value="铅笔" />铅笔
            <option value="港币"/>港币
            <option value="素描纸"/>素描纸
            <option value="橡皮"/>橡皮
            <option value="壁纸"/>壁纸
        </select>
        <select name="item" value="未选择">
            <option value="茶壶" />茶壶
            <option value="靴子"/>靴子
            <option value="袜子"/>袜子
            <option value="酸奶"/>酸奶
            <option value="糖果"/>糖果
        </select>

<p>输入购买的数量：
    <input type="text" name ="mount">
<p>选择计量单位：
    <input type="radio" name="unit" value="个">个
    <input type="radio" name="unit" value="公斤">公斤
    <input type="radio" name="unit" value="台">台
    <input type="radio" name="unit" value="瓶">瓶
    <input type="radio" name="unit" value="部">部
    <input type="radio" name="unit" value="支">支
    <input type="radio" name="unit" value="张">张
    <input type="radio" name="unit" value="双">双
    <input type="radio" name="unit" value="把">把

    <input type="submit" value="添加提交">
    <input type="reset" value="重设">
</p>

</form>
<hr>
<a href="shopping2.jsp">其它物品</a>
<a href="remove.jsp">删除商品</a>
</p>

</body>
</html>
