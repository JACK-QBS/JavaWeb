
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title >计算机</title>
    <h1 style="color: deepskyblue" align="center">计算器</h1>
</head>
<body>

<hr size="2" color="black">
<script type="text/javascript"></script>

<div>
    <form action="/calculator" style="width: 30%; margin: auto">
<table border="1" >
    <tr>
        <td width="400" height="40" colspan="2"><div align="center">我的计算器</div></td>
    </tr>
    <tr>
        <td width="200" height="40"><div align="center">第一个参数：</div></td>
        <td width="200" height="40"><input type="text" name="firstParameter" value="${firstParameter}"></td>
    </tr>
    <tr>
        <td width="200" height="40"><div align="center">运算符：</div></td>
        <td width="200" height="40">
            <select id="previous" name="operator" value="operator">
                <option value="+" >+</option>
                <option value="-">-</option>
                <option value="*">*</option>
                <option value="/">/</option>
                <option value="%">%</option>
            </select>
        </td>
    </tr>
    <tr>
        <td width="200" height="40"><div align="center">第二个参数：</div></td>
        <td width="200" height="40"><input type="text" name="secondParameter" value="${secondParameter}"></td>
    </tr>
    <tr>
        <td width="400" height="40" colspan="2"><div align="center">

                    <input type="submit" value="计算"/>

        </td>

    </tr>

</table>
        <table border="1" >
            <tr>
                <td width="405" height="40"><div align="center">
                    计算结果：${num}
                </td>
            </tr>
        </table>

    </form>
</div>
</body>
</html>
