package com.rixin.base.file;

import com.rixin.base.config.Constants;
import com.rixin.base.exception.WOException;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URI;
import java.util.Calendar;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * User: dairan
 * Date: 2015-12-29 11:27
 */
public class FileSystemFileServer implements FileServer {
    private static final Logger logger = LoggerFactory.getLogger(FileSystemFileServer.class);

    private File base;

    public FileSystemFileServer() {
        base = new File(Constants.FILE_FS_BASE);
        if (base.exists() == false) {
            base.mkdirs();
        }
    }

    /**
     * 单文件上传
     */
    @Override
    public String getSavedFileUrl(String dirType, MultipartFile file) {
        String url = "";
        if(file == null) {
            logger.info("文件不存在");
            return url;
        }
        String fileName = file.getOriginalFilename();
        String fileLocation = this.initBasicDirectoryStructure(dirType) + FileUtil.getUniqueFileName(fileName);
        if(!StringUtils.isBlank(fileName)) {
            File destFile = new File(base.getPath() + fileLocation);
            try {
                file.transferTo(destFile);
                url = FileUtil.formatRelativeURL(fileLocation);
            } catch (Exception e) {
                logger.error("上传文件失败：{}", e);
                e.printStackTrace();
            }
        }
        return url;
    }

    /**
     * 文件批量上传，打包
     */
    @Override
    public String getSavedFileUrl(String dirType, List<MultipartFile> list, List<String> xy) throws Exception {
        String url = "";
        if(CollectionUtils.isEmpty(list)) {
            logger.info("文件不存在");
            return url;
        }
        if(list.size() != xy.size()) {
            throw new WOException("文件数与坐标数不一致");
        }
        String zipLocation = this.initBasicDirectoryStructure(dirType) + FileUtil.getUniqueZipName();
        File zipFile = new File(base.getPath() + zipLocation);
        if(!zipFile.createNewFile()) {
            throw new Exception("ZIP文件已存在");
        }
        ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(zipFile));
        byte[] buffer = new byte[1024];
        for(int i = 0; i < list.size(); i ++) {
            MultipartFile file = list.get(i);
            String dir = xy.get(i);
            String fileName = FileUtil.getUniqueFileName(file.getOriginalFilename());
            if(StringUtils.isBlank(fileName)) {
                continue;
            }
            String fileLocation = this.initBasicDirectoryStructure(dirType) + fileName;
            File destFile = new File(base.getPath() + fileLocation);
            try {
                file.transferTo(destFile);
                FileInputStream input = new FileInputStream(destFile);
                logger.error("destFile: {}   fileName: {}", destFile.getName(), fileName);
                zip.putNextEntry(new ZipEntry(dir.concat(File.separator).concat(destFile.getName())));
                int len = 0;
                while((len = input.read(buffer)) > 0) {
                    zip.write(buffer, 0, len);
                }
                zip.closeEntry();
                input.close();
            } catch (Exception e) {
                logger.error("上传文件失败：{}", e);
                e.printStackTrace();
            } finally {
                destFile.delete();
            }
        }
        zip.close();
        return FileUtil.formatRelativeURL(zipLocation);
    }

    @Override
    public InputStream openForRead(URI uri) throws IOException {
        return new FileInputStream(new File(uri));
    }

    @Override
    public URI locate(String name) {
        File f = getFile(name);
        if (f.exists()) {
            return f.toURI();
        } else {
            return null;
        }
    }

    private File getFile(String name) {
        return new File(base, name);
    }

    /**
     * 初始化目录结构
     */
    public String initBasicDirectoryStructure(String dirType) {
        StringBuffer path = new StringBuffer();
        path.append(Constants.STORAGE_TOP_DIR);
        path.append(dirType);

        Calendar c = Calendar.getInstance();
        path.append(File.separator);
        path.append(c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1));
        path.append(File.separator);
        File secondDir = new File(base.getPath().concat(File.separator).concat(path.toString()));
        if(!secondDir.exists()) {
            secondDir.mkdirs();
        }
        return path.toString();
    }

    /**
     * 文件拷贝
     */
    public boolean copy(File srcFile, File destFile) {
        try {
            destFile.getParentFile().mkdirs();
            FileUtils.copyFile(srcFile, destFile);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
