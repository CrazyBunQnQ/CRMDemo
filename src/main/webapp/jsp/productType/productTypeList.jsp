<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> --%>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="../../taglibs.jsp" %>
<html>
<head>
    <%
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="css_js/index.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="css_js/jquery/jquery-1.3.2.min.js"></script>
    <script src="css_js/popup4exExcel.js" type="text/javascript"></script>
    <link href="css_js/general.css" rel="stylesheet" type="text/css"></link>
    <title>商品类别列表</title>
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

        function toDel() {
            var cbNum = checkBoxNum();
            if (cbNum > 0) {
                if (window.confirm("确定删除？")) {

                    document.getElementById("isDel").value = "del";
                    document.forms[0].submit();
                }
            }
        }

        //判断列表复选框选中个数是否大于0，是：返回个数，否：返回0
        function checkBoxNum() {
            if ($("input[name='productType_id']:checked").length > 0) {
                return $("input[name='productType_id']:checked").length;
            } else {
                return 0;
            }
        }

        //当选择 每页多少的option的时候   调用该方法 将option的 value值 保存到隐藏域中(hiddenPageSize)
        function toUrl(pageNumId, pageSizeId) {
            var _pageNum, _pageSize;
            if (pageNumId != "_null") {
                _pageNum = document.getElementById(pageNumId);
            } else {
                _pageNum = document.getElementById("_pageNum_up");
            }
            var hiddenPageNum = document.getElementById("hiddenPageNum");
            if ("" != hiddenPageNum.value) {
                hiddenPageNum.value = _pageNum.options[_pageNum.selectedIndex].value;
            }
            if (pageSizeId != "_null") {
                _pageSize = document.getElementById(pageSizeId);
            } else {
                _pageSize = document.getElementById("_pageSize_up");
            }
            var hiddenPageSize = document.getElementById("hiddenPageSize");
            if ("" != hiddenPageSize.value) {
                hiddenPageSize.value = _pageSize.options[_pageSize.selectedIndex].value;
            }
            document.forms[0].submit();
        }

        function nextPage() {
            var hiddenPageNum = document.getElementById("hiddenPageNum");
            var totalPage =${pager.totalPage};
            if (hiddenPageNum.value >= totalPage) {
                //当页号大于总页数的时候 不能在点击下一页
                return;
            }
            if ("" != hiddenPageNum.value) {
                //将隐藏域的值设置下一页的页号
                hiddenPageNum.value = hiddenPageNum.value - 0 + 1;
                document.forms[0].submit();
            }
        }

        function prePage() {
            var hiddenPageNum = document.getElementById("hiddenPageNum");
            if ("" != hiddenPageNum.value) {
                hiddenPageNum.value = hiddenPageNum.value - 0;

                if (hiddenPageNum.value == 1) {
                    //当是第一页的话   不能点击发送请求
                    return;
                }

                if (hiddenPageNum.value > 1) {
                    hiddenPageNum.value -= 1;
                }
                document.forms[0].submit();
            }
        }

        function firstPage() {
            var hiddenPageNum = document.getElementById("hiddenPageNum");
            if ("" != hiddenPageNum.value) {
                hiddenPageNum.value = 1;
                document.forms[0].submit();
            }
        }

        function lastPage() {
            var hiddenPageNum = document.getElementById("hiddenPageNum");
            if ("" != hiddenPageNum.value) {
                hiddenPageNum.value = ${pager.totalPage};
                document.forms[0].submit();
            }
        }

        function submitForm() {
            document.forms[0].submit();
        }

        function resetForm() {
            document.forms[0].reset();
        }

        function exportExcel() {
            loadPopup_excel('导出Excel');
        }

        function openTreeWindow() {
            //window.open("optionTreeWidnow","_blank");
            window.location = "optionTreeWidnow";
        }

        //清除搜索区域内容
        function clearSearchArea() {
            $("#selectTable input").val("");

        }

        //更改“选择条目”的数目
        function updateNum() {
            var num = $("input[name='productType_id']:checked").length;
            $("#select_num").html(num);
            $("#select_num2").html(num);
        }

        //点击全选  checkbox的时候
        function toChange() {
            var num = $("#ids:checked").length;
            if (num == 0) {
                $("input[name='productType_id']").attr("checked", false);
            } else {
                $("input[name='productType_id']").attr("checked", "checked");
            }
            updateNum();
        }
    </script>
</head>


<body>
<form action="${contextPath }/productType/productTypeList" method="post" name="form1" id="form1">
    <input type="hidden" name="page" value="${pager.page}" id="hiddenPageNum"/>
    <input type="hidden" name="pageSize" value="${pager.pageSize}" id="hiddenPageSize"/>
    <input type="hidden" name="isDel" value="" id="isDel"/>
    <input type="hidden" name="exportType" value="" id="exportType"/>
    <!-- </form>	 -->
    <table width="99%" border="0" cellspacing="0" cellpadding="0" id="index_main_table">
        <tr>
            <td height="26" width="100%"><span style="color:#002450; font-size:13px; font-weight:bold;">　商品类别</span>
            </td>
        </tr>
    </table>
    <table width="99%" border="0" cellspacing="0" cellpadding="0" id="index_content">
        <tr>
            <td valign="middle">
                <table width="100%" border="0" cellspacing="0" cellpadding="0" id="index_main_div1">
                    <tr>
                        <td height="21" background="image/index_main_div_titleBg.gif"><img
                                style="margin-left:5px;" src="image/index_main_div_left.gif" width="6"
                                height="2" align="absmiddle">&nbsp;<span
                                style="font-weight:bold;font-size:12px;">商品类别搜索</span></td>
                    </tr>
                    <tr>
                        <td height="56" align="left" valign="top" bgcolor="#f7fbfc">
                            <table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%"
                                   id="selectTable">
                                <tr>
                                    <td width="10%">商品类别编码:</td>
                                    <td width="25%">
                                        <input type="text" name="code" class="inputTextStyle"
                                               value="${productType.code}"></td>
                                    <td width="10%">商品类别名称:</td>
                                    <td width="27%"><input type="text" name="name" class="inputTextStyle"
                                                           value="${productType.name}"></td>
                                    <td width="7%"><img src="image/s1.gif" width="59"
                                                        height="22" onclick="submitForm()" alt="搜索按钮"></td>
                                    <td width="16%" align="left"><img src="image/s2.gif" width="62"
                                                                      height="22" onclick="clearSearchArea();"></td>
                                    <td width="5%" align="left">&nbsp;</td>
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
                        <td height="11"><img src="image/t1.gif" align="absmiddle"> <span
                                style="font-size:14px; font-weight:bold;">商品类别列表</span></td>
                    </tr>
                    <tr>
                        <td height="16" valign="top"><br/>
                            <img src="image/s3.gif" width="62" height="22"
                                 onclick="javascript:window.location.href='${contextPath}/productType/toAddProductType'"><img
                                    src="image/s7.gif" width="59" height="22" alt="删除按钮"
                                    onclick="toDel();"><img src="image/shuxing.gif"
                                                            onclick="openTreeWindow();" width="62" height="22"/></td>
                    </tr>
                    <tr>
                        <td height="5" valign="top">=</td>
                    </tr>
                    <tr>
                        <td height="28" valign="top">
                            <table width="100%" border="0" cellspacing="0" cellpadding="0" id="selectTable_content">
                                <tr>
                                    <td width="40%" height="19" bgcolor="#f2faff"
                                        style="font-size: 12px;">&nbsp;<img src="image/t2.gif"
                                                                            align="absmiddle" width="15" height="16">

                                        <span onclick="exportExcel()"
                                              class="pager" style="cursor: pointer">导出 </span>

                                        | 选择条目:<span id="select_num">0</span>

                                    </td>
                                    <td width="3%" bgcolor="#f2faff" style="font-size: 12px;">&nbsp;</td>
                                    <td width="57%" bgcolor="#f2faff" align="right"
                                        style="font-size: 12px;">共${pager.totalRecord}条 <span
                                            class="pager" onclick="firstPage();" style="cursor: pointer">首页</span>
                                        <span class="pager" onclick="prePage();" style="cursor: pointer">上一页</span>
                                        ${pager.page}/${pager.totalPage} <span onclick="nextPage()"
                                                                               class="pager"
                                                                               style="cursor: pointer">下一页</span> <span
                                                onclick="lastPage()" class="pager" style="cursor: pointer">末页</span>
                                        <select name="_pageNum" onchange="toUrl('_pageNum_up','_null');"
                                                id="_pageNum_up">
                                            <c:forEach var="i" begin="1" end="${pager.totalPage}" step="1">

                                                <option value="${i}"
                                                        <c:if test="${pager.page==i}">selected="selected"</c:if>>第${i}页
                                                </option>
                                            </c:forEach>


                                            <%-- <s:bean name="org.apache.struts2.util.Counter" id="counter">
                                                <s:param name="first" value="0" />
                                                <s:param name="last" value="#request.pager.totalPage-1" />
                                                <s:iterator>
                                                    <s:if test="#counter.current==#request.pager.page">
                                                        <option value="${counter.current}" selected="selected">第${counter.current}页</option>
                                                    </s:if>
                                                    <s:else>
                                                        <option value="${counter.current}">第${counter.current}页</option>
                                                    </s:else>
                                                </s:iterator>
                                            </s:bean> --%>
                                        </select> <select name="_pageSize" onchange="toUrl('_null','_pageSize_up')"
                                                          id="_pageSize_up">
                                            <option value="5"
                                                    <c:if test="${pager.pageSize==5}">selected="selected"</c:if>>5条
                                            </option>
                                            <option value="6"
                                                    <c:if test="${pager.pageSize==6}">selected="selected"</c:if>>6条
                                            </option>
                                            <option value="7"
                                                    <c:if test="${pager.pageSize==7}">selected="selected"</c:if>>7条
                                            </option>
                                            <option value="8"
                                                    <c:if test="${pager.pageSize==8}">selected="selected"</c:if>>8条
                                            </option>
                                            <option value="9"
                                                    <c:if test="${pager.pageSize==9}">selected="selected"</c:if>>9条
                                            </option>
                                            <option value="10"
                                                    <c:if test="${pager.pageSize==10}">selected="selected"</c:if>>10条
                                            </option>
                                            <option value="15"
                                                    <c:if test="${pager.pageSize==15}">selected="selected"</c:if>>15条
                                            </option>
                                            <option value="20"
                                                    <c:if test="${pager.pageSize==20}">selected="selected"</c:if>>20条
                                            </option>
                                            <option value="25"
                                                    <c:if test="${pager.pageSize==25}">selected="selected"</c:if>>25条
                                            </option>
                                            <option value="30"
                                                    <c:if test="${pager.pageSize==30}">selected="selected"</c:if>>30条
                                            </option>
                                            <option value="50"
                                                    <c:if test="${pager.pageSize==50}">selected="selected"</c:if>>50条
                                            </option>
                                        </select></td>
                                </tr>
                                <tr>
                                    <td colspan="3" bgcolor="#f2faff">
                                        <table width="100%" border="0" cellspacing="0" cellpadding="0" id="select_row">
                                            <tr>
                                                <td width="4%" height="28" align="center"
                                                    background="image/select_title_title.jpg"><input
                                                        type="checkbox" name="ids" id="ids" onclick="toChange()"></td>
                                                <td width="12%" align="left"
                                                    background="image/select_title_title.jpg"><strong>商品类别名称</strong>
                                                </td>
                                                <td width="29%" align="center"
                                                    background="image/select_title_title.jpg"><strong>商品类别编码</strong><strong></strong>
                                                </td>
                                                <td width="21%" align="center"
                                                    background="image/select_title_title.jpg"><strong>上一级</strong>
                                                </td>
                                                <td width="34%" align="center"
                                                    background="image/select_title_title.jpg">
                                                    <strong>备注</strong><strong></strong></td>
                                            </tr>

                                            <c:forEach items="${rows}" var="productType">
                                                <tr class="select_content_bg">
                                                    <td align="center">

                                                        <input type="checkbox" name="productType_id"
                                                               value="${productType.id}" onclick="updateNum();">
                                                    </td>
                                                    <td>${productType.name}</td>
                                                    <td align="center">${productType.code}</td>
                                                    <td align="center">
                                                            ${productType.fatherName}
                                                    </td>
                                                    <td align="center">${productType.remark}</td>
                                                </tr>
                                            </c:forEach>

                                            <%--                                   	<s:iterator value="#request.productTypeList"
                                                                            id="bproductType">

                                                                            <tr class="select_content_bg">
                                                                                <td align="center">
                                                                                <s:if test="#session.productType_ids==null">

                                                                                    <input type="checkbox" name="productType_id" value="${bproductType.id}">
                                                                                </s:if>
                                                                                <s:else>
                                                                                    <s:set name="flag" value="1" />
                                                                                    <s:iterator value="#session.productType_ids" id="c_ids">
                                                                                        <s:if test="#c_ids==#bproductType.id">
                                                                                            <input type="checkbox" name="productType_id"
                                                                                                value="${bproductType.id}" checked="checked">
                                                                                            <s:set name="flag" value="0" />
                                                                                        </s:if>
                                                                                    </s:iterator>
                                                                                    <s:if test="#flag == 1">
                                                                                        <input type="checkbox" name="productType_id"
                                                                                            value="${bproductType.id}">
                                                                                    </s:if>
                                                                                </s:else>
                                                                                </td>
                                                                                <td>${bproductType.name}</td>
                                                                                <td align="center">${bproductType.code}</td>
                                                                                <td align="center">
                                                                                    <s:iterator value="#request.productTypeList" id="bproductType_tmp">
                                                                                        <s:if test="#bproductType_tmp.id == #bproductType.pid">
                                                                                            ${bproductType_tmp.name}
                                                                                        </s:if>
                                                                                    </s:iterator>
                                                                                </td>
                                                                                <td align="center">${bproductType.remark}</td>
                                                                              </tr>
                                                                              </s:iterator> --%>


                                            <tr>
                                                <td colspan="5">&nbsp;</td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                                <tr>
                                    <td width="40%" height="19" bgcolor="#f2faff"
                                        style="font-size: 12px;">&nbsp;<img src="image/t2.gif"
                                                                            align="absmiddle" width="15" height="16"> 导出
                                        | 选择条目:<span id="select_num2">0</span></td>
                                    <td width="3%" bgcolor="#f2faff" style="font-size: 12px;">&nbsp;</td>
                                    <td width="57%" bgcolor="#f2faff" align="right"
                                        style="font-size: 12px;">共${pager.totalRecord}条 <span
                                            class="pager" onclick="firstPage();" style="cursor: pointer">首页</span>
                                        <span class="pager" onclick="prePage();" style="cursor: pointer">上一页</span>
                                        ${pager.page}/${pager.totalPage} <span onclick="nextPage()"
                                                                               class="pager"
                                                                               style="cursor: pointer">下一页</span> <span
                                                onclick="lastPage()" class="pager" style="cursor: pointer">末页</span>
                                        <select name="_pageNum" onchange="toUrl('_pageNum_down','_null');"
                                                id="_pageNum_down">
                                            <%-- <s:bean name="org.apache.struts2.util.Counter" id="counter">
                                                <s:param name="first" value="0" />
                                                <s:param name="last" value="#request.pager.totalPage-1" />
                                                <s:iterator>
                                                    <s:if test="#counter.current==#request.pager.page">
                                                        <option value="${counter.current}" selected="selected">第${counter.current}页</option>
                                                    </s:if>
                                                    <s:else>
                                                        <option value="${counter.current}">第${counter.current}页</option>
                                                    </s:else>
                                                </s:iterator>
                                            </s:bean> --%>
                                            <c:forEach var="i" begin="1" end="${pager.totalPage}" step="1">

                                                <option value="${i}"
                                                        <c:if test="${pager.page==i}">selected="selected"</c:if>>第${i}页
                                                </option>
                                            </c:forEach>
                                        </select> <select name="_pageSize"
                                                          onchange="toUrl('_null','_pageSize_down')"
                                                          id="_pageSize_down">
                                            <option value="5"
                                                    <c:if test="${pager.pageSize==5}">selected="selected"</c:if>>5条
                                            </option>
                                            <option value="6"
                                                    <c:if test="${pager.pageSize==6}">selected="selected"</c:if>>6条
                                            </option>
                                            <option value="7"
                                                    <c:if test="${pager.pageSize==7}">selected="selected"</c:if>>7条
                                            </option>
                                            <option value="8"
                                                    <c:if test="${pager.pageSize==8}">selected="selected"</c:if>>8条
                                            </option>
                                            <option value="9"
                                                    <c:if test="${pager.pageSize==9}">selected="selected"</c:if>>9条
                                            </option>
                                            <option value="10"
                                                    <c:if test="${pager.pageSize==10}">selected="selected"</c:if>>10条
                                            </option>
                                            <option value="15"
                                                    <c:if test="${pager.pageSize==15}">selected="selected"</c:if>>15条
                                            </option>
                                            <option value="20"
                                                    <c:if test="${pager.pageSize==20}">selected="selected"</c:if>>20条
                                            </option>
                                            <option value="25"
                                                    <c:if test="${pager.pageSize==25}">selected="selected"</c:if>>25条
                                            </option>
                                            <option value="30"
                                                    <c:if test="${pager.pageSize==30}">selected="selected"</c:if>>30条
                                            </option>
                                            <option value="50"
                                                    <c:if test="${pager.pageSize==50}">selected="selected"</c:if>>50条
                                            </option>
                                        </select></td>
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