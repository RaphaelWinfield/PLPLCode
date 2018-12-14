package yr_ServerDemo;

public interface IDataPresentation {

	/** 传参为数据显示文件的读取路径 */
	public void openDesignFile(String filePath);

	/** 实现对数据显示文件内容的修改，传参为一组键值对，若修改成功返回true */
	public boolean modifyData(String key, String name);

	/** 打开数据显示界面 */
	public void display();
}
