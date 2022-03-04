package corejava.workout.ropomodel;

public class QuestionNotFoundException extends Exception {

	String message;

	public QuestionNotFoundException(String message) {
		super();
		this.message = message;

	}

	@Override
	public String getMessage() {
	
		return message;
	}

	@Override
	public String toString() {
		return "QuestionNotFoundException [message=" + message + "]";
	}

}
