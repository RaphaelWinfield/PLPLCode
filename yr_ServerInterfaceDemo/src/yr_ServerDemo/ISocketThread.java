package yr_ServerDemo;

import java.net.Socket;

public interface ISocketThread extends Runnable {

	/** 设置服务器对客户端发送的信息 */
	public void setSendMessage(String sendMessage);

	/** 获取服务器从客户端收到的信息 */
	public String getReceivedMessage();

	/** 设置套接字 */
	public void setSocket(Socket socket);

	/** 获取套接字 */
	public Socket getSocket();

	/** 设置套接字心跳时间 */
	public void setHeartBeatInterval(long heartBeatInterval);

	/** 获取套接字心跳时间 */
	public long getHeartBeatInterval();
	
	/** 设置套接字身份验证 */
	public void setIdentifyAuthority(byte identifyAuthority);
}
