package yr_ServerDemo;

public interface IServerConnection {

	/** 建立ServerSocket连接，传参为连接建立配置信息 */
	public void createServerSocket(String keyWord);

	/** 建立Socket线程并返回ISocketThread接口的线程实现类 */
	public ISocketThread createSocketThread();

	/** 设置服务器轮询时间 */
	public void setPollingInterval(long pollingInterval);

	/** 获取服务器轮询时间 */
	public long getPollingInterval();

	/** 判断服务器连接是否关闭，若已关闭则返回true */
	public boolean isClosed();

	/** 关闭服务器连接，释放资源 */
	public void closeServerSocket();
}
