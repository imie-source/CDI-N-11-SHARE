/**
 * 
 */
package fr.imie;

/**
 * @author imie
 *
 */
public class Rectangle extends Shape {
	
	private Float width;
	private Float height;

	
	
	public Rectangle(Float width, Float height) {
		super();
		this.width = width;
		this.height = height;
	}

	/* (non-Javadoc)
	 * @see fr.imie.Shape#area()
	 */
	@Override
	public Float area() {
		return width*height;
	}

	/* (non-Javadoc)
	 * @see fr.imie.Shape#perimeter()
	 */
	@Override
	public Float perimeter() {
		return (height+width)*2;
	}

	public Float getWidth() {
		return width;
	}

	public void setWidth(Float width) {
		this.width = width;
	}

	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}

}
