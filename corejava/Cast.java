package com.technocis.corejava;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cast {
	private String name;
	private String nationality;
	private String gender;
	private Date dob;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Cast() {
		super();
	}
	public Cast(String name, String nationality, String gender, Date dob) {
		super();
		this.name = name;
		this.nationality = nationality;
		this.gender = gender;
		this.dob = dob;
	}
	@Override
	public String toString() {
		SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
		return "Name=" + name + "\nNationality=" + nationality + "\nGender=" + gender + "\nDob=" + sdf.format(dob) +"\n";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Cast other = (Cast) obj;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	public static Cast createCast(String line) throws ParseException
	{
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		String[] castData= line.split(",");
		String name=castData[0];
		String nationality=castData[1];
		String gender=castData[2];
		Date dob=sdf.parse(castData[3]);
		Cast newCast= new Cast(name, nationality, gender, dob);
		return newCast;
	}
}
