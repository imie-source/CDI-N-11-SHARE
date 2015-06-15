package fr.imie;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class LauncherServerUsager {

	public LauncherServerUsager() {

	}

	public static void main(String[] args) {
		try (ServerSocket serverSocket = new ServerSocket(2042);) {
			Socket socket=serverSocket.accept();
			SocketUsagerServerListener socketUsagerServerListener=  new SocketUsagerServerListener(socket);
			new Thread(socketUsagerServerListener).start();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
