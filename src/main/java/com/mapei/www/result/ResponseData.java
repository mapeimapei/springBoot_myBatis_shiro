package com.mapei.www.result;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mapei.www.util.FilterResult;

import lombok.Data;

import java.io.Serializable;

//返回结果数据格式封装
@Data
public class ResponseData extends Response implements Serializable {

    @JSONField(serialzeFeatures = {SerializerFeature.WriteMapNullValue})
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
        String jsonStr = JSONObject.toJSONString(result);
        this.result = JSONObject.parse(jsonStr);
    }

    public ResponseData(ExceptionMsg msg, Object result) {
        super(msg);
        String jsonStr = JSONObject.toJSONString(result);
        this.result = JSONObject.parse(jsonStr);
    }


    public ResponseData(ExceptionMsg msg, Object result, String[] fields) {
        super(msg);
        String jsonStr = JSONObject.toJSONString(result);
        Object res = JSONObject.parse(jsonStr);
        this.result = FilterResult.main(res, fields);
    }


    @Override
    public String toString() {
        return "ResponseData{" +
                "result=" + result +
                "} " + super.toString();
    }
}
