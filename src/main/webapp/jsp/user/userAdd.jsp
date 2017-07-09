<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="../../taglibs.jsp" %>
<html>
<head>
    <%
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script type="text/javascript" src="css_js/jquery/jquery-1.3.2.min.js"></script>
    <script type="text/javascript" src="css_js/commons.js"></script>
    <link href="css_js/index.css" rel="stylesheet" type="text/css"></link>
    <link href="css_js/general.css" rel="stylesheet" type="text/css"></link>
    <link href="css_js/calendar.css" rel="stylesheet" type="text/css"></link>
    <script src="css_js/popup.js" type="text/javascript"></script>
    <script src="css_js/jquery.form.js" type="text/javascript"></script>
    <script src="css_js/cal.js" type="text/javascript"></script>
    <title>新建人员</title>
    <style type="text/css">
        .STYLE1 {
            color: #FF0000
        }
    </style>
    <script type="text/javascript">
        jQuery(document).ready(function () {
            var ids = ["begindateStr", "enddateStr", "birthdayStr", "workdateStr", "finishschooldateStr"];
            var values = ["${bean.begindateStr}", "${bean.enddateStr}", "${bean.birthdayStr}", "${bean.workdateStr}", "${bean.finishschooldateStr}"];
            for (var i = 0; i < ids.length; i++) {
                $('#' + ids[i]).simpleDatepicker({startdate: 1960, enddate: 2060});
                //是否已经有了数据
                if ('' != values[i]) {
                    $('#' + ids[i]).val(values[i]);
                } else {
                    $('#' + ids[i]).val('点击显示时间列表');
                }
                //判断状态显示时间颜色
                if ($('#' + ids[i]).val() != "点击显示时间列表") {
                    $('#' + ids[i]).removeClass("addTimeInit");
                    $('#' + ids[i]).addClass("addTimeClick");
                }
            }
            if ('' != '${bean.createtimeStr}') {
                $('#createtimeStr').val('<s:date name="#request.bean.createtimeStr" format="yyyy-MM-dd HH:mm:ss" nice="false" />');
            }
            else if ('' != '${c_time}') {
                $('#createtimeStr').val('${c_time}');
            } else {
                $('#createtimeStr').val('点击显示时间列表');
            }

            if ('' != '${bean.updatetimeStr}') {
                $('#updatetimeStr').val('<s:date name="#request.bean.updatetimeStr" format="yyyy-MM-dd HH:mm:ss" nice="false" />');
            }
            else if ('' != '${c_time}') {
                $('#updatetimeStr').val('<s:date name="#request.c_time" format="yyyy-MM-dd HH:mm:ss" nice="false" />');
            } else {
                $('#updatetimeStr').val('点击显示时间列表');
            }
        });

        jQuery(document).ready(function () {
            if ('${bean.creator}' != "") {
                $("#creator").val('${bean.creator}');
            } else {
                $("#creator").val('${user.name}');
            }
        });
    </script>

    <script type="text/javascript">
        function checkDate(idStr) {
            if ($('#' + idStr).val() == "点击显示时间列表") {
                $('#' + idStr).val("");
            }
        }

        function submitForm() {
            var ids = ["begindateStr", "enddateStr", "birthdayStr", "workdateStr", "finishschooldateStr"];
            for (var i = 0; i < ids.length; i++) {
                checkDate(ids[i]);
            }
            document.getElementById("userForm").submit();
        }
    </script>
</head>

<body>
<form name="form1" method="post" action="/user/addOrUpdate?" id="userForm">
    <input type="hidden" name="edit_id" id="edit_id" value="${edit_id}"/>
    <table width="99%" border="0" cellspacing="0" cellpadding="0" id="index_main_table">
        <tr>
            <td height="26" width="100%"><span style="color:#002450; font-size:13px; font-weight:bold;">　人员-
                <c:if test="${edit_id == null}">新建</c:if>
                <c:if test="${edit_id != null}">修改</c:if>
            </span>
            </td>
        </tr>
    </table>

    <table width="99%" border="0" cellspacing="0" cellpadding="0" id="index_content">
        <tr>
            <td height="12"></td>
        </tr>
        <tr>
            <td valign="middle">
                <img src="image/s10.gif" width="58" height="22" onclick="submitForm();">
                <img src="image/xiugaimima.gif" width="59" height="22">
                <img src="image/s8.gif" width="59" height="22" onclick="returnList('user/userList')">
            </td>
        </tr>
        <tr>
            <td id="errorInfo" style="font-size:12px;color:red;">${suc}</td>
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
                                   id="selectTable1">
                                <tr>
                                    <td width="8%"><span class="STYLE1">用户名</span>:</td>
                                    <td width="40%">
                                        <input type="text" name="name" value="${bean.name }" class="addCText">
                                    </td>
                                    <td width="10%" align="left"><span class="STYLE1">中文名</span>:</td>
                                    <td width="37%">
                                        <input type="text" name="cnname" class="addCText" value="${bean.cnname }"></td>
                                    <td width="5%">&nbsp;</td>
                                </tr>
                                <tr>
                                    <td><span class="STYLE1">密码</span>:</td>
                                    <td>
                                        <input type="password" name="password" value="${bean.password }"
                                               class="addCText"></td>
                                    <td align="left">推荐人:</td>
                                    <td><input type="text" name="commendman" value="${bean.commendman }"
                                               class="addCText"></td>
                                    <td>&nbsp;</td>
                                </tr>
                                <tr>
                                    <td>移动电话:</td>
                                    <td><input type="text" name="movetelephone" value="${bean.movetelephone }"
                                               class="addCText"></td>
                                    <td align="left">电子邮件:</td>
                                    <td><input type="text" name="email" value="${bean.email }" class="addCText"></td>
                                    <td>&nbsp;</td>
                                </tr>
                                <tr>
                                    <td>家庭地址:</td>
                                    <td><input type="text" name="address" value="${bean.address}" class="addCText">
                                    </td>
                                    <td align="left">家庭电话:</td>
                                    <td><input type="text" name="telephone" value="${bean.telephone }"
                                               class="addCText"></td>
                                    <td>&nbsp;</td>
                                </tr>
                                <tr>
                                    <td>现住宅地址:</td>
                                    <td><input type="text" name="nowaddress" value="${bean.nowaddress }"
                                               class="addCText"></td>
                                    <td align="left">现住宅电话:</td>
                                    <td><input type="text" name="nowtelephone" value="${bean.nowtelephone }"
                                               class="addCText"></td>
                                    <td>&nbsp;</td>
                                </tr>
                                <tr>
                                    <td>身份证号码:</td>
                                    <td><input type="text" name="identitycode" value="${bean.identitycode }"
                                               class="addCText"></td>
                                    <td align="left">社会保险号</td>
                                    <td><input type="text" name="insurancecode" value="${bean.insurancecode }"
                                               class="addCText"></td>
                                    <td>&nbsp;</td>
                                </tr>
                                <tr>
                                    <td>紧急联系人:</td>
                                    <td><input type="text" name="instancylinkman" value="${bean.instancylinkman }"
                                               class="addCText"></td>
                                    <td align="left">紧急联系电话:</td>
                                    <td><input type="text" name="instancytelephone" value="${bean.instancytelephone }"
                                               class="addCText"></td>
                                    <td>&nbsp;</td>
                                </tr>
                                <tr>
                                    <td>起始有效期:</td>
                                    <td><input type="text" name="begindateStr" class="addCText" id="begindateStr"
                                               value="点击显示时间列表" readonly="readonly"></td>
                                    <td align="left">终止有效期:</td>
                                    <td><input type="text" name="enddateStr" class="addCText" id="enddateStr"
                                               value="点击显示时间列表"
                                               readonly="readonly"></td>
                                    <td>&nbsp;</td>
                                </tr>
                                <tr>
                                    <td><span class="STYLE1">操作权限组</span>:</td>
                                    <td><select name="roleId" class="addCText">
                                        <option value="">---</option>
                                        <c:forEach items="${roleList}" var="role">
                                            <option value="${role.id}"
                                                    <c:if test="${bean.roleId} == ${role.id}">
                                                        selected="selected"
                                                    </c:if>>${role.name}</option>
                                        </c:forEach>
                                    </select></td>
                                    <td align="left">
                                        <span class="STYLE1">查询权限组</span>:
                                    </td>
                                    <td><select name="accessGroupId" class="addCText">
                                        <option value="">---</option>
                                        <c:forEach items="${accessGroupList}" var="accessGroup">
                                            <option value="${accessGroup.id}"
                                                    <c:if test="${bean.accessGroupId} == ${accessGroup.id}">
                                                        selected="selected"
                                                    </c:if>>${accessGroup.name}</option>
                                        </c:forEach>
                                    </select></td>
                                    <td>&nbsp;</td>
                                </tr>
                                <tr>
                                    <td height="41"><span class="STYLE1">所属部门</span>:</td>
                                    <td><select name="groupId" class="addCText">
                                        <option value="1">---</option>
                                        <c:forEach items="${groupList}" var="group">
                                            <option value="${group.id}"
                                                    <c:if test="${bean.groupId} == ${group.id}">
                                                        selected="selected"
                                                    </c:if>>${group.name}</option>
                                        </c:forEach>
                                    </select></td>
                                    <td align="left"><span class="STYLE1">状态</span>:</td>
                                    <td>
                                        <input name="status" type="radio" value="1" checked="checked">
                                        启用
                                        <input name="status" type="radio" value="0">
                                        停用
                                    </td>
                                    <td>&nbsp;</td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>

                <table width="100%" border="0" cellspacing="0" cellpadding="0" id="index_main_div2">
                    <tr>
                        <td height="21" valign="top" background="image/index_main_div_titleBg.gif">
                            <img style="margin-left:5px;" src="image/index_main_div_left.gif" width="6" height="2"
                                 align="absmiddle">
                            &nbsp;<span style="font-weight:bold;font-size:12px;">详细信息</span></td>
                    </tr>
                    <tr>
                        <td height="56" align="left" valign="top" bgcolor="#f7fbfc">
                            <table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%"
                                   id="selectTable2">
                                <tr>
                                    <td width="111">性别:</td>
                                    <td width="537">
                                        <input name="sex" type="radio" value="1" checked="checked">
                                        男
                                        <input type="radio" name="sex" value="0">
                                        女
                                    </td>
                                    <td width="135" align="left">出生日期:</td>
                                    <td width="550">
                                        <input type="text" name="birthdayStr" class="addCText" id="birthdayStr"
                                               value="点击显示时间列表" readonly="readonly">
                                    </td>
                                    <td width="17">&nbsp;</td>
                                </tr>
                                <tr>
                                    <td>职员类别:</td>
                                    <td>
                                        <input name="personneltype" type="radio" value="1" checked="checked">
                                        全职
                                        <input type="radio" name="personneltype" value="0">
                                        兼职
                                    </td>
                                    <td align="left">职务:</td>
                                    <td><input type="text" name="duty" value="${bean.duty}" class="addCText"></td>
                                    <td>&nbsp;</td>
                                </tr>
                                <tr>
                                    <td>入职时间:</td>
                                    <td>
                                        <input type="text" name="workdateStr" class="addCText" id="workdateStr"
                                               value="点击显示时间列表" readonly="readonly">
                                    </td>
                                    <td align="left">最高学历:</td>
                                    <td>
                                        <input type="text" name="highschool" value="${bean.highschool}"
                                               class="addCText"></td>
                                    <td>&nbsp;</td>
                                </tr>
                                <tr>
                                    <td>毕业学校:</td>
                                    <td>
                                        <input type="text" name="finishschool" value="${bean.finishschool }"
                                               class="addCText">
                                    </td>
                                    <td align="left">毕业时间:</td>
                                    <td>
                                        <input type="text" name="finishschooldateStr" class="addCText"
                                               id="finishschooldateStr" value="点击显示时间列表" readonly="readonly"></td>
                                    <td>&nbsp;</td>
                                </tr>
                                <tr>
                                    <td>配偶姓名:</td>
                                    <td><input type="text" name="consortname" value="${bean.consortname }"
                                               class="addCText"></td>
                                    <td align="left">子女姓名:</td>
                                    <td><input type="text" name="youngonename" value="${bean.youngonename }"
                                               class="addCText"></td>
                                    <td>&nbsp;</td>
                                </tr>
                                <tr>
                                    <td>办公电话:</td>
                                    <td><input type="text" name="officetelephone" value="${bean.officetelephone }"
                                               class="addCText"></td>
                                    <td align="left">配偶电话:</td>
                                    <td><input type="text" name="consorttelephone" value="${bean.consorttelephone }"
                                               class="addCText"></td>
                                    <td>&nbsp;</td>
                                </tr>
                                <tr>
                                    <td>业余爱好</td>
                                    <td colspan="3"><input type="text" name="avocation" value="${bean.avocation }"
                                                           class="addCText"></td>
                                    <td>&nbsp;</td>
                                </tr>
                                <tr>
                                    <td>配偶工作单位:</td>
                                    <td colspan="3"><input type="text" name="consortcompany"
                                                           value="${bean.consortcompany }" class="addCText"></td>
                                    <td>&nbsp;</td>
                                </tr>
                                <tr>
                                    <td>备注:</td>
                                    <td colspan="3"><textarea name="remark"
                                                              class="addCText2">${bean.remark }</textarea></td>
                                    <td>&nbsp;</td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>

                <table width="100%" border="0" cellspacing="0" cellpadding="0" id="index_main_div3">
                    <tr>
                        <td height="21" valign="top" background="image/index_main_div_titleBg.gif">
                            <img style="margin-left:5px;" src="image/index_main_div_left.gif" width="6" height="2"
                                 align="absmiddle">
                            &nbsp;<span style="font-weight:bold;font-size:12px;">职业技能</span></td>
                    </tr>
                    <tr>
                        <td height="56" align="left" valign="top" bgcolor="#f7fbfc">
                            <table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%"
                                   id="selectTable3">
                                <tr>
                                    <td width="7%">偏好特长:</td>
                                    <td width="42%">
                                        <textarea name="strongsuit" class="addCText2">${bean.strongsuit }</textarea>
                                    </td>
                                    <td width="9%" align="left">信息沟通:</td>
                                    <td width="40%">
                                        <textarea name="communicate" class="addCText2">${bean.communicate }</textarea>
                                    </td>
                                    <td width="2%">&nbsp;</td>
                                </tr>
                                <tr>
                                    <td>培训情况:</td>
                                    <td><textarea name="bringup" class="addCText2">${bean.bringup }</textarea></td>
                                    <td align="left">组织能力:</td>
                                    <td><textarea name="organise" class="addCText2">${bean.organise }</textarea></td>
                                    <td>&nbsp;</td>
                                </tr>
                                <tr>
                                    <td>分析能力:</td>
                                    <td><textarea name="analyse" class="addCText2">${bean.analyse }</textarea></td>
                                    <td align="left">计划能力:</td>
                                    <td><textarea name="planing" class="addCText2">${bean.planing }</textarea></td>
                                    <td>&nbsp;</td>
                                </tr>
                                <tr>
                                    <td>人员开发:</td>
                                    <td><textarea name="empolder" class="addCText2">${bean.empolder }</textarea></td>
                                    <td align="left">人际关系:</td>
                                    <td><textarea name="relation" class="addCText2">${bean.relation }</textarea></td>
                                    <td>&nbsp;</td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>

                <table width="100%" border="0" cellspacing="0" cellpadding="0" id="index_main_div4">
                    <tr>
                        <td height="21" valign="top" background="image/index_main_div_titleBg.gif">
                            <img style="margin-left:5px;" src="image/index_main_div_left.gif" width="6" height="2"
                                 align="absmiddle">
                            &nbsp;<span style="font-weight:bold;font-size:12px;">其他信息</span></td>
                    </tr>
                    <tr>
                        <td height="56" align="left" valign="top" bgcolor="#f7fbfc">
                            <table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%"
                                   id="selectTable4">
                                <tr>
                                    <td width="7%">创建人:</td>
                                    <td width="42%"><input name="creator" type="text" class="addCText" id="creator"
                                                           readOnly="readOnly">
                                    </td>
                                    <td width="9%" align="left">创建日期:</td>
                                    <td width="40%">
                                        <input name="createTimeStr" id="createTimeStr" value="" type="text"
                                               class="addCText" readOnly="readOnly">
                                    </td>
                                    <td width="2%">&nbsp;</td>
                                </tr>
                                <tr>
                                    <td>修改人:</td>
                                    <td><input name="updater" type="text" class="addCText" value="${user.name }"
                                               id="updater" readOnly="readOnly"></td>
                                    <td align="left">修改日期:</td>
                                    <td><input name="updateTimeStr" type="text" value="" class="addCText"
                                               id="updateTimeStr"
                                               readOnly="readOnly">
                                    </td>
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
        <tr>
            <td valign="middle">&nbsp;</td>
        </tr>
        <tr>
            <td valign="middle">&nbsp;</td>
        </tr>
    </table>
</form>
</body>
</html>
