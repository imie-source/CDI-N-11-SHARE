/**
 * 
 */
package fr.imie;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import fr.imie.DAO.UsagerDAO;
import fr.imie.DTO.UsagerDTO;

/**
 * @author imie
 *
 */
public class SocketUsagerClientListener implements Runnable {

	Socket socket;

	public SocketUsagerClientListener(Socket socket) {
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
		try (ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

			while (!flag) {
				Object reponse=null;
				try {
					reponse = in.readObject();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}catch (EOFException e) {
					// le serveur n'a pas d'autre flux
				}
				if (reponse == null) {
					System.out.println("deconnexion client");
					flag=true;
				} else {
					List<UsagerDTO> dtos = (List<UsagerDTO>) reponse;
					for (UsagerDTO usagerDTO : dtos) {
						System.out.println(usagerDTO.getNom());
					}
				}
			}
		} catch (IOException e) {
			System.out.println("socket cassé");
			e.printStackTrace();
		}
	}

}
