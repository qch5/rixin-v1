function showError(b) {
    if (errFlag) {
        return
    }
    var a = arguments[1] ? true: false;
    if (a) {
        errFlag = 1
    }
    $("#show_mes").html(b);
    $("#codFloat").show();
    setTimeout(function() {
            $("#show_mes").html("");
            $("#codFloat").hide();
            if (a) {
                var c = window.location.href;
                window.location.href = c.replace(/&pos=no/, "") + "&pos=no"
            }
        },
        2000)
}
function checkform() {
    var fullName = $.trim($("#fullName").val());
    var sex = $(":radio[name='sex']:checked").length;
    var mobile = $.trim($("#mobile").val());
    var city = $("#city option:selected").val();
    var district = $("#district option:selected").val();
    var community = $("#community option:selected").val();
    var detail = $.trim($("#detail").val());
    if (fullName == "") {
        showError("姓名不能为空");
        return false
    }
    if (sex < 1) {
        showError("您是女士还是先生呢？");
        return false
    }
    var c = /^1\d{10}$/;
    if (mobile == "") {
        showError("手机号不能为空");
        return false
    } else {
        if (!c.test(mobile)) {
            showError("请正确填写手机号码");
            return false
        }
    }
    if (!city || city == "" || city == "请选择城市") {
        showError("城市不能为空");
        return false
    }
    if (community == "") {
        showError("小区名或者大厦名不能为空");
        return false
    }
    if (!district || district == "" || district === "请先选择区域") {
        showError("区域不能为空");
        return false
    }
    if (detail == "") {
        showError("详细地址不能为空");
        return false
    }
    $("#save_address").prop("disabled", true).css({
        "opacity": ".5"
    })
}
function xbtnStatus(c) {
    var b = $(c).val();
    var a = $(c).attr("id") + "_clear";
    if ($.trim(b).length > 0) {
        $("#" + a).show()
    } else {
        $("#" + a).hide()
    }
}
function clearInput(a, b) {
    $("#" + b).val("");
    $(a).hide();
    if ("searchInp" == b) {
        $("#searchList").empty();
        $("#confirm_address").prop("disabled", true).css({
            "opacity": ".5"
        });
        $("#userWin").hide()
    }
    if ("mobile" == b || "username" == b || "addr_name" == b || "detail" == b) {
        $("#save_address").prop("disabled", true).css({
            "opacity": ".5"
        })
    }
}
function setSaveBtn() {
    var fullName = $.trim($("#fullName").val());
    var sex = $(":radio[name='sex']:checked").length;
    var mobile = $.trim($("#mobile").val());
    var city = $("#city option:selected").val();
    var district = $("#district option:selected").val();
    var community = $("#community option:selected").val();
    var detail = $.trim($("#detail").val());
    var flag = true;
    var i = /^1\d{10}$/;
    if (sex === "" || !i.test(mobile)) {
        flag = false
    }
    if (flag && fullName && sex && community && city && district && detail) {
        $("#save_address").prop("disabled", false).css({
            "opacity": "1"
        });
        return true
    } else {
        $("#save_address").prop("disabled", true).css({
            "opacity": ".5"
        });
        return false
    }
}
function returnKeyword2() {
    var b = $.trim($("#searchInp").val());
    var a = $("#user_city option:selected").val();
    var f = $("#user_area option:selected").val();
    var d = $.trim($("#addr_name").val());
    var e = $("#cmbCity option:selected").val();
    var c = $("#cmbArea option:selected").val();
    if (b != d || a != e || f != c) {
        resetLngLat();
        selectedCity(a, f);
        $("#addr_name").val(b)
    }
    $("#home_city").hide();
    $("#cmbArea_wrap").show();
    SCFlag = 2;
    $("#select_wrap").show();
    setSaveBtn();
    showMainWin()
}
