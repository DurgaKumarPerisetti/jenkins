package com.cloud.core;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.cloud.processor.SignUpProcessor;
import com.cloud.request.SignUpRequest;
import com.cloud.response.GetUserResponse;
import com.cloud.response.SignUpResponse;
import com.cloud.utils.CommonUtils;
import com.cloud.utils.User;

@Path("/trial")
public class Trial {

	public CommonUtils cu;

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_ATOM_XML })
	@Path("/hi")
	public String trial() {

		String output = "Hello Kumar! RESTful Service is running ...  " + new Date().toString();
		Gson gson = new GsonBuilder().create();
		gson.toJson(output);
		return output;
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_ATOM_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_ATOM_XML })
	@Path("/signup")
	public String signUp(String input) {

		SignUpRequest request = new SignUpRequest();
		SignUpResponse response = new SignUpResponse();
		Gson gson = new GsonBuilder().create();
		request = gson.fromJson(input, new TypeToken<SignUpRequest>(){}.getType());
		SignUpProcessor processor = new SignUpProcessor(request, response);
		processor.processPost();
		cu = new CommonUtils();
		return cu.buildResponse(response);
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_ATOM_XML })
	@Path("/list")
	public String connect() {
		List<User> users = new ArrayList<User>();
		GetUserResponse response = new GetUserResponse();
		try {
			cu = new CommonUtils();
			Connection con = cu.connectToAzure();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from SIGNUP");
			while (rs.next()) {
				User user = new User();
				user.setUserName(rs.getString(1));
				user.setEmail(rs.getString(2));
				user.setPassword(rs.getString(3));
				users.add(user);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		response.setUsers(users);
		return cu.buildResponse(response);
	}
  

}
