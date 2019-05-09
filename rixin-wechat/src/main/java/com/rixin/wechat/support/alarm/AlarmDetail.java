package com.rixin.wechat.support.alarm;

import lombok.Data;

import java.util.List;

/**
 * 预警信息列表.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
@Data
public class AlarmDetail {
    List<Station> station;
}
