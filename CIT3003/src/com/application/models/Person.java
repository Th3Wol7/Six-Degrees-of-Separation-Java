package com.application.models;
/*This class represents the model of a person 
 * @author Tyrien Gilpin
 * Version 1
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable, Comparable<Person>{
	private String username;
	private String firstName;
	private String lastName;
	private String Phone;
	private String email;
	private String community;
	private String school;
	private String employer;
	private int privacy;
	private List<String> activity;
	
	

	//Default Constructor
	public Person() {
		this.username = "";
		this.firstName = "N/A";
		this.lastName = "N/A";
		this.Phone = "N/A";
		this.email = "N/A";
		this.community = "N/A";
		this.school = "N/A";
		this.employer = "N/A";
		this.privacy = 0;
		this.activity = new ArrayList<>();
	}

	// Primary Constructor
	public Person(String username, String firstName, String lastName, String phone, String email, 
			String community, String school, String employer, int privacy, List<String> activity) {
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.Phone = phone;
		this.email = email;
		this.community = community;
		this.school = school;
		this.employer = employer;
		this.privacy = privacy;
		this.activity = activity;
	}

	// Copy Constructor
	public Person(Person obj) {
		this.username = obj.username;
		this.firstName = obj.firstName;
		this.lastName = obj.lastName;
		this.Phone = obj.Phone;
		this.email = obj.email;
		this.community = obj.community;
		this.school = obj.school;
		this.employer = obj.employer;
		this.privacy = obj.privacy;
		this.activity = obj.activity;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCommunity() {
		return community;
	}

	public void setCommunity(String community) {
		this.community = community;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getEmployer() {
		return employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public int getPrivacy() {
		return privacy;
	}

	public void setPrivacy(int privacy) {
		this.privacy = privacy;
	}
	public List<String>  getActivity() {
		return activity;
	}

	public void setActivity(List<String> activity) {
		this.activity = activity;
	}

	@Override
	public String toString() {
		return "Username: "+ getUsername()+ "\nFirstname: " + getFirstName() + "\nLastname: " + getLastName() + "\nPhone: "
				+ getPhone() + "\nEmail: " + getEmail() + "\nCommunity: " + getCommunity() + "\nSchool: "
				+ getSchool() + "\nEmployer: " + getEmployer() + "\nPrivacy: " + getPrivacy() +"\n Activities: " +getActivity();
	}

	@Override
	public int compareTo(Person obj) {
		return this.getFirstName().compareTo(obj.getFirstName());
	}

}
