package com.rixin.wechat.bean.entity.template;

/**
 * 行业信息.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class Industry {
    private String firstClass;
    private String secondClass;

    public String getFirstClass() {
        return firstClass;
    }

    public void setFirstClass(String firstClass) {
        this.firstClass = firstClass;
    }

    public String getSecondClass() {
        return secondClass;
    }

    public void setSecondClass(String secondClass) {
        this.secondClass = secondClass;
    }

    @Override
    public String toString() {
        return "Industry{"
                + "firstClass='" + firstClass + '\''
                + ", secondClass='" + secondClass + '\''
                + '}';
    }
}
