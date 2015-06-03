/**
 * 
 */
package fr.imie;

/**
 * @author imie
 *
 */
public abstract class Shape {
	
	private String name;

	public abstract Float area();
	public abstract Float perimeter();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
}
