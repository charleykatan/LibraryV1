package com.qa.main.person;

import java.util.ArrayList;
import java.util.List;

import com.qa.main.items.*;

public class Person {
	
	private String firstName;
	private String surname;
	private int memberNo;
	private int itemsBorrowed;
	
	private List<Item> loans = new ArrayList<Item>();
	
	public Person(String firstName, String surname) {
		this.firstName = firstName;
		this.surname = surname;
	}
	
	@Override
	public String toString() {
		return firstName + " " + surname + ", Member Number " + memberNo;
	}

	public Person() {
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getItemsBorrowed() {
		return itemsBorrowed;
	}

	public void setItemsBorrowed(int itemsBorrowed) {
		this.itemsBorrowed = itemsBorrowed;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public List<Item> getLoans() {
		return loans;
	}

	public void setLoans(List<Item> loans) {
		this.loans = loans;
	}

}
