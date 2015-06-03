package fr.imie;

public class Personne {
	
	private String name;

	public Personne(String name) {
		super();
		this.name = name;
	}
	
	public void sayHello(){
		System.out.format("Hello, my name is %s", this.name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	

}
