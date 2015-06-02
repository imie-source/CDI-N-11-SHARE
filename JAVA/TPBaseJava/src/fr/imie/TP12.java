/**
 * 
 */
package fr.imie;

/**
 * @author imie
 *
 */
public class TP12 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] tab= {1,2,3,4,5};
		for (int i = 0; i < tab.length-1; i++) {
			Integer tmp = tab[i];
			tab[i]=tab[i+1];
			tab[i+1]=tmp;
		}
		
		System.out.print("nouveau tableau : ");
		for (Integer value : tab) {
			System.out.format("%d,", value);
		}
		System.out.println("");
		

	}

}
