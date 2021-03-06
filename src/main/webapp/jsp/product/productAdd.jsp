<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="../../taglibs.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <%
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script type="text/javascript" src="css_js/jquery/jquery-1.3.2.min.js"></script>
    <link href="css_js/index.css" rel="stylesheet" type="text/css"></link>
    <link href="css_js/general.css" rel="stylesheet" type="text/css"></link>
    <link href="css_js/calendar.css" rel="stylesheet" type="text/css"></link>
    <script src="css_js/popup.js" type="text/javascript"></script>
    <script src="css_js/jquery.form.js" type="text/javascript"></script>
    <script src="css_js/cal.js" type="text/javascript"></script>

    <title>添加商品</title>
    <script type="text/javascript">

        jQuery(document).ready(function () {
            //加载商品类别(下拉菜单)
//            loadProductTypes();

            $('#createTime').simpleDatepicker({startdate: 1960, enddate: 2060});

            $('#time1').simpleDatepicker({startdate: 1960, enddate: 2060});
            $('#time2').simpleDatepicker({startdate: 1960, enddate: 2060});
            //是否已经有了数据

            if ('' != '${product.time1Str}') {
                $('#time1').val('${product.time1Str}');
            } else {
                $('#time1').val('点击显示时间列表');
            }

            if ('' != '${product.time2Str}') {
                $('#time2').val('${product.time2Str}');
            } else {
                $('#time2').val('点击显示时间列表');
            }
            //判断状态显示时间颜色

            if ($('#time1').val() != "点击显示时间列表") {
                $('#time1').removeClass("addTimeInit");
                $('#time1').addClass("addTimeClick");
            }

            if ($('#time2').val() != "点击显示时间列表") {
                $('#time2').removeClass("addTimeInit");
                $('#time2').addClass("addTimeClick");
            }

            if ('' != '${product.createTimeStr}') {
                $('#createTime').val('${product.createTimeStr}');
                <%-- } else if ('' != '${c_time}') {
                    $('#createTime').val('${c_time}'); --%>
            } else {
                $('#createTime').val('点击显示时间列表');
            }

            if ('' != '${product.updateTimeStr}') {
                $('#updateTime').val('${product.updateTimeStr}');
                <%-- } else if ('' != '${c_time}') {
                    $('#updateTime').val('${c_time}'); --%>
            } else {
                $('#updateTime').val('无');
            }
        });

        jQuery(document).ready(function () {
            if ('${product.creater}' != "") {
                $("#creater").val('${product.creater}');
            } else {
                $("#creater").val('${user.name}');
            }
        });
    </script>

    <script type="text/javascript">
        function submitForm() {

            if ($('#time1').val() == "点击显示时间列表") {
                $('#time1').val("");
            }
            if ($('#time2').val() == "点击显示时间列表") {
                $('#time2').val("");
            }
            document.getElementById("productForm").submit();

        }


        function getPinyinCode() {
            var str = $("#name").val();

            if (str != "") {
                var queryString = {name: str};
                $.ajax({
                    type: "post",
                    url: "getPinyinCode.action",
                    data: queryString,
                    dataType: "json",
                    success: function (msg) {
                        $("#pycode").val(msg.name);
                    }
                });
            }
        }

        function checkFormat(filePath) {
            var i = filePath.lastIndexOf(".");
            var len = filePath.length;
            var str = filePath.substring(len, i + 1);
            var extName = "JPG,GIF,PNG,BMP";

            if (extName.indexOf(str.toUpperCase()) < 0) {
                alert("图片格式不正确");
                return false;
            }
            return true;

        }
        function fileChange(o) {
            if (checkFormat(o.value)) {
                if (window.ActiveXObject) {
                    document.getElementById("uploadImg").width = 100;
                    document.getElementById("uploadImg").height = 100;
                    document.getElementById("uploadImg").src = o.value;
                } else {
                    document.getElementById("uploadImg").width = 100;
                    document.getElementById("uploadImg").height = 100;
                    //document.getElementById("uploadImg").src = o.files[0].getAsDataURL();
                    showPicture("uploadImg", o);
                }

            }
        }
        function initPic() {
            if ('${product.picture}' != "") {
                document.getElementById("uploadImg").width = 100;
                document.getElementById("uploadImg").height = 100;
                document.getElementById("uploadImg").src = "upload/${product.picture}";
            }
        }
        function showPicture(picId, file) {
            var pic = document.getElementById(picId);
            //var file = document.getElementById(fileId);
            if (window.FileReader) {//chrome,firefox7+,opera,IE10,IE9，IE9也可以用滤镜来实现
                oFReader = new FileReader();
                oFReader.readAsDataURL(file.files[0]);
                oFReader.onload = function (oFREvent) {
                    pic.src = oFREvent.target.result;
                };
            } else if (document.all) {//IE8-
                file.select();
                var reallocalpath = document.selection.createRange().text//IE下获取实际的本地文件路径
                if (window.ie6)
                    pic.src = reallocalpath; //IE6浏览器设置img的src为本地路径可以直接显示图片
                else { //非IE6版本的IE由于安全问题直接设置img的src无法显示本地图片，但是可以通过滤镜来实现，IE10浏览器不支持滤镜，需要用FileReader来实现，所以注意判断FileReader先
                    pic.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='image',src=\""
                        + reallocalpath + "\")";
                    pic.src = 'data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==';//设置img的src为base64编码的透明图片，要不会显示红xx
                }
            } else if (file.files) {//firefox6-
                if (file.files.item(0)) {
                    url = file.files.item(0).getAsDataURL();
                    pic.src = url;
                }
            }
        }

    </script>
</head>
<body onload="initPic();">
<form name="form1" method="post" action="product/addOrUpdateProduct" id="productForm" enctype="multipart/form-data">
    <input type="hidden" name="edit_id" id="edit_id" value="${product.id}"/>
    <table width="99%" border="0" cellspacing="0" cellpadding="0" id="index_main_table">
        <tr>
            <td height="26" width="100%">
                <span style="color:#002450; font-size:13px; font-weight:bold;">　
                <c:if test="${edit_id == null}">新建</c:if>
                <c:if test="${edit_id != null}">修改</c:if>
                    商品</span>
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
                <img src="image/s9.gif" width="116" height="22">
                <img src="image/s8.gif" width="59" height="22"></td>
        </tr>
        <tr>
            <td id="errorInfo" style="font-size: 12px; color: #ff0000;">${suc}</td>
        </tr>
        <tr>
            <td valign="middle">
                <table width="100%" border="0" cellspacing="0" cellpadding="0" id="index_main_div1">
                    <tr>
                        <td height="21" valign="top" background="image/index_main_div_titleBg.gif">
                            <img style="margin-left:5px;" src="image/index_main_div_left.gif" width="6" height="2"
                                 align="absmiddle">&nbsp;
                            <span style="font-weight:bold;font-size:12px;">基本信息</span>
                        </td>
                    </tr>
                    <tr>
                        <td height="56" align="left" valign="top" bgcolor="#f7fbfc">
                            <table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%"
                                   id="selectTable">
                                <tr>
                                    <td width="10%"><span class="STYLE1">商品名称</span>:</td>
                                    <td width="41%"><input type="text" value="${product.name}" id="name" name="name"
                                                           class="addCText" <%--onkeyup="getPinyinCode();"--%>></td>
                                    <td width="7%" align="left">商品类别:</td>
                                    <td width="42%">
                                        <select name="ptypeId" class="addCText" id="product_type">
                                            <option value="0">/</option>
                                            ${selectOptionsStr}
                                        </select>
                                    </td>
                                    <td width="0%">&nbsp;</td>
                                </tr>
                                <tr>
                                    <td>商品编码:</td>
                                    <td><input type="text" value="${todayStr}${product.code}" name="code"
                                               class="addCText" id="code"></td>
                                    <td align="left">拼音码:</td>
                                    <td><input type="text" value="${product.pycode}" name="pycode" class="addCText"
                                               id="pycode"></td>
                                    <td>&nbsp;</td>
                                </tr>
                                <tr>
                                    <td>型号:</td>
                                    <td><input type="text" value="${product.model}" name="model" class="addCText"></td>
                                    <td align="left">规格:</td>
                                    <td><input type="text" value="${product.spec}" name="spec" class="addCText"></td>
                                    <td>&nbsp;</td>
                                </tr>
                                <tr>
                                    <td>单位:</td>
                                    <td><input type="text" value="${product.unit}" name="unit" class="addCText"></td>
                                    <td align="left">颜色:</td>
                                    <td><input type="text" value="${product.color}" name="color" class="addCText"></td>
                                    <td>&nbsp;</td>
                                </tr>
                                <tr>
                                    <td>尺寸:</td>
                                    <td><input type="text" value="${product.productSize}" name="productSize"
                                               class="addCText"></td>
                                    <td align="left">条形码:</td>
                                    <td><input type="text" value="${product.barCode}" name="barCode" class="addCText">
                                    </td>
                                    <td>&nbsp;</td>
                                </tr>
                                <tr>
                                    <td>供应商:</td>
                                    <td><input type="text" value="${product.provider}" name="provider" class="addCText">
                                    </td>
                                    <td align="left">商品库存:</td>
                                    <td><input type="text" value="${product.stock}" name="stock" class="addCText"></td>
                                    <td>&nbsp;</td>
                                </tr>
                                <tr>
                                    <td>单价:</td>
                                    <td><input type="text" value="${product.price}" name="price" class="addCText"></td>
                                    <td align="left">采购价:</td>
                                    <td><input type="text" value="${product.buyPrice}" name="buyPrice"
                                               class="addCText"></td>
                                    <td>&nbsp;</td>
                                </tr>
                                <%--<tr>
                                    <td>商品图片:</td>
                                    <td colspan="4"><input type="file" name="picture"
                                                           onchange="javascript:fileChange(this)" style="width:90%"/>
                                    </td>
                                </tr>--%>
                                <tr>
                                    <td>图片预览:</td>
                                    <td colspan="3"><img src="image/nonepicture.gif" width="0" height="0"
                                                         id="uploadImg"/></td>
                                    <td>&nbsp;</td>
                                </tr>
                                <tr>
                                    <td>备注:</td>
                                    <td colspan="3"><textarea name="remark"
                                                              class="addCText2">${product.remark}</textarea></td>
                                    <td>&nbsp;</td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>

                <table width="100%" border="0" cellspacing="0" cellpadding="0" id="index_main_div2">
                    <tr>
                        <td height="21" valign="top" background="image/index_main_div_titleBg.gif"><img
                                style="margin-left:5px;" src="image/index_main_div_left.gif" width="6" height="2"
                                align="absmiddle">&nbsp;<span style="font-weight:bold;font-size:12px;">自定义信息</span></td>
                    </tr>
                    <tr>
                        <td height="56" align="left" valign="top" bgcolor="#f7fbfc">
                            <table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%"
                                   id="selectTable2">
                                <tr>
                                    <td width="66">自定义1:</td>
                                    <td>
                                        <input name="custom1" value="${product.custom1}" type="text" class="addCText"
                                               id="custom1"></td>
                                    <td width="66" align="left">自定义2:</td>
                                    <td width="40%">
                                        <input name="custom2" value="${product.custom2}" type="text" class="addCText"
                                               id="custom2"></td>
                                    <td width="1">&nbsp;</td>
                                </tr>
                                <tr>
                                    <td>自定义3:</td>
                                    <td>
                                        <input name="custom3" value="${product.custom3}" type="text" class="addCText"
                                               id="custom3"></td>
                                    <td align="left">自定义4:</td>
                                    <td>
                                        <input name="custom4" value="${product.custom4}" type="text" class="addCText"
                                               id="custom4">
                                    </td>
                                    <td width="1"></td>
                                </tr>
                                <tr>
                                    <td>自定选项1:</td>
                                    <td><select name="choice1" class="addCText" id="product_choice1">
                                        <option value="1">---</option>
                                        <%--<s:iterator value="#request.sDictionaryDetailList" id="sdDetail">
                                            <s:if test="#sdDetail.SDictionaryClass.id == 31">
                                                <s:if test="#sdDetail.value == #request.product.choice1">
                                                    <option value="${sdDetail.value}"
                                                            selected='selected'>${sdDetail.value}</option>
                                                </s:if>
                                                <s:else>
                                                    <option value="${sdDetail.value}">${sdDetail.value}</option>
                                                </s:else>
                                            </s:if>
                                        </s:iterator>--%>
                                    </select>
                                        <img src="image/s11.gif" onclick="loadPopup('product_choice1')">
                                    </td>
                                    <td align="left">自定选项2:</td>
                                    <td><select name="choice2" class="addCText" id="product_choice2">
                                        <option value="1">---</option>
                                        <%--<s:iterator value="#request.sDictionaryDetailList" id="sdDetail">
                                            <s:if test="#sdDetail.SDictionaryClass.id == 32">
                                                <s:if test="#sdDetail.value == #request.product.choice2">
                                                    <option value="${sdDetail.value}"
                                                            selected='selected'>${sdDetail.value}</option>
                                                </s:if>
                                                <s:else>
                                                    <option value="${sdDetail.value}">${sdDetail.value}</option>
                                                </s:else>
                                            </s:if>
                                        </s:iterator>--%>
                                    </select>
                                        <img src="image/s11.gif" onclick="loadPopup('product_choice2')"></td>
                                    <td width="1"></td>
                                </tr>
                                <tr>
                                    <td>自定选项3:</td>
                                    <td><select name="choice3" class="addCText" id="product_choice3">
                                        <option value="1">---</option>
                                        <%--<s:iterator value="#request.sDictionaryDetailList" id="sdDetail">
                                            <s:if test="#sdDetail.SDictionaryClass.id == 33">
                                                <s:if test="#sdDetail.value == #request.product.choice3">
                                                    <option value="${sdDetail.value}"
                                                            selected='selected'>${sdDetail.value}</option>
                                                </s:if>
                                                <s:else>
                                                    <option value="${sdDetail.value}">${sdDetail.value}</option>
                                                </s:else>
                                            </s:if>
                                        </s:iterator>--%>
                                    </select>
                                        <img src="image/s11.gif" onclick="loadPopup('product_choice3')"></td>
                                    <td align="left">自定选项4</td>
                                    <td><select name="choice4" class="addCText" id="product_choice4">
                                        <option value="1">---</option>
                                        <%--<s:iterator value="#request.sDictionaryDetailList" id="sdDetail">
                                            <s:if test="#sdDetail.SDictionaryClass.id == 34">
                                                <s:if test="#sdDetail.value == #request.product.choice4">
                                                    <option value="${sdDetail.value}"
                                                            selected='selected'>${sdDetail.value}</option>
                                                </s:if>
                                                <s:else>
                                                    <option value="${sdDetail.value}">${sdDetail.value}</option>
                                                </s:else>
                                            </s:if>
                                        </s:iterator>--%>
                                    </select>
                                        <img src="image/s11.gif" onclick="loadPopup('product_choice4')"></td>
                                    <td width="1"></td>
                                </tr>
                                <tr>
                                    <td>自定时间1:</td>
                                    <td>
                                        <input type="text" name="time1Str" id="time1" class="addTimeInit"
                                               value="点击显示时间列表" readonly="readonly">
                                    </td>
                                    <td align="left">自定时间2:</td>
                                    <td>
                                        <input type="text" name="time2Str" id="time2" class="addTimeInit"
                                               value="点击显示时间列表" readonly="readonly">
                                    </td>
                                    <td width="1"></td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>

                <table width="100%" border="0" cellspacing="0" cellpadding="0" id="index_main_div3">
                    <tr>
                        <td height="21" valign="top" background="image/index_main_div_titleBg.gif">
                            <img style="margin-left:5px;" src="image/index_main_div_left.gif" width="6" height="2"
                                 align="absmiddle">&nbsp;
                            <span style="font-weight:bold;font-size:12px;">其他信息</span>
                        </td>
                    </tr>
                    <tr>
                        <td height="56" align="left" valign="top" bgcolor="#f7fbfc">
                            <table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%"
                                   id="selectTable3">
                                <tr>
                                    <td width="7%">创建人:</td>
                                    <td width="42%">
                                        <input name="creater" type="text" class="addCText" id="creater"
                                               readOnly="readOnly">
                                    </td>
                                    <td width="9%" align="left">创建日期:</td>
                                    <td width="40%">
                                        <input id="createTime" type="text" class="addCText" name="createTimeStr"
                                               readOnly="readOnly">
                                    </td>
                                    <td width="2%">&nbsp;</td>
                                </tr>
                                <tr>
                                    <td>修改人:</td>
                                    <td>
                                        <input name="updater" type="text" class="addCText" id="updater"
                                               value="${user.name}" readOnly="readOnly">
                                    </td>
                                    <td align="left">修改日期:</td>
                                    <td>
                                        <input type="text" name="updateTimeStr" class="addCText" id="updateTime"
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
            <td valign="middle">
                <img src="image/s10.gif" width="58" height="22">
                <img src="image/s8.gif" width="59" height="22">
            </td>
        </tr>
        <tr>
            <td valign="middle">&nbsp;</td>
        </tr>
    </table>
</form>
</body>
</html>