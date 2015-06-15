package fr.imie;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class LauncherServer {

	public LauncherServer() {

	}

	public static void main(String[] args) {
		try (ServerSocket serverSocket = new ServerSocket(2042);) {
			Socket socket=serverSocket.accept();
			SocketListener socketListener =  new SocketListener(socket);
			new Thread(socketListener).start();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
