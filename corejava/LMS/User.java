package com.technocis.lms;

import java.util.ArrayList;
import java.util.List;

public class User {
	private Integer id;
	private String name;
	private String email;
	private Long phoneNo;
	private String role;
	private List<Topic> topicList;

	public Integer getId() {
		return id;
	}

	public User(Integer id, String name, String email, Long phoneNo,String role, List<Topic> topicList) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
		this.role=role;
		this.topicList = topicList;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Topic> getTopicList() {
		return topicList;
	}

	public void setTopicList(List<Topic> topicList) {
		this.topicList = topicList;
	}


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


		
	@Override
	public String toString() {
		return "User id=" + id + ", name=" + name + ", email=" + email + ", phoneNo=" + phoneNo + ", role=" + role
				+ ", topicList=" + topicList + "]";
		//return String.format("%-15s%-15s%-15s%-15s%-15s%-15s", id,name,email,phoneNo,role);
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public static User createUser(String detail) {
		String[] splitted = detail.split(",");
		Integer id = Integer.parseInt(splitted[0]);
		String name = splitted[1];
		String email = splitted[2];
		Long phoneNo = Long.parseLong(splitted[3]);
		String role=splitted[4];
		List<Topic> topicList = new ArrayList<Topic>();
		User user=new User(id, name, email, phoneNo,role, topicList);    //role is not showing
		return user;
	}
}
