<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="../../taglibs.jsp" %>
<html>
<head>
    <%
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
    <style>
        * {
            font-size: 12px;
        }

        .simpleTree {
            font: normal 12px arial, tahoma, helvetica, sans-serif;
            margin-left: 0px;
            margin-top: 0px;
            margin-right: 0px;
            margin-bottom: 0px;
            margin: 0;
            padding: 0;
            /*
            overflow:auto;
            width: 250px;
            height:350px;
            overflow:auto;
            border: 1px solid #444444;
            */
        }

        .simpleTree li {
            list-style: none;
            margin: 0;
            padding: 0 0 0 34px;
            line-height: 14px;
        }

        .simpleTree li span {
            display: inline;
            clear: left;
            white-space: nowrap;

        }

        .simpleTree ul {
            margin: 0;
            padding: 0;
        }

        .simpleTree .root {
            margin-left: -16px;
            background: url(images/root.gif) no-repeat 16px 0;
        }

        .simpleTree .line {
            margin: 0 0 0 -16px;
            padding: 0;
            line-height: 3px;
            height: 3px;
            font-size: 3px;
            background: url(images/line_bg.gif) 0 0 no-repeat transparent;
        }

        .simpleTree .line-last {
            margin: 0 0 0 -16px;
            padding: 0;
            line-height: 3px;
            height: 3px;
            font-size: 3px;
            background: url(images/spacer.gif) 0 0 no-repeat transparent;
        }

        .simpleTree .line-over {
            margin: 0 0 0 -16px;
            padding: 0;
            line-height: 3px;
            height: 3px;
            font-size: 3px;
            background: url(images/line_bg_over.gif) 0 0 no-repeat transparent;
        }

        .simpleTree .line-over-last {
            margin: 0 0 0 -16px;
            padding: 0;
            line-height: 3px;
            height: 3px;
            font-size: 3px;
            background: url(images/line_bg_over_last.gif) 0 0 no-repeat transparent;
        }

        .simpleTree .folder-open {
            margin-left: -16px;
            background: url(images/collapsable.gif) 0 -2px no-repeat;
        }

        .simpleTree .folder-open-last {
            margin-left: -16px;
            background: url(images/collapsable-last.gif) 0 -2px no-repeat;
        }

        .simpleTree .folder-close {
            margin-left: -16px;
            background: url(images/expandable.gif) 0 -2px no-repeat;
        }

        .simpleTree .folder-close-last {
            margin-left: -16px;
            background: url(images/expandable-last.gif) 0 -2px no-repeat;
        }

        .simpleTree .doc {
            margin-left: -16px;
            background: url(images/leaf.gif) 0 -1px no-repeat;
        }

        .simpleTree .doc-last {
            margin-left: -16px;
            background: url(images/leaf-last.gif) 0 -1px no-repeat;
        }

        .simpleTree .ajax {
            background: url(images/spinner.gif) no-repeat 0 0;
            height: 16px;
            display: none;
        }

        .simpleTree .ajax li {
            display: none;
            margin: 0;
            padding: 0;

        }

        .simpleTree .trigger {
            display: inline;
            margin-left: -32px;
            width: 28px;
            height: 11px;
            cursor: pointer;
        }

        .simpleTree .text {
            cursor: hand;
        }

        .simpleTree .active {
            cursor: default;
            background-color: #F7BE77;
            padding: 0px 2px;
            border: 1px dashed #444;
        }

        #drag_container {
            background: #ffffff;
            color: #000;
            font: normal 11px arial, tahoma, helvetica, sans-serif;
            border: 1px dashed #767676;
        }

        #drag_container ul {
            list-style: none;
            padding: 0;
            margin: 0;
        }

        #drag_container li {
            list-style: none;
            background-color: #ffffff;
            line-height: 18px;
            white-space: nowrap;
            padding: 1px 1px 0px 16px;
            margin: 0;
        }

        #drag_container li span {
            padding: 0;
        }

        #drag_container li.doc, #drag_container li.doc-last {
            background: url(images/leaf.gif) no-repeat -17px 0 #ffffff;
        }

        #drag_container .folder-close, #drag_container .folder-close-last {
            background: url(images/expandable.gif) no-repeat -17px 0 #ffffff;
        }

        #drag_container .folder-open, #drag_container .folder-open-last {
            background: url(images/collapsable.gif) no-repeat -17px 0 #ffffff;
        }

        .contextMenu {
        / / display: none;
        }
    </style>
    <script type="text/javascript" src="css_js/jquery/jquery-1.3.2.min.js"></script>
    <script type="text/javascript" src="css_js/jquery.simple.tree.js"></script>
    <script type="text/javascript">
        var simpleTreeCollection;
        $(document).ready(function () {
            simpleTreeCollection = $('.simpleTree').simpleTree({
                autoclose: false,
                drag: false,
                afterClick: function (node) {
                    window.location.href = "/popedom/getPopedomTreeStr?id=" + node.attr("id") + "&role_id=" + ${role_id} +"&timestemp=" + (new Date()).valueOf();
                },
                afterDblClick: function (node) {
                    //alert("text-"+$('span:first',node).text());
                },

                afterAjax: function () {
                    //alert('Loaded');
                },
                animate: true
                //,docToFolderConvert:true
            });
        });

        function chgUrl(url) {
            var timestamp = (new Date()).valueOf();
            url = url.substring(0, 17);
            if (url.indexOf("&") >= 0) {
                url = url + "tamp=" + timestamp;
            } else {
                url = url + "?timestamp=" + timestamp;
            }
            return url;
        }

        function submitForm() {
            document.forms[0].submit();
        }

        function selectModel(code) {
            var objs = document.getElementsByTagName("input");
            if (code.indexOf("_") == -1) {
                for (var i = 0; i < objs.length; i++) {
                    if (objs[i].id.indexOf("_") != -1) {
                        var s = objs[i].id.substring(0, objs[i].id.indexOf("_"));
                        if (code == s) {
                            var o = document.getElementById(code + "pop");
                            objs[i].checked = o.checked;
                        }
                    }

                }
            } else {
                selectSubModel(code);
            }
        }
        function selectSubModel(code) {
            var objs = document.getElementsByTagName("input");
            for (var i = 0; i < objs.length; i++) {
                if (objs[i].id.lastIndexOf("_") != -1) {
                    var s = objs[i].id.substring(0, objs[i].id.lastIndexOf("_"));
                    if (s.indexOf("_") != -1) {
                        s = objs[i].id.substring(0, objs[i].id.lastIndexOf("_"));
                        if (code == s) {
                            var o = document.getElementById(code + "pop");
                            objs[i].checked = o.checked;
                        }
                    }
                }
            }
        }
    </script>
</head>
<body>
<form action="setPopedom.action" method="post" id="form1">
    <input type="hidden" name="roleId" value="${role_id}"/>
    <table width="98%" height="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td width="20%" valign="top">${treeStr}</td>
            <td width="80%" valign="top">
                <img alt="" src="image/s10.gif" onclick="submitForm()">
                <img alt="" src="image/genmulu.gif"
                     onclick="javascript:window.location='getPopedomTreeStr?role_id=${role_id}'">
                <img alt="" src="image/guanbi.gif" onclick="window.close();">
                <br/>
                <span style="color:#ff0000; font-size:12px;float:left;">${mess}</span>
                <div id="drag_container">
                    ${tableStr}
                    <ul>
                        <li><span>
                            <input type="checkbox" id="1_11">sfasfsfa
                        </span></li>
                        <li><span>
                            <input type="checkbox" id="2_22">sfasfsfa
                        </span>
                            <ul>
                                <li><span>
                                <input type="checkbox" id="code_pop">sfasdfagasgs
                                    s=code
                            </span></li>
                            </ul>
                        </li>
                        <li><span>
                            <input type="checkbox" id="3_33">sfasfsfa
                        </span></li>
                        <li><span>
                            <input type="checkbox" id="4_44">sfasfsfa
                        </span></li>
                    </ul>
                </div>
            </td>
        </tr>
    </table>
</form>
</body>
</html>