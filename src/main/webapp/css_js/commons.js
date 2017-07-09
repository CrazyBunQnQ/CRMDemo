/**
 * Created by CrazyBunQnQ on 2017/7/7.
 */
/**
 * 确认删除
 */
function toDel() {
    var cbNum = checkBoxNum();
    if (cbNum > 0) {
        if (window.confirm("确定删除？")) {
            document.getElementById("isDel").value = "true";
            document.forms[0].submit();
        }
    }
}

/**
 * 判断列表复选框选中个数是否大于 0，是：返回个数，否：返回 0
 */
function checkBoxNum() {
    if ($("input[name='selectedId']:checked").length > 0) {
        return $("input[name='selectedId']:checked").length;
    } else {
        return 0;
    }
}

/**
 * 页面跳转
 * @param pageNumId 目标页
 * @param pageSizeId 每页数量
 */
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

/**
 * 下一页
 */
function nextPage() {
    var hiddenPageNum = document.getElementById("hiddenPageNum");
    if ("" != hiddenPageNum.value) {
        hiddenPageNum.value = hiddenPageNum.value - 0 + 1;
        document.forms[0].submit();
    }
}

/**
 * 上一页
 */
function prePage() {
    var hiddenPageNum = document.getElementById("hiddenPageNum");
    if ("" != hiddenPageNum.value) {
        hiddenPageNum.value = hiddenPageNum.value - 0;
        if (hiddenPageNum.value > 1) {
            hiddenPageNum.value -= 1;
        }
        document.forms[0].submit();
    }
}

/**
 * 首页
 */
function firstPage() {
    var hiddenPageNum = document.getElementById("hiddenPageNum");
    if ("" != hiddenPageNum.value) {
        hiddenPageNum.value = 1;
        document.forms[0].submit();
    }
}

/**
 * 末页
 * @param totalPage 目标页
 */
function lastPage(totalPage) {
    var hiddenPageNum = document.getElementById("hiddenPageNum");
    if ("" != hiddenPageNum.value) {
        hiddenPageNum.value = totalPage;
        document.forms[0].submit();
    }
}

/**
 * 提交表单
 */
function submitForm() {
    document.forms[0].submit();
}

/**
 * 清空搜索条件
 */
function clearSearchArea() {
    $("#selectTable input").val("");
}

/**
 * 重置表单
 */
function resetForm() {
    document.forms[0].reset();
}

/**
 * 导出 Excel
 */
function exportExcel() {
    loadPopup_excel('导出Excel');
}

/**
 * 打开树形结构图
 */
function openTreeWindow() {
    window.open("optionTreeWidnow.action", "_blank");
}

/**
 * 更新"选中条目"数值
 */
function updateNum() {
    var num = $("input[name='selectedId']:checked").length;
    $("#select_num1").html(num);
    $("#select_num2").html(num);
}

/**
 * 全选/全不选
 */
function toChange() {
    var num = $("#ids:checked").length;
    if (num === 0) {
        $("input[name='selectedId']").attr("checked", false);
    } else {
        $("input[name='selectedId']").attr("checked", "checked");
    }
    updateNum();
}

/**
 * 返回列表
 * @param path
 */
function returnList(path) {
    window.location = path;
}