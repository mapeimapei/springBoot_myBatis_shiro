package com.mapei.www.result;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

//实现返回对象实体
@Data
public class Response {
	/** 返回信息码*/
	private String resultCode="000000";
	/** 返回信息内容*/
	private String resultMsg="操作成功";
	/** 返回请求完成时间*/
	private String consumeTime = "";

	public Response() {
		this.consumeTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}
	
	public Response(ExceptionMsg msg){
		this();
		this.resultCode=msg.getCode();
		this.resultMsg=msg.getMsg();
	}
	
	public Response(String resultCode) {
		this();
		this.resultCode = resultCode;
		this.resultMsg = "";
	}

	public Response(String resultCode, String resultMsg) {
		this();
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
	}

	@Override
	public String toString() {
		return "Response{" +
				"resultCode='" + resultCode + '\'' +
				", resultMsg='" + resultMsg + '\'' +
				", consumeTime='" + consumeTime + '\'' +
				'}';
	}
}

