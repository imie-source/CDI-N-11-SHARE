/**
 * 
 */
package fr.imie;

/**
 * @author imie
 *
 */
public class TP2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer nbPhotocopTotal = 1235;
		Double facture=0d;
		
		Integer[] nbPhotocopTranche={10,20};
		Double[] prixPhotocopTranche={0.1d,0.08d,0.05d};
		
		for (int i = 0; i < prixPhotocopTranche.length; i++) {
			Double prixPhotocop = prixPhotocopTranche[i];
			Integer nbPhotocop;
			if(i!=prixPhotocopTranche.length-1){
				nbPhotocop=Math.min(nbPhotocopTotal, nbPhotocopTranche[i]);
			}else{
				nbPhotocop=nbPhotocopTotal;
			}
			facture+=nbPhotocop*prixPhotocop;
			nbPhotocopTotal-=nbPhotocop;
		}
		
		System.out.printf("Le prix total est de : %f", facture);
		

	}

}
