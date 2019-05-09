package com.rixin.base.task;

/**
 * User: dairan
 * Date: 2017 - 06 - 12 11:20
 */
public interface EventHander {
	
	void onEvent(String key, String eventType);
	
}
