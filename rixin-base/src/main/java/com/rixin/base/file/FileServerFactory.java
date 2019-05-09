package com.rixin.base.file;

/**
 * User: dairan
 * Date: 2015-12-29 13:22
 */
public class FileServerFactory {

    private static FileServer fs = null;

    public static FileServer getFileServer(){
        if(fs == null){
            fs = new FileSystemFileServer();
        }
        return fs;
    }
}
