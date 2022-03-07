package corejava.workout.ropomodel;

public class Topic {
	private Integer id;
	private String name;
	private String description;
	private String content;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Topic() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Topic(Integer id, String name, String description, String content) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.content = content;
	}

	@Override
	public String toString() {
		return "Topic [id=" + id + ", name=" + name + ", description=" + description + ", content=" + content + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Topic other = (Topic) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public static Topic createTopic(String detail) {

		String[] topics = detail.split(",");
		Integer id = Integer.parseInt(topics[0]);
		String name = topics[1];
		String description = topics[2];
		String content = topics[3];
		Topic topic=new Topic(id, name, description, content);
		
		return topic;

	}

}
