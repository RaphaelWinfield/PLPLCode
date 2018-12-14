package yr_ServerDemo;

public class FactoryManagement {

	/** 日志打印接口实现类的实例化 */
	public ILogSystem getLogSystem(String className) {
		switch (className) {
		case "DailyLogSystem":
			return new DailyLogSystem();
		default:
			return null;
		}
	}

	/** 数据库操作接口实现类的实例化 */
	public IDatabaseSystem getDatabaseSystem(String className) {
		switch (className) {
		case "MysqlDatabaseSystem":
			return new MysqlDatabaseSystem();
		default:
			return null;
		}
	}

	/** 配置文件读取接口实现类的实例化 */
	public IConfigReader getConfigReader(String className) {
		switch (className) {
		case "XMLConfigReader":
			return new XMLConfigReader();
		default:
			return null;
		}
	}

	/** 数据显示界面接口实现类的实例化 */
	public IDataPresentation getDataPresentation(String className) {
		switch (className) {
		case "HTMLDataPresentation":
			return new HTMLDataPresentation();
		default:
			return null;
		}
	}

	/** 服务器连接接口实现类的实例化 */
	public IServerConnection getServerConnection(String className) {
		switch (className) {
		case "TCPServerConnection":
			return new TCPServerConnection();
		default:
			return null;
		}
	}

	/** 套接字线程接口实现类的实例化 */
	public ISocketThread getSocketThread(String className) {
		switch (className) {
		case "TCPSOCKETTHREAD":
			return new TCPSocketThread();
		default:
			return null;
		}
	}

	/** 线程池管理接口实现类的实例化 */
	public IThreadManagement getThreadManagement(String className) {
		switch (className) {
		case "TPETHREADMANAGEMENT":
			return new TPEThreadManagement();
		default:
			return null;
		}
	}
}
