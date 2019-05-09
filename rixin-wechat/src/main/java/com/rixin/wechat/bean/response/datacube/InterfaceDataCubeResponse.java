package com.rixin.wechat.bean.response.datacube;

import com.rixin.wechat.bean.entity.datacube.InterfaceDataCube;
import com.rixin.wechat.bean.response.BaseResponse;

import java.util.List;

public class InterfaceDataCubeResponse extends BaseResponse {
    private List<InterfaceDataCube> list;

    public List<InterfaceDataCube> getList() {
        return list;
    }

    public void setList(List<InterfaceDataCube> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "InterfaceDataCubeResponse{"
                + "list=" + list
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
