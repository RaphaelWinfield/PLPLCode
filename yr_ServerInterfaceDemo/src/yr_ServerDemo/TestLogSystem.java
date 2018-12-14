package yr_ServerDemo;

public class TestLogSystem {

	public static void main(String[] args) throws ClassNotFoundException {
		FactoryManagement factoryManagement = new FactoryManagement();
		ILogSystem logSystem = factoryManagement.getLogSystem(ConfigVariate.LOGSYSTEM);
		System.out.println(logSystem.openLogFile());
		System.out.println(logSystem.printLogContent("hi"));
		System.out.println(logSystem.printLogContent("hi2"));
		logSystem.finishLogging();
	}
}
