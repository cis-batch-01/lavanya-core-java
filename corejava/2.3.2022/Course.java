package corejava.exception;

public class Course {
	private Integer id;
	private String title;
	private String skillLevel;
	private String language;
	private Double rating;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(String skillLevel) {
		this.skillLevel = skillLevel;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Course() {
		super();

	}

	public Course(Integer id, String title, String skillLevel, String language, Double rating) {
		super();
		this.id = id;
		this.title = title;
		this.skillLevel = skillLevel;
		this.language = language;
		this.rating = rating;
	}

	@Override
	public String toString() {
		//return "Id=" + id + "\nTitle=" + title + "\nSkillLevel=" + skillLevel + "\nLanguage=" + language + "\nRating="
			//	+ rating + "\n";
		return String.format("%-15s%-15s%-15s%-15s%-15s", id,title,skillLevel,language,rating);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Course other = (Course) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}
