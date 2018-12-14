package yr_ServerDemo;

import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class TestTCPServerConnection {

	public static List<Socket> socketsList;
	
	public static void main(String[] args) {
		FactoryManagement factoryManagement = new FactoryManagement();
		IThreadManagement threadManagement = factoryManagement.getThreadManagement(ConfigVariate.THREADMANAGEMENT);
		threadManagement.creatThreadPool(null);

		IServerConnection serverConnection = factoryManagement.getServerConnection(ConfigVariate.SERVERCONNECTION);
		serverConnection.createServerSocket("7070");
		
		socketsList = new LinkedList<Socket>();
		
		while (!serverConnection.isClosed()) {
			ISocketThread socketThread = serverConnection.createSocketThread();
			threadManagement.addThread(socketThread);
			socketsList.add(socketThread.getSocket());
		}
		
		serverConnection.closeServerSocket();
		
	}
}
