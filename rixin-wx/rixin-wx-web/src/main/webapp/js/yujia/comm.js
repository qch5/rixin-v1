$(function () {
    //FastClick.attach(document.body);
    $(".bnotice").click(function () {
        $("body").addClass("billlist");
        $.weui.dialog({
            title:'发票须知',
            content: '1.根据会员的充值记录进行开票。<br/>2.发票类别为电子发票和纸质发票；发票类型为增值税普通发票和增值税专用发票。<br/>3.发票状态：<br/>申请中：发票信息正在审核中；<br/>申请失败：提交信息不符合条件，可查看申请失败原因；<br/>已开票：发票已完成开票；<br/>发票作废：发票已经作废。',
            buttons: [{
                label: '我知道了',
                type: 'primary',
                onClick: function () {
                    $(".weui_dialog_bd").css("text-align", "center");
                }
            }]
        });

    })
    window.alert = function (name) {
        var iframe = document.createElement("IFRAME");
        iframe.style.display = "none";
        iframe.setAttribute("src", 'data:text/plain,');
        document.documentElement.appendChild(iframe);
        window.frames[0].window.alert(name);
        iframe.parentNode.removeChild(iframe);
    };
    //$(".naved").click(function () {
    //    $(".dao_flash").animate({ right: "0px" });
    //    $(".dao_flash").show();
    //    $(".fix_box").show();
    //})
    //$(".fix_box").click(function () {
    //    $(".dao_flash").animate({ right: "-8em" });
    //    $(".fix_box").hide();
    //})
    $(".naved").click(function () {
        $(".cd_flash").animate({ right: "0.1rem" });
        $(".cd_flash").show();
        $(".fix_box").show();
    })
    $(".fix_box").click(function () {
        $(".cd_flash").animate({ right: "-8rem" });
        $(".fix_box").hide();
    })
})

function setCookie(c_name, value, expirehours) {
    var exdate = new Date()
    exdate.setHours(exdate.getHours() + expirehours)
    document.cookie = c_name + "=" + escape(value) +
        ((expirehours == null) ? "" : ";expires=" + exdate.toGMTString() + ";path=/")
}

function getCookie(c_name) {
    if (document.cookie.length > 0) {
        var c_start = document.cookie.indexOf(c_name + "=")
        if (c_start != -1) {
            c_start = c_start + c_name.length + 1
            var c_end = document.cookie.indexOf(";", c_start)
            if (c_end == -1) c_end = document.cookie.length
            return unescape(document.cookie.substring(c_start, c_end))
        }
    }
    return "";
}