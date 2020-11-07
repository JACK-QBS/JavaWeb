<%--
  Created by IntelliJ IDEA.
  User: 乔邦朔
  Date: 2020/11/5
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>家电</title>
    <h1 style="color: orangered">请选择你想购买的家电</h1>
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
        <option value="Home_Appliances"/>家电
        <option value="TV" />电视机
        <option value="Air_Conditioner" />空调
        <option value="Dish-washing_machine " />洗碗机
        <option value="Electric_cooker " />电饭煲
        <option value="Microwave_Oven" />微波炉
        <option value="Water_Purifier" />净水器
        <option value="Washing_Machine" />洗衣机
        <option value="Refrigerator" />冰箱
        <option value="Hair_Dryer" />吹风机
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

</form>

</body>
</html>
