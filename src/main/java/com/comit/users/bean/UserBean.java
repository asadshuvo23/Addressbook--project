package com.comit.users.bean;

public class UserBean {
	
	String firstName;
	String lastName;
	String emailAdress;
	String officePhone;
	String mobile;
	String designation;
	String department;
	String employeeId;
	public UserBean() {
		super();
	}
	
	public UserBean(String firstName,
			String lastName, 
			String emailAdress, 
			String officePhone,
			String mobile,
			String designation, 
			String department, 
			String employeeId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAdress = emailAdress;
		this.officePhone = officePhone;
		this.mobile = mobile;
		this.designation = designation;
		this.department = department;
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAdress() {
		return emailAdress;
	}
	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}
	public String getOfficePhone() {
		return officePhone;
	}
	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	@Override
	public String toString() {
		return "UserBean [firstName=" + firstName + ", lastName=" + lastName + ", emailAdress=" + emailAdress
				+ ", officePhone=" + officePhone + ", mobile=" + mobile + ", designation=" + designation
				+ ", department=" + department + ", employeeId=" + employeeId + "]";
	}
	
	
	

}
