package com.technocis.lms.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.technocis.lms.Topic;
import com.technocis.lms.User;
import com.technocis.lms.repo.UserRepo;

public class UserRepoImpl implements UserRepo {
	// static List<Topic> topicList=new ArrayList<Topic>();
	static List<User> userList = new ArrayList<User>();

	static {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		userList.add(new User(1, "lavanya", "lavanya@gmail.com", 8778804219L, "user",new ArrayList<Topic>()));
		userList.add(new User(2, "divya", "divya@gmail.com", 8778804219L, "user",new ArrayList<Topic>()));
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

	public User selectCourse(User user, Topic topic) {
		user.getTopicList().add(topic);
		return user;

	}
	public User FindUser(String email) {
		//List<User> user = new ArrayList<User>();
		User user=null;
		for (User users : userList) {
			if (users.getEmail().equals(email)) {
				//user.add(users);
				user=users;
			}
		}
		return user;
	}
}
