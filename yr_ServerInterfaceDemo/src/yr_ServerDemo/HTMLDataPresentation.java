package yr_ServerDemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class HTMLDataPresentation implements IDataPresentation {

	private File file;
	private Document document;

	@Override
	public void openDesignFile(String filePath) {
		// TODO Auto-generated method stub
		file = new File(filePath);
		try {
			document = Jsoup.parse(file, "utf-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean modifyData(String key, String value) {
		// TODO Auto-generated method stub
		Elements ListDiv = document.getElementsByAttributeValue("id", key);
		ListDiv.html(value);
		return false;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		try {
			FileOutputStream fos = new FileOutputStream(file, false);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			osw.write(document.html());
			osw.close();
			java.awt.Desktop.getDesktop().open(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
