package yr_ServerDemo;

public class TestConfigReader {

	public static void main(String[] args) {
		FactoryManagement factoryManagement = new FactoryManagement();
		IConfigReader configReader = factoryManagement.getConfigReader(ConfigVariate.CONFIGREADER);
		configReader.openFile("src/databaseInfo.xml");
		System.out.println(configReader.getValue("url"));
		System.out.println(configReader.getValue("user"));
		System.out.println(configReader.getValue("password"));
	}
}
