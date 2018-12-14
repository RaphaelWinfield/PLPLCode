package yr_ServerDemo;

import java.sql.ResultSet;

public interface IDatabaseSystem {
	
	/** 加载数据库的驱动 */
	public void loadDriver();

	/** 实现数据库连接，分别传入数据库资源定位路径、账户名称和账户密码 */
	public void makeConnection(String url, String user, String password);

	/** 实现SQL增加语句，增加成功则返回true */
	public boolean insertSql(String sql);

	/** 实现SQL删除语句 ，删除成功则返回true */
	public boolean deleteSql(String sql);

	/** 实现SQL更新语句，更新成功则返回true */
	public boolean updateSql(String sql);

	/** 实现SQL查询语句，查询成功则返回true */
	public boolean selectSql(String sql);

	/** 获取数据库操作结果，返回ResultSet */
	public ResultSet getResultSet();

	/** 关闭数据库系统，释放资源 */
	public void closeSystem();
}
