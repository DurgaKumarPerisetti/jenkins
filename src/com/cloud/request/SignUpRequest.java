package com.cloud.request;

import com.google.gson.annotations.SerializedName;

public class SignUpRequest extends BaseRequest {
	
	@SerializedName("userName")
	private String userName;
	
	@SerializedName("email")
	private String email;
	
	@SerializedName("password")
	private String password;
	
	@SerializedName("password2")
	private String password2;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

}
