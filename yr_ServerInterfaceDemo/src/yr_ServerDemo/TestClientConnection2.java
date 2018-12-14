package yr_ServerDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestClientConnection2 {
	public static void main(String[] args) {
		Socket socket;
		String port = "7070";
		String ip;
		// 最近的心跳时间
		long lastHeartbeat;
		// 心跳间隔时间
		long heartBeatInterval = 4 * 1000;

		try {
			ip = InetAddress.getLocalHost().getHostAddress();
			socket = new Socket(ip, Integer.parseInt(port));

			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			PrintWriter pw = new PrintWriter(osw, true);

			for (int i = 0; i < 10; i++) {
				System.out.println(br.readLine());
				pw.println("NO." + i);
				pw.flush();
			}

			lastHeartbeat = System.currentTimeMillis();
			socket.close();
//			while(true) {
//				if (System.currentTimeMillis() - lastHeartbeat > heartBeatInterval) {
//					pw.println("心跳包");
//					pw.flush();
//					lastHeartbeat = System.currentTimeMillis();
//				}
//			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
