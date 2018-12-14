package yr_ServerDemo;

import java.net.Socket;

public interface IThreadManagement {

	/** 创建线程池，传参为线程池配置参数 */
	public void creatThreadPool(String threadPoolConfig);

	/** 添加线程到线程池中，传参为ISocketThread接口的实现类 */
	public void addThread(ISocketThread socketThread);

	/** 关闭指定线程，传参为ISocketThread接口的实现类 */
	public void closeClient(Socket socket);

	/** 设置线程黑名单，传参为黑名单配置设置字符串 */
	public void blackList(String blackListConfig);

	/** 设置线程白名单，传参为白名单配置设置字符串 */
	public void whiteList(String whiteListConfig);

	/** 关闭线程池，释放资源 */
	public void closeThreadPool();
	
	/** 检查套接字线程的身份 */
	public byte checkIdentify(ISocketThread socketThread);
}
