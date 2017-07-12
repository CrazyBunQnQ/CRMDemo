<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="../../taglibs.jsp" %>
<html>
<head>
    <%
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="css_js/commons.js"></script>
    <script type="text/javascript" src="css_js/jquery/jquery-1.3.2.min.js"></script>
    <script src="css_js/popup4TouchTem.js" type="text/javascript"></script>
    <link href="css_js/general.css" rel="stylesheet" type="text/css"></link>

    <title>辅助信息</title>
    <style type="text/css">
        * {
            font-size: 12px;
        }
    </style>
    <script language="javascript">
        function move(fromObj, toObj) {
            for (var i = 0; i < fromObj.length; i++) {
                if (fromObj[i].selected) {
                    var op = document.createElement("option");
                    op.value = fromObj.options[fromObj.selectedIndex].value;
                    op.text = fromObj.options[fromObj.selectedIndex].text;
                    toObj.options.add(op);
                    fromObj.remove(i);
                    i--;
                }
            }
        }

        function moveAll(fromObj, toObj) {
            for (var i = 0; i < fromObj.length; i++) {
                var op = document.createElement("option");
                op.value = fromObj.options[i].value;
                op.text = fromObj.options[i].text;
                toObj.options.add(op);
                fromObj.remove(i);
                i--;
            }
        }

        function returnVal() {
            var o = document.getElementById('right_select');
            var val = "";
            for (var i = 0; i < o.length; i++) {
                val += o.options[i].value + ",";
            }
            if (val.length > 0) {
                val = val.substring(0, val.length - 1);
            }
            if (val != "") {
                document.getElementById("_ids").value = val;
            }
            document.forms[0].submit();
            window.close();
        }
    </script>
</head>
<body>
<form name="form1" method="post" action="group/setUserGroup">
    <input type="hidden" name="ids" id="_ids" value="${ids}"/>
    <input type="hidden" name="id" id="id" value="${id}"/>
    <table width="99%" border="0" cellspacing="0" cellpadding="0" id="index_main_table">
        <tr>
            <td height="26" width="100%"><span style="color:#002450; font-size:13px; font-weight:bold;">　选择相关辅助信息</span>
            </td>
        </tr>
        <tr>
            <td style="font-size: 12px; color: red;">${suc}</td>
        </tr>
    </table>

    <table width="99%" border="0" cellspacing="0" cellpadding="0" id="index_content">
        <tr>
            <td height="12"></td>
        </tr>
        <tr>
            <td valign="middle">
                <img src="image/queding.gif" width="62" height="22" onclick="returnVal()">
                <img src="image/fanhui.gif" width="59" height="22" onclick="jumpToPage('group/groupList')"></td>
        </tr>

        <tr>
            <td valign="middle">
                <table width="100%" border="0" cellspacing="0" cellpadding="0" id="index_main_div1">
                    <tr>
                        <td height="21" valign="top" background="image/index_main_div_titleBg.gif">
                            <img style="margin-left:5px;" src="image/index_main_div_left.gif" width="6" height="2"
                                 align="absmiddle">
                            &nbsp;<span style="font-weight:bold;font-size:12px;">基本信息</span>
                        </td>
                    </tr>
                    <tr>
                        <td height="56" align="left" valign="top" bgcolor="#f7fbfc">
                            <table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%"
                                   id="selectTable">
                                <tr>
                                    <td width="3%">&nbsp;</td>
                                    <td width="36%">未指定部门:</td>
                                    <td width="19%">&nbsp;</td>
                                    <td width="40%">在当前部门:</td>
                                    <td width="2%">&nbsp;</td>
                                </tr>
                                <tr>
                                    <td width="3%" rowspan="9">&nbsp;</td>
                                    <td rowspan="9" valign="top">
                                        <select name="left_select" id="left_select" size="1" multiple="yes"
                                                style="width:200px;height:250px"
                                                ondblclick="move(document.getElementById('left_select'),document.getElementById('right_select'))">
                                            <c:forEach items="${userList}" var="user">
                                                <option value="${user.id}">${user.name}</option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                    <td width="19%">&nbsp;</td>
                                    <td width="40%" rowspan="9" valign="top">
                                        <select name="right_select" size="1" multiple="yes" id="right_select"
                                                style="width:200px;height:250px"
                                                ondblclick="move(document.getElementById('right_select'),document.getElementById('left_select'))">
                                            <c:forEach items="${curGroupUsers}" var="user">
                                                <option value="${user.id}">${user.name}</option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                    <td width="2%" rowspan="9">&nbsp;</td>
                                </tr>
                                <tr>
                                    <td align="center">&nbsp;</td>
                                </tr>
                                <tr>
                                    <td align="center"><img src="image/youyi.gif" width="49" height="22"
                                                            onClick="move(document.getElementById('left_select'),document.getElementById('right_select'))">
                                    </td>
                                </tr>
                                <tr>
                                    <td align="center"><img src="image/zuoyi.gif" width="49" height="22"
                                                            onClick="move(document.getElementById('right_select'),document.getElementById('left_select'))">
                                    </td>
                                </tr>
                                <tr>
                                    <td align="center"><img src="image/quanbuyouyi.gif" width="97" height="22"
                                                            onClick="moveAll(document.getElementById('left_select'),document.getElementById('right_select'))">
                                    </td>
                                </tr>
                                <tr>
                                    <td align="center"><img src="image/quanbuzuoyi.gif" width="97" height="22"
                                                            onClick="moveAll(document.getElementById('right_select'),document.getElementById('left_select'))">
                                    </td>
                                </tr>
                                <tr>
                                    <td align="center">&nbsp;</td>
                                </tr>
                                <tr>
                                    <td align="center">&nbsp;</td>
                                </tr>
                                <tr>
                                    <td>&nbsp;</td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td valign="middle">&nbsp;</td>
        </tr>
    </table>
</form>
<div id="popupContact" style="display:none;"><a id="popupContactClose">x</a>
    <h1>标题</h1>
    <div id="dictionaryMsg"></div>
    <p id="contactArea">这里是正文</p>
</div>
<div id="backgroundPopup" style="width:100%;height:100%;background:none;"></div>
</body>
</html>