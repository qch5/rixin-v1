package com.rixin.base.file;

import com.rixin.base.utils.Base62;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * User: dairan
 * Date: 2015-12-29 13:29
 */
public class FileUtil {
    private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);

    /**
     * 根据文件名获取文件的后缀名
     */
    public static String getFileType(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
    }

    /**
     * 根据时间生成唯一的文件名,包括相对路径，例如2011/12/***.jpg
     */
    public static String getUniqueFileName(String fileName) {
        SimpleDateFormat sdf = new SimpleDateFormat("ddHHmmssSSS");
        StringBuffer sb = new StringBuffer();
        sb.append(Base62.random(7));
        sb.append("_");
        sb.append(sdf.format(new Date()));
        if(fileName.contains(".")) {
            sb.append(".").append(getFileType(fileName));
        }
        return sb.toString();
    }

    public static String getUniqueZipName() {
        SimpleDateFormat sdf = new SimpleDateFormat("ddHHmmssSSS");
        StringBuffer sb = new StringBuffer();
        sb.append(Base62.random(7));
        sb.append("_");
        sb.append(sdf.format(new Date()));
        sb.append(".zip");
        return sb.toString();
    }

    /**
     * 将包含相对文件路径的文件名转换成URL格式的相对路径
     */
    public static String formatRelativeURL(String filePath) {
        if (StringUtils.isBlank(filePath))
            return filePath;
        return filePath.replaceAll(Pattern.quote(File.separator), "/");
    }
}
