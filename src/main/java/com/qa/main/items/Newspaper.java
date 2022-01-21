package com.qa.main.items;

public class Newspaper extends Item {

	private int issueNo;

	public int getIssueNo() {
		return issueNo;
	}

	public void setIssueNo(int issueNo) {
		this.issueNo = issueNo;
	}

	public void describe() {
		System.out.println("A " + this.getPubYear() + " edition of " + this.getTitle() + ".");
	}

	@Override
	public String toString() {
		return super.toString() + " Issue Number: " + issueNo;
	}

	public Newspaper() {
		super();
	}

	public Newspaper(String title, String authorSurname, String authorFirstname, int pubYear, int issueNo) {
		super(title, authorSurname, authorFirstname, pubYear);
		this.issueNo = issueNo;
	}

	public void updateIssue(int newIssue) {
		this.setIssueNo(newIssue);
	}

}
