package com.cloud.response;

import java.util.ArrayList;
import java.util.List;

public class BaseResponse {
	
	private boolean successful = true;
	private List<String> alerts = new ArrayList<>();
	
	public boolean isSuccessful() {
		return successful;
	}
	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}
	public List<String> getAlerts() {
		return alerts;
	}
	public void setAlerts(List<String> alerts) {
		this.alerts = alerts;
	}
	
	public void addAlert(String error){
		alerts.add(error);
		successful = false;
	}
}
