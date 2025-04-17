package reflection;


public class User {
	private String Username;
	

	private String Password;	// 암호화 필요, spring 이 특정 필드(@Encrtypt 이 붙은 ) 에 대해서 암호화
	

	public User() {}
	public User(String username, String password) {
		super();
		this.Username=username;
		this.Password=password;
	}
	
	
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	
	@Override
	public String toString() {
		return "User [Username=" + Username + ", Password=" + Password + "]";
	}
	
	
}
