package com.mapei.www.result;

import lombok.Data;

//实现返回对象实体
@Data
public class Response {
	/** 返回信息码*/
	private String resultCode="000000";
	/** 返回信息内容*/
	private String resultMsg="操作成功";

	public Response() {
	}
	
	public Response(ExceptionMsg msg){
		this.resultCode=msg.getCode();
		this.resultMsg=msg.getMsg();
	}
	
	public Response(String resultCode) {
		this.resultCode = resultCode;
		this.resultMsg = "";
	}

	public Response(String resultCode, String resultMsg) {
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
	}

	@Override
	public String toString() {
		return "Response{" +
				"resultCode='" + resultCode + '\'' +
				", resultMsg='" + resultMsg + '\'' +
				'}';
	}
}

