/**
 * 
 */
package fr.imie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import fr.imie.DAO.UsagerDAO;
import fr.imie.DTO.UsagerDTO;

/**
 * @author imie
 *
 */
public class SocketUsagerServerListener implements Runnable {

	Socket socket;

	public SocketUsagerServerListener(Socket socket) {
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
			try (ObjectOutputStream out = new ObjectOutputStream(
					socket.getOutputStream())) {

				while (!flag) {
					String s = in.readLine();
					if (s == null) {
						System.out.println("deconnexion client");
						flag = true;
					} else {
						if (s.compareTo("usagers") == 0) {
							UsagerDAO usagerDAO = new UsagerDAO();
							List<UsagerDTO> dtos = usagerDAO.readAll();
							out.writeObject(dtos);
							out.flush();

						} else {
							System.out.println("commande pas comprise");
						}
					}
				}
			}
		} catch (IOException e) {
			System.out.println("socket cassé");
			e.printStackTrace();
		}
	}
}
