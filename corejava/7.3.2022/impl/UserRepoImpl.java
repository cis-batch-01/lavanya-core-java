package com.technocis.LMS.impl;

import java.util.ArrayList;
import java.util.List;

import com.technocis.LMS.User;
import com.technocis.LMS.repo.UserRepo;

public class UserRepoImpl implements UserRepo {

	static List<User> userList = new ArrayList<User>();
	static {
		userList.add(new User(1, "lavanya", "la@gmail.com", 9845318551L, topicList);
		//(1, "Java", "full stack", sdf.parse("21-12-2000"))
	}

	public List<User> getAllUser() { // to get all users

		return userList;
	}

	public User getUser(int id) { // to get a particular user
		User resUser = null;
		for (User user : userList) {
			if (user.getId() == id) {
				resUser = user;
			}
		}
		return resUser;
	}

	public boolean addUser(User user) { // to add a particular user by id

		return userList.add(user);
	}

	public boolean removeUser(int id) { // to remove a particular user by id
		User user = getUser(id);
		return userList.remove(user);
	}

	public boolean updateUser(int id, User user) { // to remove by userid and edit it
		userList.remove(id);
		return userList.add(user);

	}

}
