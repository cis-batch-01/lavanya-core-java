package com.technocis.LMS.repo;

import java.util.List;

import com.technocis.LMS.User;

public interface UserRepo {

	public List<User> getAllUser();

	public User getUser(int id);

	public boolean addUser(User user);

	public boolean removeUser(int id);

	public boolean updateUser(int id, User user);

}
