
//页面垂直滚动条
//$(document).ready(function () {
//    $("#html_body").niceScroll({ styler: "fb", cursorcolor: "#e1e1e1", cursorwidth: '6', cursorborderradius: '10px', background: 'transparent', cursorborder: '', zindex: '1000', directionlockdeadzone: 6 });
//    $("#html_body").getNiceScroll().resize();
//});
//菜单栏
//$(".naved").click(function () {
//    $(".dao_flash").animate({ right: "0px" });
//    $(".dao_flash").show();
//    $(".fix_box").show();
//})
//$(".fix_box").click(function () {
//    $(".dao_flash").animate({ right: "-8em" });
//    $(".fix_box").hide();
//})
window.alert = function (name) {
    var iframe = document.createElement("IFRAME");
    iframe.style.display = "none";
    iframe.setAttribute("src", 'data:text/plain,');
    document.documentElement.appendChild(iframe);
    window.frames[0].window.alert(name);
    iframe.parentNode.removeChild(iframe);
};
$(".naved").click(function () {
    $(".cd_flash").animate({ right: "0.1rem" });
    $(".cd_flash").show();
    $(".fix_box").show();
})
$(".fix_box").click(function () {
    $(".cd_flash").animate({ right: "-8rem" });
    $(".fix_box").hide();
})
//弹出窗关闭
$(".tck1 #gb").click(function (e) {
    $(".tck_bg").hide();
    $(".tck1").hide();
})
$(".tck2 .a1").click(function (e) {
    $(".tck_bg").hide();
    $(".tck2").hide();
})

//数量增减
$(".jia").click(function () {
    var t = this;
    var number = $(t).parent(".slbox").find(".num");
    number = parseInt(number.val()) + 1;
    var max = parseInt($(t).parent(".slbox").attr("data-max"));
    if (max != undefined && !isNaN(max) && number > max)
        number = max;
    $(t).parent(".slbox").find(".num").val(number);
})
$(".jian").click(function () {
    var t = this;
    var number = $(t).parent(".slbox").find(".num");
    number = parseInt(number.val()) - 1;
    var min = parseInt($(t).parent(".slbox").attr("data-min"));
    if (min != undefined && !isNaN(min) && number < min)
        number = min;
    $(t).parent(".slbox").find(".num").val(number);
})
//输入框（数字最大最小值）
$(".slbox .num").on("change", function () {
    var sum = parseInt($(this).val());
    var min = parseInt($(this).parent(".slbox").attr("data-min"));
    var max = parseInt($(this).parent(".slbox").attr("data-max"));
    $(this).val(sum);
    if (sum < min) {
        $(this).val(min);
    }
    if (sum > max) {
        $(this).val(max);
    }
    if (isNaN(sum)) {
        $(this).val(min);
    }
})

//筛选菜单栏
$(".sx").click(function (e) {
    $(".ddsx_box").animate({ right: "0px" });
})
$(".ddsx_box .qx").click(function (e) {
    $(".ddsx_box").animate({ right: "-5.98rem" });
})

//弹出窗关闭
$(".tck1 #gb").click(function (e) {
    $(".tck_bg").hide();
    $(".tck1").hide();
})
$(".tck2 .a1").click(function (e) {
    $(".tck_bg").hide();
    $(".tck2").hide();
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


(function ($) {
    $.my = {
        version: '0.0.1'
    };

    $.noop = $.noop || function () { };
})($);
(function ($) {

    var $dialog = null;

    /**
     *  my dialog
     * @param {Object} [options]
     */
    $.my.dialog = function (options) {
        options = $.extend({
            content: '内容',
            className: '',
            buttons: [{
                label: '确定',
                type: 'primary',
                onClick: $.noop
            }]
        }, options);

        var buttons = options.buttons.map(function (button) {
            return '<a href="javascript:;" class="a1 my_btn_dialog ' + button.type + '">' + button.label + '</a>';
        }).join('\n');
        var html = '<div class="' + options.className + '"><div class="tck_bg"></div><div class="tck2">' + '<p class="p1" style="padding: 0.7rem 0.45rem;">' + options.content + '</p>' + buttons + '</div></div>';
        $dialog = $(html);
        $('body').append($dialog);
        $dialog.on('click', '.my_btn_dialog', function () {
            var button = options.buttons[$(this).index(".my_btn_dialog")];
            var cb = button.onClick || $.noop;
            cb.call();
            $.my.closeDialog();
        });
    };

    /**
     * close dialog
     */
    $.my.closeDialog = function () {
        if ($dialog) {
            $dialog.off('click');
            // zepto 核心不包含动画相关的方法
            if (typeof $dialog.fadeOut === 'function') {
                $dialog.fadeOut('fast', function () {
                    $dialog.remove();
                    $dialog = null;
                });
            } else {
                $dialog.remove();
                $dialog = null;
            }
        }
    };
})($);

(function ($) {

    var $paypwd = null;

    /**
     *  my paypwd
     * @param {Object} [options]
     */
    $.my.paypwd = function (options) {
        options = $.extend({
            className: '',
            buttons: [{
                label: '取消',
                type: 'default',
                onClick:$.noop
            }]
        }, options);

        var buttons = options.buttons.map(function (button) {
            console.log(button);
            return '<button type="button" class="pay_btn pay_ft_btn ' + button.type + '">' + button.label + '</button>';
        }).join('\n');
        console.log(buttons);
        var html = '<div><div class="weui_mask"></div><div class="paypwd ' + options.className + '"><div class="pay_hd">余额支付</div><div class="pay_bd"><p class="pay_bd_lab">请输入支付密码</p><input type="password" value="" class="pay_bd_inp pay_pass" maxlength="6" /></div><div class="pay_ft">' + buttons + '</div></div></div>';
        $paypwd = $(html);
        $('body').append($paypwd);
        $paypwd.on('click', '.pay_ft_btn', function () {
            var button = options.buttons[$(this).index(".pay_ft_btn")];
            var cb = button.onClick || $.noop;
            cb.call();
            if ($(this).hasClass("pay_ft_rem")) {
                $.my.closepaypwd();
            }
        });
    };

    /**
     * close dialog
     */
    $.my.closepaypwd = function () {
        if ($paypwd) {
            $paypwd.off('click');
            // zepto 核心不包含动画相关的方法
            if (typeof $paypwd.fadeOut === 'function') {
                $paypwd.fadeOut('fast', function () {
                    $paypwd.remove();
                    $paypwd = null;
                });
            } else {
                $paypwd.remove();
                $paypwd = null;
            }
        }
    };
})($);