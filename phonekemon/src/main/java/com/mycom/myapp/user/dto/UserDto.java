package com.mycom.myapp.user.dto;

import java.util.Date;

public class UserDto {

	private int userSeq;
	private String UserName;
	private String userPassword;
	private String userEmail;
	private String userProfileImage;
	private Date userRegisterDate;
	
	
	
	
	public UserDto() {}
	public UserDto(int userSeq, String userName, String userPassword, String userEmail, String userProfileImage,
			Date userRegisterDate) {
		super();
		this.userSeq = userSeq;
		this.UserName = userName;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.userProfileImage = userProfileImage;
		this.userRegisterDate = userRegisterDate;
	}
	
	public int getUserSeq() {
		return userSeq;
	}
	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserProfileImage() {
		return userProfileImage;
	}
	public void setUserProfileImage(String userProfileImage) {
		this.userProfileImage = userProfileImage;
	}
	public Date getUserRegisterDate() {
		return userRegisterDate;
	}
	public void setUserRegisterDate(Date userRegisterDate) {
		this.userRegisterDate = userRegisterDate;
	}

	@Override
	public String toString() {
		return "UserDto [userSeq=" + userSeq + ", UserName=" + UserName + ", userPassword=" + userPassword
				+ ", userEmail=" + userEmail + ", userProfileImage=" + userProfileImage + ", userRegisterDate="
				+ userRegisterDate + "]";
	}
	
	
	
	
	
}
