package myServer2;

/*
 * AUTHOR : Min Gao
 * Project1-Multi-Server Chat System
 */

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Conf {

	private String serverid;
//	private String serverAddress;
	private InetAddress serverAddress;
	private int clientsPort;
	private int coordinationPort;

	public Conf(String serverid, String serverAddress, int clientsPort, int coordinationPort) {
		super();
		this.serverid = serverid;
		try {
			this.serverAddress = InetAddress.getByName(serverAddress);
			if (this.serverAddress.getHostAddress().equals(InetAddress.getByName("localhost").getHostAddress())) {
				this.serverAddress = InetAddress.getLocalHost();
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
//		this.serverAddress = serverAddress;
		//InetAddress getHostAddress();  getlocalHost() getByName()
		this.clientsPort = clientsPort;
		this.coordinationPort = coordinationPort;
	}

	public String getServerid() {
		return serverid;
	}

	public InetAddress getServerAddress() {
		return serverAddress;
	}

	public int getClientsPort() {
		return clientsPort;
	}

	public int getCoordinationPort() {
		return coordinationPort;
	}
}
