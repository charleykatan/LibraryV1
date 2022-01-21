package com.qa.main.items;

public class Thesis extends Item {

	private String discipline;

	public void describe() {
		System.out.println(this.getAuthorSurname() + ", " + this.getAuthorFirstname() + " (" + this.getPubYear() + "). "
				+ this.getTitle() + ".");
	}

	@Override
	public String toString() {
		return super.toString() + " Discipline: School of " + discipline;
	}

	public Thesis() {
		super();
	}

	public Thesis(String title, String authorSurname, String authorFirstname, int pubYear, String discipline) {
		super(title, authorSurname, authorFirstname, pubYear);
		this.discipline = discipline;
	}

	public String getDiscipline() {
		return discipline;
	}

	public void setDiscipline(String discipline) {
		this.discipline = discipline;
	}

	public void updateDiscipline(String newDiscipline) {
		this.setDiscipline(newDiscipline);
	}
	
}
