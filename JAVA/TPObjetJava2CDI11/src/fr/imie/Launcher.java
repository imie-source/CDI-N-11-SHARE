/**
 * 
 */
package fr.imie;

import java.awt.Polygon;

/**
 * @author imie
 *
 */
public class Launcher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle(10f, 15f);
		rectangle.setName("rectangle1");
		printPerimeterOf(rectangle);
		printAreaOf(rectangle);
		Circle circle = new Circle(1f);
		circle.setName("circle1");
		printPerimeterOf(circle);
		printAreaOf(circle);
		Square square= new Square(10f);
		square.setName("square1");
		printPerimeterOf(square);
		printAreaOf(square);
		Triangle triangle = new Triangle(3f, 4f, 5f);
		triangle.setName("triangle1");
		printPerimeterOf(triangle);
		printAreaOf(triangle);
		RegularPolygone regularPolygone = new RegularPolygone(5*new Float(Math.sqrt(2f))/2, 4);
		regularPolygone.setName("polygone1");
		printPerimeterOf(regularPolygone);
		printAreaOf(regularPolygone);	
		RegularPolygone regularPolygone2 = new RegularPolygone(1f, 1000);
		regularPolygone2.setName("polygone2");
		printPerimeterOf(regularPolygone2);
		printAreaOf(regularPolygone2);
	
		try {
			Triangle triangle2 = new Triangle(4f, 1f, 2f);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.format("exception lors de la creation de la forme : %s\n", e.getMessage());
			throw new RuntimeException(e);
		}
		System.out.println("fin programme");
	
	}

	private static void printAreaOf(Shape shape) {
		System.out.format("aire forme %s : %f\n", shape.getName(),shape.area());
	}

	private static void printPerimeterOf(Shape shape) {
		System.out.format("perimetre forme %s : %f\n", shape.getName(), shape.perimeter());
	}

}
