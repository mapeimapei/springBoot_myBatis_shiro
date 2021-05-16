package com.mapei.www.result;

import lombok.Data;

//返回结果数据格式封装
@Data
public class ResponseData extends Response {
    private Object result;

    public ResponseData(Object result) {
        this.result = result;
    }

    public ResponseData(ExceptionMsg msg) {
        super(msg);
    }

    public ResponseData(String resultCode, String resultMsg) {
        super(resultCode, resultMsg);
    }

    public ResponseData(String resultCode, String resultMsg, Object result) {
        super(resultCode, resultMsg);
        this.result = result;
    }

    public ResponseData(ExceptionMsg msg, Object result) {
        super(msg);
        this.result = result;
    }


    @Override
    public String toString() {
        return "ResponseData{" +
                "result=" + result +
                "} " + super.toString();
    }
}
