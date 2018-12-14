 package yr_ServerDemo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerConnection implements IServerConnection {

	private ServerSocket serverSocket;
	// 最近的心跳时间
	private long lastHeartbeat;
	// 心跳间隔时间
	private long heartBeatInterval = 4 * 1000;
	// 轮询间隔时间
	private long pollingInterval;

	//private FactoryManagement factoryManagement = new FactoryManagement();
	//private ISocketThread socketThread = factoryManagement.getSocketThread(ConfigVariate.SOCKETTHREAD);
	
	@Override
	public void createServerSocket(String keyWord) {
		// TODO Auto-generated method stub
		try {
			serverSocket = new ServerSocket(Integer.parseInt(keyWord));
			// socket = serverSocket.accept();

			lastHeartbeat = System.currentTimeMillis();

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ISocketThread createSocketThread() {
		// TODO Auto-generated method stub
		try {
			FactoryManagement factoryManagement = new FactoryManagement();
			ISocketThread socketThread = factoryManagement.getSocketThread(ConfigVariate.SOCKETTHREAD);
			Socket socket = serverSocket.accept();
			socketThread.setSocket(socket);			
			//new Thread(socketThread).start();
			return socketThread;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean isClosed() {
		// TODO Auto-generated method stub
		if (serverSocket.isClosed()) {
			System.out.println("Serversocket is closed.");
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void closeServerSocket() {
		// TODO Auto-generated method stub
		try {
			serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void setPollingInterval(long pollingInterval) {
		// TODO Auto-generated method stub
		this.pollingInterval = pollingInterval;
	}

	@Override
	public long getPollingInterval() {
		// TODO Auto-generated method stub
		return pollingInterval;
	}
}
