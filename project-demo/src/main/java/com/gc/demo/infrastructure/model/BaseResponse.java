package com.gc.demo.infrastructure.model;

/**
 * 引用规范易华录微服务开发规范[V0.1]
 * 
 */
public class BaseResponse<T> {
	public static final class Code {
		public static final int OK = 0;
		public static final int ERROR = 9;
	}

	// 状态码
	private int status;
	// 返回数据
	private T data;
	// 标准错误
	private String message;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
