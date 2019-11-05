package com.cloud.processor;

import com.cloud.request.BaseRequest;
import com.cloud.response.BaseResponse;

public abstract class ServiceProcessor {

	private BaseRequest request;
	private BaseResponse response;

	public ServiceProcessor(BaseRequest request, BaseResponse response) {
		super();
		this.request = request;
		this.response = response;
	}

	public BaseRequest getRequest() {
		return request;
	}

	public void setRequest(BaseRequest request) {
		this.request = request;
	}

	public BaseResponse getResponse() {
		return response;
	}

	public void setResponse(BaseResponse response) {
		this.response = response;
	}

	public abstract void processGet();

	public abstract void processPost();

	public abstract void processUpdate();

	public abstract void processDelete();

}
