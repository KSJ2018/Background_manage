package com.ksj.Utils;

public enum ResponseCode {

    OK("请求成功", 200), FAIL("请求失败", 400),REASON("原因失败", 500);
    // 成员变量
    private String name;
    public int index;
    // 构造方法
    ResponseCode(String name, int index) {
        this.name = name;
        this.index = index;
    }
    //覆盖方法
    @Override
    public String toString() {
        return this.index+"_"+this.name;
    }

}
