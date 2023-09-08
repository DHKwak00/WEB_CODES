package edu.web.homework;

import java.util.Arrays;

/*2. MemberVO.java 파일
 - src.edu.web.homework 패키지에 MemberVO.java 클래스 생성
 - (변수들은 위의 form input name과 동일하게 작성)
 - MemberVO 기본 생성자 및 매개변수 생성자, getter/setter는 무조건 생성
 - String[] interest; (관심사항은 배열로 변수 선언)
 - request.getParameterValues() : checkbox로 선택된 여러 개의 데이터를 저장(선택 안할 수 있다.)*/

public class MemberVO {
	private String userId;
	private String password;
	private String email;
	private String emailAgree;
	private String[] interest;
	private String phone;
	private String introdue;
	
	public MemberVO() {
		
	}

	public MemberVO(String userId, String password, String email, String emailAgree, String[] interest, String phone,
			String introdue) {
		super();
		this.userId = userId;
		this.password = password;
		this.email = email;
		this.emailAgree = emailAgree;
		this.interest = interest;
		this.phone = phone;
		this.introdue = introdue;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailAgree() {
		return emailAgree;
	}

	public void setEmailAgree(String emailAgree) {
		this.emailAgree = emailAgree;
	}

	public String[] getInterest() {
		return interest;
	}

	public void setInterest(String[] interest) {
		this.interest = interest;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIntrodue() {
		return introdue;
	}

	public void setIntrodue(String introdue) {
		this.introdue = introdue;
	}

	@Override
	public String toString() {
		return "MemberVO [userId=" + userId + ", password=" + password + ", email=" + email + ", emailAgree="
				+ emailAgree + ", interest=" + Arrays.toString(interest) + ", phone=" + phone + ", introdue=" + introdue
				+ "]";
	}

	
}
