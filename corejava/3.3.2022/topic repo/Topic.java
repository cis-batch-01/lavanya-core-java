package corejava.workout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Topic {
	private Integer tId;
	private String tName;
	private String tDescription;
	private Date tCreatedDate;
	
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
	public Date gettCreatedDate() {
		return tCreatedDate;
	}
	public void settCreatedDate(Date tCreatedDate) {
		this.tCreatedDate = tCreatedDate;
	}
	public Topic(Integer tId, String tName, String tDescription, Date tCreatedDate) {
		super();
		this.tId = tId;
		this.tName = tName;
		this.tDescription = tDescription;
		this.tCreatedDate = tCreatedDate;
	}
	public Topic() {
		super();
	
	}
	@Override
	public String toString() {
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		//return "\nTopic Id=" + tId + "\nTopic Name=" + tName + "\n Topic Description=" + tDescription + "\n Topic Created Date="
		//		+ tCreatedDate + "\n";
		return String.format("%-15s%-15s%-15s%-15s", tId,tName,tDescription,sdf.format(tCreatedDate));
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
	
	public static Topic createTopic(String topicDetail) throws ParseException
	{
		SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
		String[] topic=topicDetail.split(",");
		Integer tId = Integer.parseInt(topic[0]);
		String tName=topic[1];
		String tDescription = topic[2];
		Date tCreatedDate = sdf.parse(topic[3]);
		Topic topics = new Topic(tId, tName, tDescription, tCreatedDate);
		return topics;
		
	}
}
