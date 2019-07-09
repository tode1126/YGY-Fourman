package spring.data;

public class LoginDto {
	private String user_Email;
	private String user_Pass;
	private int user_grade;

	public String getUser_Email() {
		return user_Email;
	}

	public void setUser_Email(String user_Email) {
		this.user_Email = user_Email;
	}

	public String getUser_Pass() {
		return user_Pass;
	}

	public void setUser_Pass(String user_Pass) {
		this.user_Pass = user_Pass;
	}

	public int getUser_grade() {
		return user_grade;
	}

	public void setUser_grade(int user_grade) {
		this.user_grade = user_grade;
	}

}
