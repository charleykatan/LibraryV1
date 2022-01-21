package com.qa.main.items;

import com.qa.main.interfaces.Update;

public abstract class Item implements Update {

	// Attributes
	private static int nextID = 0;

	private String title;
	private String authorSurname;
	private String authorFirstname;
	private int pubYear;
	private int ID;
	private boolean available;

	// Constructors
	public Item() {
		this.ID = Item.nextID;
		Item.nextID++;
		this.setAvailable(true);
	}

	public Item(String title, String authorFirstname, String authorSurname, int pubYear) {
		this.title = title;
		this.authorSurname = authorSurname;
		this.authorFirstname = authorFirstname;
		this.pubYear = pubYear;
		this.ID = Item.nextID;
		Item.nextID++;
		this.setAvailable(true);
	}

	// Abstract method
	public abstract void describe();
	
	// toString
	@Override
	public String toString() {
		return title + " by " + authorFirstname + " " + authorSurname + ". Published in " + pubYear + ". ID: " + ID;
	}

	// Interface Update methods
	@Override
	public void updateTitle(String newTitle) {
		this.setTitle(newTitle);
	}

	@Override
	public void updateASur(String newSur) {
		this.setAuthorSurname(newSur);
	}

	@Override
	public void updateAFir(String newFir) {
		this.setAuthorFirstname(newFir);
	}

	@Override
	public void updatePubYr(int newPubYr) {
		this.setPubYear(newPubYr);
	}
	
	// Getters and Setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthorSurname() {
		return authorSurname;
	}

	public void setAuthorSurname(String authorSurname) {
		this.authorSurname = authorSurname;
	}

	public String getAuthorFirstname() {
		return authorFirstname;
	}

	public void setAuthorFirstname(String authorFirstname) {
		this.authorFirstname = authorFirstname;
	}

	public int getPubYear() {
		return pubYear;
	}

	public void setPubYear(int pubYear) {
		this.pubYear = pubYear;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public boolean getAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

}
