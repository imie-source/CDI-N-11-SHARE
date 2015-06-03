package fr.imie;

public class Launcher {
	
	public static void main(String[] args) {
		Personne personne = new Professor("Folamour",1000);
		Student personne2 = (Student)personne;
		personne2.sayHello();

	}
}
