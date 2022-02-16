
public class Student {

	int tamil;
	int english;
	int maths;
	int science;
	int social;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int tamil, int english, int maths, int science, int social) {
		super();
		this.tamil = tamil;
		this.english = english;
		this.maths = maths;
		this.science = science;
		this.social = social;
	}
	
	public int calTotal(int tamil, int english, int maths, int science, int social)
	{
		int total = tamil + english + maths + science + social;
		return total;
	}
	
}
 
