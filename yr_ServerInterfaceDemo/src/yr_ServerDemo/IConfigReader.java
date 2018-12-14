package yr_ServerDemo;

import java.io.File;

public interface IConfigReader {

	/** 传参为配置文件的读取路径，返回File类型 */
	public File openFile(String filePath);

	/** 传参为键值对中的关键值，返回在配置文件中获取的对应目标值ֵ */
	public String getValue(String key);

	/** 完成配置文件读取，关闭数据流 */
	public void finishReading();

}
