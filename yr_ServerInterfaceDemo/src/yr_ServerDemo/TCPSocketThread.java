package yr_ServerDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class TCPSocketThread implements ISocketThread {
	
	private Socket socket;
	private byte identifyAuthority = 0;
	private String sendMessage;
	private String receivedMessage;
	private long heartBeatInterval = 5 * 1000;
	private long lastHeartbeat;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println("id:" + this.toString());
			
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			PrintWriter pw = new PrintWriter(osw, true);

			String data = null;
			
			FactoryManagement factoryManagement = new FactoryManagement();
			ILogSystem logSystem = factoryManagement.getLogSystem(ConfigVariate.LOGSYSTEM);
			
			synchronized (TCPSocketThread.class) {
				logSystem.openLogFile();
				logSystem.printLogContent("IP为 " + socket.toString() + " 的客户端于时间 " + new Date().toString() + " 与服务器连接：");
				while (!"NO.9".equals(data)) {
					pw.println(new Date().toString());
					pw.flush();
					while ((data = br.readLine()) == null) {
					}
					System.out.println(logSystem.printLogContent(data));
					// System.out.println(data);
				}				
			}

			lastHeartbeat = System.currentTimeMillis();

			while (true) {
				if ("心跳包".equals(data = br.readLine())) {
					lastHeartbeat = System.currentTimeMillis();
					System.out.println("IP为 " + socket.toString() + " 仍在线。");
					logSystem.printLogContent("IP为 " + socket.toString() + " 仍在线。");
				}
				if (System.currentTimeMillis() - lastHeartbeat > heartBeatInterval) {
					System.out.println("IP为 " + socket.toString() + " 已下线。");
					logSystem.printLogContent("IP为 " + socket.toString() + " 已下线。");
					logSystem.finishLogging();
					socket.close();
					return;
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void setSendMessage(String sendMessage) {
		// TODO Auto-generated method stub
		this.sendMessage = sendMessage;
	}

	@Override
	public String getReceivedMessage() {
		// TODO Auto-generated method stub
		return receivedMessage;
	}

	@Override
	public void setSocket(Socket socket) {
		// TODO Auto-generated method stub
		this.socket = socket;
	}

	@Override
	public Socket getSocket() {
		// TODO Auto-generated method stub
		return socket;
	}

	@Override
	public void setHeartBeatInterval(long heartBeatInterval) {
		// TODO Auto-generated method stub
		this.heartBeatInterval = heartBeatInterval;
	}

	@Override
	public long getHeartBeatInterval() {
		// TODO Auto-generated method stub
		return heartBeatInterval;
	}

	@Override
	public void setIdentifyAuthority(byte identifyAuthority) {
		// TODO Auto-generated method stub
		this.identifyAuthority = identifyAuthority;
	}
}
