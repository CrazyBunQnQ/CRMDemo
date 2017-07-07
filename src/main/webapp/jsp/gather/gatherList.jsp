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
<form name="load4NeedGatherMain.action" method="post" name="form1" id="form1">
    <input type="hidden" name="pageNum" value="${pager.page}" id="hiddenPageNum"/>
    <input type="hidden" name="pageSize" value="${pageSize}" id="hiddenPageSize"/>
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
                            &nbsp;<span style="font-weight:bold;font-size:12px;">应收款</span></td>
                    </tr>
                    <tr>
                        <td height="46" align="left" valign="middle" bgcolor="#f7fbfc"
                            style="font-size:12px;color:#424446;"> 　　
                            <span style="color:#FF0000"> </span>未结清　　
                            <span style="color:#FF0000"> 已结清</span></td>
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
                                    <td width="17%"><input type="text" name="textfield" class="inputTextStyle"></td>
                                    <td width="11%">客户名称:</td>
                                    <td width="17%"><input type="text" name="textfield4" class="inputTextStyle"></td>
                                    <td width="11%">产生日期:</td>
                                    <td width="17%"><input type="text" name="textfield42" class="inputTextStyle"></td>
                                    <td width="5%"><img src="image/s1.gif" width="59" height="22"></td>
                                    <td width="10%" align="left"><img src="image/s2.gif" width="62" height="22"></td>
                                    <td width="1%" align="left">&nbsp;</td>
                                </tr>
                                <tr>
                                    <td>所属人:</td>
                                    <td><input type="text" name="textfield2" class="inputTextStyle"></td>
                                    <td>客户省份:</td>
                                    <td><select name="select2" class="selectOptionStyle">
                                        <option value="-1" selected="selected">---</option>
                                        <option value="1">重要客户</option>
                                        <option value="2">潜在客户</option>
                                    </select></td>
                                    <td>客户城市:</td>
                                    <td><select name="select" class="selectOptionStyle">
                                        <option value="-1" selected="selected">---</option>
                                        <option value="1">重要客户</option>
                                        <option value="2">潜在客户</option>
                                    </select></td>
                                    <td>&nbsp;</td>
                                    <td align="left">&nbsp;</td>
                                    <td align="left">&nbsp;</td>
                                </tr>
                                <tr>
                                    <td>客户区域名称:</td>
                                    <td><select name="select3" class="selectOptionStyle">
                                        <option value="-1" selected="selected">---</option>
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
                            <span style="font-size:14; font-weight:bold;">应收款列表</span>
                        </td>
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
                        <td height="28" valign="top">
                            <table width="100%" border="0" cellspacing="0" cellpadding="0" id="selectTable_content">
                                <tr>
                                    <td width="40%" height="19" bgcolor="#f2faff" style="font-size: 12px;">&nbsp;
                                        <img src="image/t2.gif" align="absmiddle" width="15" height="16">
                                        <span onclick="exportExcel()" class="pager" style="cursor: pointer">导出</span> |
                                        选择条目:
                                        <span id="select_num1">0</span>
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
                                            <%--<s:bean name="org.apache.struts2.util.Counter" id="counter">
                                                <s:param name="first" value="0"/>
                                                <s:param name="last" value="#request.pager.totalPage-1"/>
                                                <s:iterator>
                                                    <s:if test="#counter.current==#request.pager.page">
                                                        <option value="${counter.current}" selected="selected">
                                                            第${counter.current}页
                                                        </option>
                                                    </s:if>
                                                    <s:else>
                                                        <option value="${counter.current}">第${counter.current}页</option>
                                                    </s:else>
                                                </s:iterator>
                                            </s:bean>--%>
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
                                        <table width="100%" border="0" cellspacing="0" cellpadding="0" id="select_row">
                                            <tr>
                                                <td width="4%" height="28" align="center"
                                                    background="image/select_title_title.jpg">
                                                    <input type="checkbox" name="checkbox" value="checkbox">
                                                </td>
                                                <td width="15%" align="left" background="image/select_title_title.jpg">
                                                    <strong>销售单号</strong></td>
                                                <td width="10%" align="center"
                                                    background="image/select_title_title.jpg">
                                                    <strong>客户名称</strong></td>
                                                <td width="14%" align="center"
                                                    background="image/select_title_title.jpg">
                                                    <strong>产生日期</strong>
                                                </td>
                                                <td width="9%" align="center" background="image/select_title_title.jpg">
                                                    <strong>应收金额</strong></td>
                                                <td width="10%" align="center"
                                                    background="image/select_title_title.jpg">
                                                    <strong>已收金额</strong>
                                                </td>
                                                <td width="10%" align="center"
                                                    background="image/select_title_title.jpg">
                                                    <strong>应收余额</strong>
                                                </td>
                                                <td width="9%" align="center" background="image/select_title_title.jpg">
                                                    <strong>是否完成</strong></td>
                                                <td width="10%" align="center"
                                                    background="image/select_title_title.jpg">
                                                    <strong>所属人</strong></td>
                                                <td width="9%" align="center" background="image/select_title_title.jpg">
                                                    <strong>收款</strong></td>
                                            </tr>

                                            <s:iterator value="#request.needGatherList" id="bneedGather">
                                                <tr class="select_content_bg">
                                                    <td align="center"><s:if test="#session.needGather_ids==null">

                                                        <input type="checkbox" name="needGather_id"
                                                               value="${bneedGather.id}">
                                                    </s:if> <s:else>
                                                        <s:set name="flag" value="1"/>
                                                        <s:iterator value="#session.needGather_ids" id="c_ids">
                                                            <s:if test="#c_ids==#bneedGather.id">
                                                                <input type="checkbox" name="needGather_id"
                                                                       value="${bneedGather.id}" checked="checked">
                                                                <s:set name="flag" value="0"/>
                                                            </s:if>
                                                        </s:iterator>
                                                        <s:if test="#flag == 1">
                                                            <input type="checkbox" name="needGather_id"
                                                                   value="${bneedGather.id}">
                                                        </s:if>
                                                    </s:else></td>
                                                    <td>${bneedGather.saleCode}</td>
                                                    <td align="center">${bneedGather.CName}</td>
                                                    <td align="center"><s:date name="#bneedGather.buildDate"
                                                                               format="yyyy-MM-dd HH:mm:ss"
                                                                               nice="false"/></td>
                                                    <td align="center">${bneedGather.total}</td>
                                                    <td align="center">${bneedGather.payed}</td>
                                                    <td align="center">${bneedGather.balance}</td>
                                                    <td align="center">${bneedGather.overFlag}</td>
                                                    <td align="center">${bneedGather.creator}</td>
                                                    <td align="center">
                                                        <s:if test="#bneedGather.BGather==null">
                                                            <a href="load4AddGather.action?CId=${bneedGather.CId}"
                                                               class="normal">收款</a>
                                                        </s:if>
                                                        <s:elseif test="#bneedGather.overFlag == 'Y'">
                                                            <a href="load4EditGather.action?edit_id=${bneedGather.BGather.id}&CId=${bneedGather.CId}"
                                                               class="normal">已收款</a>
                                                        </s:elseif>
                                                        <s:else>
                                                            <a href="load4EditGather.action?edit_id=${bneedGather.BGather.id}&CId=${bneedGather.CId}"
                                                               class="normal">收款中</a>
                                                        </s:else>
                                                    </td>
                                                </tr>
                                            </s:iterator>

                                            <tr>
                                                <td colspan="10">&nbsp;</td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                                <tr>
                                    <td width="40%" height="19" bgcolor="#f2faff" style="font-size: 12px;">&nbsp;
                                        <img src="image/t2.gif" align="absmiddle" width="15" height="16"> 导出 |
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
                                            <%--<s:bean name="org.apache.struts2.util.Counter" id="counter">
                                                <s:param name="first" value="0"/>
                                                <s:param name="last" value="#request.pager.totalPage-1"/>
                                                <s:iterator>
                                                    <s:if test="#counter.current==#request.pager.page">
                                                        <option value="${counter.current}" selected="selected">
                                                            第${counter.current}页
                                                        </option>
                                                    </s:if>
                                                    <s:else>
                                                        <option value="${counter.current}">第${counter.current}页</option>
                                                    </s:else>
                                                </s:iterator>
                                            </s:bean>--%>
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
