<%--
  Created by IntelliJ IDEA.
  User: 乔邦朔
  Date: 2020/11/5
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除</title>
    <h1 style="color: orangered">删除你不想要的商品</h1>
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

    <select name="item" value="未选择">
        <option value="smart" />智能电子产品
        <option value="Computer" />电脑
        <option value="phone" />手机
        <option value="floor_mopping_robot" />扫地机器人
        <option value="AI" />人工智能小助手
    </select>

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

    <input type="submit" value="提交删除">

</form>

</body>
</html>
