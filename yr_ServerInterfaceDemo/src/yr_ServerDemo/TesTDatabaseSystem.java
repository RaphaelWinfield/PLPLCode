package yr_ServerDemo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TesTDatabaseSystem {

	public static void main(String[] args) {
		FactoryManagement factoryManagement = new FactoryManagement();
		IConfigReader configReader = factoryManagement.getConfigReader(ConfigVariate.CONFIGREADER);
		configReader.openFile("src/databaseInfo.xml");
		String url = configReader.getValue("url");
		String user = configReader.getValue("user");
		String password = configReader.getValue("password");
//		String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&useSSL=false&serverTimezone=GMT%2B8&characterEncoding=utf8";
//		String user = "root";
//		String password = "qq475075517";
		String sql = "select * from books";
		IDatabaseSystem aDatabaseSystem = new MysqlDatabaseSystem();
		aDatabaseSystem.loadDriver();
		aDatabaseSystem.makeConnection(url, user, password);
		aDatabaseSystem.selectSql(sql);
		ResultSet rs = aDatabaseSystem.getResultSet();
		String booksName = null;
		String booksAuthor = null;
		try {
			while (rs.next()) {
				booksName = rs.getString("booksName");
				booksAuthor = rs.getString("booksAuthor");
				System.out.println(booksName + "\t" + booksAuthor);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
