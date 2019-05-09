(function() {
    function ajax_post_json(__url, _data, _callback) {
        jQuery.ajax({
            cache: false,
            type: "POST",
            url: __url,
            data: _data,
            contentType:"application/json; charset=UTF-8",
            success: function(data, status) {
                if(!data || data["ret"] === 1) {
                    showTip(data["message"]);
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
                if(!data || data["ret"] === 1) {
                    showTip(data["message"]);
                    return;
                }
                _callback(data["json"], status);
            }
        });
    }

    function showTip(msg, url){
        $('#msg_win #msg_tip').html(msg);
        if(url){
            $('#msg_win').show().delay(2000).hide(function(){
                window.location.href = url;
            });
        }else{
            $('#msg_win').show().delay(2000).hide(0);
        }
        return;
    }

    window.ajax_post_json = ajax_post_json;
    window.ajax_post_data = ajax_post_data;
})(window);