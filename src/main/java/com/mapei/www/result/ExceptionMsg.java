
package com.mapei.www.result;
//实现响应的枚举类
public enum ExceptionMsg {
	SUCCESS("20000", "操作成功"),
	FAILED("999999","操作失败"),
    UNAUTHORIZED("000009","无权限"),
    ParamError("000500", "参数错误！"),
    FileEmpty("000400","上传文件为空"),
    LimitPictureSize("000401","图片大小必须小于2M"),
    LimitPictureType("000402","图片格式必须为'jpg'、'png'、'jpge'、'gif'、'bmp'")
    ;
   private ExceptionMsg(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    private String code;
    private String msg;
    
	public String getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}

    
}

