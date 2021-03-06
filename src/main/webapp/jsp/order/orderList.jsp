<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="../../taglibs.jsp" %>
<html>
<head>
    <%
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>销售单列表</title>
    <link href="css_js/index.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="css_js/jquery/jquery-1.3.2.min.js"></script>
    <script src="css_js/popup4exExcel.js" type="text/javascript"></script>
    <script src="css_js/commons.js" type="text/javascript"></script>
    <link href="css_js/general.css" rel="stylesheet" type="text/css"></link>
    <script type="text/javascript">
        function initPageSize() {
            $("#order_status span").click(function () {
                var orderStatus = $(this).html();

                if (orderStatus == "全部") {
                    //$("#hiddenStatus").val("");
                    window.location = "order/orderList";
                } else {
                    orderStatus = encodeURI(encodeURI(orderStatus));
                    //$("#hiddenStatus").val(orderStatus);
                    window.location = "order/orderList?status=" + orderStatus;
                }
            });

            var pageSizes = document.getElementsByName("_pageSize");
            for (var o = 0; o < pageSizes.length; o++) {
                for (var i = 0; i < pageSizes[o].options.length; i++) {
                    if (pageSizes[o].options[i].value == '${pageSize}') {
                        pageSizes[o].options[i].selected = "selected";
                    }
                }
            }
        }
    </script>
</head>
<body onload="initPageSize()">
<form action="order/orderList" method="post" name="form1" id="form1">
    <input type="hidden" name="page" value="${pager.page}" id="hiddenPageNum"/>
    <input type="hidden" name="pageSize" value="${pager.pageSize}" id="hiddenPageSize"/>
    <input type="hidden" name="status" value="${bean.status }" id="hiddenStatus"/>
    <input type="hidden" name="isDel" value="" id="isDel"/>
    <input type="hidden" name="exportType" value="" id="exportType"/>
    <table width="99%" border="0" cellspacing="0" cellpadding="0" id="index_content">
        <tr>
            <td valign="middle">
                <table width="100%" border="0" cellspacing="0" cellpadding="0" id="index_main_div1">
                    <tr>
                        <td height="21" background="image/index_main_div_titleBg.gif">
                            <img style="margin-left: 5px;" src="image/index_main_div_left.gif" width="6" height="2"
                                 align="absmiddle">&nbsp;
                            <span style="font-weight: bold; font-size: 12px;">销售单</span>
                        </td>
                    </tr>
                    <tr>
                        <td height="46" align="left" valign="middle" bgcolor="#f7fbfc"
                            style="font-size: 12px; color: #424446;" id="order_status">
                            <span <c:if test="${bean.status=='草稿' }">style="color: #FF0000"</c:if>>草稿</span>
                            <span <c:if test="${bean.status=='待审核' }">style="color: #FF0000"</c:if>>待审核</span>
                            <span <c:if test="${bean.status=='已审核' }">style="color: #FF0000"</c:if>>已审核</span>
                            <span <c:if test="${bean.status=='已驳回' }">style="color: #FF0000"</c:if>>已驳回</span>
                            <span
                                    <c:if test="${bean.status==null || bean.status eq '' }">style="color: #FF0000"</c:if>>全部</span>
                        </td>
                    </tr>
                </table>

                <table width="100%" border="0" cellspacing="0" cellpadding="0" id="index_main_div2">
                    <tr>
                        <td height="21" background="image/index_main_div_titleBg.gif">
                            <img style="margin-left: 5px;" src="image/index_main_div_left.gif" width="6" height="2"
                                 align="absmiddle">&nbsp;
                            <span style="font-weight: bold; font-size: 12px;">销售单搜索</span>
                        </td>
                    </tr>
                    <tr>
                        <td height="56" align="left" valign="top" bgcolor="#f7fbfc">
                            <table width="100%" border="0" cellspacing="0" cellpadding="0"
                                   height="100%" id="selectTable">
                                <tr>
                                    <td width="11%">销售单号:</td>
                                    <td width="17%">
                                        <input type="text" name="code" value="${bean.code}" class="inputTextStyle">
                                    </td>
                                    <td width="11%">业务员:</td>
                                    <td width="17%">
                                        <input type="text" name="textfield4" class="inputTextStyle">
                                    </td>
                                    <td width="11%">客户名称:</td>
                                    <td width="17%">
                                        <input type="text" name="cusName" value="${bean.cusName}"
                                               class="inputTextStyle">
                                    </td>
                                    <td width="5%">
                                        <img src="image/s1.gif" width="59" height="22" onclick="submitForm();">
                                    </td>
                                    <td width="10%" align="left">
                                        <img src="image/s2.gif" width="62" height="22" onclick="clearSearchArea()">
                                    </td>
                                    <td width="1%" align="left">&nbsp;</td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>

                <table width="100%" border="0" cellspacing="0" cellpadding="0" id="select_table">
                    <tr>
                        <td height="10" bgcolor="#f7fbfc">&nbsp;</td>
                    </tr>
                    <tr>
                        <td height="11">
                            <img src="image/t1.gif" align="absmiddle">
                            <span style="font-size: 14px; font-weight: bold;">销售单列表</span>
                        </td>
                    </tr>
                    <tr>
                        <td height="16" valign="top"><br/>
                            <img src="image/s3.gif" width="62" height="22"
                                 onclick="javascript:window.location.href='order/toAddOrUpdateOrder'">
                            <img src="image/s7.gif" width="59" height="22" alt="删除按钮" onclick="toDel();">
                        </td>
                    </tr>
                    <tr>
                        <td height="5" valign="top"></td>
                    </tr>
                    <tr>
                        <td id="errorInfo" style="font-size:12px;color:red;">${suc}</td>
                    </tr>
                    <tr>
                        <td height="28" valign="top">
                            <table width="100%" border="0" cellspacing="0" cellpadding="0" id="selectTable_content">
                                <tr>
                                    <td width="40%" height="19" bgcolor="#f2faff" style="font-size: 12px;">&nbsp;
                                        <img src="image/t2.gif" align="absmiddle" width="15" height="16">
                                        <span onclick="exportExcel()" class="pager" style="cursor: pointer">导出</span> |
                                        选择条目:<span id="select_num1">0</span>
                                    </td>
                                    <td width="3%" bgcolor="#f2faff" style="font-size: 12px;">&nbsp;</td>
                                    <td width="57%" bgcolor="#f2faff" align="right" style="font-size: 12px;">
                                        共${pager.totalRecord}条
                                        <span class="pager" onclick="firstPage();" style="cursor: pointer">首页</span>
                                        <span class="pager" onclick="prePage();" style="cursor: pointer">上一页</span>
                                        ${pager.page}/${pager.totalPage}
                                        <span onclick="nextPage()" class="pager" style="cursor: pointer">下一页</span>
                                        <span onclick="lastPage(${pager.totalPage})" class="pager"
                                              style="cursor: pointer">末页</span>
                                        <select name="_pageNum" onchange="toUrl('_pageNum_up','_null');"
                                                id="_pageNum_up">
                                            <c:forEach var="i" begin="1" end="${pager.totalPage}" step="1">
                                                <option value="${i}"
                                                        <c:if test="${pager.page==i}">
                                                            selected="selected"
                                                        </c:if>>第&nbsp;${i}&nbsp;页
                                                </option>
                                            </c:forEach>
                                        </select>
                                        <select name="_pageSize" onchange="toUrl('_null','_pageSize_up')"
                                                id="_pageSize_up">
                                            <option value="5">5条</option>
                                            <option value="6">6条</option>
                                            <option value="7">7条</option>
                                            <option value="8">8条</option>
                                            <option value="9">9条</option>
                                            <option value="10">10条</option>
                                            <option value="15">15条</option>
                                            <option value="20">20条</option>
                                            <option value="25">25条</option>
                                            <option value="30">30条</option>
                                            <option value="50">50条</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="3" bgcolor="#f2faff">
                                        <table width="100%" border="0" cellspacing="0" cellpadding="0"
                                               id="select_row">
                                            <tr>
                                                <td width="4%" height="28" align="center"
                                                    background="image/select_title_title.jpg">
                                                    <input type="checkbox" name="ids" id="ids" onclick="toChange()">
                                                </td>
                                                <td width="15%" align="left" background="image/select_title_title.jpg">
                                                    <strong>销售单号</strong>
                                                </td>
                                                <td width="10%" align="center"
                                                    background="image/select_title_title.jpg">
                                                    <strong>开单日期</strong>
                                                </td>
                                                <td width="14%" align="center"
                                                    background="image/select_title_title.jpg">
                                                    <strong>客户名称</strong>
                                                </td>
                                                <td width="9%" align="center" background="image/select_title_title.jpg">
                                                    <strong>业务员</strong>
                                                </td>
                                                <td width="10%" align="center"
                                                    background="image/select_title_title.jpg">
                                                    <strong>合计</strong>
                                                </td>
                                                <td width="10%" align="center"
                                                    background="image/select_title_title.jpg">
                                                    <strong>整单打折</strong></td>
                                                <td width="9%" align="center" background="image/select_title_title.jpg">
                                                    <strong>应收金额</strong>
                                                </td>
                                                <td width="10%" align="center"
                                                    background="image/select_title_title.jpg">
                                                    <strong>审核人</strong>
                                                </td>
                                                <td width="9%" align="center" background="image/select_title_title.jpg">
                                                    <strong>单据状态</strong>
                                                </td>
                                            </tr>
                                            <c:forEach items="${rows}" var="row">
                                                <tr class="select_content_bg">
                                                    <td align="center">
                                                        <input type="checkbox" name="selectedId" value="${row.id}"
                                                               onclick="updateNum()">
                                                    </td>
                                                    <td><a href="order/toAddOrUpdateOrder?edit_id=${row.id}"
                                                           class="normal">${row.code}</a></td>
                                                    <td align="center">
                                                            ${row.orderDateStr}
                                                    </td>
                                                    <td align="center">${row.cusName}</td>
                                                    <td align="center">${row.seller}</td>
                                                    <td align="center">${row.total}</td>
                                                    <td align="center">${row.agio}</td>
                                                    <td align="center">${row.agioTotal}</td>
                                                    <td align="center">${row.auditor}</td>
                                                    <td align="center">${row.status}</td>
                                                </tr>
                                            </c:forEach>
                                            <tr>
                                                <td colspan="10">&nbsp;</td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                                <tr>
                                    <td width="40%" height="19" bgcolor="#f2faff" style="font-size: 12px;">&nbsp;
                                        <img src="image/t2.gif" align="absmiddle" width="15" height="16">
                                        <span onclick="exportExcel()" class="pager" style="cursor: pointer">导出</span> |
                                        选择条目:<span id="select_num2">0</span>
                                    </td>
                                    <td width="3%" bgcolor="#f2faff" style="font-size: 12px;">&nbsp;</td>
                                    <td width="57%" bgcolor="#f2faff" align="right" style="font-size: 12px;">
                                        共${pager.totalRecord}条
                                        <span class="pager" onclick="firstPage();" style="cursor: pointer">首页</span>
                                        <span class="pager" onclick="prePage();" style="cursor: pointer">上一页</span>
                                        ${pager.page}/${pager.totalPage}
                                        <span onclick="nextPage()" class="pager" style="cursor: pointer">下一页</span>
                                        <span onclick="lastPage()" class="pager" style="cursor: pointer">末页</span>
                                        <select name="_pageNum" onchange="toUrl('_pageNum_down','_null');"
                                                id="_pageNum_down">
                                            <c:forEach var="i" begin="1" end="${pager.totalPage}" step="1">
                                                <option value="${i}"
                                                        <c:if test="${pager.page==i}">
                                                            selected="selected"
                                                        </c:if>>第&nbsp;${i}&nbsp;页
                                                </option>
                                            </c:forEach>
                                        </select>
                                        <select name="_pageSize" onchange="toUrl('_null','_pageSize_down')"
                                                id="_pageSize_down">
                                            <option value="5">5条</option>
                                            <option value="6">6条</option>
                                            <option value="7">7条</option>
                                            <option value="8">8条</option>
                                            <option value="9">9条</option>
                                            <option value="10">10条</option>
                                            <option value="15">15条</option>
                                            <option value="20">20条</option>
                                            <option value="25">25条</option>
                                            <option value="30">30条</option>
                                            <option value="50">50条</option>
                                        </select>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
