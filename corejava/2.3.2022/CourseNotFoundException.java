package corejava.exception;

public class CourseNotFoundException extends Exception{
	String message;

	public CourseNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	
}
