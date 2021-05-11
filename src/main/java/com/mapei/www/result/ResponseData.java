package com.mapei.www.result;
//返回结果数据格式封装
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

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "result=" + result +
                "} " + super.toString();
    }
}

/*return new ResponseData(ExceptionMsg.SUCCESS,"你好");*/
