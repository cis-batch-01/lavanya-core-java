package com.technocis.LMS;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Topic {
	private Integer tId;
	private String tName;
	private String tDescription;
	private Date createdDate;

	public Integer gettId() {
		return tId;
	}

	public void settId(Integer tId) {
		this.tId = tId;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public String gettDescription() {
		return tDescription;
	}

	public void settDescription(String tDescription) {
		this.tDescription = tDescription;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Topic() {
		super();
	
	}

	public Topic(Integer tId, String tName, String tDescription, Date createdDate) {
		super();
		this.tId = tId;
		this.tName = tName;
		this.tDescription = tDescription;
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "Topic Id=" + tId + "\nTopic Name=" + tName + "\nTopic Description=" + tDescription + "\nCreated Date="
				+ createdDate + "\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tId == null) ? 0 : tId.hashCode());
		result = prime * result + ((tName == null) ? 0 : tName.hashCode());
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
		Topic other = (Topic) obj;
		if (tId == null) {
			if (other.tId != null)
				return false;
		} else if (!tId.equals(other.tId))
			return false;
		if (tName == null) {
			if (other.tName != null)
				return false;
		} else if (!tName.equals(other.tName))
			return false;
		return true;
	}

	public static Topic createTopic(String detail) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String[] splitted = detail.split(",");
		Integer tId = Integer.parseInt(splitted[0]);
		String tName = splitted[1];
		String tDescription = splitted[2];
		Date createdDate = sdf.parse(splitted[3]);
		Topic topic = new Topic(tId, tName, tDescription, createdDate);
		return topic;

	}
}
