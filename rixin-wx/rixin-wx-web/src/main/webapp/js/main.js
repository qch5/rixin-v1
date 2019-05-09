/*
**Call internal native alert to prevent after modification.
**add by zqs
**2016-12-23
*/
$.alertmsg = function (txt, callback) {
    alert(txt);
    if (callback) {
        callback();
    }
};
$.alertMsg = function (txt, callback) {
    $.alertmsg(txt, callback);
};

$.getParam = function (name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) {
        return encodeURI(r[2])
    }
    return ""
};

$.openUrl = function (url) {
    var reg = new RegExp("(^|&)openid=([^&]*)(&|$)", "i");
    try {
        if (url.indexOf('?') == -1) {
            window.location.href = url + '?openid=' + $.getParam('openid');
        }
        else {
            var r = url.split('?')[1].match(reg);
            if (r != null) {
                window.location.href = url;
            }
            else {

                window.location.href = url + '&openid=' + $.getParam('openid');
            }
        }

    } catch (e) {
        window.location.href = url;
    }

};

$.ReplaceUrl = function (url) {
    var reg = new RegExp("(^|&)openid=([^&]*)(&|$)", "i");
    try {
        if (url.indexOf('?') == -1) {
            window.location.replace(url + '?openid=' + $.getParam('openid'))
        }
        else {
            var r = url.split('?')[1].match(reg);
            if (r != null) {
                window.location.replace(url);
            }
            else {

                window.location.replace(url + '&openid=' + $.getParam('openid'));
            }
        }

    } catch (e) {
        window.location.replace(url);
    }

    //$.openUrl(url);

};

$.ReloadPage = function (obj) {
    window.location.reload();
};

/*
**Check current environment is weixin.
**Solemnly declare: using this method is not the best solution,because it is easy to be forged.
**add by zqs
**2017-04-08
*/
$.IsWeiXin = function () {
    var ua = navigator.userAgent.toLowerCase();
    if (ua.match(/MicroMessenger/i) == "micromessenger") {
        //do something...
        return true;
    } else {
        //do something...
        return false;
    }

}

$.CheckBoxHasCheck = function (ckb_name) {
    //var ischeck = false;
    //$('[name=' + ckb_name + ']').each(function () {
    //    if ($(this).get(0).checked) {
    //        ischeck = true;
    //        return;
    //    }
    //});


    //return false;
}

function waitPerfect() {
    $.alertmsg('静待完善')
}

$.GetPointByAddr = function (mapid, city, addr, callback) {
    if (!mapid || mapid == "") {
        alert("mapid 不能为空！");
        return false
    }
    if (!city || city == "") {
        //alert("city 不能为空！");
        return false
    }
    if (!addr || addr == "") {
        //alert("addr 不能为空！");
        return false
    }
    if (!callback) {
        alert("callback 不能为空！");
        return false
    }
    var map = new BMap.Map(mapid);
    var myGeo = new BMap.Geocoder();
    myGeo.getPoint(addr, function (point) {
        if (point && callback) {
            callback(point.lng, point.lat)
        }
    }, city)
};




/*
**post 提交
*/
$.submit = function (jdata) {

    var openid = $.getParam("openid");
    if (!jdata.url) {
        $.alertmsg("url不能为空！");
        return
    }
    if (jdata.loading == null || jdata.loading == undefined) {
        jdata.loading = true;
    }
    //$.showLoadding();
    $.ajax({
        url: jdata.url,
        data: jdata.paramData + '&openid=' + openid,
        type: "post",
        async: true,
        beforeSend: function () {

            if (jdata.loading) {
                $.showLoadding();
            }
        },
        success: function (result) {
            //$.hideLoadding();
            if (jdata.func) {
                jdata.func(result)
            }
        },
        error: function (e) {
            if (jdata.loading) {
                $.hideLoadding();
            }
        },
        complete: function () {

            if (jdata.loading) {
                $.hideLoadding();
            }
        }
    })
};

$.pagelist = function (jdata) {
    var initpage = 1;
    var total = 1;
    var openid_ = $.getParam("openid");
    //	 alert(openid);

    if (jdata.url == null || jdata.url == undefined || jdata.url == "") {
        $.alertmsg('url不能为空！');
        return;
    }

    if (jdata.tbid == null || jdata.tbid == undefined || jdata.tbid == "") {
        $.alertmsg('tbid不能为空！');
        return;
    }

    if (!jdata.format == null || jdata.format == undefined || jdata.format == "") {
        $.alertmsg('列表格式不能为空！');
        return;
    }
    if (jdata.loading == null || jdata.loading == undefined) {
        jdata.loading = true;
    }

    //取消mui的事件绑定,以免重复触发事件
    if (jdata.isMui) {
        mui(".moreBox").off('tap', '#more');
    }


    $.ajax({
        url: jdata.url,
        data: jdata.paramData + '&page=' + initpage + '&openid=' + openid_,
        dataType: 'json',
        type: 'POST',
        beforeSend: function () {

            if (jdata.loading) {
                $.showLoadding();
            }
        },
        success: function (result) {
            //$.hideLoadding();
            if ((!result || result == '') && result.code == -1) {
                $.alertmsg('数据异常，请重试！');
                return;
            }

            $('#' + jdata.tbid).children().remove();
            var obj = eval('(' + result + ')');
            if (obj.list.length > 0) {
                total = obj.total;
                for (var i = 0; i < obj.list.length; i++) {
                    $('#' + jdata.tbid).append(jdata.format(obj.list[i]));
                }
            }

            if (jdata.func) {
                jdata.func(obj);
            }

            if (jdata.moreid) {
                if (obj.total == 1 || obj.count == 0)  //如果只有总记录只有一页，则隐藏获取更多数据按钮
                {
                    $('#' + jdata.moreid).parent().hide();
                    return false;
                }
                //修改更多按钮样式
                $('#' + jdata.moreid).parent().css('margin', '10px 0px');

                var objh = $('#' + jdata.moreid).parent();
                var mhtml = objh.html();
                objh.html('');
                objh.append(mhtml);
                $('#' + jdata.moreid).html('查看更多').parent().show();

                if (jdata.isMui) { //mui导致click事件失效时使用此方式
                    mui(".moreBox").on('tap', '#more', function (event) {
                        $.showLoadding();
                        initpage++;
                        $.ajax({
                            url: jdata.url,
                            data: jdata.paramData + '&page=' + initpage + '&openid=' + openid_,
                            dataType: 'json',
                            type: 'POST',
                            beforeSend: function () {
                                //$.hideLoadding();
                                if (jdata.loading) {
                                    $.showLoadding();
                                }
                            },
                            success: function (result) {
                                //$.hideLoadding();
                                if ((!result || result == '') && result.code == -1) {
                                    $.alertmsg('数据异常，请重试！');
                                    return;
                                }

                                //$('#'+jdata.tbid).children().remove();
                                var obj = eval('(' + result + ')');
                                if (obj.list.length > 0) {
                                    for (var i = 0; i < obj.list.length; i++) {
                                        $('#' + jdata.tbid).append(jdata.format(obj.list[i]));
                                    }
                                }

                                if (initpage >= obj.total) {
                                    var objh = $('#' + jdata.moreid).parent();
                                    var mhtml = objh.html();
                                    objh.html('');
                                    objh.append(mhtml);
                                    $('#' + jdata.moreid).html('木有更多了...');
                                    return false;
                                }
                                return false;
                            },
                            error: function () {
                                if (jdata.loading) {
                                    $.hideLoadding();
                                }
                                return false;
                            },
                            complete: function () {

                                if (jdata.loading) {
                                    $.hideLoadding();
                                }
                            }
                        });

                        event.stopPropagation();
                        return false;
                    });
                } else { //可正常使用click事件时的使用方式
                    document.getElementById(jdata.moreid).addEventListener("click", function (e) {
                        initpage++;
                        $.ajax({
                            url: jdata.url,
                            data: jdata.paramData + '&page=' + initpage + '&openid=' + openid_,
                            dataType: 'json',
                            type: 'POST',
                            beforeSend: function () {

                                if (jdata.loading) {
                                    $.showLoadding();
                                }
                            },
                            success: function (result) {
                                //$.hideLoadding();
                                if ((!result || result == '') && result.code == -1) {
                                    $.alertmsg('数据异常，请重试！');
                                    return;
                                }

                                //$('#'+jdata.tbid).children().remove();
                                var obj = eval('(' + result + ')');
                                if (obj.list.length > 0) {
                                    for (var i = 0; i < obj.list.length; i++) {
                                        $('#' + jdata.tbid).append(jdata.format(obj.list[i]));
                                    }
                                }

                                if (initpage >= obj.total) {
                                    var objh = $('#' + jdata.moreid).parent();
                                    var mhtml = objh.html();
                                    objh.html('');
                                    objh.append(mhtml);
                                    $('#' + jdata.moreid).html('木有更多了...');
                                    return false;
                                }
                                return false;
                            },
                            error: function () {
                                if (jdata.loading) {
                                    $.hideLoadding();
                                }
                                return false;
                            },
                            complete: function () {
                                if (jdata.loading) {
                                    $.hideLoadding();
                                }

                            }
                        });

                        e.stopPropagation();
                        return false;
                    }, false);
                }
            }
        },
        error: function (e) {
            if (jdata.loading) {
                $.hideLoadding();
            }
        },
        complete: function () {
            if (jdata.loading) {
                $.hideLoadding();
            }
        }
    });
};

$.pageList = function (jdata) {
    $.pagelist(jdata);
};

$.showLoadding = function () {
    $("#loadingToast").show();
}

$.hideLoadding = function () {
    $("#loadingToast").hide();
}
function showloadding() {
    $.showLoadding();
}
function hideloadding() {
    $.hideLoadding();
}

/*
--Add by Allan at 2017-06-02
--For 增加公司的访问统计代码
*/
if ($.getParam('c') == '65347') {
    //Yisheng Shangqiao
    var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
    document.write(unescape("%3Cscript src='" + _bdhmProtocol + "www.nisure.cn/piwikdatalistener/consultAnalyze.js' %3E%3C/script%3E"));

    //百度
    var _hmt = _hmt || [];
    (function () {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?bf19c98d7747d417b01a25ebea605c67";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
}
/*End Add*/

//初始化mui的地区控件
//clickId：点击触发的按钮
//AreaPId：存储省的input的id
//AreaCId：存储市的input的id
//AreaDId：存储区的input的id
function InitMuiArea(clickId, AreaPId, AreaCId, AreaDId,AreaPValue) {
    (function ($, doc) {
        //$.init();//调用页面初始化mui
        $.ready(function () {
            var cityPicker3 = new $.PopPicker({
                layer: 3
            });
            cityPicker3.setData(cityData3);
            var defaultSelect = '440000';
            if (AreaPValue != undefined && AreaPValue != null && AreaPValue!='') {
                for (var i = 0; i < cityData3.length; i++) {
                    var _item = cityData3[i];
                    if (_item.text == AreaPValue) {
                        defaultSelect = _item.value;
                        break;
                    }
                }
            }

            cityPicker3.pickers[0].setSelectedValue(defaultSelect);
            var showCityPickerButton = doc.getElementById(clickId);
            var AccidentAreaP = doc.getElementById(AreaPId);
            var AccidentAreaC = doc.getElementById(AreaCId);
            var AccidentAreaD = doc.getElementById(AreaDId);
            showCityPickerButton.addEventListener('tap', function (event) {
                cityPicker3.show(function (items) {
                    showCityPickerButton.innerText = (items[0] || {}).text + " " + (items[1] || {}).text + " " + ((items[2] || {}).text == undefined ? "" : (items[2] || {}).text);

                    AccidentAreaP.value = (items[0] || {}).text;
                    AccidentAreaC.value = (items[1] || {}).text;
                    AccidentAreaD.value = ((items[2] || {}).text == undefined ? "" : (items[2] || {}).text);

                    //cityPicker3.dispose();
                    //返回 false 可以阻止选择框的关闭
                    //return false;
                });
            }, false);
        });
    })(mui, document);
}

//初始化mui选择多地区控件
//clickId：点击触发的按钮
//AreaBox：展示多地区的地方
function InitMultiMoreArea(clickId, AreaBox,layerLevel) {

    (function ($, doc) {
        $.ready(function () {
            var cityPicker3 = new $.PopPicker({
                layer: layerLevel
            });
            cityPicker3.setData(cityData3);
            cityPicker3.pickers[0].setSelectedValue('440000');
            var showCityPickerButton = doc.getElementById(clickId);

            var AccidentAreaBox = doc.getElementById(AreaBox);

            showCityPickerButton.addEventListener('tap', function (event) {
                cityPicker3.show(function (items) {

                    var html = '<div class="pickAreaFather" style="float:left;">';
                    html = html + '<div class="pickAreaClose" style="float:right;margin-left:5px;font-size:0.95em;color:#ff0000">×</div>';
                    html = html + '<div style="overflow:hidden;">';
                    html = html + (items[0] || {}).text + "" + (items[1] || {}).text + "" + ((items[2] || {}).text == undefined ? "" : (items[2] || {}).text);
                    html = html + '<input type="hidden" name="WorkAreas" value="' + (items[0] || {}).text + "|" + (items[1] || {}).text + "|" + ((items[2] || {}).text == undefined ? "" : (items[2] || {}).text) + '" />';
                    html=html+'</div>';
                    html = html + '</div>';
                    var oldHtml = AccidentAreaBox.innerHTML;

                    var ret1 = new RegExp(html).test(oldHtml);

                    if (!ret1) {
                        AccidentAreaBox.insertAdjacentHTML('beforeend', html);
                    }

                    initPickAreaClose('pickAreaClose');

                });
            }, false);
        });
    })(mui, document);
}

function initPickAreaClose(className)
{

    $("." + className).click(function () {
        $(this).parent().remove();
    });
}


//文件已迁移到verify.js，请动态引用~/Views/Shared/_VerifyJsTmpl
//var waitTime = 60;

//function getvcode(PhoneId, codeBtn) {
//    var phone = $("#" + PhoneId).val();
//    if (phone == '' || phone == null || phone == undefined) {
//        alert('请输入手机号码');
//        $("#" + PhoneId).focus();
//        return;
//    }

//    if (!(/^1[3|4|5|6|7|8|9][0-9]\d{8}$/.test($.trim(phone)))) {
//        alert("请输入正确的手机号码");
//        return;
//    }
//    if (window.verify == undefined || window.verify == null) {
//        verify=  new TencentCaptcha(
//    $("#" + codeBtn)[0],
//    '2081444708',
//    function (res) {

//        if (res.ret === 0) {

//            $.ajax({
//                url: baseurl + "/Common/SendSMS",
//                data: { no: $("#" + PhoneId).val(), ticket: res.ticket, randstr: res.randstr },
//                cache: false,
//                type: 'POST',
//                success: function (data) {
//                    if (data.r == true) {
//                        time($("#" + codeBtn));
//                    } else {
//                        alert(data.msg)
//                    }
//                }
//            });

//        }
//    },
//    { bizState: phone }
//    );
//        window.verify.show();
//    }
//}


//function time(o) {
//    if (waitTime == 0) {
//        $(o).removeAttr('disabled');
//        $(o).html("获取验证码").removeClass('btn-disabled');
//        waitTime = 60
//    } else {
//        $(o).attr("disabled", "disabled");
//        $(o).html(waitTime + "秒后重新获取").addClass('btn-disabled');
//        waitTime--;
//        setTimeout(function () {
//            time(o)
//        }, 1000)
//    }
//}

//开启分享功能
function InitOpenWeiXinShare(appid, timestamp, nonceStr, signature, title, desc, link, imgUrl) {
    wx.config({
        debug: false,
        appId: appid,
        timestamp: timestamp,
        nonceStr: nonceStr,
        signature: signature,
        jsApiList:
            ['checkJsApi',
                'onMenuShareAppMessage',
                'hideMenuItems',
                'showMenuItems',
                'getLocation',
                'onMenuShareTimeline'
            ]
    });

    wx.ready(function () {

        wx.checkJsApi({
            jsApiList: [
                'onMenuShareAppMessage',
                'hideMenuItems',
                'showMenuItems',
                'onMenuShareTimeline'
            ],
            success: function (res) {
            }
        });

        wx.hideMenuItems({
            menuList: [
                'menuItem:share:qq',
                'menuItem:share:weiboApp',
                'menuItem:favorite',
                'menuItem:share:email',
                'menuItem:share:QZone'
            ]
        });

        wx.onMenuShareAppMessage({
            title: title,
            desc: desc,
            link: link,
            imgUrl: imgUrl,
            success: function () {

            },
            cancel: function () {

            }
        });

    });
}


//关闭分享功能
function InitCloseWeiXinShare(appid, timestamp, nonceStr, signature, title, desc, link, imgUrl) {
    wx.config({
        debug: false,
        appId: appid,
        timestamp: timestamp,
        nonceStr: nonceStr,
        signature: signature,
        jsApiList:
            ['checkJsApi',
                'hideMenuItems',
                'showMenuItems',
                'getLocation',
            ]
    });
}


//select下拉选项选择器初始
//SelectUlId：存放在页面选项数据<ul>的id，数据摆放格式参考 投诉家政公司页面的"<ul id=FromSourceUl></ul>"这个地方
//ClickBtn：触发mui选项弹窗的按钮
//SetValueId：存储选择后值的input的id
//otherFunction：事件方法，如果选择后需要另外执行别的事件，请将方法名传入

function InitMuiSelect(SelectUlId, ClickBtn, SetValueId, otherFunction) {
    var SelectUlStr = "";

    $("#" + SelectUlId + " li").each(function () {
        var val = $(this).attr("data-val");
        var name = $(this).attr("data-name");

        if (SelectUlStr == "") {
            SelectUlStr = "{value:'" + val + "',text:'" + name + "'}";
        } else {
            SelectUlStr = SelectUlStr + "," + "{value:'" + val + "',text:'" + name + "'}";
        }
    });

    var SelectUlJson = (new Function("return [" + SelectUlStr + "]"))();

    (function ($, doc) {
        //$.init();//调用页面初始化mui
        $.ready(function () {
            //普通示例
            var userPicker = new $.PopPicker();

            userPicker.setData(SelectUlJson);
            if (doc.getElementById(ClickBtn) == null || doc.getElementById(ClickBtn)==undefined) {
                return;
            }
            var showUserPickerButton = doc.getElementById(ClickBtn);
            var userResult = doc.getElementById(SetValueId);

            userPicker.pickers[0].setSelectedIndex(0);
            showUserPickerButton.addEventListener('tap', function (event) {
                userPicker.show(function (items) {
                    showUserPickerButton.innerHTML = items[0].text;
                    userResult.value = items[0].value;
                    //返回 false 可以阻止选择框的关闭
                    //return false;

                    if (otherFunction != undefined && otherFunction != "") {
                        otherFunction(items[0].value);
                    }
                    //userPicker.dispose();
                });
                return false;
            }, false);
        });
    })(mui, document);
}

/**
 * <summary>询问对话框插件，此jquery插件基于weui，所以使用时一定要引用weui.css</summary>
 *<param name="text">提示内容</param>
 *<param name="ok">确认回调函数</param>
 *<param name="cancel">取消回调函数</param>
 * <author>zqs</author>
 *<createtime>2017/12/02</createtime>
 **/
; (function ($) {
    $.fn.confirm = function (options) {
        var defaults = {
            text: '您确认当前操作吗',
            ok: function () { },
            cancel: function () { }
        };
        var settings = $.extend({}, defaults, options);

        $('.weui_dialog_confirm').remove();
        if ($('.weui_dialog_confirm').length == 0) {
            $(document.body).append('<div class="weui_dialog_confirm"><div class="weui_mask"></div><div class="weui_dialog"><div class="weui_dialog_hd"><strong class="weui_dialog_title"></strong></div><div class="weui_dialog_bd">' + settings.text + '</div><div class="weui_dialog_ft"><a href="javascript:;" class="weui_btn_dialog default" id="cancel">取消</a><a href="javascript:;" class="weui_btn_dialog primary" id="sure">确定</a></div></div></div>');
        }

        $('.weui_dialog_confirm').on('click', '#cancel', function () {
            settings.cancel();
            $(this).parents('.weui_dialog_confirm').remove();
        });
        $('.weui_dialog_confirm').on('click', '#sure', function () {
            settings.ok();
            $(this).parents('.weui_dialog_confirm').remove();
        });

    };
})(jQuery);

//时间控件
(function ($) {
    $.fn.pickDate = function (func) {
        var _this = $(this);

        _this.click(function () {
            var optionsJson = _this.attr('data-options');

            var _function = _this.attr("data-function");
            var options;
            if (optionsJson == null || optionsJson == undefined || optionsJson == undefined || options == '') {
                options = { type: 'date' }
            }
            else {
                try {
                    options = JSON.parse(optionsJson);
                } catch (e) {
                    options = { type: 'date' }
                }
            }



            var picker = new mui.DtPicker(options);
            picker.show(function (rs) {
                _this.html(rs.text);
                _this.siblings('input').val(rs.text);

                if (func != null && func != undefined)
                {
                    func();
                }

                picker.dispose();
            });

            return false;
        });

    }
})(jQuery);


//根据url渲染页面到底部弹出层
function loadUrlToBottomDialog(url) {
    if ($('.bottom-dialog').length == 0) {
        $('.mui-content').append('<div class="bottom-dialog"><div class="bottom-dialog-content"></div></div>');
    }

    $.showLoadding();
    $(".bottom-dialog-content").load(url, function () {
        $.hideLoadding();

        $('.bottom-dialog').animate({ 'bottom': 0 });
        $(document.body).append('<div class="mui-backdrop" style="opacity:1"></div>');
    });
}
//关闭底部弹出层
function closeBottomDialog() {
    $(".bottom-dialog").animate({ 'bottom': '-100%' });
    $('.mui-backdrop').remove();
}