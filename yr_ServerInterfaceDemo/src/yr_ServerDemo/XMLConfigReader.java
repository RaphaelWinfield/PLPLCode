package yr_ServerDemo;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XMLConfigReader implements IConfigReader {

	private File file;
	private Map<String, String> map;

	@Override
	public File openFile(String filePath) {
		// TODO Auto-generated method stub
		file = new File(filePath);

		try {
			SAXReader reader = new SAXReader();
			Document doc;
			doc = reader.read(file);
			Element root = doc.getRootElement();
			Iterator<Element> it = root.elementIterator();
			map = new HashMap<String, String>();
			while (it.hasNext()) {
				Element stuElem = it.next();
				Iterator<Element> it2 = stuElem.elementIterator();
				while (it2.hasNext()) {
					Element elem = it2.next();
					map.put(elem.getName(), elem.getText());
				}

			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return file;
	}

	@Override
	public String getValue(String key) {
		// TODO Auto-generated method stub

		return map.get(key);
	}

	@Override
	public void finishReading() {
		// TODO Auto-generated method stub

	}
}
