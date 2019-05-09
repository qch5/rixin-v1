package com.rixin.wx.controller;

import com.rixin.base.config.Constants;
import com.rixin.wechat.utils.message.MessageUtil;
import com.rixin.wechat.utils.message.XmlUtil;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang.StringUtils;
import org.dom4j.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;

/**
 * User: dairan
 * Date: 2019-04-14 22:44
 */
@Controller
@RequestMapping("/wx")
public class WxController {
    private static final Logger logger = LoggerFactory.getLogger(WxController.class);
    private static final String TOKEN = "RIXINDAOJIA";

    @RequestMapping(method = RequestMethod.GET, value = "")
    public void index(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String signature = request.getParameter("signature");       // 获得signature
        String timestamp = request.getParameter("timestamp");       // 获得timestamp
        String nonce = request.getParameter("nonce");               // 获得nonce
        String echostr = request.getParameter("echostr");           // 获得echostr

        logger.error("timestamp：{}", timestamp);
        logger.error("nonce：{}", nonce);
        logger.error("signature：{}", signature);
        logger.error("echostr：{}", echostr);

        String[] arr = new String[] {TOKEN, timestamp, nonce};
        Arrays.sort(arr);
        StringBuilder content = new StringBuilder();
        content.append(arr[0]).append(arr[1]).append(arr[2]);
        String hash = null;
        try {
            hash = new String(Hex.encodeHex(MessageDigest.getInstance("SHA-1").digest(content.toString().getBytes(Constants.CHARSET_NAME))));
            logger.error("加密后：{}",  hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        PrintWriter out = response.getWriter();
        if(StringUtils.isNotBlank(hash) && hash.equals(signature)) {
            out.print(echostr);
        }
        out.close();
    }

    @RequestMapping(method = RequestMethod.POST, value = "")
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String message = "success";
        try {
            Map<String, String> map = XmlUtil.xmlToMap(request);
            String fromUserName = map.get("FromUserName");//消息来源用户标识
            String toUserName = map.get("ToUserName");//消息目的用户标识
            String msgType = map.get("MsgType");//消息类型
            String content = map.get("Content");//消息内容

            String eventType = map.get("Event");
            if(MessageUtil.MSGTYPE_EVENT.equals(msgType)){                                                              // 如果为事件类型
                if(MessageUtil.MESSAGE_SUBSCIBE.equals(eventType)){                                                     // 处理订阅事件
                    message = MessageUtil.subscribeForText(toUserName, fromUserName);
                }else if(MessageUtil.MESSAGE_UNSUBSCIBE.equals(eventType)){                                             // 处理取消订阅事件
                    message = MessageUtil.unsubscribe(toUserName, fromUserName);
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally{
            out.println(message);
            if(out!=null){
                out.close();
            }
        }
    }
}
