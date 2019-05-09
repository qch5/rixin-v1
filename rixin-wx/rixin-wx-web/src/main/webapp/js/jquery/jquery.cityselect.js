(function($) {
        $.fn.citySelect = function(settings) {
            if (this.length < 1) {
                return
            }
            settings = $.extend({
                url: "js/city.min.js",
                prov: null,
                city: null,
                dist: null,
                nodata: null,
                showall: false,
                required: true,
                pdefaulttext: null,
                cdefaulttext: null,
                ddefaulttext: null
            }, settings);
            var box_obj = this;
            var prov_obj = box_obj.find(".prov");
            var city_obj = box_obj.find(".city");
            var dist_obj = box_obj.find(".dist");
            var prov_val = settings.prov;
            var city_val = settings.city;
            var dist_val = settings.dist;
            var showall_val = settings.showall;
            var pdefaulttext = settings.pdefaulttext == null ? "<option value=''>省</option>" : "<option value=''>" + settings.pdefaulttext + "</option>";
            var cdefaulttext = settings.cdefaulttext == null ? "<option value=''>市</option>" : "<option value=''>" + settings.cdefaulttext + "</option>";
            var ddefaulttext = settings.ddefaulttext == null ? "<option value=''>区</option>" : "<option value=''>" + settings.ddefaulttext + "</option>";
            var pselect_prehtml = (settings.required) ? "" : pdefaulttext;
            var select_prehtml = (settings.required) ? "" : "<option value=''>请选择</option>";
            var city_json;
            var cityStart = function() {
                var prov_id = prov_obj.get(0).selectedIndex;
                if (!settings.required) {
                    prov_id--
                }
                city_obj.empty().attr("disabled", true);
                dist_obj.empty().attr("disabled", true);
                if (prov_id < 0 || typeof (city_json.citylist[prov_id].c) == "undefined") {
                    if (settings.nodata == "none") {
                        city_obj.css("display", "none");
                        dist_obj.css("display", "none")
                    } else {
                        if (settings.nodata == "hidden") {
                            city_obj.css("visibility", "hidden");
                            dist_obj.css("visibility", "hidden")
                        }
                    }
                    return
                }
                temp_html = cdefaulttext;
                $.each(city_json.citylist[prov_id].c, function(i, city) {
                    temp_html += "<option value='" + city.n + "'>" + city.n + "</option>"
                });
                city_obj.html(temp_html).attr("disabled", false).css({
                    "display": "",
                    "visibility": ""
                });
                distStart()
            };
            var distStart = function() {
                var prov_id = prov_obj.get(0).selectedIndex;
                var city_id = city_obj.get(0).selectedIndex;
                if (!settings.required) {
                    prov_id--;
                    city_id--
                }
                dist_obj.empty().attr("disabled", true);
                if (prov_id < 0 || city_id < 0 || typeof (city_json.citylist[prov_id].c[city_id].a) == "undefined") {
                    if (settings.nodata == "none") {
                        dist_obj.css("display", "none")
                    } else {
                        if (settings.nodata == "hidden") {
                            dist_obj.css("visibility", "hidden")
                        }
                    }
                    return
                }
                temp_html = ddefaulttext;
                if (showall_val) {
                    temp_html += "<option value=''>全部</option>"
                }
                $.each(city_json.citylist[prov_id].c[city_id].a, function(i, dist) {
                    temp_html += "<option value='" + dist.s + "'>" + dist.s + "</option>"
                });
                dist_obj.html(temp_html).attr("disabled", false).css({
                    "display": "",
                    "visibility": ""
                });
                dist_obj.change()
            };
            var init = function() {
                temp_html = pselect_prehtml;
                $.each(city_json.citylist, function(i, prov) {
                    temp_html += "<option value='" + prov.p + "'>" + prov.p + "</option>"
                });
                prov_obj.html(temp_html);
                setTimeout(function() {
                    if (settings.prov != null) {
                        prov_obj.val(settings.prov);
                        cityStart();
                        setTimeout(function() {
                            if (settings.city != null) {
                                city_obj.val(settings.city);
                                distStart();
                                setTimeout(function() {
                                    if (settings.dist != null) {
                                        dist_obj.val(settings.dist)
                                    }
                                }, 1)
                            }
                        }, 1)
                    }
                }, 1);
                prov_obj.bind("change", function() {
                    cityStart()
                });
                city_obj.bind("change", function() {
                    distStart()
                })
            };
            if (typeof (settings.url) == "string") {
                $.getJSON(settings.url, function(json) {
                    city_json = json;
                    init()
                })
            } else {
                city_json = settings.url;
                init()
            }
        }
    }
)(jQuery);
