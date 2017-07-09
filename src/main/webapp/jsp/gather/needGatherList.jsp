<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="../../taglibs.jsp" %>
<html>
<head>
    <%
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>销售收款</title>
    <link href="css_js/index.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="css_js/jquery/jquery-1.3.2.min.js"></script>
    <script src="css_js/popup4exExcel.js" type="text/javascript"></script>
    <script src="css_js/commons.js" type="text/javascript"></script>
    <link href="css_js/general.css" rel="stylesheet" type="text/css"></link>
    <script type="text/javascript">
        function initPageSize() {
            $("#ng_status span").click(function () {
                var gatherStatus = $(this).html();

                if (gatherStatus === "全部") {
                    window.location = "gather/gatherList";
                } else {
                    gatherStatus = encodeURI(encodeURI(gatherStatus));
                    window.location = "needGather/needGatherList?status=" + gatherStatus;
                }
            })

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
<form action="needGather/needGatherList" method="post" name="form1" id="form1">
    <input type="hidden" name="page" value="${pager.page}" id="hiddenPageNum"/>
    <input type="hidden" name="pageSize" value="${pager.pageSize}" id="hiddenPageSize"/>
    <input type="hidden" name="isDel" value="" id="isDel"/>
    <input type="hidden" name="exportType" value="" id="exportType"/>
    <table width="99%" border="0" cellspacing="0" cellpadding="0" id="index_content">
        <tr>
            <td valign="middle">
                <table width="100%" border="0" cellspacing="0" cellpadding="0" id="index_main_div1">
                    <tr>
                        <td height="21" background="image/index_main_div_titleBg.gif">
                            <img style="margin-left:5px;" src="image/index_main_div_left.gif" width="6" height="2"
                                 align="absmiddle">
                            &nbsp;<span style="font-weight:bold;font-size:12px;">应收款</span>
                        </td>
                    </tr>
                    <tr>
                        <td height="46" align="left" valign="middle" bgcolor="#f7fbfc"
                            style="font-size:12px;color:#424446;" id="ng_status"> 　　
                            <span <c:if test="${bean.status=='未结清'}">style="color:#FF0000;"</c:if>>未结清</span>
                            <span <c:if test="${bean.status=='已结清'}">style="color:#FF0000;"</c:if>>已结清</span>
                            <span
                                    <c:if test="${bean.status==null||bean.status eq ''}">style="color:#FF0000;"</c:if>>全部</span>
                        </td>
                    </tr>
                </table>

                <table width="100%" border="0" cellspacing="0" cellpadding="0" id="index_main_div2">
                    <tr>
                        <td height="21" background="image/index_main_div_titleBg.gif">
                            <img style="margin-left:5px;" src="image/index_main_div_left.gif" width="6" height="2"
                                 align="absmiddle">
                            &nbsp;<span style="font-weight:bold;font-size:12px;">应收款搜索</span></td>
                    </tr>
                    <tr>
                        <td height="56" align="left" valign="top" bgcolor="#f7fbfc">
                            <table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%"
                                   id="selectTable">
                                <tr>
                                    <td width="11%">销售单号:</td>
                                    <td width="17%"><input type="text" name="saleCode" value="${bean.saleCode}"
                                                           class="inputTextStyle"></td>
                                    <td width="11%">客户名称:</td>
                                    <td width="17%"><input type="text" name="cusName" value="${bean.cusName}"
                                                           class="inputTextStyle"></td>
                                    <td width="11%">产生日期:</td>
                                    <td width="17%"><input type="text" name="createtimeStr"
                                                           value="${bean.createtimeStr}" class="inputTextStyle"></td>
                                    <td width="5%">
                                        <img src="image/s1.gif" width="59" height="22" onclick="submitForm()">
                                    </td>
                                    <td width="10%" align="left">
                                        <img src="image/s2.gif" width="62" height="22" onclick="clearSearchArea()">
                                    </td>
                                    <td width="1%" align="left">&nbsp;</td>
                                </tr>
                                <tr>
                                    <td>所属人:</td>
                                    <td><input type="text" name="ownerUsrName" value="${bean.ownerUsrName}"
                                               class="inputTextStyle"></td>
                                    <td>客户省份:</td>
                                    <td><select name="province" class="selectOptionStyle">
                                        <option value="" selected="selected">---</option>
                                        <option value="1">重要客户</option>
                                        <option value="2">潜在客户</option>
                                    </select></td>
                                    <td>客户城市:</td>
                                    <td><select name="city" class="selectOptionStyle">
                                        <option value="" selected="selected">---</option>
                                        <option value="1">重要客户</option>
                                        <option value="2">潜在客户</option>
                                    </select></td>
                                    <td>&nbsp;</td>
                                    <td align="left">&nbsp;</td>
                                    <td align="left">&nbsp;</td>
                                </tr>
                                <tr>
                                    <td>客户区域名称:</td>
                                    <td><select name="regionName" class="selectOptionStyle">
                                        <option value="" selected="selected">---</option>
                                        <option value="1">重要客户</option>
                                        <option value="2">潜在客户</option>
                                    </select></td>
                                    <td>&nbsp;</td>
                                    <td>&nbsp;</td>
                                    <td>&nbsp;</td>
                                    <td>&nbsp;</td>
                                    <td>&nbsp;</td>
                                    <td align="left">&nbsp;</td>
                                    <td align="left">&nbsp;</td>
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
                            <span style="font-size:14px; font-weight:bold;">应收款列表</span></td>
                    </tr>
                    <tr>
                        <td height="16" valign="top"><br/>
                            <img src="image/s3.gif" width="62" height="22">
                        </td>
                    </tr>
                    <tr>
                        <td height="5" valign="top"></td>
                    </tr>
                    <tr>
                        <td id="errorInfo" style="font-size: 12px;color:red;">${suc}</td>
                    </tr>
                    <tr>
                        <td height="28" valign="top">
                            <table width="100%" border="0" cellspacing="0" cellpadding="0" id="selectTable_content">
                                <tr>
                                    <td width="40%" height="19" bgcolor="#f2faff" style="font-size: 12px;">&nbsp;
                                        <img src="image/t2.gif" align="absmiddle" width="15" height="16">
                                        <span onclick="exportExcel()" class="pager" style="cursor: pointer">
                                            &nbsp;导出&nbsp;
                                        </span>
                                        |&nbsp;选择条目:&nbsp;
                                        <span id="select_num1">0</span>
                                    </td>
                                    <td width="3%" bgcolor="#f2faff" style="font-size: 12px;">&nbsp;</td>
                                    <td width="57%" bgcolor="#f2faff" align="right" style="font-size: 12px;">
                                        共${pager.totalRecord}条&nbsp;
                                        <span class="pager" onclick="firstPage();" style="cursor: pointer">首页</span>&nbsp;
                                        <span class="pager" onclick="prePage();" style="cursor: pointer">上一页</span>&nbsp;
                                        ${pager.page}/${pager.totalPage}&nbsp;
                                        <span onclick="nextPage()" class="pager" style="cursor: pointer">下一页</span>&nbsp;
                                        <span onclick="lastPage(${pager.totalPage})" class="pager"
                                              style="cursor: pointer">末页</span>&nbsp;
                                        <select name="_pageNum" onchange="toUrl('_pageNum_up','_null');"
                                                id="_pageNum_up">
                                            <c:forEach var="i" begin="1" end="${pager.totalPage}" step="1">
                                                <option value="${i}"
                                                        <c:if test="${pager.page==i}">
                                                            selected="selected"
                                                        </c:if>>第&nbsp;${i}&nbsp;页
                                                </option>
                                            </c:forEach>
                                        </select>&nbsp;
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
                                        <table width="100%" border="0" cellspacing="0" cellpadding="0" id="select_row">
                                            <tr>
                                                <td width="4%" height="28" align="center"
                                                    background="image/select_title_title.jpg">
                                                    <input type="checkbox" name="ids" id="ids" onclick="toChange()">
                                                </td>
                                                <td width="15%" align="center"
                                                    background="image/select_title_title.jpg">
                                                    <strong>销售单号</strong></td>
                                                <td width="10%" align="center"
                                                    background="image/select_title_title.jpg"><strong>客户名称</strong></td>
                                                <td width="14%" align="center"
                                                    background="image/select_title_title.jpg"><strong>产生日期</strong>
                                                </td>
                                                <td width="9%" align="center"
                                                    background="image/select_title_title.jpg"><strong>应收金额</strong>
                                                </td>
                                                <td width="10%" align="center"
                                                    background="image/select_title_title.jpg"><strong>已收金额</strong></td>
                                                <td width="10%" align="center"
                                                    background="image/select_title_title.jpg"><strong>应收余额</strong>
                                                </td>
                                                <td width="9%" align="center"
                                                    background="image/select_title_title.jpg"><strong>是否完成</strong>
                                                </td>
                                                <td width="10%" align="center"
                                                    background="image/select_title_title.jpg"><strong>所属人</strong>
                                                </td>
                                                <td width="9%" align="center"
                                                    background="image/select_title_title.jpg"><strong>状态</strong></td>
                                            </tr>
                                            <c:forEach items="${rows}" var="row">
                                                <tr class="select_content_bg">
                                                    <td align="center">
                                                        <input type="checkbox" name="selectedId" value="${row.id}"
                                                               onclick="updateNum();">
                                                    <td align="center">${row.saleCode}</td>
                                                    <td align="center">${row.cusName}</td>
                                                    <td align="center">${row.createtimeStr}</td>
                                                    <td align="center">${row.total}</td>
                                                    <td align="center">${row.payed}</td>
                                                    <td align="center">${row.balance}</td>
                                                    <td align="center">${row.overFlag}</td>
                                                    <td align="center">${row.ownerUsr}</td>
                                                    <td align="center">${row.status}</td>
                                                </tr>
                                            </c:forEach>
                                            <tr>
                                                <td colspan="5">&nbsp;</td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                                <tr>
                                    <td width="40%" height="19" bgcolor="#f2faff" style="font-size: 12px;">&nbsp;
                                        <img src="image/t2.gif" align="absmiddle" width="15" height="16">
                                        <span onclick="exportExcel()" class="pager" style="cursor: pointer">
                                            &nbsp;导出&nbsp;
                                        </span>
                                        |&nbsp;选择条目:&nbsp;
                                        <span id="select_num2">0</span>
                                    </td>
                                    <td width="3%" bgcolor="#f2faff" style="font-size: 12px;">&nbsp;</td>
                                    <td width="57%" bgcolor="#f2faff" align="right" style="font-size: 12px;">
                                        共${pager.totalRecord}条&nbsp;
                                        <span class="pager" onclick="firstPage();" style="cursor: pointer">首页</span>&nbsp;
                                        <span class="pager" onclick="prePage();" style="cursor: pointer">上一页</span>&nbsp;
                                        ${pager.page}/${pager.totalPage}&nbsp;
                                        <span onclick="nextPage()" class="pager" style="cursor: pointer">下一页</span>&nbsp;
                                        <span onclick="lastPage(${pager.totalPage})" class="pager"
                                              style="cursor: pointer">末页</span>&nbsp;
                                        <select name="_pageNum" onchange="toUrl('_pageNum_up','_null');"
                                                id="_pageNum_up">
                                            <c:forEach var="i" begin="1" end="${pager.totalPage}" step="1">
                                                <option value="${i}"
                                                        <c:if test="${pager.page==i}">
                                                            selected="selected"
                                                        </c:if>>第&nbsp;${i}&nbsp;页
                                                </option>
                                            </c:forEach>
                                        </select>&nbsp;
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
