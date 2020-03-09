package com.designpatterns.creational.builder;

public class User {
	private String firstName;
	private String lastName;
	private int age;
	private String jobTitle;
	private String address;
	
	private User(UserBuilder builder) {
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.age = builder.age;
		this.jobTitle = builder.jobTitle;
		this.address = builder.address;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getJobTitle() {
		return jobTitle;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append(firstName + ",");
		sb.append(lastName);
		if(age > 0) {
			sb.append(",");
			sb.append(age);
		}
		if(jobTitle != null) {
			sb.append(",");
			sb.append(jobTitle);
		}
		if(address != null) {
			sb.append(",");
			sb.append(address);
		}
		sb.append("]");
		return sb.toString();
	}
	
	static class UserBuilder {
		private String firstName;
		private String lastName;
		private int age;
		private String jobTitle;
		private String address;
		
		public UserBuilder(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}
		
		public UserBuilder age(int age) {
			this.age = age;
			return this;
		}
		
		public UserBuilder jobTitle(String jobTitle) {
			this.jobTitle = jobTitle;
			return this;
		}
		
		public UserBuilder address(String address) {
			this.address = address;
			return this;
		}
		
		public User build() {
			User user = new User(this);
			return user;
		}
	}

}
