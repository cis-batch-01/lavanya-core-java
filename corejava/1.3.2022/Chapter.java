package com.technocis.corejava.practice;

public class Chapter {
 private String cId;
 private String cName;
 private String cDescription;
 private String cContent; // for url 
public String getcId() {
	return cId;
}
public void setcId(String cId) {
	this.cId = cId;
}
public String getcName() {
	return cName;
}
public void setcName(String cName) {
	this.cName = cName;
}
public String getcDescription() {
	return cDescription;
}
public void setcDescription(String cDescription) {
	this.cDescription = cDescription;
}
public String getcContent() {
	return cContent;
}
public void setcContent(String cContent) {
	this.cContent = cContent;
}
public Chapter() {
	super();
	// TODO Auto-generated constructor stub
}
public Chapter(String cId, String cName, String cDescription, String cContent) {
	super();
	this.cId = cId;
	this.cName = cName;
	this.cDescription = cDescription;
	this.cContent = cContent;
}
@Override
public String toString() {
	return "\nChapterId=" + cId + "\nChapterName=" + cName + "\nChapterDescription=" + cDescription + "\nChapterContent=" + cContent
			+ "\n";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((cContent == null) ? 0 : cContent.hashCode());
	result = prime * result + ((cDescription == null) ? 0 : cDescription.hashCode());
	result = prime * result + ((cId == null) ? 0 : cId.hashCode());
	result = prime * result + ((cName == null) ? 0 : cName.hashCode());
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
	Chapter other = (Chapter) obj;
	if (cContent == null) {
		if (other.cContent != null)
			return false;
	} else if (!cContent.equals(other.cContent))
		return false;
	if (cDescription == null) {
		if (other.cDescription != null)
			return false;
	} else if (!cDescription.equals(other.cDescription))
		return false;
	if (cId == null) {
		if (other.cId != null)
			return false;
	} else if (!cId.equals(other.cId))
		return false;
	if (cName == null) {
		if (other.cName != null)
			return false;
	} else if (!cName.equals(other.cName))
		return false;
	return true;
}
 
public static Chapter createChapter(String chapterDetail) {
	String[] chapterDetails = chapterDetail.split(",");
	String cId = chapterDetails[0];
	String cName = chapterDetails[1];
	String cDescription = chapterDetails[2];
	String cContent = chapterDetails[3];
	Chapter chapter = new Chapter(cId, cName, cDescription, cContent);
	return chapter;

}

}
