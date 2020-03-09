package com.designpatterns.creational.builder;

public class UserTest {

	public static void main(String[] args) {
		User user = new User.UserBuilder("Tanaya", "Karmakar")
				.age(31)
				.build();
		
		System.out.println(user);
		
		User user1 = new User.UserBuilder("Mishti", "Mew")
				.age(1)
				.jobTitle("BeingCute")
				.address("Bangalore")
				.build();
		
		System.out.println(user1);

	}

}
