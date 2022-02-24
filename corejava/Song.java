package corejava.music;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;

public class Song implements Comparable<Song> {
	
 private String title;
 private String genre;
 private Date duration;
 private Double rating;
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getGenre() {
	return genre;
}
public void setGenre(String genre) {
	this.genre = genre;
}
public Date getDuration() {
	return duration;
}
public void setDuration(Date duration) {
	this.duration = duration;
}
public Double getRating() {
	return rating;
}
public void setRating(Double rating) {
	this.rating = rating;
}
public Song() {
	super();
	// TODO Auto-generated constructor stub
}
public Song(String title, String genre, Date duration, Double rating) {
	super();
	this.title = title;
	this.genre = genre;
	this.duration = duration;
	this.rating = rating;
}
@Override
public String toString() {
	SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
	return "Song [title=" + title + ", genre=" + genre + ", duration=" + sdf.format(duration) + ", rating=" + rating + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((duration == null) ? 0 : duration.hashCode());
	result = prime * result + ((title == null) ? 0 : title.hashCode());
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
	Song other = (Song) obj;
	if (duration == null) {
		if (other.duration != null)
			return false;
	} else if (!duration.equals(other.duration))
		return false;
	if (title == null) {
		if (other.title != null)
			return false;
	} else if (!title.equals(other.title))
		return false;
	return true;
}
 
 public static Song CreateSong(String line) throws ParseException
 {
	 SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
	 String[] songs1= line.split(",");
		String title=songs1[0];
		String genre=songs1[1];
		Date duration=sdf.parse(songs1[2]);
		double rating=Double.parseDouble(songs1[3]);
		Song newsong = new Song(title, genre, duration, rating);
		return newsong;
 }

public int compareTo(Song o) {

	return this.getTitle().compareTo(o.getTitle());
}
 }

