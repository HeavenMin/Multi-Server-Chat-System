package myServer2;

/*
 * AUTHOR : Min Gao
 * Project1-Multi-Server Chat System
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerCommunicationThread extends Thread {

	private int coordinationPort;
	private ServerSocket listeningServerSocket;
	volatile private boolean isRunning = true;

	public ServerCommunicationThread(int coordinationPort) {
		try{
			this.coordinationPort = coordinationPort;
			this.listeningServerSocket = new ServerSocket(this.coordinationPort);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try{
			while(isRunning) {
				Socket serverSocket = listeningServerSocket.accept();
				new ServerMsgDealerThread(serverSocket).start();
			}
			listeningServerSocket.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
