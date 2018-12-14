package yr_ArduinoWebDemo;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.*;
import java.net.*;

public class yr_PCWebServer {

	public static void main(String args[]) {
		int i = 0;
		while (true) {

			try {
				String port = "5278";
				ServerSocket server;
				server = new ServerSocket(Integer.parseInt(port));
				System.out.println("listening...");

				Socket socket;
				socket = server.accept();
				System.out.println("connecting..." + ++i);

				/*
				// 客户端输入“12345”(0x3039)，服务器会理解为“09”，即存在8bit与ַ16bit解读差异
				DataInputStream in = new DataInputStream(socket.getInputStream());
				char info = in.readChar();
				System.out.println(info);
				// 服务器输出“我”(0x6211)，客户端会理解为98(0x62)和17(0x11)
				DataOutputStream out = new DataOutputStream(socket.getOutputStream());
				out.writeChar('0');*/

				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);

				/*
				char info;
				while ((info = (char) br.read()) != '!') {
					System.out.print(info);
				}
				System.out.println();
				*/

				char info;
				while ((info = (char) br.read()) != '<') {
				}
				while ((info = (char) br.read()) != '>') {
					System.out.print(info);
				}
				System.out.println();

//				socket.shutdownInput();//关闭输入流，但不关闭网络连接

				OutputStream os = socket.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os);
				PrintWriter pw = new PrintWriter(osw, true);
//				pw.println("123456");

//				pw.flush();

//				pw.print("fuinewfdsuifhdsfhwiefnsduhdsifuhewiufnm,zvncxvuiwaheifundzxcvfewsdsdsadsadsadfewfdsfewfewfxzvcvcxv");
				pw.write("welcome welcome welcome welcome welcome");
				pw.flush();
				pw.write("welcome welcome welcome welcome welcome");
				pw.flush();
//				pw.println("party party party party party");
//				pw.flush();											

				System.out.println("send successfully!");

				Robot r = new Robot();
				r.delay(1000); // 留给单片机缓冲时间

				socket.close();
				server.close();

			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
