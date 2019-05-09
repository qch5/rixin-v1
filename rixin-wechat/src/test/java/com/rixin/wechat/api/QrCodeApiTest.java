package com.rixin.wechat.api;

import com.rixin.wechat.bean.MediaFile;
import com.rixin.wechat.bean.response.qrcode.QrCodeResponse;
import org.junit.Assert;
import org.junit.Test;

/**
 * 二维码API测试.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class QrCodeApiTest extends BaseApiTest {
    @Test
    public void testCreateTempAndDownLoad() {
        QrCodeResponse result = QrCodeApi.createTemp(TOKEN, 6000, 10);
        System.out.println("Create Temp QrCode: " + result);
        Assert.assertEquals(true, result.isSuccess());

        MediaFile file = QrCodeApi.download(result.getTicket());
        System.out.println("Download QrCode: " + file);
        Assert.assertNotNull(file.getFileStream());
    }

    @Test
    public void testCreateFinal() {
        QrCodeResponse result = QrCodeApi.createFinal(TOKEN, 10);
        System.out.println("Create Final QrCode: " + result);
        Assert.assertEquals(true, result.isSuccess());
    }
}
