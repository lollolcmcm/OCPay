package com.stormfives.ocpay.common.util;/** * Created by luyangjian on 2017/9/22. */public class AesReq {    private String value;//前端实际参数JSON字符串通过AES加密产生的字符串    public String getValue() {        return value;    }    public void setValue(String value) {        this.value = value;    }}