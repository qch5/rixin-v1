(function(){
    var formTools = {
        check_value : function(obj) {
            var err_text = "";
            var data_type = $(obj).attr("data-type");
            var value = StringUtils.trim($(obj).val());
            if (value == "") {
                if ($(obj).attr("data-must") == "true") {
                    return $(obj).attr("data-name") + "不能为空";
                } else {
                    return "";
                }
            }
            if(StringUtils.isNotNull($(obj).attr("data-maxLength"))){
                if(value.length > $(obj).attr("data-maxLength")){
                    return $(obj).attr("data-name") + "最大长度为" + $(obj).attr("data-maxLength");
                }
            }
            var reg;
            switch (data_type) {
                case "mobiletel":
                    reg = /^(0[\d]{2,3})\-(\d{7,8})(\-(\d{3,}))?$|^1\d{10}$/;
                    err_text = "电话号码为空或格式不正确";
                    break;
                case "email":
                    reg = /^(\w-*\.*\**)+@(\w-?)+(\.\w{2,})+$/;
                    err_text = "邮箱为空或值不正确";
                    break;
                case "mobile":
                    reg = /^1[0-9*]{10}$/;
                    err_text = "手机号码为空或格式不正确";
                    break;
                case "number":
                    reg = /^[0-9]+(\.[0-9]{0,2})?$/;
                    err_text = "只能填写数字";
                    break;
                case "ints":
                    reg = /^100000$|^([1-9])([0-9]{0,4})$/;
                    err_text = "只能填写正整数字，1~100000";
                    break;
            }
            if (reg !== undefined && !reg.test(value)) {
                return err_text;
            }
            return "";
        },

        check_form : function(form) {
            var can_submit = true;
            var err_text = "";
            var list = $(form).find("input[type!='file'],textarea");
            for(var i = 0; i < list.length; i++) {
                if (formTools.check_value($(list).eq(i)) !== "") {
                    err_text = formTools.check_value($(list).eq(i));
                    if(err_text !== ""){
                        can_submit = false;
                        $(list).eq(i).nextAll(".invoice-tips").html(err_text);
                        $(list).eq(i).parent().addClass("tips-err");
                    }
                }
            }
            return can_submit;
        },

        getFormParams : function(form) {
            var param = {};
            var list = $(form).find("input,select,textarea");
            for (var i = 0; i < list.length; i++) {
                if($(list).eq(i).attr("type") == "checkbox" && $(list).eq(i).attr("checked") != "checked") {
                    continue;
                }
                var key = $(list).eq(i).attr("name");
                var value = $(list).eq(i).val();
                if(StringUtils.isNull(key)) {
                    continue;
                }
                if($(list).eq(i).attr("data-type") == "array") {
                    param[key] = value.split(",");
                    continue;
                }
                if(param[key]) {
                    param[key] += "," + value;
                    continue;
                }
                param[key] = value;
            }
            return param;
        }
    };

    var formEvent = {
        submit : function(config) {
            var forms = $(config.btn).parents(".formBox");
            if(formTools.check_form(forms)) {
                var params = formTools.getFormParams(forms);
                ajax_post_json(config.url, JSON.stringify(params), function (data) {
                    layer.confirm(config.successMsg, {
                        btn: ['确定']
                    }, function(){
                        config.callBack(data);
                    });
                });
            }
        },

        fieldFocus : function(){
            $(this).parent().removeClass("tips-err");
        },

        fieldBlur : function(){
            var _errText = formTools.check_value(this);
            if(StringUtils.isNotNull(_errText)){
                $(this).nextAll(".invoice-tips").html(_errText);
                $(this).parent().addClass("tips-err");
            }
        },

        radioEvt : function(){
            $(this).parents("dd").removeClass("tips-err");
            $(this).siblings("label").find("i").removeClass("radio-check");
            $(this).find("i").addClass("radio-check");
            var value = $(this).attr("data");
            $(this).parents("dd").find("input").val(value);
        },
    };

    var pageInit = {
        dataMush : function() {
            var form = $(".formBox");
            var list = $(form).find("input[type!='hidden'], textarea, select");
            for(var i = 0; i < list.length; i++) {
                var input = $(list).eq(i);
                var must = input.attr("data-must");
                if(!must) {
                    continue;
                }
                input.parents("dd").append('<span style="color: red;">　*</span>');
                input.parents("dd").append('<p class="invoice-tips"></p>');
            }
        },
        orderSubmit : function() {
            pageInit.dataMush();
            $(".formBox").on("focus", "input,textarea", formEvent.fieldFocus);
            $(".formBox").on("blur", "input,textarea", formEvent.fieldBlur);
            $(".dropdown-btn").click(function(e) {
                $(this).parent().toggleClass("open");
                e.stopPropagation();
            });

            $(".dropdown-list").on("click", "li a", function() {
                var name = $(this).text();
                $(this).parents(".select-box").find(".select-value").text(name);
                $(this).parents(".select-box").find("input").val($(this).attr("value") ? $(this).attr("value") : name);
            });

            var url = $(".btn_submit").parents(".formBox").attr("action");
            $(".btn_submit").on("click", function() {
                formEvent.submit({
                    btn : $(".btn_submit"),
                    url : url,
                    successMsg : "提交成功",
                    callBack : function(){
                        parent.location.reload();
                    }
                });
            });
            $(".list_radio").on("click", "label", formEvent.radioEvt);
        }
    };

    $(document).ready(function () {
        var url = $(".formBox").attr("action");
        if(url && url.indexOf("/info") > 0) {
            var list = $(".formBox").find("input,textarea");
            for(var i = 0; i < list.length; i++) {
                $(list).eq(i).attr("readonly", "readonly");
            }
            $(".btn_wrap").remove();
            $(".select2").prop("disabled", true);
        } else {
            pageInit.orderSubmit();
        }

        $('#unSelect').dblclick(function() {
            $("option:selected", this).appendTo('#isSelect');
            multipleSetValue($(this));
        });

        $('#isSelect').dblclick(function() {
            $("option:selected", this).appendTo('#unSelect');
            multipleSetValue($(this));
        });

        $('#selectAdd').click(function() {
            $('#unSelect option:selected').appendTo('#isSelect');
            multipleSetValue($(this));
        });

        $('#selectDel').click(function() {
            $('#isSelect option:selected').appendTo('#unSelect');
            multipleSetValue($(this));
        });

        function multipleSetValue(_this) {
            var selected = [];
            $("#isSelect").find("option").each(function() {
                selected.push($(this).val());
            });
            $(_this).parents("dd").find("input[type='hidden']").val(selected);
        }

        $(document).click(function(e) {
            $(".select-box").removeClass("open");
        });
    })

})();
