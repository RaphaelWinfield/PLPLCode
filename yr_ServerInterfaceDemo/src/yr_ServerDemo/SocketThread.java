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

public class SocketThread implements Runnable {

	private Socket socket;
	// 最近的心跳时间
	private long lastHeartbeat;
	// 心跳间隔时间
	private long heartBeatInterval = 5 * 1000;

	public SocketThread(Socket socket) {
		super();
		this.socket = socket;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		try {
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			PrintWriter pw = new PrintWriter(osw, true);

			String data = null;

			while (!"NO.2".equals(data)) {
				synchronized (this) {
					pw.println(new Date().toString());
					pw.flush();
					while ((data = br.readLine()) == null) {
					}
					System.out.println(data + this.toString());
				}
			}
			lastHeartbeat = System.currentTimeMillis();

			while (true) {
				if ((data = br.readLine()) != null) {
					lastHeartbeat = System.currentTimeMillis();
					System.out.println("Client is online." + this.toString());
				}
				if (System.currentTimeMillis() - lastHeartbeat > heartBeatInterval) {
					System.out.println("Client is not online.");
					socket.close();
					return;
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setHeartBeatInterval(long heartBeatInterval) {
		this.heartBeatInterval = heartBeatInterval;
	}

}
