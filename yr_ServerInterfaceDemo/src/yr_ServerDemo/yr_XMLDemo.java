package yr_ServerDemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

public class yr_XMLDemo {

	public static void main(String args[]) throws Exception {
		// 使用dom4j解析scores2.xml,生成dom树
		System.out.println(new Date().toString());

		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File("src/scores.xml"));
		// 得到根节点：students
		Element root = doc.getRootElement();

		// 得到students的所有子节点：student
		Iterator<Element> it = root.elementIterator();
		// 处理每个student
		while (it.hasNext()) {
			// 得到每个学生
			Element stuElem = it.next();
			// System.out.println(stuElem);
			// 输出学生的属性：id
			List<Attribute> attrList = stuElem.attributes();
			for (Attribute attr : attrList) {
				String name = attr.getName();
				String value = attr.getValue();
				System.out.println(name + "----->" + value);
			}
			// 输出学生的子元素：name，course，score
			Iterator<Element> it2 = stuElem.elementIterator();
			while (it2.hasNext()) {
				Element elem = it2.next();
				String name = elem.getName();
				String text = elem.getText();
				System.out.println(name + "----->" + text);
			}
			System.out.println();
		}

		FactoryManagement factoryManagement = new FactoryManagement();
		IConfigReader configReader = factoryManagement.getConfigReader(ConfigVariate.CONFIGREADER);
		configReader.openFile("src/scores.xml");
		System.out.println(configReader.getValue("name1"));

		Document doc1 = DocumentHelper.createDocument();
		// 增加根节点
		Element books = doc1.addElement("books");
		// 增加子元素
		Element book1 = books.addElement("book");
		Element title1 = book1.addElement("title");
		Element author1 = book1.addElement("author");

		Element book2 = books.addElement("book");
		Element title2 = book2.addElement("title");
		Element author2 = book2.addElement("author");

		// 为子节点添加属性
		book1.addAttribute("id", "001");
		// 为元素添加内容
		title1.setText("Harry Potter");
		author1.setText("J K. Rowling");

		book2.addAttribute("id", "002");
		title2.setText("Learning XML");
		author2.setText("Erik T. Ray");

		// 实例化输出格式对象
		OutputFormat format = OutputFormat.createPrettyPrint();
		// 设置输出编码
		format.setEncoding("UTF-8");
		// 创建需要写入的File对象
		File file = new File("src/books.xml");
		// 生成XMLWriter对象，构造函数中的参数为需要输出的文件流和格式
		XMLWriter writer = new XMLWriter(new FileOutputStream(file), format);
		// 开始写入，write方法中包含上面创建的Document对象
		writer.write(doc1);

		File in = new File("src/show.html");
		org.jsoup.nodes.Document document = Jsoup.parse(in, "utf-8");
		System.out.println((document).title());
		// org.jsoup.nodes.Element div = document.select("right").first();
		// div.text("test");
		// div.html("test");
		// div = div.nextElementSibling();
		// div.text("test");
		// div.html("test");
		Elements ListDiv = document.getElementsByAttributeValue("id", "right");
		ListDiv.html("test");

		// java.awt.Desktop.getDesktop().open(file);

		FileOutputStream fos = new FileOutputStream(new File("src/show1.html"), false);
		OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
		osw.write(document.html());
		osw.close();

//      //声明Connection对象
//        Connection con;
//        //驱动程序名
//        String driver = "com.mysql.cj.jdbc.Driver";
//        //URL指向要访问的数据库名mydata
		String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
//        //MySQL配置时的用户名
		String user = "root";
//        //MySQL配置时的密码
		String password = "qq475075517";
//        //遍历查询结果集
//      
//            //加载驱动程序
//            Class.forName(driver);
//            //1.getConnection()方法，连接MySQL数据库！！
//            con = DriverManager.getConnection(url,user,password);
//            if(!con.isClosed())
//                System.out.println("Succeeded connecting to the Database!");
//            //2.创建statement类对象，用来执行SQL语句！！
//            Statement statement = con.createStatement();
//            //要执行的SQL语句
		String sql = "select * from books";
//            //3.ResultSet类，用来存放获取的结果集！！
//            ResultSet rs = statement.executeQuery(sql);
//            System.out.println("-----------------");
//            System.out.println("执行结果如下所示:");  
//            System.out.println("-----------------");  
//            System.out.println("姓名" + "\t" + "职称");  
//            System.out.println("-----------------");  
//             
//            String job = null;
//            String id = null;
//            while(rs.next()){
//                //获取stuname这列数据
//                job = rs.getString("booksName");
//                //获取stuid这列数据
//                id = rs.getString("booksAuthor");
//
//                //输出结果
//                System.out.println(id + "\t" + job);
//            }
//            rs.close();
//            con.close();
		IDatabaseSystem aDatabaseSystem = new MysqlDatabaseSystem();
		aDatabaseSystem.loadDriver();
		aDatabaseSystem.makeConnection(url, user, password);
		aDatabaseSystem.selectSql(sql);
		ResultSet rs = aDatabaseSystem.getResultSet();

		System.out.println("执行结果如下所示:");
		System.out.println("-----------------");
		System.out.println("姓名" + "\t" + "职称");
		System.out.println("-----------------");

		String job = null;
		String id = null;
		while (rs.next()) {
			// 获取stuname这列数据
			job = rs.getString("booksName");
			// 获取stuid这列数据
			id = rs.getString("booksAuthor");

			// 输出结果
			System.out.println(id + "\t" + job);
		}
	}
}
