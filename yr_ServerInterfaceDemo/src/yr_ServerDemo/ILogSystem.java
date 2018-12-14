package yr_ServerDemo;

public interface ILogSystem {
	
	/** 打开日志文件，若没有则新建，打开或新建成功则返回true */
	public boolean openLogFile();

	/** 向日志文件输入日志内容，传参为日志输入内容，若输入成功则返回true */
	public boolean printLogContent(String logContent);

	/** 完成日志文件输出，关闭数据流 */
	public void finishLogging();

}
