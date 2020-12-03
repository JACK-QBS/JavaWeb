
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购买商品页面</title>
</head>
<body>
<h1 style="color: deepskyblue" align="center"> 国外潮牌 </h1>
<hr size="2" color="black">
<form action="/buyPut" method="post" align="center">
    <input type="hidden" name="id" value="${book.id}">
    <input type="hidden" name="name" value="${book.name}">
    <table border="1" align="center">
        <tr bgcolor="white">
            <td height="50" width="100"><div align="center"><span>商品编号</span></div></td>
            <td height="50" width="100"><div align="center"><span>商品名称</span></div></td>
            <td height="50" width="100"><div align="center"><span>商品价格/元</span></div></td>
            <td height="50" width="100"><div align="center"><span>商品数量/个</span></div></td>
            <td height="50" width="100"><div align="center"><span>请输入购买数量</span></div></td>
        </tr>

        <tr bgcolor="white">
            <td height="50" width="100">
                <div >
                    <div align="center">${book.id} </div>
                </div>

            </td>
            <td height="50" width="100"><div align="center">${book.name}</div></td>
            <td height="50" width="100"><div align="center">${book.price}</div></td>
            <td height="50" width="100"><div align="center">${book.number}</div></td>
            <td height="50" width="100"><div align="center">
                <input type="number" name="buy_numbers">
            </div></td>
        </tr>
    </table>
    <br>
    <input type="submit" value="提交" align="center">
</form>
<br>
<a href="/bookList" align="center" style="color: orange">返回</a>
</body>
</html>
