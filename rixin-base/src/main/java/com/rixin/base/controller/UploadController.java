package com.rixin.base.controller;

import com.rixin.base.config.Constants;
import com.rixin.base.file.FileServerFactory;
import com.rixin.base.file.FileSystemFileServer;
import com.rixin.base.model.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * User: dairan
 * Date: 2016-09-23 16:48
 */
@Controller
@RequestMapping("/")
public abstract class UploadController extends JsonController {
    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

    @RequestMapping(value = "/upload_dialog")
    public String upload() {
        return "dialog/upload";
    }

    @ResponseBody
    @RequestMapping(value = "/upload")
    public JsonResult upload(HttpServletRequest request, @RequestParam(value = "file", required = false) MultipartFile file) {
        JsonResult result = this.saveUploadData(request, file);
        String path = this.getSavedFileUrl(Constants.STORAGE_SECOND_DIR, file);
        return result;
    }

    /**
     * 获取上传文件存放路径
     */
    public String getSavedFileUrl(String dirType, MultipartFile file) {
        FileSystemFileServer fileServer = (FileSystemFileServer) FileServerFactory.getFileServer();
        String url = fileServer.getSavedFileUrl(dirType, file);
        return url;
    }
    
    /**
     * 存储表单数据
     */
    protected abstract JsonResult saveUploadData(HttpServletRequest request, MultipartFile file);
}
