package corejava.exception;

public class CourseNotFoundByTitle extends Exception {
	String message;

	public CourseNotFoundByTitle(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
