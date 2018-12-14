package yr_ServerDemo;

public class TestHTMLDataPresentation {

	public static void main(String[] args) {
		FactoryManagement factoryManagement = new FactoryManagement();
		IDataPresentation dataPresentation = factoryManagement.getDataPresentation(ConfigVariate.DATAPRESENTATION);
		dataPresentation.openDesignFile("src/show.html");
		dataPresentation.modifyData("right", "test");
		dataPresentation.display();
	}
}
