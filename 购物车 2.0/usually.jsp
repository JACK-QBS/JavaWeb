<%--
  Created by IntelliJ IDEA.
  User: 乔邦朔
  Date: 2020/11/5
  Time: 18:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>日常物品</title>
    <h1 style="color: orangered">请选择你想购买的日常物品</h1>
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
<form action="/css/shopping.jsp" method="post" name="form">

    <select name="item" value="未选择">
        <option value="apple"/>苹果
        <option value="coke"/>可口可乐
        <option value="milk"/>牛奶
        <option value="tea"/>茶叶
        <option value="铅笔" />铅笔
        <option value="港币"/>港币
        <option value="素描纸"/>素描纸
        <option value="橡皮"/>橡皮
        <option value="壁纸"/>壁纸
    </select>

    <p>输入购买的数量：
        <input type="text" name ="mount">

        <select name="unit" value="未选择">
            <option value="个" />个
            <option value="公斤" />公斤
            <option value="台" />台
            <option value="瓶" />瓶
            <option value="部" />部
            <option value="之" />支
            <option value="张" />张
            <option value="把" />把
        </select>
    </p>

    </br>
    </br>
    <input type="submit" value="添加提交">
    <input type="reset" value="重设">
    </p>

</form>

</body>
</html>
