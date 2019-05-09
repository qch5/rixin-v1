//function getpw() { return $(window).width(); }
//function getph() { return $(window).height(); }
//function setfontsize() {
//   var wiw = getpw();
//   var wih = getph();
//   var fz = (wiw / 750);
//    $('html').css('font-size', fz * 100);
//    $('#html_body').css('height', wih);
//}
//function loads() {
//    setfontsize();
//    $(window).on("resize", function () {
//        setfontsize();
//        setTimeout(function () { setfontsize(); }, 300);
//    })
//}
//$(function () {
//    loads();
//});

(function (doc, win) {
    var docEl = doc.documentElement,
        resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize',
        recalc = function () {
            var clientWidth = docEl.clientWidth;
            if (!clientWidth) return;
            docEl.style.fontSize = 100 * (clientWidth / 750) + 'px';
            if (doc.getElementById("html_body")) {
                doc.getElementById("html_body").style.height = docEl.clientHeight + "px";
            }

        };

    if (!doc.addEventListener) return;
    win.addEventListener(resizeEvt, recalc, false);
    doc.addEventListener('DOMContentLoaded', recalc, false);
})(document, window);