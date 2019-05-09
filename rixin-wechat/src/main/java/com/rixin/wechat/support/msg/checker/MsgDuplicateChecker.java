package com.rixin.wechat.support.msg.checker;

import com.rixin.wechat.bean.xml.in.InMessage;

/**
 * 微信消息重复校验器.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public interface MsgDuplicateChecker {

    /**
     * 判断微信消息是否重复.
     *
     * @param msg 微信消息
     * @return {boolean}
     */
    boolean isDuplicate(InMessage msg);
}
