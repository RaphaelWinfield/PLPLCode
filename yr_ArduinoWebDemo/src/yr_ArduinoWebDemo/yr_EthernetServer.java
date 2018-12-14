package yr_ArduinoWebDemo;

import java.io.*;
import java.net.*;

public class yr_EthernetServer {
	public static void main(String args[]) {				
		while (true) {		
			try {
				String port="5278";
				ServerSocket server;
				server = new ServerSocket(Integer.parseInt(port));
				System.out.println("listening...");								
				Socket socket;
				socket = server.accept();
				System.out.println("connecting...");
				
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				
				char info;								
				while((info = (char)br.read()) != '<'){					
				}
				while((info = (char)br.read()) != '>'){
					System.out.print(info);
				}
				System.out.println();
															
				OutputStream os=  socket.getOutputStream();
				OutputStreamWriter osw=new OutputStreamWriter(os);
				PrintWriter pw=new PrintWriter(osw,true);
				pw.println("OK!");
				pw.flush();					
				
				socket.close();
				server.close();							
				
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}					
		}
	}	
}
