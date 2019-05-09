package com.rixin.wechat.support.msg.proccessor;

import com.rixin.wechat.bean.xml.in.InMessage;


/**
 * 微信消息处理器.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public interface MsgProcessor {
    /**
     * 消费处理微信消息.
     *
     * @param inMsg 微信消息
     * @param out   返回的结果
     */
    boolean process(InMessage inMsg, String out);
}
