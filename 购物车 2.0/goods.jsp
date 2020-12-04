
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>购物页面</title>
</head>
<body>
<h1 style="color: deepskyblue" align="center">欢迎购买国外潮牌</h1>
<hr size="2" color=" black">
<table border="1" align="center">
    <tr bgcolor="white">
        <td height="50" width="100"><div align="center"><span>商品编号</span></div></td>
        <td height="50" width="100"><div align="center"><span>商品名称</span></div></td>
        <td height="50" width="100"><div align="center"><span>商品价格/元</span></div></td>
        <td height="50" width="100"><div align="center"><span>商品数量/个</span></div></td>
        <td height="50" width="100"><div align="center"><span>点击购买进行购买</span></div></td>
    </tr>
    <c:choose>
        <c:when test="${empty books}">
            <td height="50" width="100" align="center"><div align="center">没有查询到书籍信息</div></td>
        </c:when>
        <c:otherwise>
            <c:forEach var="book" items="${books}">
                <tr bgcolor="white">
                    <td height="50" width="100">
                        <div >
                            <div align="center">${book.id}</div>
                        </div>
                    </td>
                    <td height="50" width="100"><div align="center">${book.name}</div></td>
                    <td height="50" width="100"><div align="center">${book.price}</div></td>
                    <td height="50" width="100"><div align="center">${book.number}</div></td>
                    <td height="50" width="100"><div align="center"><a href="/buy?id=${book.id}" style="">购买</a></div></td>
                </tr>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</table>
<br>
<a href="/showGoods" align="center" style="color: orange">查看购物车</a>
</body>
</html>
