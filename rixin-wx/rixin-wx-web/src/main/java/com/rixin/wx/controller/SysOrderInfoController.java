package com.rixin.wx.controller;

import com.rixin.base.controller.JsonController;
import com.rixin.base.model.JsonResult;
import com.rixin.base.utils.JSONUtils;
import com.rixin.data.domain.SysOrderInfo;
import com.rixin.data.service.SysOrderInfoService;
import com.rixin.wechat.bean.response.user.UserResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * User: dairan
 * Date: 2019-04-21 12:29
 */
@Controller
@RequestMapping("/sysOrderInfo")
public class SysOrderInfoController extends JsonController {

    @Resource
    private SysOrderInfoService sysOrderInfoService;

    @RequestMapping("")
    public String index(HttpServletRequest request, ModelMap map) {
        HttpSession session = request.getSession();
        UserResponse userInfo = (UserResponse) session.getAttribute("userInfo");
        List<SysOrderInfo> list = sysOrderInfoService.selectByOpenId(userInfo.getOpenid());
        map.put("list", list);
        return "/sysOrderInfo/index";
    }

    @RequestMapping("create")
    public String create() {
        return "/sysOrderInfo/edit";
    }

    @ResponseBody
    @RequestMapping(value = "/create", method= RequestMethod.POST)
    public JsonResult create(HttpServletRequest request, @RequestBody Map<String, Object> map) {
        HttpSession session = request.getSession();
        UserResponse userInfo = (UserResponse) session.getAttribute("userInfo");
        String fullName = (String) map.get("fullName");
        String orderName = (String) map.get("orderName");
        String orderTime = String.valueOf(map.get("orderTime"));
        Double prices = Double.parseDouble(String.valueOf(map.get("prices")));
        Double discount = Double.parseDouble(String.valueOf(map.get("discount")));
        String address = (String) map.get("address");
        String comment = (String) map.get("comment");
        String mobile = (String) map.get("mobile");
        String orderDetail = (String) map.get("orderDetail");

        SysOrderInfo sysOrderInfo = new SysOrderInfo();
        sysOrderInfo.setOpenid(userInfo.getOpenid());
        sysOrderInfo.setFullName(fullName);
        sysOrderInfo.setOrderName(orderName);
        sysOrderInfo.setOrderTime(new Date());
        sysOrderInfo.setPrices(prices);
        sysOrderInfo.setDiscount(discount);
        sysOrderInfo.setAddress(address);
        sysOrderInfo.setComment(comment);
        sysOrderInfo.setMobile(mobile);
        sysOrderInfo.setStatus((byte) 0);
        sysOrderInfo.setCreateTime(new Date());
        sysOrderInfoService.insert(sysOrderInfo);
        return new JsonResult(RET_OK);
    }

    @RequestMapping("info")
    public String info(Integer orderId, ModelMap map) {
        SysOrderInfo info = sysOrderInfoService.selectByPrimaryKey(orderId);
        map.put("info", info);
        return "/sysOrderInfo/info";
    }

    @ResponseBody
    @RequestMapping("/api")
    public Object api() {
        String json = "{\"ret\":true,\"ts\":1555820871,\"version\":\"1.0\",\"data\":{\"order_page_info\":{\"title\":\"专业清洗\",\"success_description\":\"预约成功请等待小e上门取件\",\"categories\":[{\"category_id\":1010,\"category_name\":\"洗衣\"},{\"category_id\":1020,\"category_name\":\"洗鞋\"},{\"category_id\":1011,\"category_name\":\"洗家纺\"},{\"category_id\":1030,\"category_name\":\"洗窗帘\"},{\"category_id\":1070,\"category_name\":\"袋洗\"}],\"default_address\":{\"address_id\":5763447,\"username\":\"戴\",\"tel\":\"18610875668\",\"city\":\"北京\",\"city_id\":1,\"area\":\"朝阳区\",\"area_id\":1,\"address\":\"恒大江湾 1207\",\"address_line_1\":\"恒大江湾\",\"address_line_2\":\"1207\",\"available_category_ids\":[1,1010,1011,2,1020,3,1030,4,2040,5,2050,7,1070]},\"order_tips\":{\"background_image\":\"https://cdnopen.edaixi.com/app_resources/shopping_tip_bg@2x.png\",\"details\":[\"悠然洗特价活动不支持退洗及加急，不支持余额/e卡支付；如需正常使用余额/e卡支付、优惠券抵用请选回正价，谢谢\"]},\"delivery_fee_info\":{\"total\":[{\"sentinel_min\":\"满50.0元\",\"fee\":\"免运费\"},{\"sentinel_min\":\"不满50.0元\",\"fee\":\"10.0元\"}],\"sub\":[{\"category_id\":1010,\"category_name\":\"洗衣\",\"delivery_fee\":[{\"sentinel_min\":\"满50.0元\",\"fee\":\"免运费\"},{\"sentinel_min\":\"不满50.0元\",\"fee\":\"10.0元\"}]},{\"category_id\":1020,\"category_name\":\"洗鞋\",\"delivery_fee\":[{\"sentinel_min\":\"满50.0元\",\"fee\":\"免运费\"},{\"sentinel_min\":\"不满50.0元\",\"fee\":\"10.0元\"}]},{\"category_id\":1011,\"category_name\":\"洗家纺\",\"delivery_fee\":[{\"sentinel_min\":\"满50.0元\",\"fee\":\"免运费\"},{\"sentinel_min\":\"不满50.0元\",\"fee\":\"10.0元\"}]},{\"category_id\":1030,\"category_name\":\"洗窗帘\",\"delivery_fee\":[{\"sentinel_min\":\"全场\",\"fee\":\"免运费\"}]},{\"category_id\":1070,\"category_name\":\"袋洗\",\"delivery_fee\":[{\"sentinel_min\":\"全场\",\"fee\":\"免运费\"}]}]}},\"select_addr_url\":\"/mobile.php?m=wap&act=address&do=order_address_list&link_from=comm_order_place&back=%252Fnew_weixin%252Fview%252Fexpress_order.html%253Fcity_id%253D1%2526mark%253D66d5e0da-65b8-11e5-a990-5cb901892a54%2526price_read%253D1&city_id=1&mark=66d5e0da-65b8-11e5-a990-5cb901892a54\",\"last_order_info\":{\"ret\":true,\"ts\":1555820871,\"version\":\"5.0\",\"data\":{\"city_id\":\"1\",\"area_id\":\"1\",\"city\":\"北京\",\"area\":\"朝阳区\",\"address_id\":5763447,\"address\":\"恒大江湾 1207\",\"tel\":\"18610875668\",\"username\":\"戴\",\"is_express\":0,\"info\":\"正常单\"}},\"submit_url\":\"/mobile.php?m=wap&act=homepage&do=do_order&city_id=1&mark=66d5e0da-65b8-11e5-a990-5cb901892a54\",\"user_type\":20,\"error_index_url\":\"/mobile.php?m=wap&act=homepage&do=index&mark=66d5e0da-65b8-11e5-a990-5cb901892a54&city_id=1\"},\"message\":\"\"}";
        return JSONUtils.fromJson(json, Map.class);
    }
}
