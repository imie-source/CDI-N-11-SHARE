/**
 * 
 */
package fr.imie;

/**
 * @author imie
 *
 */
public class TP6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer inputFact = 3;	
		System.out.printf("résultat de factioriel %d = %d",inputFact, fact(inputFact));
	}
	
	public static Integer fact(Integer inputFact){
		Integer retour;
		if (inputFact>1){
			retour= inputFact*(fact(inputFact-1));
		}else{
			retour=1;
		}
		return retour;
	}

}
