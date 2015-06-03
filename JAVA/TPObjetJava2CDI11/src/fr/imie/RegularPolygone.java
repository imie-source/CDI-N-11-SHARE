/**
 * 
 */
package fr.imie;

/**
 * @author imie
 *
 */
public class RegularPolygone extends Shape{
	private Float radius;
	private Integer sideCount;
	private Float sideSize;
	
	
	
	public RegularPolygone(Float radius, Integer sideCount) {
		super();
		this.radius = radius;
		this.sideCount = sideCount;
		this.sideSize = new Float(2*radius*Math.sin(Math.PI/sideCount));
	}

	/* (non-Javadoc)
	 * @see fr.imie.Shape#area()
	 */
	@Override
	public Float area() {
		Triangle triangle= new Triangle(radius,radius,sideSize);
		return triangle.area()*sideCount;
	}
	
	/* (non-Javadoc)
	 * @see fr.imie.Shape#perimeter()
	 */
	@Override
	public Float perimeter() {
		return sideCount*sideSize;
	}
	
	

}
