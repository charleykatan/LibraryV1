package com.qa.main.items;

public class Books extends Item {

	// Attributes
	private int length;
	private String genre;

	// Constructors
	public Books() {
		super();
	}

	public Books(String title, String authorSurname, String authorFirstname, int pubYear, int length, String genre) {
		super(title, authorSurname, authorFirstname, pubYear);
		this.length = length;
		this.genre = genre;
	}
	
	// toString
	@Override
	public String toString() {
		return super.toString() + ", of genre " + genre + ", with length: " + length + " pages";
	}
	
	// Abstract method, polymorphism
	public void describe() {
		System.out.println(
				"A " + this.getGenre() + " book by " + this.getAuthorFirstname() + " " + this.getAuthorSurname() + ".");
	}

	// Getters and Setters
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	// Updating unique attributes
	public void updateLength(int newLength) {
		this.setLength(newLength);
	}

	public void updateGenre(String newGenre) {
		this.setGenre(newGenre);
	}

}
