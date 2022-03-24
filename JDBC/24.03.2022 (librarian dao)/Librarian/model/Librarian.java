package com.technocis.Librarian.model;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Librarian {

	private Integer id;
	private String name;
	private Long phoneNo;
	private String email;
	private String password;
	private Date joinDate;
	private String address;
	private String areaOfInterest;

	public Integer getId() {
		return id;
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

	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
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

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAreaOfInterest() {
		return areaOfInterest;
	}

	public void setAreaOfInterest(String name) {
		this.areaOfInterest = areaOfInterest;
	}

	public Librarian() {
		super();
	}

	public Librarian(Integer id, String name, Long phoneNo, String email, String password, Date joinDate,
			String address, String areaOfInterest) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNo = phoneNo;
		this.email = email;
		this.password = password;
		this.joinDate = joinDate;
		this.address = address;
		this.areaOfInterest = areaOfInterest;
	}

	public Librarian(String name, Long phoneNo, String email, String password, Date joinDate, String address,
			String areaOfInterest) {
		super();
		this.name = name;
		this.phoneNo = phoneNo;
		this.email = email;
		this.password = password;
		this.joinDate = joinDate;
		this.address = address;
		this.areaOfInterest = areaOfInterest;
	}

	public String toString() {
		return "Id: " + id + "\nName: " + name + "\nPhone No: " + phoneNo + "\nEmail: " + email + "\nPassword: "
				+ password + "\nJoin Date: " + joinDate + "\nAddress: " + address + "\nArea of Interest: "
				+ areaOfInterest;
	}

	public static Librarian createLibrarian(String details) {
		Librarian librarian = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

			String[] splitted = details.split(",");
			String name = splitted[0];
			Long phoneNo = Long.parseLong(splitted[1]);
			String email = splitted[2];
			String password = splitted[3];
			Date joinDate = sdf.parse(splitted[4]);
			String address = splitted[5];
			String areaOfInterest = splitted[6];
			librarian = new Librarian(name, phoneNo, email, password, joinDate, address, areaOfInterest);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return librarian;
	}
}
