/**
 * 
 */
package fr.imie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author imie
 *
 */
public class SocketListener implements Runnable {

	Socket socket;

	public SocketListener(Socket socket) {
		super();
		this.socket = socket;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		Boolean flag = false;
		try (BufferedReader in = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));) {

			while (!flag) {
				String s = in.readLine();
				if (s == null) {
					System.out.println("deconnexion client");
					flag=true;
				} else {
					System.out.println(s);
				}
			}
		} catch (IOException e) {
			System.out.println("socket cassé");
			e.printStackTrace();
		}
	}

}
