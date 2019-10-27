<html>
<head>
    <title>Оплата</title>
    <#include "navTemplate1.ftl">
    <#include "navTemplate3.ftl">
</head>
<body>
<#include "navTemplate2.ftl">
<table width="100%">
    <tr><td align="center" bgcolor="#b2ff9c">Заказ</td></tr>
</table>
<table id='payInfo' class="table">
    <thead class="thead-light">
    <tr>
        <th>Кол-во</th>
        <th>Сумма к оплате</th>
    </tr>
    </thead>
    <tr>
        <td>
            ${cartArticlesCount}
        </td>
        <td>
            <#if cartArticlesSum??>
                ${cartArticlesSum}
            <#else>
                0
            </#if>
        </td>
    </tr>
</table>
</body>
</html>
