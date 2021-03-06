package com.technocis.lms.repo;

import java.util.List;

import com.technocis.lms.Topic;
import com.technocis.lms.User;

public interface UserRepo {

	public List<User> getAllUser();

	public User getUser(int id);

	public boolean addUser(User user);

	public boolean removeUser(int id);

	public boolean updateUser(int id, User user);

	public User selectCourse(User user, Topic topic);
}
