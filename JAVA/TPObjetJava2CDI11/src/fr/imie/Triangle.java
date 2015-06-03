/**
 * 
 */
package fr.imie;

/**
 * @author imie
 *
 */
public class Triangle extends Shape {

	private Float side1;
	private Float side2;
	private Float side3;
	
	
	
	public Triangle(Float side1, Float side2, Float side3) {
		super();
		if(side1<=0||side2<=0||side3<=0){
			throw new IllegalArgumentException("un côté ne peut pas être inférieur ou égal à 0");
		}
		if((side1>side2+side3)||(side2>side1+side3)||(side3>side1+side2)){
			throw new IllegalArgumentException("un côté ne peut pas être plus grand que la somme des deux autres");
		}
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}

	/* (non-Javadoc)
	 * @see fr.imie.Shape#area()
	 */
	@Override
	public Float area() {
		Float p = perimeter()/2;
		return new Float(Math.sqrt(p*(p-side1)*(p-side2)*(p-side3)));
	}

	/* (non-Javadoc)
	 * @see fr.imie.Shape#perimeter()
	 */
	@Override
	public Float perimeter() {
		return side1+side2+side3;
	}

}
