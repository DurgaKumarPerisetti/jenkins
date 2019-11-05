package com.cloud.response;

import java.util.ArrayList;
import java.util.List;

import com.cloud.utils.User;

public class GetUserResponse {

	List<User> users = new ArrayList<User>();

	/**
	 * @return the users
	 */
	public List<User> getUsers() {
		return users;
	}

	/**
	 * @param users
	 *            the users to set
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}

}
