package com.rixin.wechat.support.msg.proccessor.loader;

import com.rixin.wechat.support.msg.proccessor.MsgProcessor;

import java.util.HashSet;

/**
 * 微信消息处理器管理器.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public interface ProcessorsMgr {
    /**
     * 获取所有的消息处理器.
     */
    HashSet<MsgProcessor> getAll();
}
