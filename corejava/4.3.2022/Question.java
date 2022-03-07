package corejava.workout.ropomodel;

public class Question {

	private Integer id;
	private Integer topicId;
	private String content;
	private String answer;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Question() {
		super();

	}

	public Question(Integer id, Integer topicId, String content, String answer) {
		super();
		this.id = id;
		this.topicId = topicId;
		this.content = content;
		this.answer = answer;
	}

	@Override
	public String toString() {
		//return "Question id=" + id + ", topicId=" + topicId + ", content=" + content + ", answer=" + answer + "\n";
		return String.format("%-15s%-15s%-30s%-15s", id,topicId,content,answer);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Question other = (Question) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public static Question createQuestion(String detail) {

		String[] question = detail.split(",");
		Integer id = Integer.parseInt(question[0]);
		Integer topicId = Integer.parseInt(question[1]);
		String content = question[2];
		String answer = question[3];
		Question questions=new Question(id, topicId, content, answer);
		
		return questions;

	}
}
