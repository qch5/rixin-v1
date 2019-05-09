package com.rixin.base.file;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.List;

/**
 * User: dairan
 * Date: 2015-12-29 11:31
 */
public interface FileServer {

    String getSavedFileUrl(String dirType, MultipartFile file);

    String getSavedFileUrl(String dirType, List<MultipartFile> list, List<String> xy) throws Exception;

    InputStream openForRead(URI uri) throws IOException;

    URI locate(String name);

}
