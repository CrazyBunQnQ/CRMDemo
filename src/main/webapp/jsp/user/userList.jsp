<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="../../taglibs.jsp" %>
<html>
<head>
    <%
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">
    <title>人事管理</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="css_js/index.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="css_js/jquery/jquery-1.3.2.min.js"></script>
    <script type="text/javascript" src="css_js/commons.js"></script>
    <script src="css_js/popup4exExcel.js" type="text/javascript"></script>
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

        function toEnable() {
            var cbNum = checkBoxNum();
            if (cbNum > 0) {
                document.getElementById("changeStatus").valueOf = ("true");
                document.forms[0].submit();
            }
        }

        function toDisable() {
            var cbNum = checkBoxNum();
            if (cbNum > 0) {
                document.getElementById("changeStatus").valueOf = ("false");
                document.forms[0].submit();
            }
        }
    </script>
</head>
<body onload="initPageSize()">
<form action="user/userList" method="post" name="form1" id="form1">
    <input type="hidden" name="pageNum" value="${pager.page}" id="hiddenPageNum"/>
    <input type="hidden" name="pageSize" value="${pager.pageSize}" id="hiddenPageSize"/>
    <input type="hidden" name="isDel" value="" id="isDel"/>
    <input type="hidden" name="changeStatus" value="" id="changeStatus"/>
    <input type="hidden" name="exportType" value="" id="exportType"/>

    <table width="99%" border="0" cellspacing="0" cellpadding="0" id="index_content">
        <tr>
            <td valign="middle">
                <table width="100%" border="0" cellspacing="0" cellpadding="0" id="index_main_div1">
                    <tr>
                        <td height="21" background="image/index_main_div_titleBg.gif">
                            <img style="margin-left:5px;" src="image/index_main_div_left.gif" width="6" height="2"
                                 align="absmiddle">
                            &nbsp;<span style="font-weight:bold;font-size:12px;">人事管理</span>
                        </td>
                    </tr>
                </table>

                <table width="100%" border="0" cellspacing="0" cellpadding="0" id="index_main_div2">
                    <tr>
                        <td height="21" background="image/index_main_div_titleBg.gif">
                            <img style="margin-left:5px;" src="image/index_main_div_left.gif" width="6" height="2"
                                 align="absmiddle">
                            &nbsp;<span style="font-weight:bold;font-size:12px;">人员搜索</span>
                        </td>
                    </tr>
                    <tr>
                        <td height="56" align="left" valign="top" bgcolor="#f7fbfc">
                            <table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%"
                                   id="selectTable">
                                <tr>
                                    <td width="11%" height="41">用户名:</td>
                                    <td width="17%"><input type="text" name="name" value="${bean.name}"
                                                           class="inputTextStyle"></td>
                                    <td width="11%">中文名</td>
                                    <td width="17%"><input type="text" name="cnname" value="${bean.cnname}"
                                                           class="inputTextStyle"></td>
                                    <td width="11%">&nbsp;</td>
                                    <td width="17%">&nbsp;</td>
                                    <td width="5%">
                                        <img src="image/s1.gif" width="59" height="22" onclick="submitForm()">
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
                            <span style="font-size:14px; font-weight:bold;">人员列表</span></td>
                    </tr>
                    <tr>
                        <td height="16" valign="top"><br/>
                            <img src="image/s3.gif" width="62" height="22"
                                 onclick="javascript:window.location.href='user/toAddOrUpdate'">
                            <img src="image/s7.gif" onclick="toDel()">
                            <img src="image/qiyong.gif" width="59" height="22" onclick="toEnable()">
                            <img src="image/tingyong.gif" width="59" height="22" onclick="toDisable()">
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
                                                <td width="10%" align="left" background="image/select_title_title.jpg">
                                                    <strong>用户名</strong></td>
                                                <td width="10%" align="center"
                                                    background="image/select_title_title.jpg"><strong>中文名</strong></td>
                                                <td width="14%" align="center"
                                                    background="image/select_title_title.jpg"><strong>操作权限组</strong>
                                                </td>
                                                <td width="10%" align="center"
                                                    background="image/select_title_title.jpg"><strong>查询权限组</strong>
                                                </td>
                                                <td width="10%" align="center"
                                                    background="image/select_title_title.jpg"><strong>所属部门</strong></td>
                                                <td width="10%" align="center"
                                                    background="image/select_title_title.jpg"><strong>起始有效期</strong>
                                                </td>
                                                <td width="10%" align="center"
                                                    background="image/select_title_title.jpg"><strong>终止有效期</strong>
                                                </td>
                                                <td width="10%" align="center"
                                                    background="image/select_title_title.jpg"><strong>状态</strong></td>
                                            </tr>
                                            <c:forEach items="${rows}" var="row">
                                                <tr class="select_content_bg">
                                                    <td align="center">
                                                        <input type="checkbox" name="selectedId" value="${row.id}"
                                                               onclick="updateNum();">
                                                    <td align="center">${row.cnname}</td>
                                                    <td align="center">${row.roleName}</td>
                                                    <td align="center">${row.accessGroupName}</td>
                                                    <td align="center">${row.groupName}</td>
                                                    <td align="center">${row.begindateStr}</td>
                                                    <td align="center">${row.enddateStr}</td>
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
