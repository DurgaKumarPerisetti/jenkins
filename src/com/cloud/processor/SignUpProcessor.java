package com.cloud.processor;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.cloud.request.SignUpRequest;
import com.cloud.response.SignUpResponse;
import com.cloud.utils.CommonUtils;

public class SignUpProcessor extends ServiceProcessor {
	
	public SignUpProcessor(SignUpRequest request, SignUpResponse response) {
		super(request, response);
	}

	public CommonUtils cu;
	

	@Override
	public void processGet() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processPost() {
		SignUpRequest request = (SignUpRequest) getRequest();
		SignUpResponse response = (SignUpResponse) getResponse();
		String userName = request.getUserName();
		String email = request.getEmail();
		String password = request.getPassword();
		String password2 = request.getPassword2();

		if (userName != null && userName.length() > 5) {
			if(email != null && password != null && password2!= null){
				if(password.equals(password2)) {
					cu = new CommonUtils();
					//Connection con = cu.connectToDB();
					Connection con = cu.connectToAzure();
					try {
						Statement stmt = con.createStatement();
						stmt.executeUpdate("INSERT INTO SIGNUP VALUES (" + "'"+userName+"'" + "," +"'"+email+"'"+","+"'"+password+"'"+")");
					} catch (SQLException e) {
						response.addAlert(e.getMessage());
					}
					
				} else {
					response.addAlert("Dude! Password and confirm password does not matched..!");
				}
				
			} else {
				response.addAlert("Dude! e mail or password should not be null");
			}
		}
		else {
			response.addAlert("Dude! User Name invalid");
		}
		
	}

	@Override
	public void processUpdate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processDelete() {
		// TODO Auto-generated method stub
		
	}
	
}
