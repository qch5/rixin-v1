package com.rixin.wechat.bean.response.menu;


import com.rixin.wechat.bean.entity.menu.Button;
import com.rixin.wechat.bean.response.BaseResponse;

import java.util.List;

public class TryMatchResponse extends BaseResponse {
    private List<Button> button;

    public List<Button> getButton() {
        return button;
    }

    public void setButton(List<Button> button) {
        this.button = button;
    }

    @Override
    public String toString() {
        return "TryMatchResponse{"
                + "button=" + button
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
