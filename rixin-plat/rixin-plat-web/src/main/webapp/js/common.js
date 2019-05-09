(function() {
    if(window.StringUtils) return;

    var StringUtils = {
        isNull : function(name){
            if(name == "" || name == undefined || name == null)
                return true;
            return false;
        },

        isNotNull : function(name){
            return !StringUtils.isNull(name);
        },

        trim : function(str) {
            return str.replace(/(^\s*)|(\s*$)/g, "");
        }
    };

    function ajax_post_json(__url, _data, _callback) {
        jQuery.ajax({
            cache: false,
            type: "POST",
            url: __url,
            data: _data,
            contentType:"application/json; charset=UTF-8",
            success: function(data, status) {
                if(!data || data["ret"] == 1) {
                    layer.msg(data["message"]);
                    return;
                }
                _callback(data["json"], status);
            }
        });
    }

    function ajax_post_data(__url, _data, _callback) {
        jQuery.ajax({
            cache: false,
            type: "POST",
            url: __url,
            data: _data,
            contentType:"application/x-www-form-urlencoded; charset=UTF-8",
            success: function(data, status) {
                if(!data || data["ret"] == 1) {
                    layer.msg(data["message"]);
                    return;
                }
                _callback(data["json"], status);
            }
        });
    }

    window.StringUtils = StringUtils;
    window.ajax_post_json = ajax_post_json;
    window.ajax_post_data = ajax_post_data;
})(window);