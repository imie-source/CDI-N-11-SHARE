/**
 * 
 */
package fr.imie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author imie
 *
 */
public class LaucherClientUsager {

	/**
	 * 
	 */
	public LaucherClientUsager() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {
			try (Socket socket = new Socket("192.168.1.97", 2042)) {
				String s = "";
				SocketUsagerClientListener socketUsagerClientListener = new SocketUsagerClientListener(socket);
				new Thread(socketUsagerClientListener).start();
				PrintWriter out = new PrintWriter(socket.getOutputStream(),
						false);
				while (s.compareTo("STOP") != 0) {
					s= scanner.nextLine();
					out.println(s);
					out.flush();
				}
				System.out.println("fin saisie");
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
