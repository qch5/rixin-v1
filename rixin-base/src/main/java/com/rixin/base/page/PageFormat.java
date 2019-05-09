package com.rixin.base.page;

/**
 * User: dairan
 * Date: 2015-12-04 20:55
 */
public interface PageFormat {
	String format(PageMeta page);
	String format(PageMeta page, String url);
	String getUrl();
}
