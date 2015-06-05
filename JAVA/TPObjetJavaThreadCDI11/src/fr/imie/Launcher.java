package fr.imie;

public class Launcher {

	public static void main(String[] args) {
		Long initTime = System.currentTimeMillis();

		Calcul calcul = new Calcul();
		//calcul.setVal(5);
		Thread thread = new Thread(new monRunnableCalcul(calcul,5));

		//Calcul calcul2 = new Calcul();
		//calcul2.setVal(15);
		Thread thread2 = new Thread(new monRunnableCalcul(calcul,5));
		
		thread.start();
//		try {
//			thread.join();
//		} catch (InterruptedException e) {
//			// TODO sdfkjgblsdfjhglfsdh
//			e.printStackTrace();
//		}
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}

		thread2.start();

//		try {
//			thread2.join();
//		} catch (InterruptedException e) {
//			// TODO sdfkjgblsdfjhglfsdh
//			e.printStackTrace();
//		}

		System.out.format("Fin Launcher; durée : %d",
				System.currentTimeMillis() - initTime);

	}
}
