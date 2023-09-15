package edu.web.el01;

public class ContactVO {
	private String name;
	private String phone;
	private String eamil;
	public ContactVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ContactVO(String name, String phone, String eamil) {
		super();
		this.name = name;
		this.phone = phone;
		this.eamil = eamil;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEamil() {
		return eamil;
	}
	public void setEamil(String eamil) {
		this.eamil = eamil;
	}
	@Override
	public String toString() {
		return "ContactVO [name=" + name + ", phone=" + phone + ", eamil=" + eamil + "]";
	}
	
	
}
