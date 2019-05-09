package com.rixin.base.page;

import com.rixin.base.config.SystemConfig;
import com.rixin.base.utils.HttpUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 分页处理
 * User: dairan
 * Date: 2015-12-04 21:05
 */
public class DefaultPageFormat implements PageFormat {
	private static final Logger logger = LoggerFactory.getLogger(DefaultPageFormat.class);

	public static final DefaultPageFormat instance;
    public static HttpServletRequest request;

	static {
		instance = new DefaultPageFormat();
	}
	public static DefaultPageFormat getInstance() {
        if(RequestContextHolder.getRequestAttributes() != null) {
            request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        }
		return instance;
	}

	private DefaultPageFormat() {
	}

    public String getUri() {
		if(request==null){
			return "";
		}
        return request.getScheme() + "://" + SystemConfig.getDomain() + request.getServletPath();
    }

	public String getUrl() {
        String url = this.getUri();
        if(request.getQueryString() != null){
            url += "?" + request.getQueryString();
        }
        return url;
    }
	
	public String format(PageMeta page) {
		return format(page, this.getUri());
	}

	@Override
	public String format(PageMeta page, String url) {
		String target = buildTarget(url, page);
		logger.debug("page targe: {}", target);
		StringWriter buf = new StringWriter(1024);
		PrintWriter out = new PrintWriter(buf);
		if (page.getTotalRow() == 0) {
			out.println("没有记录");
		} else {
			if (page.getPage() > 1) {
                out.printf("<a href=\"%s%d\">上一页</a><b></b>", target, page.getPage() - 1);
			}
			
			if (page.getTotalPage() < 6){
				int start = 0;
				int end = page.getTotalPage();
				int current = page.getPage();
				while(start < end){
					++start;
					if(start == current){
                        out.printf("<a href=\"#\" class=\"current\">%d</a>", start);
					} else {
                        out.printf("<a href=\"%s%d\">%d</a>", target, start, start);
					}
				}

			} else {
				int start = page.getPage() - 3;
				int end = page.getPage() + 2;
				int current = page.getPage();
				start = start < 0 ? 0: start;
				end = end > page.getTotalPage() ? page.getTotalPage() : end; 

				if(start > 0){
                    out.printf("<a href=\"%s%d\">%d</a>", target, 1, 1);
				}
				if(start > 1){
					out.print("<span class=\"text\">...</span>");
				}
				
				while(start < end){
					++start;
					if(start == current){
                        out.printf("<a href=\"#\" class=\"current\">%d</a>", start);
					} else {
                        out.printf("<a href=\"%s%d\">%d</a>", target, start, start);
					}
				}
				
				if(start < page.getTotalPage() - 1){
					out.print("<span class=\"text\">...</span>");
				}
				if(start < page.getTotalPage()){
                    out.printf("<a href=\"%s%d\">%d</a>", target, page.getTotalPage(), page.getTotalPage());
				}
			}
			if (page.getPage() < page.getTotalPage()) {
                out.printf("<a href=\"%s%d\">下一页</a>", target, page.getPage() + 1);
			}
            out.printf("<span class=\"count\">共%d页 到第<input type=\"text\" class=\"w20 t-c\" value=\"1\">页 <input onclick=\"location.href='%s'+jQuery(this).prev().val()\" class=\"inactive w50\" type=\"submit\" value=\"确定\">\n</span>", page.getTotalPage(), target);
		}
		return buf.toString();
	}
	
	private String buildTarget(String uri, PageMeta page){
        Map<String, Object> validParam = new HashMap();
        Map<String, String[]> params = request.getParameterMap();
		for(Entry<String, String[]> entry : params.entrySet()){
			Object paramValue = entry.getValue();
			if(entry.getKey().equals("page")){
				continue;
			} else if(paramValue == null){
				continue;
			} else if(paramValue instanceof String){
				if(((String) paramValue).isEmpty()){
					continue;
				}
			} else if (paramValue instanceof String[]){
				if(((String[])paramValue).length == 1 && StringUtils.isBlank(((String[]) paramValue)[0])){
					continue;
				}
			}
			validParam.put(entry.getKey(), paramValue);
		}
		
		String paramString = HttpUtils.encodeParameter(validParam, "UTF-8");

		StringBuilder buffer = new StringBuilder();
		buffer.append(uri);
		if(paramString != null && paramString.length() > 0){
			if(buffer.indexOf("?") < 0){
				buffer.append("?");
			} else {
				buffer.append("&");
			}
			buffer.append(paramString);
		}
		if(buffer.indexOf("?") < 0){
			buffer.append("?");
		} else {
			buffer.append("&");
		}
		buffer.append("page=");
		return buffer.toString();
	}
}
