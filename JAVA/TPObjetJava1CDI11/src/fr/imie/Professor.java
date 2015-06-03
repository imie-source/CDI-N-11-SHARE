/**
 * 
 */
package fr.imie;

/**
 * @author imie
 *
 */
public class Professor extends Personne {

	Integer salary;
	
	/**
	 * 
	 */
	public Professor(String name, Integer salary) {
		super(name);
		this.salary=salary;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		super.sayHello();
		saySalary();
	}
	
	public void saySalary(){
		System.out.format(" and i earn %d£",salary);
	}
	
	

}
