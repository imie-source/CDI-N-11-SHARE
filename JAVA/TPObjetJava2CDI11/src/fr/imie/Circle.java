/**
 * 
 */
package fr.imie;

/**
 * @author imie
 *
 */
public class Circle extends Shape {

	private Float radius;
	
	
	/**
	 * @param radius
	 */
	public Circle(Float radius) {
		super();
		this.radius = radius;
	}

	/* (non-Javadoc)
	 * @see fr.imie.Shape#area()
	 */
	@Override
	public Float area() {
		return new Float(Math.PI*Math.pow(radius, 2));
	}

	/* (non-Javadoc)
	 * @see fr.imie.Shape#perimeter()
	 */
	@Override
	public Float perimeter() {
		return new Float(2*Math.PI*radius);
	}

}
